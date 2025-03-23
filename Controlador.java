/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

public class Controlador {
    private Biblioteca biblioteca;

    public Controlador(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void manejarAgregar(String titulo, String autor) {
        biblioteca.agregarLibro(titulo, autor);
    }

    public void manejarEliminar(String titulo) {
        biblioteca.eliminarLibro(titulo);
    }

    public boolean manejarBuscar(String titulo) {
        return biblioteca.buscarLibro(titulo);
    }

    public String manejarListar() {
        StringBuilder lista = new StringBuilder();
        for (Libro libro : biblioteca.listarLibros()) {
            lista.append(libro.toString()).append("\n");
        }
        return lista.toString();
    }
}
