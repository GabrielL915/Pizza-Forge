package com.api.PizzaForge.service.mapper.custom;

import com.api.PizzaForge.domain.dtos.IngredientDTO;
import com.api.PizzaForge.domain.dtos.StockMovementDTO;
import com.api.PizzaForge.domain.entities.Ingredient;
import com.api.PizzaForge.domain.entities.StockMovement;
import com.api.PizzaForge.service.mapper.PizzaForgeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IngredientMapper implements PizzaForgeMapper<Ingredient, IngredientDTO> {

    private final StockMovementMapper stockMovementMapper;

    @Override
    public IngredientDTO toDTO(Ingredient ingredient) {
        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .currentStock(ingredient.getCurrentStock())
                .minimumStock(ingredient.getMinimumStock())
                .unit(ingredient.getUnit())
                .costPerUnit(ingredient.getCostPerUnit())
                .stockMovementDTO(ingredient.getStockMovement().stream().map(stockMovementMapper::toDTO).toList())
                .build();
    }

    @Override
    public Ingredient toEntity(IngredientDTO ingredientDTO) {
        return Ingredient.builder()
                .name(ingredientDTO.getName())
                .currentStock(ingredientDTO.getCurrentStock())
                .minimumStock(ingredientDTO.getMinimumStock())
                .unit(ingredientDTO.getUnit())
                .costPerUnit(ingredientDTO.getCostPerUnit())
                .stockMovement(ingredientDTO.getStockMovementDTO().stream().map(stockMovementMapper::toEntity).toList())
                .build();
    }

    public List<StockMovement> toEntityList(List<StockMovementDTO> stockMovementDTOS) {
        return stockMovementDTOS.stream().map(stockMovementMapper::toEntity).toList();
    }
}
