package com.food.ordering.system.payment.source.domain.event;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.payment.source.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collections;

public class PaymentCancelledEvent extends PaymentEvent{
    private final DomainEventPublisher<PaymentCancelledEvent> paymentCancelledEventDomainPublisher;
    public PaymentCancelledEvent(Payment payment, ZonedDateTime createdAt, DomainEventPublisher<PaymentCancelledEvent> paymentCancelledEventDomainPublisher) {
        super(payment, createdAt, Collections.emptyList());
        this.paymentCancelledEventDomainPublisher = paymentCancelledEventDomainPublisher;
    }

    @Override
    public void fire() {
        paymentCancelledEventDomainPublisher.publish(this);
    }
}
