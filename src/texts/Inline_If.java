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
public class Inline_If {
    
    public static void main(String[] args){
        int number = 7;
        int number2 = 9;
        String res = (number > number2) ? "larger" : (number == number2 ? "equals" : "smaller");
        
        System.out.println(res);
    }
    
}
