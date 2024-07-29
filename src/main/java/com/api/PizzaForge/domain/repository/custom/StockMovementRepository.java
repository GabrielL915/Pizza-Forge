package com.api.PizzaForge.domain.repository.custom;

import com.api.PizzaForge.domain.entities.StockMovement;
import com.api.PizzaForge.domain.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMovementRepository extends CRUDRepository<StockMovement, Long> {
}
