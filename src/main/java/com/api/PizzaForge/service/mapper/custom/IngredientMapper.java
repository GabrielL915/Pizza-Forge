package com.api.PizzaForge.service.mapper.custom;

import com.api.PizzaForge.domain.dtos.IngredientDTO;
import com.api.PizzaForge.domain.dtos.TransactionsDTO;
import com.api.PizzaForge.domain.entities.Ingredient;
import com.api.PizzaForge.domain.entities.Transactions;
import com.api.PizzaForge.service.mapper.PizzaForgeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IngredientMapper implements PizzaForgeMapper<Ingredient, IngredientDTO> {

    @Override
    public IngredientDTO toDTO(Ingredient ingredient) {
        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .price(ingredient.getPrice())
                .build();
    }

    @Override
    public Ingredient toEntity(IngredientDTO ingredientDTO) {
        return Ingredient.builder()
                .name(ingredientDTO.getName())
                .price(ingredientDTO.getPrice())
                .build();
    }
}
