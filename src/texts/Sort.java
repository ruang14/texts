/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.Arrays;

/**
 *
 * @author ruang
 */
public class Sort {

    public static void main(String[] args) {
        int[] numbers = {5, 6, 8, 32, 1, 45, 2, 11, 9};
        int temp = 0;

        System.out.println("array before sort: " + Arrays.toString(numbers));

        for (int in : numbers) {
            for (int i = 0; i < numbers.length; i++) {
                try {
                    if (numbers[i] > numbers[i + 1]) {
                        temp = numbers[i + 1];
                        numbers[i + 1] = numbers[i];
                        numbers[i] = temp;
                    }
                } catch (Exception e) {
                }
            }
        }

        System.out.println("array after sort: " + Arrays.toString(numbers));
    }

}
