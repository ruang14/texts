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
public class StringSpace {

    public static void main(String[] args) {//40
        String s = "The first paragraph"
                + "The second paragraph"
                + "The third paragraph"
                + "The fourth paragraph"
                + "The fifth paragraph"
                + "The sixth paragraph"
                + "The seventh paragraph"
                + "The eigth paragraph"
                + "The ninth paragraph"
                + "The tenth paragraph";
        
        System.out.println("before:\n" + s);
        System.out.println("");
        System.out.println("after: ");
        
        String[] sarr = s.split("paragraph");
        for(String st : sarr){
            st = st + "paragraph";
            System.out.println(st);
        }
    }
}
