package com.api.PizzaForge.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
public class StockDTO {

    private Long id;

    @NotNull(message = "The field 'quantity' cannot be null")
    @Positive(message = "The field 'quantity' must be positive")
    private Double quantity;

    @NotBlank(message = "The field 'unit' cannot be blank")
    @Size(max = 40, message = "The field 'unit' must be less than or equal to 10 characters")
    private String unit;

    private IngredientDTO ingredientDTO;

    private List<TransactionsDTO> transactionsDTOs;
}
