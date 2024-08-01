package com.api.PizzaForge.service.custom;

import com.api.PizzaForge.domain.dtos.TransactionsDTO;
import com.api.PizzaForge.domain.entities.Transactions;
import com.api.PizzaForge.service.CRUDService;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService extends CRUDService<Transactions, Long, TransactionsDTO> {

    @Override
    protected void updateData(Transactions transactions, TransactionsDTO transactionsDTO) {
        transactions.setDetails(transactionsDTO.getDetails());
        transactions.setType(transactionsDTO.getType());
        transactions.setCreateAt(transactionsDTO.getCreateAt());
        transactions.setQuantity(transactionsDTO.getQuantity());
    }
//
//    public List<TransactionsDTO> getRecentMovements(int limit) {
//        Pageable pageable = PageRequest.of(0, limit);
//        return transactionsRepository.findTopByOrderByTimestampDesc(pageable)
//                .stream()
//                .map(stockMovementMapper::toDTO)
//                .toList();
//    }
//
//    public Page<TransactionsDTO> getMovementsByDateRange(LocalDateTime start, LocalDateTime end, Pageable pageable) {
//        return transactionsRepository.findByTimestampBetween(start, end, pageable)
//                .map(stockMovementMapper::toDTO);
//    }
}
