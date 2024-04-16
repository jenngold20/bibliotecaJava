package com.miapp.biblioteca;

public class Libros {

    //Atributos
    private String ISBN;
    private String titulo;
    private String autor;
    private String genero;
    private boolean disponible;

    //Constructores

    //Constructor vacio
    public Libros() {
    }

    //Contructor parametrizado


    public Libros(String ISBN, String titulo, String autor, String genero) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponible = true;
    }
//Getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


    //Funcion de Informacion

    @Override
    public String toString() {
        return "Libros{" +
                "\n ISBN='" + ISBN + '\'' +
                "\n titulo='" + titulo + '\'' +
                "\n autor='" + autor + '\'' +
                "\n genero='" + genero + '\'' +
                "\n disponible=" + disponible +
                '}';
    }
}
