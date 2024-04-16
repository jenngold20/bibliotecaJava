package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libros;
import com.miapp.biblioteca.Usuarios;
import com.miapp.biblioteca.service.LibrosService;
import com.miapp.biblioteca.service.UsuariosService;

import java.util.Scanner;

public class MenuLibros implements MenuCRUD<LibrosService> {

    private LibrosService librosService;

    //Constructor con parametros
    public MenuLibros(LibrosService librosService) {
        this.librosService = librosService;
    }

    @Override
    public void crear() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ISBN del nuevo libro:");
        String ISBN = scanner.nextLine();

        System.out.println("Ingrese el título del nuevo libro:");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese el autor del nuevo libro:");
        String autor = scanner.nextLine();

        System.out.println("Ingrese el genero del nuevo libro:");
        String genero = scanner.nextLine();

        librosService.createLibro(ISBN, titulo, autor, genero);
        System.out.println("Libro creado correctamente.");
    }

    @Override
    public void listar() {
        System.out.println("Listado de todos los libros:");
        librosService.readAllLibros().forEach(System.out::println);
    }

    @Override
    public void listarPorId() {
        System.out.println("Ingrese el ISBN del libro:");
        Scanner scanner = new Scanner(System.in);
        String ISBN = scanner.next();

        Libros libro = librosService.readByISBN(ISBN);

        if (libro != null) {
            System.out.println("Información del libro:");
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    @Override
    public void actualizar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ISBN del libro a actualizar:");
        String ISBN = scanner.nextLine().trim();

        System.out.println("Ingrese el nuevo ISBN (o presione Enter para mantener el mismo):");
        String nuevoISBN = scanner.nextLine().trim();

        System.out.println("Ingrese el nuevo titulo (o presione Enter para mantener el mismo):");
        String nuevoTitulo = scanner.nextLine().trim();

        System.out.println("Ingrese el nuevo autor (o presione Enter para mantener el mismo):");
        String nuevoAutor = scanner.nextLine().trim();

        System.out.println("Ingrese el nuevo genero (o presione Enter para mantener el mismo):");
        String nuevoGenero = scanner.nextLine().trim();

        librosService.updateLibro(ISBN,
                nuevoISBN.trim().isEmpty() ? null : nuevoISBN,
                nuevoTitulo.trim().isEmpty() ? null : nuevoTitulo,
                nuevoAutor.trim().isEmpty() ? null : nuevoAutor,
                nuevoGenero.trim().isEmpty() ? null : nuevoGenero);

        System.out.println("Libro actualizado correctamente.");
    }

    @Override
    public void borrar() {
        System.out.println("Ingrese el ISBN del libro a borrar:");
        Scanner scanner = new Scanner(System.in);
        String ISBN = scanner.next();

        librosService.deleteLibro(ISBN);
        System.out.println("Libro borrado correctamente.");
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("LIBROS");
            System.out.println("1 - Crear libro");
            System.out.println("2 - Listar todos los libros");
            System.out.println("3 - Listar libros por ISBN");
            System.out.println("4 - Actualizar libro");
            System.out.println("5 - Borrar libro");
            System.out.println("0 - Menu anterior");

            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    listarPorId();
                    break;
                case 4:
                    actualizar();
                    break;
                case 5:
                    borrar();
                    break;
                case 0:
                    return; // Salir del bucle y volver al menú anterior
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}

