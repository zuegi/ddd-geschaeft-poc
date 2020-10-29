package com.github.zuegi.dddgeschaeftpoc.domain;

public interface DomainEventPublisher {

    void publish(Object domainEvent);
}
