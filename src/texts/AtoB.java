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
public class AtoB {

    public static void main(String[] args) {
        int a = 40;
        int b = 30;

        System.out.println("-------BEFORE");
        System.out.println("a: " + a);
        System.out.println("b: " + b);

//        a = (a * b) / a;
//        b = (a * b) / (b > a ? (a + b) : (a - b));
//        if(b > a){
//            System.out.println("1");
//            a = (b = a) + ((b + a) * (b - a));
//        } else {
//            System.out.println("2");
//            b = (a = b) + b;
//        }
        b = a + b;
        a = b - a;
        b = b - a;

        System.out.println("-------AFTER");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

}
