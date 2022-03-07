/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ruang
 */
public class Server {

    public static void main(String[] args) {
        try {
            
            ServerSocket ss = new ServerSocket(1234);
            System.out.println(">> SERVER ONLINE <<");

            while (true) {
                final Socket socket = ss.accept();
                System.out.println(">> CLIENT CONNECTED <<");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new ServerReader(socket).Read();
                    }

                }).start();

                ServerWriter.clientSockets.add(socket);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
