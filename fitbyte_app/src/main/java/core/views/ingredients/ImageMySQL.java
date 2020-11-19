/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.views.ingredients;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ImageMySQL extends javax.swing.JPanel {
    
    BufferedImage ruta;
    
    public ImageMySQL(int x, int y  ,BufferedImage ruta){
        this.setSize(x, y);
        this.ruta = ruta;
    }
    
    public void paint (Graphics g){
        Dimension height = getSize();       
        BufferedImage img = ruta;

        g.drawImage(img,0,0,height.width,height.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
