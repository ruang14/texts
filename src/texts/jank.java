/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruang
 */
public class jank {

    public static void main(String[] args) {
        String s = "Teast - PCN";
        
        String optionName = "";
        if(s != null && s.contains("- PCN")){
            optionName = s.substring(0, s.indexOf("-")).trim();
        } else {
            optionName = String.valueOf(s);
        }
        
        System.out.println(optionName);
        
//        String a = "1q@W3e$R";
//        String b = "92F0B8B7C7E0A755F9C00A7A9F92384C";
//        
//        String c = "1";
//        String cc = "92F0";
//        String d = "q";
//        String dd = "B8B7";
//        String e = "@";
//        String ee = "C7E0";
//        String f = "W";
//        String ff = "A755";
//        String g = "3";
//        String gg = "F9C0";
//        String h = "e";
//        String hh = "0A7A";
//        String i = "$";
//        String ii = "9F92";
//        String j = "R";
//        String jj = "384C";        
//        
//        System.out.println("a: " + a.length());
//        System.out.println("b: " + b.length());
                
//        List<String> s = new ArrayList<String>();
//        s.add("a");
//        s.add("b");
//        s.add("c");
//        
//        int count = 0;
//        while(true){
//            try {
//                System.out.println(s.get(count));
//                count++;
//            } catch (Exception e) {
//                break;
//            }            
//        }
    }

}

//class Dog{
//    public void bark(){
//        System.out.println("woof ");
//    }
//}
//class Hound extends Dog{
//    public void sniff(){
//        System.out.println("sniff ");
//    }
// 
//    public void bark(){
//        System.out.println("bowl");
//    }
//    
//}
// 
//public class jank{
////    static {
////        throw new NullPointerException();
////    }
//    public static void main(String [] args){
//        Dog dog = new Hound();
//        dog.bark();
//    }
//}
