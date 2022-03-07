/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ruang
 */
public class PasswordCracker {

    static List<String> codes = new ArrayList();
    static List<String> chars = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
    static List<String> integers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
    static List<String> specials = Arrays.asList("`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+", "[", "{", "]", "}", "\\", "|", ";", ",", ":", "'", "\"", ",", "<", ".", ">", "/", "?");

    public static void main(String[] args) {

        new StartCracker("1m5");

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
            int matches = 0;

            do {
                String built = "";
                boolean match = false;

                for (int i = 0; i < code.length(); i++) {
                    int nextInt = gen.nextInt(4) + 1;
                    int nextChar = gen.nextInt(26);
                    int nextInteger = gen.nextInt(10);
                    int nextSpecial = gen.nextInt(33);
                    switch (nextInt) {
                        case 1:
                            built += chars.get(nextChar);
                            break;
                        case 2:
                            built += chars.get(nextChar).toUpperCase();
                            break;
                        case 3:
                            built += integers.get(nextInteger);
                            break;
                        case 4:
                            built += specials.get(nextSpecial);
                            break;
                        default:
                            System.out.println("Out of range");
                            break;
                    }
                }

                pass = built;

                for (String s : codes) {
                    if (pass.equals(s)) {
                        match = true;
                        matches++;
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
                        System.out.println("Match count: \u001B[33m" + matches + "\u001B[0m");

                        noMatch = false;
                    } else {
                        count++;
                    }
                }
            } while (noMatch);

        }

    }

}
