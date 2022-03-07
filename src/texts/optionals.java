/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.util.Optional;

/**
 *
 * @author ruang
 */
public class optionals {
    
    public static void main(String[] args){
        Optional<String> empty = Optional.empty();
//        assertFalse(empty.isPresent());
        
        ////////////////////////////////////////////////////////////////////////
        
        String name = "test";
        Optional<String> opt = Optional.of(name);
    }
    
}
