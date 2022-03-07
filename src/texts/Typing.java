/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ruang
 */
public class Typing {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            Date datestart = new Date();
            String alphabet = "abcdefghijklmnopqrstuvwxyz";

            System.out.println("Type the alphabet without any spaces");
            String typed = sc.nextLine();

            if (typed.trim().equalsIgnoreCase(alphabet)) {
                Date datestop = new Date();
                long diff = datestop.getTime() - datestart.getTime();
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000) % 24;
                long diffDays = diff / (24 * 60 * 60 * 1000);

                System.out.println("Congratulations, finished in ");
                System.out.print(diffDays + " days, ");
                System.out.print(diffHours + " hours, ");
                System.out.print(diffMinutes + " minutes, ");
                System.out.print(diffSeconds + " seconds.");
                
                System.out.println("");
            } else {
                System.out.println("Failed, try again");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
