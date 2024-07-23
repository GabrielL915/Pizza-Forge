package com.api.PizzaForge.service.mapper.custom;

import com.api.PizzaForge.domain.dtos.IngredientDTO;
import com.api.PizzaForge.domain.dtos.PizzaDTO;
import com.api.PizzaForge.domain.entities.Ingredient;
import com.api.PizzaForge.domain.entities.Pizza;
import com.api.PizzaForge.service.mapper.PizzaForgeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PizzaMapper implements PizzaForgeMapper<Pizza, PizzaDTO> {

    private final IngredientMapper ingredientMapper;

    @Override
    public PizzaDTO toDTO(Pizza pizza) {
        return PizzaDTO.builder()
                .id(pizza.getId())
                .name(pizza.getName())
                .price(pizza.getPrice())
                .ingredientDTO(pizza.getIngredientList().stream().map(ingredientMapper::toDTO).toList())
                .build();
    }

    @Override
    public Pizza toEntity(PizzaDTO pizzaDTO) {
        return Pizza.builder()
                .name(pizzaDTO.getName())
                .price(pizzaDTO.getPrice())
                .ingredientList(pizzaDTO.getIngredientDTO().stream().map(ingredientMapper::toEntity).toList())
                .build();
    }

    public List<Ingredient> toEntityList(List<IngredientDTO> ingredientDTOs) {
        return ingredientDTOs.stream().map(ingredientMapper::toEntity).toList();
    }
}
