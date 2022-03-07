/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.net.Socket;

/**
 *
 * @author ruang
 */
public class Client {

    public static void main(String[] args) {
        try {

            final Socket s = new Socket("localhost", 1234);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new ClientReader(s).Read();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    new ClientWriter(s).Write();
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
