package com.food.ordering.system.payment.service.dataaccess.outbox.mapper;

import com.food.ordering.system.payment.service.dataaccess.outbox.entity.OrderOutboxEntity;
import com.food.ordering.system.payment.service.domain.outbox.model.OrderOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class OrderOutboxDataAccessMapper {
    public OrderOutboxEntity orderOutboxMessageToOutboxEntity(OrderOutboxMessage orderOutboxMessage){
        return OrderOutboxEntity.builder()
                .id(orderOutboxMessage.getId())
                .sagaId(orderOutboxMessage.getSagaId())
                .createdAt(orderOutboxMessage.getCreatedAt())
                .type(orderOutboxMessage.getType())
                .payload(orderOutboxMessage.getPayload())
                .paymentStatus(orderOutboxMessage.getPaymentStatus())
                .outboxStatus(orderOutboxMessage.getOutboxStatus())
                .version(orderOutboxMessage.getVersion())
                .build();
    }

    public OrderOutboxMessage orderOutboxEntityToOrderOutboxMessage(OrderOutboxEntity orderOutboxEntity){
        return OrderOutboxMessage.builder()
                .id(orderOutboxEntity.getId())
                .sagaId(orderOutboxEntity.getSagaId())
                .createdAt(orderOutboxEntity.getCreatedAt())
                .type(orderOutboxEntity.getType())
                .payload(orderOutboxEntity.getPayload())
                .paymentStatus(orderOutboxEntity.getPaymentStatus())
                .outboxStatus(orderOutboxEntity.getOutboxStatus())
                .version(orderOutboxEntity.getVersion())
                .build();
    }
}
