package com.github.zuegi.dddgeschaeftpoc.domain.service;

import com.github.zuegi.dddgeschaeftpoc.domain.Geschaeft;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftHandle;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftIdentifier;
import com.github.zuegi.dddgeschaeftpoc.domain.Preis;

public interface GeschaeftService {

    GeschaeftIdentifier createGeschaeft(String anbieterId, String konsumentId, GeschaeftHandle geschaeftHandle, Preis preis);

    Geschaeft findGeschaeftByIdentifier(GeschaeftIdentifier geschaeftIdentifier);
}
