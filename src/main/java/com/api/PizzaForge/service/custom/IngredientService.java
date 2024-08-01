package com.api.PizzaForge.service.custom;

import com.api.PizzaForge.domain.dtos.IngredientDTO;
import com.api.PizzaForge.domain.entities.Ingredient;
import com.api.PizzaForge.service.CRUDService;
import org.springframework.stereotype.Service;

@Service
public class IngredientService extends CRUDService<Ingredient, Long, IngredientDTO> {

    @Override
    protected void updateData(Ingredient ingredient, IngredientDTO ingredientDTO) {
        ingredient.setName(ingredientDTO.getName());
        ingredient.setPrice(ingredientDTO.getPrice());
    }

//    private void checkLowStock(Ingredient ingredient) {
//        if (ingredient.getCurrentStock() < ingredient.getMinimumStock()) {
//            System.out.println("Alert");
//        }
//    }
}