/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banco;

/**
 *
 * @author Estefania
 */
public class Banco {

    public static void main(String[] args) {
        Usuario usuario= new Usuario("Pedro navaja",500000);
        CajeroAutomatico cajero= new CajeroAutomatico();
        cajero.ConsultarSaldo(usuario);
        cajero.depositar(usuario, 300);
        cajero.retirar(usuario, 310);
        
        
        
    }
}
