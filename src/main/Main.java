/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import comicSystem.Comic;
import comicSystem.ComicCollectorSystem;
import comicSystem.ComicNoEncontradoException;
import comicSystem.ComicYaReservadoException;
import comicSystem.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ComicCollectorSystem sistema = new ComicCollectorSystem(); // Se instancia el sistema
        Scanner scanner = new Scanner(System.in); // Scanner para entrada del usuario
        try {
            File archivoComics = new File("comics.csv");
            File archivoUsuarios = new File("usuarios.txt");

            if (!archivoComics.exists()) archivoComics.createNewFile(); // Crea si no existen
            if (!archivoUsuarios.exists()) archivoUsuarios.createNewFile();

        try {
            sistema.cargarComics("comics.csv");
        } catch (IOException e) {
            System.out.println("Error al cargar cómics: " + e.getMessage());
        }

            // Cargar usuarios desde archivo
            Scanner Scanner = new Scanner(archivoUsuarios);
            while (Scanner.hasNextLine()) {
                String nombre = Scanner.nextLine().trim();
                if (!nombre.isEmpty()) {
                    sistema.agregarUsuario(new Usuario(nombre)); // Agrega usuario
                }
            }
            Scanner.close();

        } catch (IOException e) {
            System.out.println("Error al cargar archivos: " + e.getMessage());
        }
        while (true) {
            System.out.println("\n--- Comic Collector ---");
            System.out.println("1. Buscar comic");
            System.out.println("2. Reservar comic");
            System.out.println("3. Ver catalogo ordenado");
            System.out.println("4. Registrar usuario");
            System.out.println("5. Salir");
            System.out.print("Seleccione opcion: ");
            String opcion = scanner.nextLine();
            try {
                switch (opcion) {
                    case "1":
                        System.out.print("Ingrese título del cómic: ");
                        String tituloBusqueda = scanner.nextLine();
                        Comic encontrado = sistema.buscarComic(tituloBusqueda);
                        System.out.println(encontrado);
                        break;
                    case "2":
                        System.out.print("Ingrese nombre de usuario: ");
                        String usuario = scanner.nextLine();

                        System.out.print("Ingrese título del cómic a reservar: ");
                        String tituloComic = scanner.nextLine();

                        sistema.reservarComic(usuario, tituloComic);
                        System.out.println("Cómic reservado exitosamente.");
                        break;
                    case "3":
                        System.out.println("--- Catálogo de cómics ---");
                        sistema.mostrarCatalogoOrdenado();
                        break;
                    case "4":
                        System.out.print("Ingrese nombre del nuevo usuario: ");
                        String nuevoUsuario = scanner.nextLine().trim();

                        if (nuevoUsuario.isEmpty()) {
                            System.out.println("Nombre inválido.");
                            break;
                        }

                        try {
                            sistema.getUsuario(nuevoUsuario);
                            System.out.println("El usuario ya está registrado.");
                        } catch (NoSuchElementException e) {
                            sistema.agregarUsuario(new Usuario(nuevoUsuario));
                            System.out.println("Usuario registrado exitosamente.");
                        }
                        break;
                        case "5":
                        try {
                            sistema.guardarUsuarios("usuarios.txt");
                            System.out.println("Datos guardados. ¡Vuelta prontos!");
                        } catch (IOException e) {
                            System.out.println("Error al guardar usuarios: " + e.getMessage());
                        }
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (ComicNoEncontradoException | ComicYaReservadoException | NoSuchElementException e) {
                System.out.println("Error: " + e.getMessage());    
            }
        }
    }
}




