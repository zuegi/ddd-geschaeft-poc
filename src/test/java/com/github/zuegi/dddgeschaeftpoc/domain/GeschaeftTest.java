package com.github.zuegi.dddgeschaeftpoc.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GeschaeftTest {

    public static final String BILDSCHIRM_PHILIPS_278_E = "Bildschirm Philips 278E";

    @Test
    void testCreateGeschaeft() {
        GeschaeftHandle geschaeftHandle = GeschaeftHandle.geschaeftHandle(BILDSCHIRM_PHILIPS_278_E);

        Geschaeft geschaeft = Geschaeft.newGeschaeft(geschaeftHandle,
                new Preis(new BigDecimal("35.70"), Currency.CHF));

        assertNotNull(geschaeft);
        assertNotNull(geschaeft.id());
        assertEquals(geschaeftHandle, geschaeft.geschaeftHandle());

    }

}
