package com.github.zuegi.dddgeschaeftpoc.domain.service;

import com.github.zuegi.dddgeschaeftpoc.TestHelper;
import com.github.zuegi.dddgeschaeftpoc.domain.*;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.GeschaeftRepository;
import com.github.zuegi.dddgeschaeftpoc.domain.repository.UserRepository;
import com.github.zuegi.dddgeschaeftpoc.domain.user.FirstName;
import com.github.zuegi.dddgeschaeftpoc.domain.user.LastName;
import com.github.zuegi.dddgeschaeftpoc.domain.user.User;
import com.github.zuegi.dddgeschaeftpoc.domain.user.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ErstelleGeschaeftServiceTest {

    private ErstelleGeschaeftService erstelleGeschaeftService;
    private GeschaeftRepository geschaeftRepository;
    private UserRepository userRepository;
    User anbieter;
    User konsument;

    @BeforeEach
    void setUp() {
        geschaeftRepository = mock(GeschaeftRepository.class);
        userRepository = new UserRepository();
        erstelleGeschaeftService = new ErstelleGeschaeftService(geschaeftRepository, userRepository);
        anbieter = User.newUser(FirstName.firstName("Hampi"), LastName.lastName("Stamm"));
        konsument = User.newUser(FirstName.firstName("Stefan"), LastName.lastName("Räber"));
    }

    @Test
    void startNeuesGeschaeft() {
        GeschaeftHandle geschaeftHandle = GeschaeftHandle.geschaeftHandle(TestHelper.BILDSCHIRM_PHILIPS_278E);
        Preis preis = new Preis(TestHelper.BILDSCHIRM_PHILIPS_278E_VERKAUFSPREIS, Currency.CHF);

              GeschaeftIdentifier geschaeftIdentifier = erstelleGeschaeftService.createGeschaeft(anbieter.userId().value(), konsument.userId().value(), geschaeftHandle, preis);
        verify(geschaeftRepository).add(any(Geschaeft.class));
        assertNotNull(geschaeftIdentifier);
    }

    @Test
    void findGeschaeftByIdentifier() {
        // given
        GeschaeftHandle geschaeftHandle = GeschaeftHandle.geschaeftHandle(TestHelper.BILDSCHIRM_PHILIPS_278E);
        Preis preis = new Preis(TestHelper.BILDSCHIRM_PHILIPS_278E_VERKAUFSPREIS, Currency.CHF);
        when(geschaeftRepository.get(any(GeschaeftIdentifier.class))).thenReturn(Geschaeft.newGeschaeft(anbieter.userId().value(), konsument.userId().value(),geschaeftHandle, preis));

        // when
        GeschaeftIdentifier geschaeftIdentifier = erstelleGeschaeftService.createGeschaeft(anbieter.userId().value(), konsument.userId().value(), geschaeftHandle, preis);
        Geschaeft geschaeft = erstelleGeschaeftService.findGeschaeftByIdentifier(geschaeftIdentifier);

        // then
        verify(geschaeftRepository).get(any(GeschaeftIdentifier.class));

        assertEquals(geschaeftHandle, geschaeft.geschaeftHandle());
        assertEquals(preis, geschaeft.preis());
    }
}
