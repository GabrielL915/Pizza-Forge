package com.api.PizzaForge.service.custom;

import com.api.PizzaForge.domain.dtos.PizzaDTO;
import com.api.PizzaForge.domain.entities.Pizza;
import com.api.PizzaForge.domain.repository.custom.PizzaRepository;
import com.api.PizzaForge.service.CRUDService;
import com.api.PizzaForge.service.mapper.custom.PizzaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PizzaService extends CRUDService<Pizza, Long, PizzaDTO> {

    @Autowired
    private PizzaMapper pizzaMapper;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    protected void checkBeforeSave(Pizza pizza, PizzaDTO pizzaDTO) {
        Optional<Pizza> existingPizza = getPizzaByName(pizzaDTO);

        if (existingPizza.isPresent() && !existingPizza.get().getId().equals(pizza.getId())) {
            throw new RuntimeException("An pizza with this name already exists");

        }
    }


    private Optional<Pizza> getPizzaByName(PizzaDTO pizzaDTO) {
        return pizzaRepository.findByName(pizzaDTO.getName());
    }

    @Override
    protected void updateData(Pizza pizza, PizzaDTO pizzaDTO) {
        checkBeforeSave(pizza, pizzaDTO);
        pizza.setName(pizzaDTO.getName());
        pizza.setPrice(pizzaDTO.getPrice());
        pizza.setIngredientList(pizzaMapper.toEntityList(pizzaDTO.getIngredientDTO()));
    }
}
