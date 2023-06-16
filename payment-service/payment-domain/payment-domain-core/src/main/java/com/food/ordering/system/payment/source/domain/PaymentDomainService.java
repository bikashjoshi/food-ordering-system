package com.food.ordering.system.payment.source.domain;

import com.food.ordering.system.payment.source.domain.entity.CreditEntry;
import com.food.ordering.system.payment.source.domain.entity.CreditHistory;
import com.food.ordering.system.payment.source.domain.entity.Payment;
import com.food.ordering.system.payment.source.domain.event.PaymentEvent;

import java.util.List;

public interface PaymentDomainService {
    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages);

    PaymentEvent validateAndCancelPayment(Payment payment,
                                          CreditEntry creditEntry,
                                          List<CreditHistory> creditHistories,
                                          List<String> failureMessages);
}