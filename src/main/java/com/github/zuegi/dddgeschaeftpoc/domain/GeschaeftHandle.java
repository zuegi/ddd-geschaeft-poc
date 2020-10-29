package com.github.zuegi.dddgeschaeftpoc.domain;

import com.github.zuegi.dddgeschaeftpoc.stereotypen.ValueObject;

@ValueObject
public class GeschaeftHandle {

    private final String value;

    private GeschaeftHandle(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static GeschaeftHandle geschaeftHandle(String value) {
        return new GeschaeftHandle(value);
    }

    @Override
    public boolean equals(Object anObject) {
        boolean equalObjects = false;
        if (anObject != null && this.getClass() == anObject.getClass()) {
            GeschaeftHandle typedObject = (GeschaeftHandle) anObject;
            equalObjects =
                    this.value().equals(typedObject.value());
        }
        return equalObjects;
    }

    @Override
    public String toString() {
        return value();
    }

    @Override
    public int hashCode() {
        // irgend ein häschCode zusammengestellt
        return + (12342345 * 13434) +value().hashCode();
    }
}
