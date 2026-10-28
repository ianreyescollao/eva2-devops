package com.cocinApp.msvc_ingrediente.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException (String msje) {
        super(msje);
    }
}
