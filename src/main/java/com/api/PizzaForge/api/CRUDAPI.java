package com.api.PizzaForge.api;

import com.api.PizzaForge.service.CRUDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public abstract class CRUDAPI<Entity, ID, DTO> {

    private static final String ID_PATH_VARIABLE = "/{id}";

    @Autowired
    private CRUDService<Entity, ID, DTO> crudService;

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody @Valid DTO dto) {
        var newObject = crudService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newObject);
    }

    @GetMapping
    public ResponseEntity<List<DTO>> findAll() {
        var list = crudService.findAll();
        return ResponseEntity.ok(list);
    }
}
