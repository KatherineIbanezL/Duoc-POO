/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comicSystem;

/**
 *
 * @author Katherine
 */

import java.io.*;
import java.util.*;

public class ComicCollectorSystem {
    private ArrayList<Comic> comics;
    private HashMap<String, Usuario> usuarios;

    public ComicCollectorSystem() {
        comics = new ArrayList<>();
        usuarios = new HashMap<>();
    }

    public void cargarComics(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(";");
            if (partes.length == 3) {
                String titulo = partes[0].trim();
                String editorial = partes[1].trim();
                boolean reservado = Boolean.parseBoolean(partes[2].trim());

                Comic comic = new Comic(titulo, editorial);
                if (reservado) {
                    try {
                        comic.reservar();
                    } catch (ComicYaReservadoException e) {
                        System.out.println("Cómic ya reservado al cargar: " + titulo);
                    }
                }
                comics.add(comic);
            }
        }
        br.close();
}

    public void guardarUsuarios(String archivo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        for (Usuario u : usuarios.values()) {
            bw.write(u.getNombre() + "\n");
        }
        bw.close();
    }

    public Comic buscarComic(String titulo) throws ComicNoEncontradoException {
        for (Comic c : comics) {
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                return c;
            }
        }
        throw new ComicNoEncontradoException("Cómic '" + titulo + "' no encontrado.");
    }

    public Usuario getUsuario(String nombre) throws NoSuchElementException {
        if (!usuarios.containsKey(nombre)) {
            throw new NoSuchElementException("Usuario no registrado.");
        }
        return usuarios.get(nombre);
    }

    public void agregarUsuario(Usuario u) {
        usuarios.put(u.getNombre(), u);
    }

    public void reservarComic(String nombreUsuario, String tituloComic)
            throws ComicNoEncontradoException, ComicYaReservadoException, NoSuchElementException {
        Usuario u = getUsuario(nombreUsuario);
        Comic c = buscarComic(tituloComic);
        c.reservar();
        u.reservarComic(c);
    }

    public void mostrarCatalogoOrdenado() {
        TreeSet<Comic> ordenados = new TreeSet<>(comics);
        for (Comic c : ordenados) {
            System.out.println(c);
        }
    }
}
