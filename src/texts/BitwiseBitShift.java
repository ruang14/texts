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
public class BitwiseBitShift {

//  ~       Unary bitwise complement
//  <<      Signed left shift
//  >>      Signed right shift
//  >>>     Unsigned right shift
//  &       Bitwise AND
//  ^       Bitwise exclusive OR
//  |       Bitwise inclusive OR
    public static void main(String[] args) {
//        int bitmask = 0x000F;
//        int val = 0x2222;
//        // prints "2"
//        System.out.println(bitmask);
//        System.out.println(val);
//        System.out.println(val & bitmask);

        int a = 72;
        int b = 19;
        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("--------");
        System.out.println("binary a = " + binA);
        System.out.println("binary b = " + binB);

        String tempA = "";
        String tempB = "";
        for (int i = 0; i < binA.length(); i++) {
            if((tempA + binA).length() % 4 == 0){
                break;
            }
            tempA += "0";
        }
        for (int i = 0; i < binB.length(); i++) {
            if((tempB + binB).length() % 4 == 0){
                break;
            }
            tempB += "0";
        }
        binA = tempA + binA;
        binB = tempB + binB;

        System.out.println("--------");
        System.out.println("A = " + binA);
        System.out.println("B = " + binB);

        int div4A = binA.length() / 4;
        int div4B = binB.length() / 4;
        String fBinA = "";
        String fBinB = "";

        for (int i = 0; i < div4A; i++) {
            fBinA += binA.substring((4 * i), (4 * (i + 1))) + " ";
        }
        for (int i = 0; i < div4B; i++) {
            fBinB += binB.substring((4 * i), (4 * (i + 1))) + " ";
        }

        System.out.println("--------");
        System.out.println("A = " + fBinA);
        System.out.println("B = " + fBinB);
        System.out.println("--------");
        
        System.out.println();
        System.out.println("Bitwise and (&) - copies a bit to the result if it exists in both operands");
        System.out.print("A & B = ");
        System.out.println(a & b);
        System.out.println("--------");
        System.out.println("Bitwise or (|) - copies a bit if it exists in either operand");
        System.out.print("A | B = ");
        System.out.println(a | b);
        System.out.println("--------");
        System.out.println("Bitwise xor (^) - copies the bit if it is set in one operand but not both");
        System.out.print("A ^ B = ");
        System.out.println(a ^ b);
        System.out.println("--------");
        System.out.println("Bitwise compliment (~) - is unary and has the effect of 'flipping' bits");
        System.out.print("~A = ");
        System.out.println(~a);
        System.out.print("~B = ");
        System.out.println(~b);
        System.out.println("--------");
        System.out.println("Left shift (<<) - the left operands value is moved left by the number of bits specified by the right operand");
        System.out.print("A << 2 = ");
        System.out.println(a << 2);
        System.out.print("B << 2 = ");
        System.out.println(b << 2);
        System.out.println("--------");
        System.out.println("Right shift (>>) - the left operands value is moved right by the number of bits specified by the right operand");
        System.out.print("A >> 2 = ");
        System.out.println(a >> 2);
        System.out.print("B >> 2 = ");
        System.out.println(b >> 2);
        System.out.println("--------");
        System.out.println("Zero fill right shift (>>>) - the left operands value is moved right by the number of bits specified by the right operand and shifted values are filled up with zeros");
        System.out.print("A >>> 2 = ");
        System.out.println(a >>> 2);
        System.out.print("B >>> 2 = ");
        System.out.println(b >>> 2);
        System.out.println();
    }
}
