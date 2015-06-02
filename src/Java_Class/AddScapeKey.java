/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Class;

import static Representacion.frminicio.jdpescritorio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

/**
 *
 * @author Anthony Flores Llantoy
 */
public class AddScapeKey {
    
    private JInternalFrame jifauxiliar;

    public AddScapeKey(JInternalFrame jifauxiliar) {
        this.jifauxiliar = jifauxiliar;
    }
    
    public static void addScapeKey(JInternalFrame jifaux){
        KeyStroke kstescape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0,false);
        Action atcescape = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                jifaux.getDesktopPane().getDesktopManager().closeFrame(jifaux);
                //inhabilitar();
            }
            
        };
        jdpescritorio.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(kstescape, "ESCAPE");
        jdpescritorio.getRootPane().getActionMap().put("ESCAPE", atcescape);
    }
    
}
