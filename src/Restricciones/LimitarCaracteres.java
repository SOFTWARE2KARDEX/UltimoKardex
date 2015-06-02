
/**
* 
* @(1.0)LimitarCaracteres.java 26/05/15
* 
* Copyright © 2015 DevTeam. All rights reserved.
* 
*/

package Restricciones;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * La clase LimitarCaracteres ha sido creada con el fin de restringir
 * el tamaño de la cadena de texto en un JTextField.
 * 
 * @author Anthony Flores Llantoy
 * @version 1.0, 26/05/15
 * 
 */

public class LimitarCaracteres extends PlainDocument{
    private JTextField jtfEditor;
    private int intNumero;

    public LimitarCaracteres(JTextField editor, int num) {
        this.jtfEditor = editor;
        this.intNumero = num;
    }
    
    public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException{
        if((jtfEditor.getText().length()+arg1.length()) > this.intNumero){
            return;
        }super.insertString(arg0, arg1, arg2);
    }
}
