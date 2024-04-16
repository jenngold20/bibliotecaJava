package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libros;
import com.miapp.biblioteca.Prestamos;
import com.miapp.biblioteca.Usuarios;
import com.miapp.biblioteca.service.LibrosService;
import com.miapp.biblioteca.service.PrestamosService;
import com.miapp.biblioteca.service.UsuariosService;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuInicial {

    public void mostrarMenuInicial() {
        // Crear listas fuera del bucle
        ArrayList<Usuarios> gente = new ArrayList<>();
        ArrayList<Libros> books = new ArrayList<>();
        ArrayList<Prestamos> borrow = new ArrayList<>();

        // Crear servicios fuera del bucle
        UsuariosService usuariosService = new UsuariosService(gente);
        LibrosService librosService = new LibrosService(books);
        PrestamosService prestamosService = new PrestamosService(borrow, librosService, usuariosService);
// metodo mostrar menu
        while (true) {
            System.out.println("Bienvenidos a la Ale's library: ");
            System.out.println("1 - Usuarios");
            System.out.println("2 - Libros");
            System.out.println("3 - Prestamos");
            System.out.println("0 - Salir");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear un menú de usuarios con el servicio de usuarios
                    MenuUsuarios menuUsuarios = new MenuUsuarios(usuariosService);
                    // Mostrar menu de usuarios
                    menuUsuarios.mostrarMenu();
                    break;

                case 2:
                    // Crear un menú de libros con el servicio de libros
                    MenuLibros menuLibros = new MenuLibros(librosService);
                    // Mostrar menu de libros
                    menuLibros.mostrarMenu();
                    break;

                case 3:
                    // Crear un menú de préstamos con el servicio de préstamos
                    MenuPrestamos menuPrestamos = new MenuPrestamos(prestamosService);
                    // Mostrar menu de préstamos
                    menuPrestamos.mostrarMenu();
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}


