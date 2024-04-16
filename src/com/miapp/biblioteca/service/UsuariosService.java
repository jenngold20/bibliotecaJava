package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Usuarios;
import java.util.ArrayList;

public class UsuariosService {

    //Atributos
    private ArrayList<Usuarios> usuarios; //Listado de usuarios de la biblioteca en un ArrayList


    //Constructor
    public UsuariosService(ArrayList<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }


    //Metodos (CRUD)

    // Crear un usuario
    public void createUsuario(String id, String nombre) {
        Usuarios nuevoUsuario = new Usuarios(id, nombre);
        usuarios.add(nuevoUsuario);
    }

    // Leer todos los usuarios (READ)
    public ArrayList<Usuarios> readAllUsuarios() {
        return usuarios;
    }

    // Leer usuario por id (READ BY id)
    public Usuarios readById(String id) {
        for (Usuarios usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        System.out.println("Usuario no encontrado");
        return null;
    }

    // Actualizar (UPDATE)

    //Condicional por cada parametro (si no lo cambio o es nulo, que traiga el mismo)
    public void updateUsuario(String id, String nuevoId, String nuevoNombre) {
        boolean encontrado = false;  // Variable para indicar si se encontró el ID
        for (Usuarios usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                encontrado = true; // Se encontró el ID

                if (nuevoId != null && !nuevoId.trim().isEmpty() && !usuario.getId().equals(nuevoId.trim())) {
                    usuario.setId(nuevoId.trim());
                    System.out.println("Id del usuario actualizado correctamente");
                }

                if (nuevoNombre != null && !usuario.getNombre().equals(nuevoNombre)) {
                    usuario.setNombre(nuevoNombre.trim());
                    System.out.println("Nombre del usuario actualizado correctamente");
                }
                // Termina la búsqueda después de encontrar y actualizar el usuario
                break;
            }

            // Imprime el mensaje solo si no se encontró el usuario con el ID proporcionado
            if (!encontrado) {
                System.out.println("Id inexistente. No se encontró un usuario para el id: " + id);
            }
        }
    }


    // Eliminar (DELETE)
    public void deleteUsuario(String id) {
        usuarios.removeIf(usuarios -> usuarios.getId().equals(id));
    }
}
