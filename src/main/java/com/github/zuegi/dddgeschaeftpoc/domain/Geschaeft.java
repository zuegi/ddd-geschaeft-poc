package com.github.zuegi.dddgeschaeftpoc.domain;

import com.github.zuegi.dddgeschaeftpoc.domain.partner.Partners;
import com.github.zuegi.dddgeschaeftpoc.domain.user.User;
import com.github.zuegi.dddgeschaeftpoc.domain.user.UserId;
import com.github.zuegi.dddgeschaeftpoc.stereotypen.Aggregate;
import com.github.zuegi.dddgeschaeftpoc.stereotypen.AggregateFactory;
import com.github.zuegi.dddgeschaeftpoc.stereotypen.AggregateId;

@Aggregate
public class Geschaeft {

    private static transient DomainEventPublisher domainEventPublisher;
    private final GeschaeftIdentifier geschaeftIdentifier;
    private final GeschaeftHandle geschaeftHandle;
    private final Preis preis;
    private final UserId anbieterId;
    private final UserId konsumentId;

    public Geschaeft(DomainEventPublisher domainEventPublisher, UserId anbieterId, UserId konsumentId, GeschaeftHandle geschaeftHandle, Preis preis) {
        this.domainEventPublisher = domainEventPublisher;
        this.geschaeftHandle = geschaeftHandle;
        this.geschaeftIdentifier = GeschaeftIdentifier.newGeschaeftIdentifier();
        this.preis = preis;
        this.anbieterId = anbieterId;
        this.konsumentId = konsumentId;
    }

    @AggregateId
    public GeschaeftIdentifier id() {
        return this.geschaeftIdentifier;
    }

    public GeschaeftHandle geschaeftHandle() {
        return this.geschaeftHandle;
    }



    public UserId anbieter() {
        return this.anbieterId;
    }

    public UserId konsument() {
        return this.konsumentId;
    }

    @AggregateFactory(Geschaeft.class)
    public static Geschaeft newGeschaeft(String anbieter, String konsument, GeschaeftHandle geschaeftHandle, Preis preis) {
        return new Geschaeft(domainEventPublisher, UserId.userId(anbieter), UserId.userId(konsument), geschaeftHandle, preis);
    }

    public Preis preis() {
        return this.preis;
    }
}
