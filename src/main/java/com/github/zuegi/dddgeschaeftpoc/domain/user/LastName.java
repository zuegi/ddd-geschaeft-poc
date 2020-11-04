package com.github.zuegi.dddgeschaeftpoc.domain.user;

import com.github.zuegi.dddgeschaeftpoc.stereotypen.ValueObject;

@ValueObject
public class LastName {

    private final String value;

    private LastName(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static LastName lastName(String value) {
        return new LastName(value);
    }

}
