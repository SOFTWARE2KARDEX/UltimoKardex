
/**
* 
* @(1.1)LetrasODigitos.java 25/05/15
* 
* Copyright 2015 DevTeam. All rights reserved.
* 
*/
package Java_Class;

import static Representacion.frminicio.jdpescritorio;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * 
 * La clase CentrarVentanaInterna ha sido creada con el fin de centrar una 
 * instancia de JInternalFrame en un JDesktopPane.
 * 
 * @author Anthony Flores Llantoy
 * @version 1.1, 28/05/15
 * @since 1.0
 */
public class CentrarVentanaInterna {
    
    private JInternalFrame jieinternalFrame;

    public CentrarVentanaInterna(JInternalFrame internalFrame) {
        this.jieinternalFrame = internalFrame;
    }
    
    public static void FocusInternalWindow(JInternalFrame internalFrame ){           //  centra el jinternalframe y la muestra en el jDesktop
        int x = (jdpescritorio.getWidth()/2) - internalFrame.getWidth()/2;
        int y = (jdpescritorio.getHeight()/2) - internalFrame.getHeight()/2;
        
        if(internalFrame.isShowing()){
            internalFrame.setLocation(x,y);
            //JOptionPane.showMessageDialog(escritorio, "Este es un mensaje de prueba");
        }
        else{
            jdpescritorio.add(internalFrame);
            internalFrame.setLocation(x,y);
            internalFrame.show();
            internalFrame.toFront();
        }
    }    
    
}
