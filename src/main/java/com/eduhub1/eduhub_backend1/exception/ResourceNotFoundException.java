package com.eduhub1.eduhub_backend1.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, String field, String error) {
        super(String.format("%s not found with %s: %s", resource, field, error));
    }
}


