package com.github.zuegi.dddgeschaeftpoc.domain;

import com.github.zuegi.dddgeschaeftpoc.stereotypen.Aggregate;
import com.github.zuegi.dddgeschaeftpoc.stereotypen.AggregateFactory;
import com.github.zuegi.dddgeschaeftpoc.stereotypen.AggregateId;

@Aggregate
public class Geschaeft {

    private static transient DomainEventPublisher domainEventPublisher;
    private final GeschaeftIdentifier geschaeftIdentifier;
    private final GeschaeftHandle geschaeftHandle;
    private final Preis preis;

    public Geschaeft(DomainEventPublisher domainEventPublisher, GeschaeftHandle geschaeftHandle, Preis preis) {
        this.domainEventPublisher = domainEventPublisher;
        this.geschaeftHandle = geschaeftHandle;
        this.geschaeftIdentifier = GeschaeftIdentifier.newGeschaeftIdentifier();
        this.preis = preis;
    }

    @AggregateId
    public GeschaeftIdentifier id() {
        return this.geschaeftIdentifier;
    }

    public GeschaeftHandle geschaeftHandle() {
        return this.geschaeftHandle;
    }

    @AggregateFactory(Geschaeft.class)
    public static Geschaeft newGeschaeft(GeschaeftHandle geschaeftHandle, Preis preis) {
        return new Geschaeft(domainEventPublisher, geschaeftHandle, preis);
    }
}
