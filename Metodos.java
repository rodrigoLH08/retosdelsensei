/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.metodos;



public class Metodos {

    public static void main(String[] args) {
        String correo1= "sefuelalux.@gmail.com";
        String correo2= "nohayluz@laolo.xd";
        System.out.println("es gmail?"+Validarcorreo.EsGmail(correo1));
        System.out.println("es gmail?"+Validarcorreo.EsGmail(correo2));
        //area
        double radio=90;
        System.out.println("el area es de: "+CalculoArea.Areacirculo(radio));
        //vocales
        System.out.println("vocales en (hola mundo)"+Conteovocales.Contarvocales("hola"));
        
        //primos
        System.out.println("es primo?"+Primo.esPrimo(7));
        System.out.println("es primo?"+Primo.esPrimo(10));
        //hora
        Reloj.Convertirminutos(125);
            
    }
    

    
    public class Validarcorreo{
        public static boolean EsGmail(String correo){
            return correo.toLowerCase().endsWith(".@gmail.com");
        }
    }   
   
    public class CalculoArea{
        public static double Areacirculo (double radio){
            return Math.PI*Math.pow(radio, 2);
        }
    }
    
    public class Conteovocales{
        public static int Contarvocales (String palabra){
            int contador=0;
            palabra= palabra.toLowerCase();
            for(char c: palabra.toCharArray()){
                if("aeiou".indexOf(c)!=-1){
                    contador++;
                }
            }
            return contador;
        }
    }
   
    public class Primo{
        public static boolean esPrimo (int numero){
            if(numero<=1){
                return false;
            }
            for(int i = 2 ; i <= Math.sqrt(numero);i++){
                if(numero%i==0){
                    return false;
                }
            }
            return true;
        }
    }

    public class Reloj{
        public static void Convertirminutos(int minutos){
            int horas = minutos / 60;
            int minutosrest = minutos%60;
            int segundos= minutos*60;
            System.out.println("minutos son en horas "+horas);
            System.out.println("en segundos es "+segundos);
            
        }
    }
}


