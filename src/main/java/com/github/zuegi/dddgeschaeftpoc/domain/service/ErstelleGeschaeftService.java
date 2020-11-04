package com.github.zuegi.dddgeschaeftpoc.domain.service;

import com.github.zuegi.dddgeschaeftpoc.domain.Geschaeft;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftHandle;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftIdentifier;
import com.github.zuegi.dddgeschaeftpoc.domain.Preis;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.GeschaeftRepository;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.UserRepository;


public class ErstelleGeschaeftService implements GeschaeftService {

    private GeschaeftRepository geschaeftRepository;
    private UserRepository userRepository;

    public ErstelleGeschaeftService(GeschaeftRepository geschaeftRepository, UserRepository userRepository) {
        this.geschaeftRepository = geschaeftRepository;
        this.userRepository = userRepository;
    }

    @Override
    public GeschaeftIdentifier createGeschaeft(String anbieterId, String konsumentId, GeschaeftHandle geschaeftHandle, Preis preis) {
        Geschaeft geschaeft = Geschaeft.newGeschaeft(anbieterId, konsumentId, geschaeftHandle, preis);
        this.geschaeftRepository.add(geschaeft);
        return geschaeft.id();
    }

    @Override
    public Geschaeft findGeschaeftByIdentifier(GeschaeftIdentifier geschaeftIdentifier) {
        return this.geschaeftRepository.get(geschaeftIdentifier);
    }
}
