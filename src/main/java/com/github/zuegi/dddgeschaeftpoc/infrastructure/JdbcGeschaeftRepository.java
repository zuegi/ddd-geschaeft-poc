package com.github.zuegi.dddgeschaeftpoc.infrastructure;

import com.github.zuegi.dddgeschaeftpoc.domain.*;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.GeschaeftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collection;

@Component
public class JdbcGeschaeftRepository implements GeschaeftRepository {

    private final SpringDataJdbcGeschaeftRepository springDataJdbcGeschaeftRepository;

    @Autowired
    public JdbcGeschaeftRepository(SpringDataJdbcGeschaeftRepository springDataJdbcGeschaeftRepository) {
        this.springDataJdbcGeschaeftRepository = springDataJdbcGeschaeftRepository;
    }

    @Override
    public void add(Geschaeft geschaeft) throws GeschaeftSchonErfasstException {
       saveOrUpdate(geschaeft);
    }

    private void saveOrUpdate(Geschaeft geschaeft) {
        GeschaeftEntity geschaeftEntity = this.springDataJdbcGeschaeftRepository.findByGeschaeftId(geschaeft.id().value());
        if (geschaeftEntity != null) {
            geschaeftEntity.setBeschreibung(geschaeft.geschaeftHandle().value());
        } else {
            geschaeftEntity = new GeschaeftEntity(geschaeft);
        }
        springDataJdbcGeschaeftRepository.save(geschaeftEntity);
    }

    @Override
    public void addAll(Collection<Geschaeft> geschaeftCollection) {

    }

//    @Override
//    public void update(Geschaeft geschaeft) {
//        GeschaeftEntity entity = this.springDataJdbcGeschaeftRepository.findByGeschaeftId(geschaeft.id().value());
//        // findet hier ein Mapping statt oder im Service?
//        entity.setBeschreibung(geschaeft.geschaeftHandle().value());
//        springDataJdbcGeschaeftRepository.save(entity);
//    }

    @Override
    public Geschaeft get(GeschaeftIdentifier geschaeftIdentifier) {
        GeschaeftEntity entity = this.springDataJdbcGeschaeftRepository.findByGeschaeftId(geschaeftIdentifier.value());
        GeschaeftHandle geschaeftHandle = GeschaeftHandle.geschaeftHandle(entity.beschreibung);
        Preis preis = new Preis(new BigDecimal("20.35"), Currency.CHF);
        return Geschaeft.newGeschaeft(geschaeftHandle, preis);
    }

    @Override
    public Collection<Geschaeft> findAll() {
        return null;
    }


}
