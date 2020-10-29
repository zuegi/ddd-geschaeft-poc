package com.github.zuegi.dddgeschaeftpoc.domain;

import com.github.zuegi.dddgeschaeftpoc.stereotypen.Repository;

@Repository
public interface GeschaeftRepository {

   void add(Geschaeft geschaeft) throws GeschaeftSchonErfasstException;

   void update(Geschaeft geschaeft);

   Geschaeft get(GeschaeftIdentifier geschaeftIdentifier);

   Geschaeft find(GeschaeftHandle geschaeftHandle);
}
