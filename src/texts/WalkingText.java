/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.applet.*;
import java.awt.*;

/**
 *
 * @author ruang
 */
public class WalkingText extends Applet implements Runnable {

    protected String mesg = null;
    protected int xloc, yloc, width, height, textWidth, textHeight;
    protected Thread t;
    protected boolean done = false;
    protected int napTime = 150;

    @Override
    public void init() {
        xloc = 0;
        width = getSize().width;
        height = getSize().height;

        if ((mesg = getParameter("text")) == null) {
            mesg = "Hellow ";
        }

        String pSize = getParameter("fontsize");

        if (pSize == null) {
            pSize = "12";
        }

        String fontName = getParameter("fontName");

        if (fontName == null) {
            fontName = "Helvetica";
        }

        Font f = new Font(fontName, Font.PLAIN, Integer.parseInt(pSize));
        setFont(f);

        FontMetrics fm = getToolkit().getFontMetrics(f);
        textWidth = fm.stringWidth(mesg);
        textHeight = fm.getHeight();

        yloc = height - ((height - textHeight) / 2);
    }

    @Override
    public void stop() {
        done = true;
        t = null;
    }

    @Override
    public void start() {
        if (t == null) {
            t = new Thread(this);
            done = false;
            t.start();
        }
    }

    @Override
    public String[][] getParameterInfo() {
        String[][] params = {
            {"text", "text", "Text to walk across the screen"},
            {"fontName", "text", "Name of font to display in"},
            {"fontsize", "int", "How big to make the text"}};
        return params;
    }

    @Override
    public void run() {
        while (!done) {
            if ((xloc += 5) > getSize().width) {
                xloc = 0;
            }
            repaint();
            try {
                Thread.sleep(napTime);
            } catch (InterruptedException ie) {
                System.out.println("Who dares to interrupt my sleep? " + ie);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(mesg, xloc, yloc);
    }

}
