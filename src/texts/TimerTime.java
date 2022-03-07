/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ruang
 */
public class TimerTime {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(sdf.format(date));
        
        getTimeFromTimer(12000000);
    }

    private static String getTimeFromTimer(long milliseconds) {
        String result = "";
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        DecimalFormat df = new DecimalFormat("#.##");

        try {
            seconds = (int) milliseconds / 1000;
            minutes = seconds / 60;
            hours = minutes / 60;
            
            int countMinutes = 0;
            while(seconds > 59){
                seconds = seconds - 60;
                countMinutes++;
            }
            System.out.println("countMinutes: " + countMinutes);
            System.out.println("seconds: " + seconds);
            
            int countHours = 0;
            while(minutes > 59){
                minutes = minutes - 60;
                countHours++;
            }
            System.out.println("countHours: " + countHours);
            System.out.println("minutes: " + minutes);
            
            System.out.println(df.format(hours) + ":" + df.format(minutes) + ":" + df.format(seconds));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
