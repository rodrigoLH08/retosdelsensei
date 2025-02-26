
package calculadoraxd;

import java.util.Scanner;


public class CalculadoraXd {

  
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Calculadora");
        System.out.println("----------------");
        System.out.println("ingrese el primer numero");
        double num1 = leer.nextDouble();
        System.out.println("Ingrese el segundo numero");
        double num2 = leer.nextDouble();
        System.out.println("agregue la operacion( +,-,*,/)");
        char operacion= leer.next().charAt(0);
        
        double resultado = 0;

        switch(operacion){
            case '+':
                resultado=num1+num2;
                break;
            case'-':
                resultado=num1-num2;
                break;
            case'*':
                resultado=num1*num2;
                break;
            case'/':
                if(num2!=0){
                   resultado=num1/num2; 
                }else{
                    System.out.println("no seas wey no se puede");
                    return;
                }
        
                break;

            case'%':
                resultado=num1%num2;
                break;
            default:
                throw new AssertionError();
               
        }
        System.out.println("El resultado de operacion es:"+resultado);
        
       
                
            
            
            
        
   
        
        
        
        
        
        
        
    }
    
}
