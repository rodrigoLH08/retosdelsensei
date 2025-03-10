/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco;


public class CajeroAutomatico {
    public void ConsultarSaldo(Usuario usuario){
        System.out.println("Usuario:"+usuario.getNombre()+"  Su saldo ectual es de:"+usuario.getCuenta().getSaldo());
    }
    
    public void depositar (Usuario usuario,double cantidad){
       usuario.getCuenta().depositr(cantidad);
    }
    
    public void retirar(Usuario usuario, double cantidad){
        usuario.getCuenta().retirar(cantidad);
        
    }
}
