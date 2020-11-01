package com.github.zuegi.dddgeschaeftpoc.application.rest;

import com.github.zuegi.dddgeschaeftpoc.domain.Currency;
import com.github.zuegi.dddgeschaeftpoc.domain.Geschaeft;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftIdentifier;
import com.github.zuegi.dddgeschaeftpoc.domain.Preis;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class GeschaeftUI {
    private String beschreibung;
    private String geschaeftId;
    private BigDecimal betrag;
    private Currency currency;

    public GeschaeftUI(Geschaeft geschaeft) {
        this.beschreibung = geschaeft.geschaeftHandle().value();
        this.geschaeftId = geschaeft.id().value();
        this.betrag = geschaeft.preis().betrag();
        this.currency = geschaeft.preis().currency();
    }
}
