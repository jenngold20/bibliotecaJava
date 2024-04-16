package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Usuarios;
import com.miapp.biblioteca.service.UsuariosService;
import java.util.Scanner;

public class MenuUsuarios implements MenuCRUD<UsuariosService> {

    private UsuariosService usuariosService;

    //Constructor con parametros
    public MenuUsuarios(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @Override
    public void crear() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del nuevo usuario:");
        String id = scanner.nextLine();

        System.out.println("Ingrese el nombre del nuevo usuario:");
        String nombre = scanner.nextLine();

        usuariosService.createUsuario(id, nombre);
        System.out.println("Usuario creado correctamente.");
    }

    @Override
    public void listar() {
        System.out.println("Listado de todos los usuarios:");
        usuariosService.readAllUsuarios().forEach(System.out::println);
    }

    @Override
    public void listarPorId() {
        System.out.println("Ingrese el ID del usuario:");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();

        Usuarios usuario = usuariosService.readById(id);

        if (usuario != null) {
            System.out.println("Información del usuario:");
            System.out.println(usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    @Override
    public void actualizar() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del usuario a actualizar:");
        String id = scanner.nextLine().trim();

        System.out.println("Ingrese el nuevo ID (o presione Enter para mantener el mismo):");
        String nuevoId = scanner.nextLine().trim();

        System.out.println("Ingrese el nuevo nombre (o presione Enter para mantener el mismo):");
        String nuevoNombre = scanner.nextLine().trim();

        usuariosService.updateUsuario(id,
                nuevoId.isEmpty() ? null : nuevoId,
                nuevoNombre.isEmpty() ? null : nuevoNombre);

        System.out.println("Usuario actualizado correctamente.");
    }

    @Override
    public void borrar() {
        System.out.println("Ingrese el ID del usuario a borrar:");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();

        usuariosService.deleteUsuario(id);
        System.out.println("Usuario borrado correctamente.");
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("USUARIOS");
            System.out.println("1 - Crear usuario");
            System.out.println("2 - Listar todos los usuarios");
            System.out.println("3 - Listar usuario por ID");
            System.out.println("4 - Actualizar usuario");
            System.out.println("5 - Borrar usuario");
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

