/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco;

/**
 *
 * @author Estefania
 */
public class CuentaBancaria {
    double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositr(double cantidad){
        if(cantidad>0){
            saldo+=cantidad;
            System.out.println("deposito exitoso, Nuevo saldo:"+saldo);
        }else{
            System.out.println("la cantidad es insufuciente");
        }
    }
    public boolean retirar (double cantidad){
        if(cantidad>0 && cantidad<saldo){
            saldo-=cantidad;
            System.out.println("Retiro exitoso ,tu saldo es de "+saldo);
            return true;
        }else{
            System.out.println("Saldo insuficiente");
            return false;
        }
    }
    
    public double getSaldo(){
        return saldo;
        
    }
    
    
    
}
