/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ruang
 */
public class Threads {

//    public Threads() {
//        Indicator i = new Indicator();
//        ExecutorService ex = Executors.newSingleThreadExecutor();
//        ex.submit(i);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        i.finished = true;
//        ex.shutdown();
//    }
//
//    public static void main(String[] args) {
//        new Threads();
//    }
//
//    private class Indicator implements Runnable {
//
//        private static final int DOTS_NO = 3;
//        private volatile boolean finished = false;
//
//        @Override
//        public void run() {
//            for (int i = 0; !finished; i = (i + 1) % (DOTS_NO + 1)) {
//                for (int j = 0; j < i; j++) {
//                    System.out.print('.');
//                }
//                try {
//                    Thread.sleep(750);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                for (int j = 0; j < i; j++) {
//                    System.out.print("\b \b");
//                }
//            }
//        }
//
//    }
    public static void main(String[] args) {

        ExecutorService e = Executors.newSingleThreadExecutor();
        Future f = e.submit(new Runnable() {
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(1000); //exclude try/catch for brevity
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print(".");
                }
            }
        });
//do excel work
//f.cancel(true);
//e.shutdownNow();

    }}
