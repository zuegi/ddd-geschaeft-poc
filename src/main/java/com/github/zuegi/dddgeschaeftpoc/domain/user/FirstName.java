package com.github.zuegi.dddgeschaeftpoc.domain.user;


import com.github.zuegi.dddgeschaeftpoc.stereotypen.ValueObject;

@ValueObject
public class FirstName {

    private final String value;

    private FirstName(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static FirstName firstName(String value) {
        return new FirstName(value);
    }

}
