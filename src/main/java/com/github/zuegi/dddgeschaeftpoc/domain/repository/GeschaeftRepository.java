package com.github.zuegi.dddgeschaeftpoc.domain.repository;

import com.github.zuegi.dddgeschaeftpoc.domain.Geschaeft;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftHandle;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftIdentifier;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftSchonErfasstException;
import com.github.zuegi.dddgeschaeftpoc.infrastructure.GeschaeftEntity;
import com.github.zuegi.dddgeschaeftpoc.stereotypen.Repository;

@Repository
public interface GeschaeftRepository {

   void save(Geschaeft geschaeft) throws GeschaeftSchonErfasstException;

   void update(Geschaeft geschaeft);

   Geschaeft findGeschaeftByIdentifier(GeschaeftIdentifier geschaeftIdentifier);

   Geschaeft find(GeschaeftHandle geschaeftHandle);

   Geschaeft findBy(String geschaeftIdentifier);
}
