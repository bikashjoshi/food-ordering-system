package com.food.ordering.system.restaurant.service.domain.ports.output.repository;

import com.food.ordering.system.restaurant.domain.entity.OrderApproval;

public interface OrderApprovalRepository {
    OrderApproval save(OrderApproval orderApproval);
}
