package com.github.zuegi.dddgeschaeftpoc.domain.service;

import com.github.zuegi.dddgeschaeftpoc.domain.Geschaeft;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftHandle;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftIdentifier;
import com.github.zuegi.dddgeschaeftpoc.domain.Preis;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.GeschaeftRepository;


public class DomainGeschaeftService implements GeschaeftService {


    private GeschaeftRepository geschaeftRepository;

    public DomainGeschaeftService(GeschaeftRepository geschaeftRepository) {
        this.geschaeftRepository = geschaeftRepository;
    }

    @Override
    public GeschaeftIdentifier createGeschaeft(GeschaeftHandle geschaeftHandle, Preis preis) {
        Geschaeft geschaeft = Geschaeft.newGeschaeft(geschaeftHandle, preis);
        this.geschaeftRepository.add(geschaeft);
        return geschaeft.id();
    }
}
