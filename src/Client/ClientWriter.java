/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ruang
 */
public class ClientWriter {

    Socket s;

    public ClientWriter(Socket s) {
        this.s = s;
    }

    public void Write() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {

                PrintWriter pw = new PrintWriter(s.getOutputStream());
                String message = sc.nextLine();
                pw.write(message);
                pw.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
