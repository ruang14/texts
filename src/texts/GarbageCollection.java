/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.*;

/**
 *
 * @author ruang
 */
public class GarbageCollection {
    
    public static void main(String[] args){
        Runtime rs = Runtime.getRuntime();
        System.out.println("Free memory in JVM before Garbage Collection: " + rs.freeMemory());
        rs.gc();
        System.out.println("Free memory in JVM after Garbage Collectioln: " + rs.freeMemory());
    }
    
}
