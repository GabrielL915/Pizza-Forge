package com.api.PizzaForge.service.custom;

import com.api.PizzaForge.domain.dtos.StockMovementDTO;
import com.api.PizzaForge.domain.entities.StockMovement;
import com.api.PizzaForge.service.CRUDService;
import org.springframework.stereotype.Service;

@Service
public class StockMovementService extends CRUDService<StockMovement, Long, StockMovementDTO> {
    @Override
    protected void updateData(StockMovement stockMovement, StockMovementDTO stockMovementDTO) {
        stockMovement.setDetails(stockMovementDTO.getDetails());
        stockMovement.setType(stockMovementDTO.getType());
        stockMovement.setTimestamp(stockMovementDTO.getTimestamp());
        stockMovement.setQuantity(stockMovement.getQuantity());
    }
}
