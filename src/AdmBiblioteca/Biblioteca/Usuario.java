/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdmBiblioteca.Biblioteca;

import java.util.ArrayList;

/**
 *
 * @author Katherine
 */
public class Usuario {
    private String nombre;
    private ArrayList<Libro> librosPrestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    public void prestarLibro(Libro libro) throws Exception {
        if (librosPrestados.contains(libro))
            throw new Exception("Este usuario ya tiene prestado este libro.");
        librosPrestados.add(libro);
    }
    
    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    @Override
    public String toString() {
        return nombre + " - Libros prestados: " + librosPrestados.size();
    }
}
