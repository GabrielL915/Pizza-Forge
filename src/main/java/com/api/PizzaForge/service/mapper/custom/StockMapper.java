package com.api.PizzaForge.service.mapper.custom;

import com.api.PizzaForge.domain.dtos.StockDTO;
import com.api.PizzaForge.domain.entities.Stock;
import com.api.PizzaForge.service.mapper.PizzaForgeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockMapper implements PizzaForgeMapper<Stock, StockDTO> {

    private final IngredientMapper ingredientMapper;

    @Override
    public StockDTO toDTO(Stock stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .quantity(stock.getQuantity())
                .unit(stock.getUnit())
                .ingredientDTO(ingredientMapper.toDTO(stock.getIngredient()))
                .build();
    }

    @Override
    public Stock toEntity(StockDTO stockDTO) {
        return Stock.builder()
                .quantity(stockDTO.getQuantity())
                .unit(stockDTO.getUnit())
                .ingredient(ingredientMapper.toEntity(stockDTO.getIngredientDTO()))
                .build();
    }
}
