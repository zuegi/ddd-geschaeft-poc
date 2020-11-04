package com.github.zuegi.dddgeschaeftpoc.domain.partner;


import com.github.zuegi.dddgeschaeftpoc.domain.user.UserId;
import com.github.zuegi.dddgeschaeftpoc.stereotypen.ValueObject;

@ValueObject
public class Partners {

    UserId anbieterId;
    UserId konsumentId;

    public Partners(UserId anbieterId, UserId konsumentId) {
        this.anbieterId = anbieterId;
        this.konsumentId = konsumentId;
    }

    public UserId anbieterId() {
        return this.anbieterId;
    }

    public UserId konsumentId() {
        return this.konsumentId;
    }
}
