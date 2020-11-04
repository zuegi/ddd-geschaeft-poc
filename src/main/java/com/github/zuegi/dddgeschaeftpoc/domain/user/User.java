package com.github.zuegi.dddgeschaeftpoc.domain.user;

import com.github.zuegi.dddgeschaeftpoc.stereotypen.Aggregate;
import com.github.zuegi.dddgeschaeftpoc.stereotypen.AggregateFactory;

@Aggregate
public class User {
    private String vorname;
    private String nachname;
    private UserId userId;

    public User(UserId userId, FirstName firstName, LastName lastName) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.userId = userId;
    }

    public UserId userId() {
        return this.userId;
    }

    @AggregateFactory(User.class)
    public static User newUser(FirstName firstName, LastName lastName) {
        return new User(UserId.newUserId(), firstName, lastName);
    }
}
