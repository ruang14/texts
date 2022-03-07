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
public class Recursion {

    public static void main(String[] args) {
        Recursion rec = new Recursion();
        System.out.println(rec.reverseString("word"));
    }

    private String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }

}
