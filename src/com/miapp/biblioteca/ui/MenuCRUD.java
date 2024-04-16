package com.miapp.biblioteca.ui;

public interface MenuCRUD<T> {
    void crear();
    void listar();
    void listarPorId();
    void actualizar();
    void borrar();
}