package com.api.PizzaForge.service.custom;

import com.api.PizzaForge.domain.dtos.StockMovementDTO;
import com.api.PizzaForge.domain.entities.Ingredient;
import com.api.PizzaForge.domain.entities.StockMovement;
import com.api.PizzaForge.domain.repository.custom.StockMovementRepository;
import com.api.PizzaForge.service.CRUDService;
import com.api.PizzaForge.service.mapper.custom.StockMovementMapper;
import com.api.PizzaForge.shared.enums.TypeMovement;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockMovementService extends CRUDService<StockMovement, Long, StockMovementDTO> {

    @Autowired
    private StockMovementRepository stockMovementRepository;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private StockMovementMapper stockMovementMapper;

    @Override
    @Transactional
    public StockMovementDTO create(StockMovementDTO stockMovementDTO) {
        StockMovement stockMovement = stockMovementMapper.toEntity(stockMovementDTO);
        stockMovement.setTimestamp(LocalDateTime.now());

        StockMovement savedMovement = stockMovementRepository.save(stockMovement);

        return stockMovementMapper.toDTO(savedMovement);
    }

    @Override
    protected void updateData(StockMovement stockMovement, StockMovementDTO stockMovementDTO) {
        stockMovement.setDetails(stockMovementDTO.getDetails());
        stockMovement.setType(stockMovementDTO.getType());
        stockMovement.setTimestamp(stockMovementDTO.getTimestamp());
        stockMovement.setQuantity(stockMovementDTO.getQuantity());
    }

    public List<StockMovementDTO> getRecentMovements(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return stockMovementRepository.findTopByOrderByTimestampDesc(pageable)
                .stream()
                .map(stockMovementMapper::toDTO)
                .toList();
    }

    public Page<StockMovementDTO> getMovementsByDateRange(LocalDateTime start, LocalDateTime end, Pageable pageable) {
        return stockMovementRepository.findByTimestampBetween(start, end, pageable)
                .map(stockMovementMapper::toDTO);
    }
}
