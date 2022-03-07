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
public class RecursionHanoi {

    private static int moves = 0;

    public static void main(String[] args) {
        tower(5, 'A', 'B', 'C');
        System.out.println("Moves: " + moves);
    }

    private static void tower(int i, char a, char b, char c) {
        moves++;
        if (i == 1) {
            System.out.println("Move disc 1 from " + a + " to " + c);
        } else {
            tower(i - 1, a, c, b);
            System.out.println("Move disc " + i + " from " + a + " to " + c);
            tower(i - 1, b, a, c);
        }
    }

}
