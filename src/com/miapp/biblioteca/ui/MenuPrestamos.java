package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Prestamos;
import com.miapp.biblioteca.service.PrestamosService;

import java.util.Scanner;

public class MenuPrestamos implements MenuCRUD<PrestamosService> {

    private PrestamosService prestamosService;

    //Constructor con parametros
    public MenuPrestamos(PrestamosService prestamosService) {
        this.prestamosService = prestamosService;
    }

    @Override
    public void crear() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del nuevo prestamo:");
        String idPrestamo = scanner.nextLine();

        System.out.println("Ingrese el ISBN del libro:");
        String ISBN = scanner.nextLine();

        System.out.println("Ingrese el ID del usuario:");
        String idUsuario = scanner.nextLine();

        prestamosService.crearPrestamo(idPrestamo, ISBN, idUsuario);
        System.out.println("Usuario creado correctamente.");
    }

    @Override
    public void listar() {
        System.out.println("Listado de todos los prestamos:");
        prestamosService.readAllPrestamos().forEach(System.out::println);
    }

    @Override
    public void listarPorId() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del usuario:");
        String idPrestamo = scanner.next();

        Prestamos prestamo = prestamosService.readById(idPrestamo);

        if (prestamo != null) {
            System.out.println("Información del prestamo:");
            System.out.println(prestamo);
        } else {
            System.out.println("Prestamo no encontrado.");
        }
    }

    @Override
    public void actualizar() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del préstamo a actualizar:");
        String idPrestamo = scanner.nextLine().trim();

        System.out.println("Ingrese el nuevo ID (o presione Enter para mantener el mismo):");
        String nuevoIdPrestamo = scanner.nextLine().trim();

        System.out.println("Ingrese el nuevo ID de usuario (o presione Enter para mantener el mismo):");
        String nuevoIdUsuario = scanner.nextLine().trim();

        System.out.println("Ingrese el nuevo ISBN (o presione Enter para mantener el mismo):");
        String nuevoISBN = scanner.nextLine().trim();

        prestamosService.updatePrestamo(idPrestamo, nuevoIdUsuario, nuevoISBN);

        System.out.println("Préstamo actualizado correctamente.");
    }

    @Override
    public void borrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del prestamo a borrar:");
        String idPrestamo = scanner.next();

        prestamosService.deletePrestamo(idPrestamo);
        System.out.println("Usuario borrado correctamente.");
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("PRESTAMOS");
            System.out.println("1 - Crear prestamo");
            System.out.println("2 - Listar todos los prestamos");
            System.out.println("3 - Listar prestamo por ID");
            System.out.println("4 - Actualizar prestamo");
            System.out.println("5 - Borrar prestamo");
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

