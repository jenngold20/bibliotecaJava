package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libros;
import java.util.ArrayList;
import java.util.Iterator;

public class LibrosService {

    //Atributos
    private ArrayList<Libros> biblioteca; //Listado de libros de la biblioteca en un ArrayList


    //Constructor
    public LibrosService(ArrayList<Libros> biblioteca) {
        this.biblioteca = biblioteca;
    }


    //Metodos (CRUD)

    // Crear un libro
    public void createLibro(String ISBN, String titulo, String autor, String genero){
        Libros nuevoLibro = new Libros(ISBN, titulo, autor, genero);
        biblioteca.add(nuevoLibro);
    }

    // Leer todos los libros (READ)
    public ArrayList<Libros> readAllLibros(){
        return biblioteca;
    }

    // Leer libro por ISBN (READ BY ISBN)
    public Libros readByISBN(String ISBN){
        for(Libros libro : biblioteca){
            if(libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    // Leer libro por Autor (READ BY Autor)
    public Libros readByAutor(String autor){
        for (Libros libro : biblioteca){
            if(libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        System.out.println("Autor no encontrado");
        return null;
    }

    // Leer libro por Género (READ BY Género)
    public Libros readByGenero(String genero){
        for (Libros libro : biblioteca){
            if(libro.getGenero().equals(genero)) {
                return libro;
            }
        }
        System.out.println("Género no encontrado");
        return null;
    }

    // Leer libro por Titulo (READ BY Titulo)
    public Libros readByTitulo(String titulo){
        for (Libros libro : biblioteca){
            if(libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        System.out.println("Título no encontrado");
        return null;
    }

    // Actualizar (UPDATE)

    //Condicional por cada parametro (si no lo cambio o es nulo, que traiga el mismo)
    public void updateLibro(String ISBN, String nuevoISBN, String nuevoTitulo, String nuevoAutor, String nuevoGenero) {
        boolean encontrado = false;  // Variable para indicar si se encontró el ISBN
        for (Libros libro : biblioteca) {
            if (libro.getISBN().equals(ISBN)) {
                encontrado = true;  // Se encontró el ISBN

                if (nuevoISBN != null && !nuevoISBN.trim().isEmpty() && !libro.getISBN().equals(nuevoISBN.trim())) {
                    libro.setISBN(nuevoISBN.trim());
                    System.out.println("ISBN del libro actualizado correctamente");
                }

                if (nuevoTitulo != null && !libro.getTitulo().equals(nuevoTitulo)) {
                        libro.setTitulo(nuevoTitulo.trim());
                        System.out.println("Título del libro actualizado correctamente");
                }

                if (nuevoAutor != null && !libro.getAutor().equals(nuevoAutor)) {
                    libro.setAutor(nuevoAutor.trim());
                    System.out.println("Autor del libro actualizado correctamente");
                }

                if (nuevoGenero != null && !libro.getGenero().equals(nuevoGenero)) {
                    libro.setGenero(nuevoGenero.trim());
                    System.out.println("Género del libro actualizado correctamente");
                }

                break;  // Termina la búsqueda después de encontrar y actualizar el libro.
                }
            }

        if (!encontrado) {
            System.out.println("ISBN inexistente: No se encontró un libro para el ISBN proporcionado");
        }
    }


    // Eliminar (DELETE)
    public void deleteLibro (String ISBN){
        boolean libroEncontrado = false;
        Iterator<Libros> iterator = biblioteca.iterator();

        while (iterator.hasNext()) {
            Libros libro = iterator.next();
            if (libro.getISBN().equals(ISBN)) {
                iterator.remove();
                libroEncontrado = true;
                System.out.println("Libro borrado correctamente.");
                break;
            }
        }
        if (!libroEncontrado) {
            System.out.println("ISBN inexistente: No se encontró un libro para el ISBN proporcionado.");
        }
    }

}
