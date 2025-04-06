/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcu;


public class Operaciones {
    public int Sumar (int num1,int num2){
        int suma=num1+num2;
        return suma;
    }
    public int Restar (int num1, int num2){
        int resta = num1 - num2;
        return resta;
    }
    
    public int Multiplicar (int num1,int num2){
        int multiplicacion=num1*num2;
        return multiplicacion;
        
    }
    
    public int Dividir(int num1,int num2){
        int division=num1/ num2;
        return division;
    }

    public void Resultados(int suma,int resta,int multiplicacion, int division){
        System.out.println("la sumas es: "+ suma);
        System.out.println("la resta es: "+ resta);
        System.out.println("la multiplicacion es "+ multiplicacion);
        System.out.println("la division es "+division);
    }
    
    
}

