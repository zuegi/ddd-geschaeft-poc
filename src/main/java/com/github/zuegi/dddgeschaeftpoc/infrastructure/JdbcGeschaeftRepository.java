package com.github.zuegi.dddgeschaeftpoc.infrastructure;

import com.github.zuegi.dddgeschaeftpoc.domain.*;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.GeschaeftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcGeschaeftRepository implements GeschaeftRepository {


    private final SpringDataJdbcGeschaeftRepository orderRepository;

    @Autowired
    public JdbcGeschaeftRepository(SpringDataJdbcGeschaeftRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Geschaeft geschaeft) throws GeschaeftSchonErfasstException {
        orderRepository.save(new GeschaeftEntity(geschaeft));
    }

    @Override
    public void update(Geschaeft geschaeft) {

    }

    @Override
    public Geschaeft get(GeschaeftIdentifier geschaeftIdentifier) {
        return null;
    }

    @Override
    public Geschaeft find(GeschaeftHandle geschaeftHandle) {
        return null;
    }
}
