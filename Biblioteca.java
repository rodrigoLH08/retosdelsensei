/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(String titulo, String autor) {
        libros.add(new Libro(titulo, autor));
    }

    public void eliminarLibro(String titulo) {
        libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

    public ArrayList<Libro> listarLibros() {
        return libros;
    }

    public boolean buscarLibro(String titulo) {
        return libros.stream().anyMatch(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }
}
