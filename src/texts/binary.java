/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

/**
 *
 * @author ruang
 */
public class binary {

    public static void main(String[] args) {
        int i = 0;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        try {
            while (i < alphabet.length) {
                System.out.println(i + " = " + Integer.toBinaryString(i));
                System.out.println(alphabet[i] + " = " + Integer.toBinaryString(alphabet[i]));
                i++;
//                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
