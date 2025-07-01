/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdmBiblioteca.Biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author Katherine
 */
public class Biblioteca {
    private ArrayList<Libro> libros;
    private HashMap<String, Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombre(), usuario);
    }

    public Libro buscarLibro(String titulo) throws LibroNoEncontradoException {
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) return l;
        }
        throw new LibroNoEncontradoException("Libro '" + titulo + "' no encontrado.");
    }

    public Usuario getUsuario(String nombre) throws UsuarioNoEncontradoException {
        if (!usuarios.containsKey(nombre))
            throw new UsuarioNoEncontradoException("Usuario '" + nombre + "' no encontrado.");
        return usuarios.get(nombre);
    }

    public void prestarLibro(String nombreUsuario, String tituloLibro)
        throws LibroNoEncontradoException, UsuarioNoEncontradoException, LibroYaPrestadoException {
    Usuario u = getUsuario(nombreUsuario);
    Libro l = buscarLibro(tituloLibro);
    l.prestar(); 
    }


    public void generarInforme() {
        System.out.println("=== INFORME BIBLIOTECA ===");
        for (Libro l : libros) {
            System.out.println(l);
        }
    }
    
    public boolean existeLibro(String titulo) {
        HashSet<String> titulos = new HashSet<>();
        for (Libro l : libros) {
            titulos.add(l.getTitulo().toLowerCase());
        }
        return titulos.contains(titulo.toLowerCase());
    }

    public void mostrarLibrosOrdenados() {
        TreeSet<Libro> ordenados = new TreeSet<>(Comparator.comparing(Libro::getTitulo));
        ordenados.addAll(libros);
        for (Libro l : ordenados) {
            System.out.println(l);
        }
    }
    
    public void guardarLibros(String archivo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        for (Libro l : libros) {
            bw.write(l.getTitulo() + ";" + l.getAutor() + ";" + l.isPrestado());
            bw.newLine();
        }
        bw.close();
    }

    public void cargarLibros(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(";");
            if (partes.length == 3) {
                Libro l = new Libro(partes[0], partes[1]);
                if (Boolean.parseBoolean(partes[2])) {
                    try {
                        l.prestar(); // esto lanza LibroYaPrestadoException
                    } catch (LibroYaPrestadoException e) {
                        System.out.println("Error al marcar como prestado: " + e.getMessage());
                    }
                }
                libros.add(l);
            }
        }
        br.close();
    }

    public void guardarUsuarios(String archivo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        for (Usuario u : usuarios.values()) {
            StringBuilder sb = new StringBuilder(u.getNombre());
            for (Libro l : u.getLibrosPrestados()) {
                sb.append(";").append(l.getTitulo());
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.close();
    }

    public void cargarUsuarios(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(";");
            if (partes.length >= 1) {
                Usuario u = new Usuario(partes[0]);
                usuarios.put(u.getNombre(), u);
                for (int i = 1; i < partes.length; i++) {
                    try {
                        Libro libroPrestado = buscarLibro(partes[i]);
                        u.prestarLibro(libroPrestado);
                    } catch (Exception ignored) {}
                }
            }
        }
        br.close();
    }

}
