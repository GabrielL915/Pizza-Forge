package com.api.PizzaForge.service.custom;

import com.api.PizzaForge.domain.dtos.PizzaDTO;
import com.api.PizzaForge.domain.entities.Pizza;
import com.api.PizzaForge.service.CRUDService;
import com.api.PizzaForge.service.mapper.custom.PizzaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService extends CRUDService<Pizza, Long, PizzaDTO> {

    @Autowired
    private PizzaMapper pizzaMapper;

    @Override
    protected void updateData(Pizza pizza, PizzaDTO pizzaDTO) {
        pizza.setName(pizzaDTO.getName());
        pizza.setPrice(pizzaDTO.getPrice());
        pizza.setIngredientList(pizzaMapper.toEntityList(pizzaDTO.getIngredientDTO()));
    }
}
