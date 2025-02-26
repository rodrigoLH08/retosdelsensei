//package com.mycompany.usuariovideo;

public class Usuario {
    
    private String nombre;
    private String  correo;

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }
    
    public void  verVideo(Video video){
         System.out.println(nombre+"esta viendo: "+video.getTitulo() );
         video.reproducir();
     }
     
    public String obtenerNombre (){
        return nombre;
    }
    
}
