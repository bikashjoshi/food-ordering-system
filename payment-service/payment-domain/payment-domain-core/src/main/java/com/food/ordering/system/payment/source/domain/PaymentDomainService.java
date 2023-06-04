package com.food.ordering.system.payment.source.domain;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.payment.source.domain.entity.CreditEntry;
import com.food.ordering.system.payment.source.domain.entity.CreditHistory;
import com.food.ordering.system.payment.source.domain.entity.Payment;
import com.food.ordering.system.payment.source.domain.event.PaymentCancelledEvent;
import com.food.ordering.system.payment.source.domain.event.PaymentCompletedEvent;
import com.food.ordering.system.payment.source.domain.event.PaymentEvent;
import com.food.ordering.system.payment.source.domain.event.PaymentFailedEvent;

import java.util.List;

public interface PaymentDomainService {
    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages,
                                            DomainEventPublisher<PaymentCompletedEvent> paymentCompletedEventDomainEventPublisher, DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher);

    PaymentEvent validateAndCancelPayment(Payment payment,
                                          CreditEntry creditEntry,
                                          List<CreditHistory> creditHistories,
                                          List<String> failureMessages,
                                          DomainEventPublisher<PaymentCancelledEvent> paymentCancelledEventDomainPublisher, DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher);
}