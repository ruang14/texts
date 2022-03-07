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
public class This_Class {

    public static void main(String[] args) {
        System.out.println("Calling That_Class");
        new That_Class().run();
    }

    public void run() {
        main(null);
    }

}
