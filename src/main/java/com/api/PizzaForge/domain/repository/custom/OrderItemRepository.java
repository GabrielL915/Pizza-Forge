package com.api.PizzaForge.domain.repository.custom;

import com.api.PizzaForge.domain.entities.OrderItem;
import com.api.PizzaForge.domain.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CRUDRepository<OrderItem, Long> {
}
