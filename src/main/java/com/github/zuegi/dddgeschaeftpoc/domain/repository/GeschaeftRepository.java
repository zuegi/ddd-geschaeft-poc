package com.github.zuegi.dddgeschaeftpoc.domain.repository;

import com.github.zuegi.dddgeschaeftpoc.domain.Geschaeft;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftHandle;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftIdentifier;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftSchonErfasstException;
import com.github.zuegi.dddgeschaeftpoc.infrastructure.GeschaeftEntity;
import com.github.zuegi.dddgeschaeftpoc.stereotypen.Repository;

import java.util.Collection;

@Repository
public interface GeschaeftRepository {

   void add(Geschaeft geschaeft) throws GeschaeftSchonErfasstException;
   void addAll(Collection<Geschaeft> geschaeftCollection);

   Geschaeft get(GeschaeftIdentifier geschaeftIdentifier);

   Collection<Geschaeft> findAll();

}
