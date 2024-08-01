package com.api.PizzaForge.api.custom;

import com.api.PizzaForge.api.CRUDAPI;
import com.api.PizzaForge.domain.dtos.TransactionsDTO;
import com.api.PizzaForge.domain.entities.Transactions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
public class StockMovementAPI extends CRUDAPI<Transactions, Long, TransactionsDTO> {
}
