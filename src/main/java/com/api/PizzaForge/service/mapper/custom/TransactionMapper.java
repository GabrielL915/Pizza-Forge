package com.api.PizzaForge.service.mapper.custom;

import com.api.PizzaForge.domain.dtos.TransactionsDTO;
import com.api.PizzaForge.domain.entities.Transactions;
import com.api.PizzaForge.service.mapper.PizzaForgeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionMapper implements PizzaForgeMapper<Transactions, TransactionsDTO> {

    private final StockMapper stockMapper;

    @Override
    public TransactionsDTO toDTO(Transactions transactions) {
        return TransactionsDTO.builder()
                .id(transactions.getId())
                .quantity(transactions.getQuantity())
                .createAt(transactions.getCreateAt())
                .type(transactions.getType())
                .details(transactions.getDetails())
                .stock(stockMapper.toDTO(transactions.getStock()))
                .build();
    }

    @Override
    public Transactions toEntity(TransactionsDTO transactionsDTO) {
        return Transactions.builder()
                .quantity(transactionsDTO.getQuantity())
                .createAt(transactionsDTO.getCreateAt())
                .type(transactionsDTO.getType())
                .details(transactionsDTO.getDetails())
                .stock(stockMapper.toEntity(transactionsDTO.getStock()))
                .build();
    }
}
