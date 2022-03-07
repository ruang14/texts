/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author ruang
 */
public class ArcExample extends Frame{
    
    ArcExample(){
        
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke bsThin = new BasicStroke(2.0f);
        BasicStroke bsThick = new BasicStroke(3.0f);
        
        Rectangle2D.Double rect1 = new Rectangle2D.Double(50, 50, 200, 100);
        g2d.setPaint(Color.black);
        g2d.setStroke(bsThin);
        g2d.draw(rect1);
        
        Arc2D.Double arcOpen = new Arc2D.Double(rect1, 45, 90, Arc2D.OPEN);
        g2d.setPaint(Color.red);
        g2d.setStroke(bsThick);
        g2d.draw(arcOpen);
        
        Rectangle2D.Double rect2 = new Rectangle2D.Double(300, 50, 200, 100);
        g2d.setPaint(Color.black);
        g2d.setStroke(bsThin);
        g2d.draw(rect2);
        
        Arc2D.Double arcPie = new Arc2D.Double(rect2, 45, 90, Arc2D.PIE);
        g2d.setPaint(Color.green);
        g2d.setStroke(bsThick);
        g2d.draw(arcPie);
        
        Rectangle2D.Double rect3 = new Rectangle2D.Double(550, 50, 200, 100);
        g2d.setPaint(Color.black);
        g2d.setStroke(bsThin);
        g2d.draw(rect3);
        
        Arc2D.Double arcChord = new Arc2D.Double(rect3, 45, 90, Arc2D.CHORD);
        g2d.setPaint(Color.blue);
        g2d.setStroke(bsThick);
        g2d.draw(arcChord);
    }
    
    public static void main(String[] argv){
        ArcExample f = new ArcExample();
        f.setTitle("Ellipse arc, section and segment");
        f.setSize(800, 200);
        f.setVisible(true);
    }
    
}
