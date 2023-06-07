package com.food.ordering.system.restaurant.domain;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.restaurant.domain.entity.Restaurant;
import com.food.ordering.system.restaurant.domain.event.OrderApprovalEvent;
import com.food.ordering.system.restaurant.domain.event.OrderApprovedEvent;
import com.food.ordering.system.restaurant.domain.event.OrderRejectedEvent;

import java.util.List;

public interface RestaurantDomainService {
    OrderApprovalEvent validateOrder(Restaurant restaurant,
                                     List<String> failureMessages,
                                     DomainEventPublisher<OrderApprovedEvent> orderApprovedEventDomainEventPublisher,
                                     DomainEventPublisher<OrderRejectedEvent> orderRejectedEventDomainEventPublisher);
}
