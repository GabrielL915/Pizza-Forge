package com.api.PizzaForge.domain.repository.custom;

import com.api.PizzaForge.domain.entities.Ingredient;
import com.api.PizzaForge.domain.entities.Pizza;
import com.api.PizzaForge.domain.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaRepository extends CRUDRepository<Pizza, Long> {
    Optional<Pizza> findByName(String name);
}
