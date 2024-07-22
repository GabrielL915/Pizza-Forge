package com.api.PizzaForge.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemDTO {

    private Long id;

    @NotNull(message = "The field 'quantity' cannot be null")
    @Positive(message = "The field 'quantity' must be positive")
    private Integer quantity;

    private OrderDTO orderDTO;

    private PizzaDTO pizzaDTO;
}
