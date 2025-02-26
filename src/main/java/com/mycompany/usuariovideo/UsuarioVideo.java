/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.usuariovideo;

/**
 *
 * @author Estefania
 */
public class UsuarioVideo {

    public static void main(String[] args) {
        
      Usuario usuario = new Usuario("macaco","macaco@gmail.com");
        Video video = new Video ("Monkey flip",60);
       Comentario comentario = new Comentario ("macaco","Increible FLIP vro");
        usuario.verVideo(video);
        video.detener();
       
        comentario.verAutor();
         comentario.verComentario();
        
        
        
        
        
        
        
    }
}
