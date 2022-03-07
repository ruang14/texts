/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.awt.*;
import java.awt.geom.*;
import java.util.Date;

/**
 *
 * @author ruang
 */
public class DToCMorphing extends Frame{
    
    public DToCMorphing(){
        
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        BasicStroke bs = new BasicStroke(5.0f);
        g2d.setStroke(bs);
        
        int[] xd = new int[6];
        int[] yd = new int[6];
        xd[1] = 50;
        yd[1] = 50;
        xd[2] = 50;
        yd[2] = 450;
        xd[3] = 400;
        yd[3] = 250;
        xd[4] = 50;
        yd[4] = 450;
        xd[5] = 50;
        yd[5] = 250;
        
        int[] xc = new int[6];
        int[] yc = new int[6];
        xc[1] = 50;
        yc[1] = 250;
        xc[2] = 250;
        yc[2] = 50;
        xc[3] = 50;
        yc[3] = 50;
        xc[4] = 250;
        yc[4] = 450;
        xc[5] = 50;
        yc[5] = 450;
        
        QuadCurve2D.Double q1;
        QuadCurve2D.Double q2;
        
        q1 = new QuadCurve2D.Double(xd[1], yd[1], xd[3], yd[3], xd[2], yd[2]);
        q2 = new QuadCurve2D.Double(xd[1], yd[1], xd[5], yd[5], xd[4], yd[4]);
        
        g2d.draw(q1);
        g2d.draw(q2);
        
        sustain(1000);
        
        double x[] = new double[xc.length];
        double y[] = new double[x.length];
        double alpha;
        int steps = 50;
        double stepsDouble = steps;
        
        for(int i = 1; i < steps; i++){
            
            alpha = i / stepsDouble;            
            
            for(int j = 1; j < x.length; j++){
                x[j] = (1 - alpha) * xd[j] + alpha * xc[j];
                y[j] = (1 - alpha) * yd[j] + alpha * yc[j];
            }
            
            q1 = new QuadCurve2D.Double(x[1], y[1], x[3], y[3], x[2], y[2]);
            q2 = new QuadCurve2D.Double(x[1], y[1], x[5], y[5], x[4], y[4]);
            
            clearWindow(g2d);
            
            g2d.draw(q1);
            g2d.draw(q2);
        }
    }
    
    public static void clearWindow(Graphics2D g){
        g.setPaint(Color.white);
        g.fill(new Rectangle(0, 0, 270, 470));
        g.setPaint(Color.black);
    }
    
    public static void  sustain(long t){
        long finish = (new Date()).getTime() + t;
        while((new Date()).getTime() < finish){
            
        }
    }
    
    public static void main(String[] argv){
        DToCMorphing f = new DToCMorphing();
        f.setTitle("Transforming D -> C");
        f.setSize(270, 470);
        f.setVisible(true);
    }
    
}
