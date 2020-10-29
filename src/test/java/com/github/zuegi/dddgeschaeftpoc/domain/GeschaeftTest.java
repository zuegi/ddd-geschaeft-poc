package com.github.zuegi.dddgeschaeftpoc.domain;

import com.github.zuegi.dddgeschaeftpoc.TestHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeschaeftTest {


    @Test
    void testCreateGeschaeft() {
        GeschaeftHandle geschaeftHandle = GeschaeftHandle.geschaeftHandle(TestHelper.BILDSCHIRM_PHILIPS_278E);

        Geschaeft geschaeft = Geschaeft.newGeschaeft(geschaeftHandle,
                new Preis(TestHelper.BILDSCHIRM_PHILIPS_278E_VERKAUFSPREIS, Currency.CHF));

        assertNotNull(geschaeft);
        assertNotNull(geschaeft.id());
        assertEquals(geschaeftHandle, geschaeft.geschaeftHandle());

    }

}
