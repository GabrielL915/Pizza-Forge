package com.api.PizzaForge.service.custom;

import com.api.PizzaForge.domain.dtos.IngredientDTO;
import com.api.PizzaForge.domain.entities.Ingredient;
import com.api.PizzaForge.domain.repository.custom.IngredientRepository;
import com.api.PizzaForge.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService extends CRUDService<Ingredient, Long, IngredientDTO> {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    protected void checkBeforeSave(Ingredient ingredient, IngredientDTO ingredientDTO) {
        Optional<Ingredient> existingIngredient = getIngredientByName(ingredientDTO);

        if (existingIngredient.isPresent() && !existingIngredient.get().getId().equals(ingredient.getId())) {
            throw new RuntimeException("An ingredient with this name already exists");
        }
    }

    private Optional<Ingredient> getIngredientByName(IngredientDTO ingredientDTO) {
        return ingredientRepository.findByName(ingredientDTO.getName());
    }

    @Override
    protected void updateData(Ingredient ingredient, IngredientDTO ingredientDTO) {
        checkBeforeSave(ingredient, ingredientDTO);
        ingredient.setName(ingredientDTO.getName());
        ingredient.setPrice(ingredientDTO.getPrice());
    }

//    private void checkLowStock(Ingredient ingredient) {
//        if (ingredient.getCurrentStock() < ingredient.getMinimumStock()) {
//            System.out.println("Alert");
//        }
//    }
}