package com.github.zuegi.dddgeschaeftpoc.infrastructure;

import com.github.zuegi.dddgeschaeftpoc.domain.*;

public class JdbcGeschaeftRepository implements GeschaeftRepository {
    @Override
    public void add(Geschaeft geschaeft) throws GeschaeftSchonErfasstException {

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
