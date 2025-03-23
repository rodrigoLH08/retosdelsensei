/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library;

/**
 *
 * @author Estefania
 */
public class Library {

    public static void main(String[] args) {
       
        Biblioteca biblioteca = new Biblioteca();
        Controlador controlador = new Controlador(biblioteca);
        VistaBlibioteca vista = new VistaBlibioteca(controlador);
        vista.mostrar();
    }
}

    

