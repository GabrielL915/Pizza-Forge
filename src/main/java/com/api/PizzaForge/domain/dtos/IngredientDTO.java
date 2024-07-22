package com.api.PizzaForge.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
public class IngredientDTO {

    private Long id;

    @NotBlank(message = "The field 'name' cannot be blank")
    @Size(max = 100, message = "The field 'name' must be less than or equal to 100 characters")
    private String name;

    @NotNull(message = "The field 'currentStock' cannot be null")
    @PositiveOrZero(message = "The field 'currentStock' must be zero or positive")
    private Double currentStock;

    @NotNull(message = "The field 'minimumStock' cannot be null")
    @PositiveOrZero(message = "The field 'minimumStock' must be zero or positive")
    private Double minimumStock;

    @NotBlank(message = "The field 'unit' cannot be blank")
    @Size(max = 40, message = "The field 'unit' must be less than or equal to 10 characters")
    private String unit;

    @NotNull(message = "The field 'costPerUnit' cannot be null")
    @Positive(message = "The field 'costPerUnit' must be positive")
    private Double costPerUnit;

    private List<StockMovementDTO> stockMovementDTO;
}