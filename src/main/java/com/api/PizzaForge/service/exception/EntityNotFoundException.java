package com.api.PizzaForge.service.exception;

public class EntityNotFoundException extends PizzaForgeStandardException {

    private static final String DEFAULT_MESSAGE = "Unable to find entity.";

    private static final String DEFAULT_MESSAGE_KEY = "pizza-forge.entity-not-found.error";

    public EntityNotFoundException(Object id) {
        super(String.format("Entity with id %s not found.", id));
    }

    @Override
    public String getDefaultMessage() {
        return DEFAULT_MESSAGE;
    }

    @Override
    public String getDefaultMessageKey() {
        return DEFAULT_MESSAGE_KEY;
    }
}
