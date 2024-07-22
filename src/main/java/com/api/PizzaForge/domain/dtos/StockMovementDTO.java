package com.api.PizzaForge.domain.dtos;

import com.api.PizzaForge.shared.enums.TypeMovement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockMovementDTO {

    private Long id;

    @NotNull(message = "The field 'quantity' cannot be null")
    @PositiveOrZero(message = "The field 'quantity' must be 0 or positive")
    private Double quantity;

    @NotNull(message = "The field 'timestamp' cannot be null")
    @PastOrPresent(message = "The field 'timestamp' must be in the past or present")
    private LocalDateTime timestamp;

    @NotNull(message = "The field 'type' cannot be null")
    private TypeMovement type;

    @NotBlank(message = "The field 'details' cannot be null")
    private String details;

    private IngredientDTO ingredientDTO;
}
