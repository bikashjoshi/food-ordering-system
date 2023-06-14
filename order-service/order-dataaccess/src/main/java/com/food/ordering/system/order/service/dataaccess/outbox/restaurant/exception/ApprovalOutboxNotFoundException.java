package com.food.ordering.system.order.service.dataaccess.outbox.restaurant.exception;

public class ApprovalOutboxNotFoundException extends RuntimeException{
    public ApprovalOutboxNotFoundException(String message) {
        super(message);
    }
}
