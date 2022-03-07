/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.text.DecimalFormat;

/**
 *
 * @author ruang
 */
public class Loading {

    public static void main(String[] args) {
        Loading();
    }

    private static void Loading() {
        DecimalFormat df = new DecimalFormat("#.##");
        double avg = 1.50;//seconds
        int items = 8500;
        double max = avg * items;

        System.out.println("Average time item takes to send: about " + avg + " seconds");
        System.out.println("Items: " + items);
        System.out.println("Time to send: about " + df.format((max / 60) / 60) + " hours");

        for (int i = 1; i <= 8500; i++) {
            try {
                System.out.println("Item sent");
                items--;

                System.out.print("[");
                for (int k = 0; k < ((8500 - items) / 100); k++) {
                    System.out.print("█");
                }
                for (int k = 85; k > ((8500 - items) / 100); k--) {
                    System.out.print(" ");
                }
                System.out.println("]");

                max = avg * items;
                System.out.println("Max: " + ((max / 60) / 60));

                System.out.println("Remaining time: about " + df.format((max / 60) / 60) + " hours");
                System.out.println("Remaining time: about " + df.format(max / 60) + " minutes");
                System.out.println("Remaining time: about " + df.format(max) + " seconds");
                System.out.println("Remaining items: " + items);
//                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
