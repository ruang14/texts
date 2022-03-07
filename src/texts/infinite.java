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
public class infinite {

    public static void main(String[] args) {
        int second = 00;
        int minute = 00;
        int hour = 00;
        
        try {
            for (int i = 1; i < 61; i++) {
                second++;
                if(second == 60){
                    minute++;
                    second = 0;
                    i = 0;
                }
                if(minute == 60){
                    hour++;
                    minute = 0;
                    second = 0;
                    i = 0;
                }
                System.out.println(hour + ":" + minute + ":" + second);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
//        int n = 10;
//        int m = 10;
//        String s = "";
//        
//        for(int i = 0; i < n; i++){
//            s += "~.";
//            System.out.print(s + ">   ");
//            s += " ";
        }

//        while (n <= 50) {
//            for (int i = 0; i < n; i++) {
//                for (int j = n - i; j > 1; j--) {
//                    if (n == 50) {
//                        if (j >= 30) {
//                            System.out.print("*");
//                        } else {
//                            System.out.print("_");
//                        }
//
//                    }
//                }
//
//                for (int j = 0; j <= i; j++) {
//                    if (n == 50) {
//                        if (j >= 20) {
//                            System.out.print("*");
//                        } else {
//                            System.out.print("_");
//                        }
//                    }
//                }
//
//                if (n == 50) {
//                    System.out.println();
//                }
//            }
//        for (int j = 0; j < m; j++) {
//            for (int i = 0; i < n; i++) {
//                if (i < 5) {
//                    if (j < 5) {
//                        System.out.print("> ");
//                    } else {
//                        System.out.print("< ");
//                    }
//                } else {
//                    System.out.print("< < ");
//                }
//            }
//            System.out.println("");
//        }

//            n++;
//        }
//    }
}
