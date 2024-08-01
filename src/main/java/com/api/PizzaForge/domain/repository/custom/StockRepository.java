package com.api.PizzaForge.domain.repository.custom;

import com.api.PizzaForge.domain.entities.Stock;
import com.api.PizzaForge.domain.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CRUDRepository<Stock, Long> {
}
