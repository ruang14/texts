/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ruang
 */
public class DateFormat {

//    public static void main(String[] args){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String date = "20200820";
//        
//        try {
////            Date today = new Date();
////            System.out.println("Today: " + today);
////            System.out.println("Today parsed: " + sdf.format(today));
////            System.out.println("--");
//            
//            Date dateP = new SimpleDateFormat("dd/MM/yyyy").parse(date);
//            System.out.println("Date: " + date);
//            System.out.println("Date parsed: " + dateP);
//        } catch (Exception e) {
//        }
//    }
    public static void main(String[] args) throws Exception {
        String sDate1 = "20200820";
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        System.out.println(sDate1 + "\t" + date1);
    }

}
