package com.github.zuegi.dddgeschaeftpoc.domain.user;

import com.github.zuegi.dddgeschaeftpoc.stereotypen.ValueObject;

import static java.util.UUID.randomUUID;

@ValueObject
public class UserId {

    private String value;

    private UserId() {
        this(randomUUID().toString());
    }

    private UserId(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static UserId userId(String value) {
        return new UserId(value);
    }

    public static UserId newUserId() {
        return new UserId();
    }
}
