package com.github.zuegi.dddgeschaeftpoc.infrastructure;

import com.github.zuegi.dddgeschaeftpoc.domain.*;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.GeschaeftRepository;
import org.springframework.stereotype.Component;

@Component
public class JdbcGeschaeftRepository implements GeschaeftRepository {



    @Override
    public void save(Geschaeft geschaeft) throws GeschaeftSchonErfasstException {

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
