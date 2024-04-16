package com.miapp.biblioteca;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Prestamos {

    // Atributos
    private String idPrestamo;
    private Libros libro;
    private Usuarios usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;


    //Constructores

    public Prestamos(String idPrestamo, Libros libro, Usuarios usuario) {
        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now(); // La fecha de préstamo es la fecha actual

        // Inicializar la fecha de devolución como fechaPrestamo + 10 días
        this.fechaDevolucion = this.fechaPrestamo.plusDays(10);
    }

    //Getters y setters

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = LocalDate.from(fechaPrestamo);
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
    }

    @Override
    public String toString() {
        return "Prestamos{" +
                "\n idPrestamo='" + idPrestamo + '\'' +
                "\n libro=" + libro +
                "\n usuario=" + usuario +
                "\n fechaPrestamo=" + fechaPrestamo +
                "\n fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
