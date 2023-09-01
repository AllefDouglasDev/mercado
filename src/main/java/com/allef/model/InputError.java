package com.allef.model;

import java.util.HashMap;

public class InputError {
    private HashMap<String, String> errors;

    public InputError() {
        this.errors = new HashMap<>();
    }

    public void add(String field, String message) {
        this.errors.put(field, message);
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String getError(String field) {
        return errors.get(field);
    }

    public void clearErrors() {
        errors.clear();
    }
}
