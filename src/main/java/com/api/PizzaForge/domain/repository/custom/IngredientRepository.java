package com.api.PizzaForge.domain.repository.custom;

import com.api.PizzaForge.domain.entities.Ingredient;
import com.api.PizzaForge.domain.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CRUDRepository<Ingredient, Long> {
    Optional<Ingredient> findByName(String name);
}
