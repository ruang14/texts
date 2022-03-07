/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.Scanner;

/**
 *
 * @author ruang
 */
public class idval {

    public static Boolean getIdentitySummation(String identities) {
        String identify = String.valueOf(identities);
        int sumOdd = 0, sumEven = 0, _doubled;
        int summation;
        try {
            String identity = String.valueOf(identify);
            int length = identity.length() - 1;
            char[] chars = identity.toCharArray();
            String check = identity.substring(12);
            for (int x = 0; x < length; x++) {
                if (x % 2 == 0) {
                    String numString = String.valueOf(chars[x]);
                    int numbers = Integer.valueOf(numString);
                    sumOdd += numbers;
                } else if (x % 2 != 0) {
                    String numString = String.valueOf(chars[x]);
                    int numbers = Integer.valueOf(numString);
                    int doubled = numbers * 2;
                    if (doubled > 9) {
                        _doubled = doubled - 9;
                    } else {
                        _doubled = doubled;
                    }
                    sumEven += _doubled;
                }
            }
            summation = sumOdd + sumEven;
            int checksum = Integer.valueOf(check);
            if ((summation * 9) % 10 == checksum) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter idnum");
        Scanner sc = new Scanner(System.in);
        String idnum = sc.next();
        if (getIdentitySummation(idnum)) {
            System.out.println("valid id");
        } else {
            System.out.println("invalid id");
        }
    }

}
