package com.api.PizzaForge.domain.repository.custom;

import com.api.PizzaForge.domain.entities.Transactions;
import com.api.PizzaForge.domain.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends CRUDRepository<Transactions, Long> {
//    List<Transactions> findTopByOrderByTimestampDesc(Pageable pageable);
//
//    Page<Transactions> findByTimestampBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);
}
