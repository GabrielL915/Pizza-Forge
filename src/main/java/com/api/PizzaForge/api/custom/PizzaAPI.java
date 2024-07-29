package com.api.PizzaForge.api.custom;

import com.api.PizzaForge.api.CRUDAPI;
import com.api.PizzaForge.domain.dtos.PizzaDTO;
import com.api.PizzaForge.domain.entities.Pizza;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pizza")
public class PizzaAPI extends CRUDAPI<Pizza, Long, PizzaDTO> {
}
