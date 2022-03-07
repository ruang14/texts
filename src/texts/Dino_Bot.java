/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *
 * @author ruang
 */
public class Dino_Bot {

    Color col;
    Color col2;
    Color col3;
    Color defaultCol;
    int x;
    Robot bot;
    int xCord;
    int yCord;
    int def;

    public static void main(String[] args) {
        try {
            Thread.sleep(3000);
            new Dino_Bot().play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            col = new Color(172, 172, 172);
            col2 = new Color(155, 155, 155);
            col3 = new Color(96, 96, 96);
            defaultCol = new Color(32, 33, 36);
            x = 0;
            bot = new Robot();
            xCord = 800;
            yCord = 315;
            def = defaultCol.getRGB();

            while (true) {
//                Thread.sleep(100);
                start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            if (x >= 50) {
                xCord = 815;
            }
            Color screenCol = bot.getPixelColor(xCord, 310);
            int rgbVal = screenCol.getRGB();
            Color screenCol2 = bot.getPixelColor(xCord - 5, 310);
            int rgbVal2 = screenCol2.getRGB();
            System.out.println(xCord + ", 315: " + screenCol);
//            System.out.println("RGB: " + screenCol.getRGB());
            if (rgbVal != def || rgbVal2 != def) {
                System.out.println(">>>>>" + screenCol);
                jump();
            } 
//            else if (screenCol2.equals(col) || screenCol2.equals(col2) || screenCol2.equals(col3) || screenCol2.equals(col4) || screenCol2.equals(col5) || screenCol2.equals(col6)) {
//                System.out.println("<<<<<" + screenCol2);
////                duck();
//                jump();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jump() {
        try {
            System.out.println(">>>>>>>>>>>>>>>>>>>>");
            bot.keyPress(KeyEvent.VK_UP);
            Thread.sleep(100);
            bot.keyRelease(KeyEvent.VK_UP);
            System.out.println(x + ". UP Key Pressed");
            x++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void duck() {
        try {
            System.out.println("<<<<<<<<<<<<<<<<<<<<");
            bot.keyPress(KeyEvent.VK_DOWN);
            Thread.sleep(50);
            bot.keyRelease(KeyEvent.VK_DOWN);
            System.out.println(x + ". DOWN Key Pressed");
            x++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
