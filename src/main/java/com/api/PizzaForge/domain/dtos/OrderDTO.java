package com.api.PizzaForge.domain.dtos;

import com.api.PizzaForge.shared.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {

    private Long id;

    @NotNull(message = "The field 'orderData' cannot be null")
    @PastOrPresent(message = "The field 'orderData' must be in the past or present")
    private LocalDateTime orderData;

    @NotNull(message = "The field 'status' cannot be null")
    private Status status;

    @NotNull(message = "The field 'totalAmount' cannot be null")
    @PositiveOrZero(message = "The field 'totalAmount' must be 0 or positive")
    private Double totalAmount;

    private List<OrderItemDTO> orderItemDTOS;
}
