/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdmBiblioteca.Biblioteca;

/**
 *
 * @author Katherine
 */
public class Libro {
    private String titulo;
    private String autor;
    private boolean prestado;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isPrestado() { return prestado; }

    public void prestar() throws LibroYaPrestadoException {
    if (prestado) throw new LibroYaPrestadoException("El libro ya está prestado.");
    prestado = true;
    }

    public void devolver() {
        prestado = false;
    }

    @Override
    public String toString() {
        return titulo + " por " + autor + (prestado ? " (Prestado)" : " (Disponible)");
    }
    
}
