package com.api.PizzaForge.service.mapper;

public interface PizzaForgeMapper<Entity, DTO> {

    DTO toDTO(Entity entity);

    Entity toEntity(DTO dto);
}
