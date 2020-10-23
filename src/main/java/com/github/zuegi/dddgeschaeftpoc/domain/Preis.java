package com.github.zuegi.dddgeschaeftpoc.domain;

import com.github.zuegi.dddgeschaeftpoc.stereotypen.ValueObject;

import java.math.BigDecimal;


@ValueObject
public class Preis {

    private final BigDecimal betrag;
    private final Currency currency;

    public Preis(BigDecimal betrag, Currency currency) {
        this.betrag = betrag;
        this.currency = currency;
    }

   public Preis(Preis preis) {
        this(preis.betrag, preis.currency);
    }


    @Override
    public boolean equals(Object object) {
        boolean areObjectsEqual = false;
        if (object != null && this.getClass() == object.getClass()) {
            Preis preis = (Preis) object;
            areObjectsEqual = this.betrag.equals(preis.betrag)
                    && this.currency.equals(preis.currency);
        }
        return areObjectsEqual;
    }

    @Override
    public String toString() {
        return "Preis: " +this.betrag +" " +this.currency;
    }
}
