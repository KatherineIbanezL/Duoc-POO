/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comicSystem;

/**
 *
 * @author Katherine
 */

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Comic> comicsReservados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.comicsReservados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Comic> getComicsReservados() {
        return comicsReservados;
    }

    public void reservarComic(Comic c) {
        comicsReservados.add(c);
    }

    @Override
    public String toString() {
        return nombre + " | Cómics reservados: " + comicsReservados.size();
    }
}