
/**
* 
* @(1.1)LetrasODigitos.java 25/05/15
* 
* Copyright 2015 DevTeam. All rights reserved.
* 
*/

package Restricciones;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;

/**
 *
 * La clase LetrasODigitos ha sido creada con el fin de restringir 
 * la escritura de caracteres(letras) o dígitos en un JTextField.
 * 
 * @author Anthony Flores Llantoy
 * @version 1.1, 26/05/15
 * @since 1.0
 * 
 */

public class LetrasODigitos{

    private JTextField jtfLetra;

    public LetrasODigitos(JTextField jtfLetra) {
        this.jtfLetra = jtfLetra;
    }

    public static void soloLetras(JTextField jtfLetra){
        jtfLetra.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent ke_event){
                char charLetra = ke_event.getKeyChar();
                if(Character.isDigit(charLetra)){
                    Toolkit.getDefaultToolkit().beep();
                    ke_event.consume();
                }
            }
        });
    }
    
    public static void soloDigitos(JTextField jtfLetra){
        jtfLetra.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent ke_evento){
                char charLetra = ke_evento.getKeyChar();
                if(Character.isLetter(charLetra) || Character.isSpaceChar(charLetra)){
                    Toolkit.getDefaultToolkit().beep();
                    ke_evento.consume();
                }
            }
        });
    }    
    
}
