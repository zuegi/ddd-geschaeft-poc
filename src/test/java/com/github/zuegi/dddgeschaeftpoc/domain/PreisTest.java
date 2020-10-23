package com.github.zuegi.dddgeschaeftpoc.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PreisTest {

    @Test
    void preiseMitgleichemBetragUndCurrencyLiefernTrue() {
        Preis preisOne = new Preis(new BigDecimal("50.00"),Currency.CHF);
        Preis preisTwo = new Preis(preisOne);

        assertNotSame(preisOne, preisTwo);
        assertEquals(preisTwo, preisOne);
        assertEquals(preisOne, preisTwo);
    }

    @Test
    void preisStringEnthaelt50Stutz() {
        Preis preisOne = new Preis(new BigDecimal("50.00"),Currency.CHF);
        assertEquals("Preis: 50.00 CHF",preisOne.toString());
    }
}
