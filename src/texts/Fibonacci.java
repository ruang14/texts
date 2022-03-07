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
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("The Fibonacci Sequence: ");
        
        int i = 0;
        int max = 10;
        long num1 = 0;
        long num2 = 1;
        long num3 = num1 + num2;

        while (true) {
            
            if(i == max){
                break;
            }
            
            System.out.print(num3);

            num1 = num2;
            num2 = num3;
            num3 = num1 + num2;

            if(i != (max - 1)){
                System.out.print(", ");
            } else {
                System.out.println("");
            }
            
            i++;
        }

    }

}
