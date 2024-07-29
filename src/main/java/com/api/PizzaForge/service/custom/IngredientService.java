package com.api.PizzaForge.service.custom;

import com.api.PizzaForge.domain.dtos.IngredientDTO;
import com.api.PizzaForge.domain.entities.Ingredient;
import com.api.PizzaForge.domain.repository.custom.IngredientRepository;
import com.api.PizzaForge.service.CRUDService;
import com.api.PizzaForge.service.mapper.custom.IngredientMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientService extends CRUDService<Ingredient, Long, IngredientDTO> {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientMapper ingredientMapper;

    @Override
    protected void updateData(Ingredient ingredient, IngredientDTO ingredientDTO) {
        ingredient.setName(ingredientDTO.getName());
        ingredient.setCurrentStock(ingredientDTO.getCurrentStock());
        ingredient.setMinimumStock(ingredientDTO.getMinimumStock());
        ingredient.setUnit(ingredientDTO.getUnit());
        ingredient.setCostPerUnit(ingredient.getCostPerUnit());
        ingredient.setStockMovement(ingredientMapper.toEntityList(ingredientDTO.getStockMovementDTO()));
    }

    @Override
    @Transactional
    public IngredientDTO update(Long id, IngredientDTO ingredientDTO) {
        Ingredient ingredient = findByIdOrElseThrowException(id);
        updateData(ingredient, ingredientDTO);
        Ingredient updatedIngredient = ingredientRepository.save(ingredient);
        checkLowStock(updatedIngredient);
        return ingredientMapper.toDTO(updatedIngredient);
    }

    private void checkLowStock(Ingredient ingredient) {
        if (ingredient.getCurrentStock() < ingredient.getMinimumStock()) {
            System.out.println("Alert");
        }
    }
}