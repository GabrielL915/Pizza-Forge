package com.api.PizzaForge.service;

import com.api.PizzaForge.domain.repository.CRUDRepository;
import com.api.PizzaForge.service.mapper.PizzaForgeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CRUDService<Entity, ID, DTO> {

    @Autowired
    private CRUDRepository<Entity, ID> crudRepository;

    @Autowired
    private PizzaForgeMapper<Entity, DTO> pizzaForgeMapper;

    public DTO create(DTO dto) {
        Entity newEntity = pizzaForgeMapper.toEntity(dto);
        return pizzaForgeMapper.toDTO(crudRepository.save(newEntity));
    }

    public List<DTO> findAll() {
        return crudRepository.findAll()
                .stream()
                .map(pizzaForgeMapper::toDTO)
                .toList();
    }

    public DTO findById(ID id) {
        return pizzaForgeMapper.toDTO(findByIdOrElseThrowException(id));
    }

    public DTO update(ID id, DTO dto) {
        Entity entityToUpdate = findByIdOrElseThrowException(id);
        updateData(entityToUpdate, dto);
        return pizzaForgeMapper.toDTO(crudRepository.save(entityToUpdate));
    }

    public void delete(ID id) {
        crudRepository.delete(findByIdOrElseThrowException(id));
    }

    private Entity findByIdOrElseThrowException(ID id) {
        return crudRepository.findById(id).orElseThrow();
    }

    protected abstract void updateData(Entity entity, DTO dto);
}
