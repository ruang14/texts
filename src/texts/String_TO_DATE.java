/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author ruang
 */
public class String_TO_DATE {
    
    public static void main(String[] args){
        try {
            String date = "20200217";
        Date serviceDate = new SimpleDateFormat("yyyyMMdd").parse(date);
            System.out.println(serviceDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
