/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ruang
 */
public class Cracker {

    static List<String> codes = new ArrayList();

    public static void main(String[] args) {

        new StartCracker("1");

    }

    public static class StartCracker {

        public StartCracker(String code) {

            CrackerFac.Break(code);

        }

    }

    public static class CrackerFac {

        static Random gen = new Random();
        static int next;
        static String pass;

        public static void Break(String code) {

            int count = 0;
            boolean noMatch = true;

            do {
                String built = "";
                boolean match = false;

                for (int i = 0; i < code.length(); i++) {
                    next = gen.nextInt(10);
                    built += String.valueOf(next);
                }

                pass = built;

                for (String s : codes) {
                    if (pass.equals(s)) {
                        match = true;
                    }
                }

                if (!match) {
                    codes.add(pass);

                    System.out.println("Attempt: " + (count + 1));
                    System.out.println("Crack: " + pass);

                    if (pass.equals(code)) {
                        System.out.println("Cracked in \u001B[32m" + (count + 1) + "\u001B[0m tries");
                        System.out.println("Your code: " + code);
                        System.out.println("Cracked code: " + pass);

                        noMatch = false;
                    } else {
                        count++;
                    }
                }
            } while (noMatch);

        }

    }

}
