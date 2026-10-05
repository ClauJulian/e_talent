package com.claujulian.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String nombre) {
        super("No se encontró el producto: " + nombre);
    }
    public ProductNotFoundException(int id) {
        super("No se encontró el producto con el siguiente id: " + id);
    }
}
