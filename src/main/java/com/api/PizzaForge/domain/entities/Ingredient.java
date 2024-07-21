package com.api.PizzaForge.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ingredient")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "current_stock", nullable = false)
    private Double currentStock;

    @Column(name = "minimum_stock", nullable = false)
    private Double minimumStock;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "cost_per_unit", nullable = false)
    private Double costPerUnit;

    @OneToMany
    @JoinColumn(name = "stock_movement_id")
    private List<StockMovement> stockMovement;
}
