/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruang
 */
public class Lists {
    
    public static void main(String[] args){
        List<String> ls = new ArrayList();
        ls.add("one");
        ls.add("two");
        int count = ls.size();
        
        for(int i = 0; i < count; i++){
            System.out.println("s: " + ls.get(i));
            ls.add("three");
            
//            if((i + 1) == count){
//                break;
//            }
        }
        
        System.out.println("ls.size: " + ls.size());
        System.out.println(ls);
    }
    
}
