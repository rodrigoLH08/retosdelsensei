/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlist;

/**
 *
 * @author Estefania
 */
public class Musicas {
    String titulo;
    String album;
    String fecha;
    int duracion;

    
    //metodos
    // primera forma

   /* public void Musicas(String _titulo, String _album, String _fecha,int _duracion){
        titulo=_titulo;
        album=_album;
        fecha=_fecha;
        duracion=_duracion;
    } */
    //segunda forma

    public Musicas(String titulo, String album, String fecha, int duracion) {
        this.titulo = titulo;
        this.album = album;
        this.fecha = fecha;
        this.duracion = duracion;
    }
    public void ShowPlaylist(){
        System.out.println("el titulo es: "+titulo);
        System.out.println("album:"+album);
        System.out.println("fecha:"+fecha);
        System.out.println("duracion :"+duracion);
    }
}
