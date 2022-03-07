/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.math.BigInteger;

/**
 *
 * @author ruang
 */
public class Maths {

    private static final int SUM = 446;
    private static int recCount = 0;
    private static BigInteger res = new BigInteger("1");
    private static int steps = 0;

    public static void main(String[] args) {
//        factorial(7);
//        System.out.println("random: " + random(500));
//        collatzConjecture(new BigInteger("1234567890"), BigInteger.valueOf(1));
//        System.out.println(getBinary(1998));
//        containsThree(new BigInteger("10000"));
    }

    //factorial
    private static void factorial(int i) {
        recCount++;
        res = res.multiply(BigInteger.valueOf(recCount));

        if (recCount != i) {
            factorial(i);
        } else {
            System.out.println("result: " + res);
        }

    }

    //random without math.Random
    private static int random(int i) {
        int result = (int) (System.currentTimeMillis() % i);
        return result;
    }

    //collatzConjecture
    private static void collatzConjecture(BigInteger n, BigInteger step) {
        step = step.add(BigInteger.valueOf(1));
        System.out.println("Step : " + step + " n = " + n);

        if (!n.equals(BigInteger.valueOf(1))) {
            BigInteger i = n.mod(BigInteger.valueOf(2));

            if (i.equals(BigInteger.valueOf(0))) {
                n = n.divide(BigInteger.valueOf(2));
            } else {
                n = n.multiply(BigInteger.valueOf(3));
                n = n.add(BigInteger.valueOf(1));
            }

            collatzConjecture(n, step);
        } else {
            System.out.println("Completed in " + step + " steps");
        }
    }

    //get binary
    private static String getBinary(int num) {
        String result = "";

        while (num > 0) {
            result = ((num % 2) == 0 ? "0" : "1") + result;
            num = num / 2;
        }

        return result;
    }

    //contains 3
    private static void containsThree(BigInteger num) {
        double inc = 0;

        for (int i = 0; i <= num.doubleValue(); i++) {
            if (String.valueOf(i).contains("3")) {
                inc++;
            }
            System.out.println("i: " + i + " inc: " + inc);
        }

        double result = (inc / num.doubleValue()) * 100;
        System.out.println(result + "%");
    }

}
