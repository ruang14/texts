/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.awt.*;
import java.awt.image.*;

/**
 *
 * @author ruang
 */
public class BufferedImageDrawer extends Frame{
    
    public BufferedImage bi;
    public Graphics2D g2dbi;
    private Graphics2D g2d;
    
    public BufferedImageDrawer(BufferedImage buffIm, int width, int height){
        bi = buffIm;
        g2dbi = bi.createGraphics();
        this.setTitle("Double-Buffering");
        this.setSize(width, height);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        update(g);
    }
    
    @Override
    public void update(Graphics g){
        g2d = (Graphics2D)g;
        g2d.drawImage(bi, 0, 0, null);
    }
    
    public static void main(String[] args){
       // BufferedImageDrawer f = new BufferedImageDrawer(buffIm, WIDTH, HEIGHT);
    }
    
}
