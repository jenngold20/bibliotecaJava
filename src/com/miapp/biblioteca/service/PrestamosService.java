package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libros;
import com.miapp.biblioteca.Prestamos;
import com.miapp.biblioteca.Usuarios;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PrestamosService {

    //Atributos
    private ArrayList<Prestamos> prestamos; //Listado de prestamos de la biblioteca en un ArrayList
    private LibrosService librosService;
    private UsuariosService usuariosService;


    //Constructor
    public PrestamosService(ArrayList<Prestamos> prestamos, LibrosService librosService, UsuariosService usuariosService) {
        this.prestamos = prestamos;
        this.librosService = librosService;
        this.usuariosService = usuariosService;
    }

    //Metodos (CRUD)

    // Crear un prestamo
    public ArrayList<Prestamos> crearPrestamo(String idPrestamo, String ISBN, String idUsuario) {

        // Buscar libro por ISBN
        Libros libro = librosService.readByISBN(ISBN);

        // Buscar usuario por ID
        Usuarios usuario = usuariosService.readById(idUsuario);


        // Verificar si el libro y el usuario existen
        if (libro != null && usuario != null) {
            // Verificar si el libro está disponible
            if (libro.isDisponible()) {
                Prestamos nuevoPrestamo = new Prestamos(idPrestamo, libro, usuario);

                // Obtener la fecha y hora actual
                LocalDateTime fechaActual = LocalDateTime.now();

                // Establecer fecha de prestamos y de devolución
                nuevoPrestamo.setFechaPrestamo(fechaActual);
                LocalDateTime fechaDevolucion = fechaActual.plusDays(10);
                nuevoPrestamo.setFechaDevolucion(fechaDevolucion);

                // Agregar el préstamo a la lista de préstamos
                prestamos.add(nuevoPrestamo);

                // Agregar el libro a la lista de libros prestados del usuario
                usuario.getLibrosPrestados().add(libro);

                // Marcar el libro como no disponible
                libro.setDisponible(false);

                System.out.println("Préstamo creado exitosamente.");
                System.out.println("Fecha del prestamo: " + nuevoPrestamo.getFechaPrestamo());
                System.out.println("Fecha de devolución: " + nuevoPrestamo.getFechaDevolucion());

            } else {
                System.out.println("El libro no está disponible para préstamo");
            }
        } else {
            System.out.println("Usuario o libro no encontrado");
        }
        return prestamos;
    }

    // Leer todos los prestamos (READ)
    public ArrayList<Prestamos> readAllPrestamos() {
        return prestamos;
    }

    // Leer prestamo por id (READ BY id)
    public Prestamos readById(String idPrestamo) {
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getIdPrestamo().equals(idPrestamo)) {
                return prestamo;
            }
        }
        System.out.println("Prestamo no encontrado");
        return null;
    }


    // Actualizar (UPDATE)

    //Condicional por cada parametro (si no lo cambio o es nulo, que traiga el mismo)
    public void updatePrestamo(String idPrestamo, String nuevoIdUsuario, String nuevoISBN) {
        boolean encontrado = false;  // Variable para indicar si se encontró el ID

        // Obtener la fecha y hora actual fuera del bucle para evitar recalcularla en cada iteración
        LocalDateTime fechaActual = LocalDateTime.now();

        for (Prestamos prestamo : prestamos) {
            if (prestamo.getIdPrestamo().equals(idPrestamo)) {
                encontrado = true; // Se encontró el ID

                // Actualizar ISBN si es proporcionado
                if (nuevoISBN != null && !nuevoISBN.isEmpty()) {
                    Libros nuevoLibro = librosService.readByISBN(nuevoISBN);
                    if (nuevoLibro != null) {
                        prestamo.setLibro(nuevoLibro);
                        System.out.println("ISBN del préstamo se ha actualizado correctamente");
                    } else {
                        System.out.println("El nuevo ISBN no corresponde a un libro existente");
                    }
                }

                // Actualizar ID de usuario si es proporcionado
                if (nuevoIdUsuario != null && !nuevoIdUsuario.isEmpty()) {
                    Usuarios nuevoUsuario = usuariosService.readById(nuevoIdUsuario);
                    if (nuevoUsuario != null) {
                        prestamo.setUsuario(nuevoUsuario);
                        System.out.println("ID de usuario del préstamo actualizado correctamente");
                    } else {
                        System.out.println("El nuevo ID de usuario no corresponde a un usuario existente");
                    }
                }

                // Establecer fecha de préstamo y de devolución
                prestamo.setFechaPrestamo(fechaActual);
                LocalDateTime fechaDevolucion = fechaActual.plusDays(10);
                prestamo.setFechaDevolucion(fechaDevolucion);

                System.out.println("Préstamo modificado exitosamente.");
                System.out.println("Fecha del préstamo: " + prestamo.getFechaPrestamo());
                System.out.println("Fecha de devolución: " + prestamo.getFechaDevolucion());

                // Termina la búsqueda después de encontrar y actualizar el préstamo
                break;
            }
        }

        // Imprime el mensaje solo si no se encontró el préstamo con el ID proporcionado
        if (!encontrado) {
            System.out.println("ID inexistente. No se encontró un préstamo para el ID: " + idPrestamo);
        }
    }


    // Eliminar (DELETE)
    public void deletePrestamo(String idPrestamo) {
        prestamos.removeIf(prestamos -> prestamos.getIdPrestamo().equals(idPrestamo));
    }
}