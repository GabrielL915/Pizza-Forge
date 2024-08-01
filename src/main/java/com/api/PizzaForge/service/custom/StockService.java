package com.api.PizzaForge.service.custom;

import com.api.PizzaForge.domain.dtos.StockDTO;
import com.api.PizzaForge.domain.entities.Stock;
import com.api.PizzaForge.service.CRUDService;
import org.springframework.stereotype.Service;

@Service
public class StockService extends CRUDService<Stock, Long, StockDTO> {
    @Override
    protected void updateData(Stock stock, StockDTO stockDTO) {

    }
}
