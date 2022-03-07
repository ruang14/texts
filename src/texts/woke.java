/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.awt.AWTException;
import java.awt.Robot;

/**
 *
 * @author ruang
 */
public class woke {

    public static void main(String[] args) throws AWTException {
        System.out.println("Starting bot...");
        Robot robot = new Robot();

        while (1 == 1) {
            try {                
                Thread.sleep(2000);
                robot.mouseMove(0, 0);
                Thread.sleep(500);
                robot.mouseMove(0, 1);
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
