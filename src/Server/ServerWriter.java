/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author ruang
 */
public class ServerWriter {

    static ArrayList<Socket> clientSockets = new ArrayList();

    public ServerWriter(ArrayList<Socket> clientSockets) {
        this.clientSockets = clientSockets;
    }

    public static void Write(String message) {
        for (Socket s : clientSockets) {
            try {

                PrintWriter pw = new PrintWriter(s.getOutputStream());
                pw.write(message + "\n");
                pw.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
