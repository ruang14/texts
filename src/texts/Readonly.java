/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.io.File;

/**
 *
 * @author ruang
 */
public class Readonly {
    
    public static void main(String[] args){
        File file = new File("C:/Users/RuanG/Documents/NetBeansProjects/java.txt");
        System.out.println(file.setReadOnly());
        System.out.println(file.canWrite());
    }
    
}
