package com.github.zuegi.dddgeschaeftpoc.domain.service;

import com.github.zuegi.dddgeschaeftpoc.TestHelper;
import com.github.zuegi.dddgeschaeftpoc.domain.Currency;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftHandle;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftIdentifier;
import com.github.zuegi.dddgeschaeftpoc.domain.Preis;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.GeschaeftRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DomainGeschaeftServiceTest {

    DomainGeschaeftService domainGeschaeftService;
    GeschaeftRepository geschaeftRepository;

    @BeforeEach
    void setUp() {
        geschaeftRepository = mock(GeschaeftRepository.class);
        domainGeschaeftService = new DomainGeschaeftService(geschaeftRepository);
    }

    @Test
    void startNeuesGeschaeft() {
        GeschaeftHandle geschaeftHandle = GeschaeftHandle.geschaeftHandle(TestHelper.BILDSCHIRM_PHILIPS_278E);
        Preis preis = new Preis(TestHelper.BILDSCHIRM_PHILIPS_278E_VERKAUFSPREIS, Currency.CHF);

        GeschaeftIdentifier geschaeftIdentifier = domainGeschaeftService.createGeschaeft(geschaeftHandle, preis);

        assertNotNull(geschaeftIdentifier);

    }
}
