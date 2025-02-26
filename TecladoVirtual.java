
package tecladovirtual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class TecladoVirtual {

    public static void main(String[] args) {
       //ventana
      JFrame frame = new JFrame("Teclado en pantalla");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800,300);
      frame.setLayout(new BorderLayout());
     
      
//cuadro donde van las letras
      JTextField textField =new JTextField();
      
      textField.setFont(new Font ("Arial",Font.PLAIN,20));
      frame.add(textField,BorderLayout.NORTH);
      //panel
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(8,10));
      
      String[] fila1= {"1","2","3","4","5","6","7","8","9","0"};
      String[] fila2= {"Q","w","E","R","T","Y","U","I","O","P"};
      String[] fila3= {"A","S","D","F","G","H","J","K","L","ñ"};
      String[] fila4= {"Z","X","C","C","V","B","N","M",",","."};
      
      agregarBotones(panel, fila1, textField);
      agregarBotones(panel, fila2, textField);
      agregarBotones(panel, fila3, textField);
      agregarBotones(panel, fila4, textField);
      
      frame.add(panel,BorderLayout.CENTER);
      frame.setVisible(true);
    }
      private static void  agregarBotones(JPanel panel, String[] letras, JTextField textField){
         
         for(String letra: letras){
             JButton button = new JButton(letra);
             button.setFont(new Font("Arial",Font.BOLD,16));
             button.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e){
                     
                     String currentText = textField.getText();
                     textField.setText(currentText+letra);
                 }
                 
                 
                 
             });
             panel.add(button);
             
             
             
             
             
             
             
             
             
         }
         
         
         
         
         
         
         
     }
      
      


      
      
      
      
        
        
        
        
        
        
        
        
        
        
        
    }
    

