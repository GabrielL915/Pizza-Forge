package com.api.PizzaForge.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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
public class IngredientDTO {

    private Long id;

    @NotBlank(message = "The field 'name' cannot be blank")
    @Size(max = 100, message = "The field 'name' must be less than or equal to 100 characters")
    private String name;

    @NotNull(message = "The field 'price' cannot be null")
    @PositiveOrZero(message = "The field 'price' must be zero or positive")
    private Double price;
}