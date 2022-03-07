/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ruang
 */
public class Animation {

    public static void main(String[] args) {
        System.out.println("Analyzing...");
        System.out.print("Progress: [");

        for (int i = 0; i <= 20; i++ ) {
            System.out.printf("█");
//            System.out.print(i + "%");
            try {
                Thread.sleep(500);
                
                if(i == 5 || i == 13){
                    Thread.sleep(1000);
                }
                
                if(i == 10 || i == 18){
                    Thread.sleep(1500);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
            }

//            System.out.print("\b\b");
        }
        System.out.print("]\n");
        System.out.println("Analysis Complete!");
    }

}
