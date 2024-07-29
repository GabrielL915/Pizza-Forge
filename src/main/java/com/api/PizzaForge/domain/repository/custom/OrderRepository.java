package com.api.PizzaForge.domain.repository.custom;

import com.api.PizzaForge.domain.entities.Order;
import com.api.PizzaForge.domain.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CRUDRepository<Order, Long> {
}
