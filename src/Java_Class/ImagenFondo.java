
/**
* 
* @(1.0)LetrasODigitos.java 25/05/15
* 
* Copyright 2015 DevTeam. All rights reserved.
* 
*/
package Java_Class;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 * 
 * La clase ImagenFondo ha sido creada con el fin de hacer posible ajustar una imagen 
 * a las dimensiones de un JDesktopPane, JFrame, JInternalFrame.
 * 
 * @author Anthony Flores Llantoy
 * @version 1.0. 30/05/15
 * 
 */
public class ImagenFondo implements Border {

    BufferedImage bfifondo;
    public ImagenFondo(){
        try{
            //se obtiene la imagen
            URL url = new URL(getClass().getResource("/File/fondo.png").toString());
            bfifondo = ImageIO.read(url);
        }catch(IOException ex){
            Logger.getLogger(ImagenFondo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // se sobreescriben los metodos propios de border 
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){     
        //se dibuja la imagen de fondo en el centro del contenedor
        //cada que se redimensione el contenedor, la imagen automaticamente se posiciona en el centro
        g.drawImage(bfifondo, (x + (width - bfifondo.getWidth())/2),(y + (height - bfifondo.getHeight())/2), null);
    }
    
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
    
}
