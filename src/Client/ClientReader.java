/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author ruang
 */
public class ClientReader {

    Socket s;

    public ClientReader(Socket s) {
        this.s = s;
    }

    public void Read() {
        while (true) {
            try {

                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String message = br.readLine();
                System.out.println(message);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
