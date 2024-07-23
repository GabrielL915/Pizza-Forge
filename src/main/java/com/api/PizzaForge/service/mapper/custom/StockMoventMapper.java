package com.api.PizzaForge.service.mapper.custom;

import com.api.PizzaForge.domain.dtos.StockMovementDTO;
import com.api.PizzaForge.domain.entities.StockMovement;
import com.api.PizzaForge.service.mapper.PizzaForgeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockMoventMapper implements PizzaForgeMapper<StockMovement, StockMovementDTO> {

    private final IngredientMapper ingredientMapper;

    @Override
    public StockMovementDTO toDTO(StockMovement stockMovement) {
        return StockMovementDTO.builder()
                .id(stockMovement.getId())
                .quantity(stockMovement.getQuantity())
                .timestamp(stockMovement.getTimestamp())
                .type(stockMovement.getType())
                .details(stockMovement.getDetails())
                .ingredientDTO(ingredientMapper.toDTO(stockMovement.getIngredient()))
                .build();
    }

    @Override
    public StockMovement toEntity(StockMovementDTO stockMovementDTO) {
        return StockMovement.builder()
                .quantity(stockMovementDTO.getQuantity())
                .timestamp(stockMovementDTO.getTimestamp())
                .type(stockMovementDTO.getType())
                .details(stockMovementDTO.getDetails())
                .ingredient(ingredientMapper.toEntity(stockMovementDTO.getIngredientDTO()))
                .build();
    }
}
