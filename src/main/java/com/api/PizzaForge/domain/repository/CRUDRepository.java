package com.api.PizzaForge.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CRUDRepository<Entity, ID> extends JpaRepository<Entity, ID> {
}
