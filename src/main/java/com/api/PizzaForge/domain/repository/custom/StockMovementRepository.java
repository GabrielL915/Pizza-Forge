package com.api.PizzaForge.domain.repository.custom;

import com.api.PizzaForge.domain.entities.StockMovement;
import com.api.PizzaForge.domain.repository.CRUDRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StockMovementRepository extends CRUDRepository<StockMovement, Long> {
    List<StockMovement> findTopByOrderByTimestampDesc(Pageable pageable);

    Page<StockMovement> findByTimestampBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);
}
