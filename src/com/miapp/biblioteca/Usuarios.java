package com.miapp.biblioteca;

import java.util.ArrayList;

public class Usuarios {

    //Atributos
    private String id;
    private String nombre;
    private ArrayList<Libros> librosPrestados;


    //Constructores

    public Usuarios() {
    }

    public Usuarios(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Libros> getLibrosPrestados() {
        return librosPrestados;
    }


    //Funcion de informacion


    @Override
    public String toString() {
        return "Usuarios{" +
                "\nid='" + id + '\'' +
                "\nnombre='" + nombre + '\'' +
                "\nlibrosPrestados=" + librosPrestados +
                '}';
    }
}
