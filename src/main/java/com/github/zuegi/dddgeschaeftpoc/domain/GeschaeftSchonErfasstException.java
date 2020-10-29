package com.github.zuegi.dddgeschaeftpoc.domain;


import com.github.zuegi.dddgeschaeftpoc.stereotypen.BusinessException;

@BusinessException
public class GeschaeftSchonErfasstException extends RuntimeException {

    private GeschaeftSchonErfasstException(Geschaeft geschaeft) {
        super("geschaeft  '" + geschaeft.id() + "' is already in use");
    }

    public static GeschaeftSchonErfasstException userHandleAlreadyInUse(Geschaeft geschaeft) {
        return new GeschaeftSchonErfasstException(geschaeft);
    }

}
