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
public class Rot {
    
    private static final char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final int ROT = 3;
    
    public static void main(String[] args){
        if(ROT > 26 || ROT < 1){
            System.out.println("Non-valid rot");
        } else {
            decryptWithRot(encryptWithRot("katie meow", ROT), ROT);
        }
    }
    
    private static String encryptWithRot(String string, int rot){
        String result = "";
        
        try {
            char[] chars = string.toCharArray();

            for(char c : chars){
                for(int i = 0; i < ALPHABET.length; i++){
                    if(c == ALPHABET[i]){
                        if(i + rot > 25){
                            result += ALPHABET[i - 26 + rot];
                        } else {
                            result += ALPHABET[i + rot];
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Encrypted " + string + " to " + result);
        return result;
    }
    
    private static String decryptWithRot(String string, int rot){
        String result = "";
        
        try {
            char[] chars = string.toCharArray();
            
            for(char c : chars){
                for(int i = 0; i < ALPHABET.length; i++){
                    if(c == ALPHABET[i]){
                        if(i < rot){
                            result += ALPHABET[26 - rot + i];
                        } else {
                            result += ALPHABET[i - rot];
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Decrypted " + string + " to " + result);
        return result;
    }
    
}
