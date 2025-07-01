/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comicSystem;

public class Comic implements Comparable<Comic> {
    private String titulo;
    private String editorial;
    private boolean reservado;

    public Comic(String titulo, String editorial) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.reservado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void reservar() throws ComicYaReservadoException {
        if (reservado) {
            throw new ComicYaReservadoException("El cómic '" + titulo + "' ya está reservado.");
        }
        reservado = true;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Editorial: " + editorial + " | Reservado: " + (reservado ? "Sí" : "No");
    }

    @Override
    public int compareTo(Comic otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

}
