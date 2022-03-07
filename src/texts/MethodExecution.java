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
public class MethodExecution {

    private static long start = System.nanoTime();

    public static void main(String[] args) {
        while (true) {
            long end = System.nanoTime();
            long execTime = end - start;
            System.out.println("time: " + (execTime / 1000000000));
            if ((execTime / 1000000000) > 3) {
                System.out.println("execTime: " + (execTime / 1000000000) + " secs");
                System.out.println("Method Execution Time Exceeded. Force Stopping Program.");
                System.exit(1);
            }
        }
    }

}
