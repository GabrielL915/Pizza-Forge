package com.api.PizzaForge.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PizzaDTO {

    private Long id;

    @NotBlank(message = "The field 'name' cannot be blank")
    private String name;

    @NotNull(message = "The field 'price' cannot be blank")
    private Double price;

    private List<IngredientDTO> ingredientDTO;
}