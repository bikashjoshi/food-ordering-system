package com.food.ordering.system;

public interface OutboxScheduler {
    void processOutboxMessage();
}
