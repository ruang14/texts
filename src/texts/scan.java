/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ruang
 */
public class scan {

    public static void main(String[] args) throws InterruptedException {
//        System.out.print("                                                                     _____"
//                + "\n-----    _____        ^        |\\      |  |      /|  |  |\\      |   /     \\"
//                + "\n|       /            / \\       | \\     |  |     / |  |  | \\     |  |"
//                + "\n|      |            /   \\      |  \\    |  |    /  |  |  |  \\    |  |"
//                + "\n-----  |           /     \\     |   \\   |  |   /   |  |  |   \\   |  |"
//                + "\n     | |          /_______\\    |    \\  |  |  /    |  |  |    \\  |  |"
//                + "\n     | |         /         \\   |     \\ |  | /     |  |  |     \\ |  |      _"
//                + "\n-----   \\_____  /           \\  |      \\|  |/      |  |  |      \\|   \\_____|        "
//                + "");

        ExecutorService e = Executors.newSingleThreadExecutor();
        Future f = e.submit(new Runnable() {
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(1000); //exclude try/catch for brevity
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("\n"
                            + "\n_____"
                            + "\n|"
                            + "\n|____"
                            + "\n    |"
                            + "\n____|"
                            + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(scan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("\n"
                            + "\n ____"
                            + "\n/"
                            + "\n|"
                            + "\n|"
                            + "\n\\___"
                            + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(scan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("\n"
                            + "\n    /\\"
                            + "\n   /  \\"
                            + "\n  /    \\"
                            + "\n /______\\"
                            + "\n/        \\"
                            + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(scan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("\n"
                            + "\n|\\    |"
                            + "\n| \\   |"
                            + "\n|  \\  |"
                            + "\n|   \\ |"
                            + "\n|    \\|"
                            + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(scan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("\n"
                            + "\n|\\    |"
                            + "\n| \\   |"
                            + "\n|  \\  |"
                            + "\n|   \\ |"
                            + "\n|    \\|"
                            + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(scan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("\n"
                            + "\n|"
                            + "\n|"
                            + "\n|"
                            + "\n|"
                            + "\n|"
                            + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(scan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("\n"
                            + "\n|\\    |"
                            + "\n| \\   |"
                            + "\n|  \\  |"
                            + "\n|   \\ |"
                            + "\n|    \\|"
                            + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(scan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("\n"
                            + "\n ____"
                            + "\n/    \\"
                            + "\n|"
                            + "\n|    _"
                            + "\n\\___|"
                            + "");
                }
            }
        });
    }

}
