package com.github.zuegi.dddgeschaeftpoc.domain;

import static java.util.UUID.randomUUID;

public class GeschaeftIdentifier {

    private final String value;

    private GeschaeftIdentifier() {
        this(randomUUID().toString());
    }

    private GeschaeftIdentifier(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static GeschaeftIdentifier geschaeftIdentifier(String value) {
        return new GeschaeftIdentifier(value);
    }

    static GeschaeftIdentifier newGeschaeftIdentifier() {
        return new GeschaeftIdentifier();
    }

}
