package com.mycompany.usuariovideo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Estefania
 */
public class Comentario {
    private String autor;
    private String comentario;

    public Comentario(String autor, String comentario) {
        this.autor = autor;
        this.comentario = comentario;
    }
    
    public void verAutor(){
       
        System.out.println(autor+" comento el video");
    }   
    
    
    public void  verComentario(){
        System.out.println("comento:"+comentario);
    }
    

    
    
    
}
