/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calcu;

import javax.swing.JOptionPane;



/**
 *
 * @author Estefania
 */
public class Calcu {

    public static void main(String[] args) {
       int n1 = Integer.parseInt(JOptionPane.showInputDialog("numero1"));
        int n2= Integer.parseInt(JOptionPane.showInputDialog("numero2"));
        
        Operaciones ope= new Operaciones();
        int suma = ope.Sumar(n1, n2);
        int resta = ope.Restar(n1, n2);
        int multiplicacion  = ope.Multiplicar(n1, n2);
        int dividir= ope.Dividir(n1, n2);
        ope.Resultados(suma, resta, multiplicacion, dividir);
    
    }
}
