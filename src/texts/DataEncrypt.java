/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
//import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author ruang
 */
public class DataEncrypt {

    public static void main(String[] args) {
        String data = "password";
        System.out.println("p: " + data);
        Password p = new Password(data);
        System.out.println(p.toString());
    }

//    public static String Encrypt(String plainText, SecretKey secretKey) {
//try {
//    System.out.println("Start encryption ...");
//
//    /* Get Input Data */
//    String input = getInputData();
//    System.out.println("Input data : "+input);
//
//    /* Create Secret Key */
//    KeyGenerator keyGen = KeyGenerator.getInstance(ALGO);
//    SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
//    keyGen.init(56,random);
//      Key sharedKey = keyGen.generateKey();
//
//    /* Create the Cipher and init it with the secret key */
//    Cipher c = Cipher.getInstance(ALGO+"/"+MODE+"/"+PADDING);
//    //System.out.println("\n" + c.getProvider().getInfo());
//    c.init(Cipher.ENCRYPT_MODE,sharedKey);
//    byte[] ciphertext = c.doFinal(input.getBytes());
//    System.out.println("Input Encrypted : "+new String(ciphertext,"UTF8"));
//
//    /* Save key to a file */
//    save(sharedKey.getEncoded(),"shared.key");
//
//    /* Save encrypted data to a file */
//    save(ciphertext,"encrypted.txt");
//} catch (Exception e) {
//    e.printStackTrace();
//} 
//    }

    public static String Decrypt(String s) {

        return s;
    }

    public static class Password {

        final String password; // the string to mask

        Password(String password) {
            this.password = password;
        } // needs null protection
        // allow this to be equal to any string
        // reconsider this approach if adding it to a map or something?

        public boolean equals(Object o) {
            return password.equals(o);
        }
        // we don't need anything special that the string doesnt

        public int hashCode() {
            return password.hashCode();
        }
        // send stars if anyone asks to see the string - consider sending just
        // "******" instead of the length, that way you don't reveal the password's length
        // which might be protected information

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < password.length(); i++) {
                sb.append("*");
            }
            return sb.toString();
        }
    }

}
