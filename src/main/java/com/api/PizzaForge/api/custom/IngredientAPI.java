package com.api.PizzaForge.api.custom;

import com.api.PizzaForge.api.CRUDAPI;
import com.api.PizzaForge.domain.dtos.IngredientDTO;
import com.api.PizzaForge.domain.entities.Ingredient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientAPI extends CRUDAPI<Ingredient, Long, IngredientDTO> {
}
