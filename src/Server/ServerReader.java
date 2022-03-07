/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author ruang
 */
public class ServerReader {

    Socket socket;

    public ServerReader(Socket socket) {
        this.socket = socket;
    }

    public void Read() {
        while (true) {
            try {

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = br.readLine();
                System.out.println(message);
                ServerWriter.Write(message);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
