/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import javax.swing.JOptionPane;

/**
 *
 * @author ruang
 */
public class StringReverse {

    public static void main(String[] args) {
//        String s = JOptionPane.showInputDialog(null, "String to reverse");
//
//        if (s == null) {
//            System.exit(0);
//        }
//
//        String temp = "";
//        String finalS = "";
//
//        for (int i = 0; i <= s.length(); i++) {
//
//            if (i != 0) {
//                temp = "" + s.charAt((s.length() - i));
//            }
//
//            finalS += temp;
//        }
//
//        JOptionPane.showMessageDialog(null, "Original: " + s + "\nReversed: " + finalS);

        String s = "gee my jou brood";
        char[] chars = s.toCharArray();
        String rev = "";
        
        for(int i = chars.length; i > 0; i--){
            rev += chars[i - 1];
        }
        
        System.out.println(rev);
    }

}
