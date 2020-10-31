package com.github.zuegi.dddgeschaeftpoc.domain.service;

import com.github.zuegi.dddgeschaeftpoc.domain.Geschaeft;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftHandle;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftIdentifier;
import com.github.zuegi.dddgeschaeftpoc.domain.Preis;
import com.github.zuegi.dddgeschaeftpoc.infrastructure.GeschaeftEntity;

import java.util.UUID;

public interface GeschaeftService {

    GeschaeftIdentifier createGeschaeft(GeschaeftHandle geschaeftHandle, Preis preis);

    Geschaeft findGeschaeftByIdentifier(GeschaeftIdentifier geschaeftIdentifier);
}
