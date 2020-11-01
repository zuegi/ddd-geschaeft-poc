package com.github.zuegi.dddgeschaeftpoc.domain.service;

import com.github.zuegi.dddgeschaeftpoc.TestHelper;
import com.github.zuegi.dddgeschaeftpoc.domain.*;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.GeschaeftRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        verify(geschaeftRepository).add(any(Geschaeft.class));
        assertNotNull(geschaeftIdentifier);
    }

    @Test
    void findGeschaeftByIdentifier() {
        // given
        GeschaeftHandle geschaeftHandle = GeschaeftHandle.geschaeftHandle(TestHelper.BILDSCHIRM_PHILIPS_278E);
        Preis preis = new Preis(TestHelper.BILDSCHIRM_PHILIPS_278E_VERKAUFSPREIS, Currency.CHF);
        when(geschaeftRepository.get(any(GeschaeftIdentifier.class))).thenReturn(Geschaeft.newGeschaeft(geschaeftHandle, preis));

        // when
        GeschaeftIdentifier geschaeftIdentifier = domainGeschaeftService.createGeschaeft(geschaeftHandle, preis);
        Geschaeft geschaeft = domainGeschaeftService.findGeschaeftByIdentifier(geschaeftIdentifier);

        // then
        verify(geschaeftRepository).get(any(GeschaeftIdentifier.class));

        assertEquals(geschaeftHandle, geschaeft.geschaeftHandle());
        assertEquals(preis, geschaeft.preis());
    }
}
