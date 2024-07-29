package com.api.PizzaForge.service.custom;

import com.api.PizzaForge.domain.dtos.IngredientDTO;
import com.api.PizzaForge.domain.entities.Ingredient;
import com.api.PizzaForge.service.CRUDService;
import com.api.PizzaForge.service.mapper.custom.IngredientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientService extends CRUDService<Ingredient, Long, IngredientDTO> {

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

    public void updateStock(Long id, double newStock) {
        Ingredient ingredient = findByIdOrElseThrowException(id);
        ingredient.setCurrentStock(newStock);
//        save(ingredient);

        checkLowStock(ingredient);
    }

    private void checkLowStock(Ingredient ingredient) {
        if (ingredient.getCurrentStock() < ingredient.getMinimumStock()) {
//            emailService.sendLowStockAlert(ingredient);
            System.out.println("Alert");
        }
    }
}
