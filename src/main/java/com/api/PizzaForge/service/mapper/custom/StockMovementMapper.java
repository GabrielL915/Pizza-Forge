package com.api.PizzaForge.service.mapper.custom;

import com.api.PizzaForge.domain.dtos.StockMovementDTO;
import com.api.PizzaForge.domain.entities.StockMovement;
import com.api.PizzaForge.service.mapper.PizzaForgeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class StockMovementMapper implements PizzaForgeMapper<StockMovement, StockMovementDTO> {

    @Override
    public StockMovementDTO toDTO(StockMovement stockMovement) {
        return StockMovementDTO.builder()
                .id(stockMovement.getId())
                .quantity(stockMovement.getQuantity())
                .timestamp(stockMovement.getTimestamp())
                .type(stockMovement.getType())
                .details(stockMovement.getDetails())
                .build();
    }

    @Override
    public StockMovement toEntity(StockMovementDTO stockMovementDTO) {
        return StockMovement.builder()
                .quantity(stockMovementDTO.getQuantity())
                .timestamp(stockMovementDTO.getTimestamp())
                .type(stockMovementDTO.getType())
                .details(stockMovementDTO.getDetails())
                .build();
    }
}
