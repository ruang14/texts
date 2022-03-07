/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ruang
 */
public class taste {

    public static void main(String[] args) {

        int param = 1;
        
        String s = "select user_name, name, surname, id_number, email_address from neo_user where 1 = 1 and ( # )";
//        if (user.getIdentityNumber() != null && !user.getIdentityNumber().trim().isEmpty()) {
            s = s.replace("#", " trim(lower(id_number)) = ? # ");
            param++;
//            params.put(param++, user.getIdentityNumber().toLowerCase().trim());
//        }

//        if (user.getEmailAddress() != null && !user.getEmailAddress().trim().isEmpty()) {
            if (param > 1) {
                s = s.replace("#", " or # ");
            }

            s = s.replace("#", " trim(lower(email_address)) = ? ");
            param++;
//            params.put(param++, user.getEmailAddress().toLowerCase().trim());
//        }

        s = s.replaceAll("#", "");
        
        System.out.println(s);

//        String s = "2022_OVERAGE_DEPENDANTS_03200000273_2";
//        String prefix = "2022_OVERAGE_DEPENDANTS_";
//        
//        String cnum = s;
//        cnum = cnum.substring(prefix.length(), s.length() - 2);
//        
//        System.out.println(cnum);
//        double price = Double.parseDouble("0.00");
//        System.out.println("price: " + price);
//        double packsize = Double.parseDouble("3");
//        System.out.println("packsize: " + packsize);
//        double cp = Double.parseDouble("100");
//        System.out.println("cp: " + cp);
//        double unitprice = ((price / (100 - cp)) * 100) / packsize;
//        System.out.println(unitprice);
    }

//				anp.setUnitPrice(unitprice);
//    private int currentValue = 1;
//    public int i;
//    public static void main(String[] args) {
//        String A$B = "";
//        String _helloWrold = "";
//        String true = "";
//        String java.lang = "";
//        String Public = "";
//        String 1980_s = "";
//        int myArray[];
//        int myArray1[5];
//        int mayArray2[5] = {1, 2, 3, 4, 5};
//        int myArray3[] = {1,2,3,4,5};
//        Calendar oldOptionsEndDate = Calendar.getInstance();
//        oldOptionsEndDate.set(Calendar.MILLISECOND, 0000);
//    	oldOptionsEndDate.set(Calendar.SECOND, 00);
//    	oldOptionsEndDate.set(Calendar.MINUTE, 00);
//    	oldOptionsEndDate.set(Calendar.HOUR_OF_DAY, 00);
//    	oldOptionsEndDate.set(Calendar.DAY_OF_MONTH, 31);
//    	oldOptionsEndDate.set(Calendar.MONTH, 11);
//    	oldOptionsEndDate.set(Calendar.YEAR, 2019);
//    	
//    	Calendar newOptionsStartDate = Calendar.getInstance();
//    	newOptionsStartDate.set(Calendar.MILLISECOND, 0000);
//    	newOptionsStartDate.set(Calendar.SECOND, 00);
//    	newOptionsStartDate.set(Calendar.MINUTE, 00);
//    	newOptionsStartDate.set(Calendar.HOUR_OF_DAY, 00);
//    	newOptionsStartDate.set(Calendar.DAY_OF_MONTH, 01);
//    	newOptionsStartDate.set(Calendar.MONTH, 00);
//    	newOptionsStartDate.set(Calendar.YEAR, 2020);
//        
//        System.out.println("olddate: " + oldOptionsEndDate.getTime());
//        System.out.println("newdate: " + newOptionsStartDate.getTime());
//        
//        Date inceptionDate = null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//        
//        try {
//             inceptionDate = sdf.parse("2019/11/01");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("incep: " + inceptionDate);
//        
//       if(inceptionDate.after(oldOptionsEndDate.getTime())){
//           System.out.println("true");
//       } else {
//           System.out.println("false");
//       }
//        DecimalFormat df = new DecimalFormat("#.##");
//        double avg = 1.50;//seconds
//        int items = 8500;
//        double max = avg * items;
//        
//        System.out.println("Average time item takes to send: about " + avg + " seconds");
//        System.out.println("Items: " + items);
//        System.out.println("Time to send: about " + df.format((max / 60) / 60) + " hours");
//        
//        for(int i = 1; i <= 8500; i++){
////            try {
////                Thread.sleep(1500);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//            
//            System.out.println("Item sent");
//            items--;
//            System.out.print("[");
////            for(int j = 0; j < 85; j++){
//                for(int k = 0; k < ((8500 - items) / 100); k++){
//                    System.out.print("█");
//                }
//                for(int k = 85; k > ((8500 - items) / 100); k--){
//                    System.out.print(" ");
//                }
////            }
//            System.out.println("]");
//            max = avg * items;
//            
//            System.out.println("Remaining time: about " + df.format((max / 60) / 60) + " hours");
//            System.out.println("Remaining items: " + items);
//        }
//        Calendar result = Calendar.getInstance();
//        Calendar date = Calendar.getInstance();
//        
//        try {
//            date.setTime(new Date());
//            date.set(Calendar.DAY_OF_MONTH, date.getActualMaximum(Calendar.DAY_OF_MONTH));
//            System.out.println("date: " + date.getTime());
//            result.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH));
//            result.set(Calendar.MONTH, date.get(Calendar.MONTH));
//            result.set(Calendar.YEAR, date.get(Calendar.YEAR));
//            System.out.println("result: " + result.getTime());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        List<Integer> intList = new ArrayList<Integer>();
//        intList.add(100);
//        intList.add(101);
//        intList.add(102);
//        intList.add(103);
//        intList.add(104);
//        intList.add(105);
//        intList.add(106);
//        intList.add(107);
//        System.out.println("intList: " + intList);
//        
//        if(intList.contains(101)){
//            System.out.println("contains");
//        }
//        if(!intList.contains(111)){
//            System.out.println("not contains");
//        }
//        String s = " ";
//        if (s.trim().isEmpty()){
//            System.out.println("empty");
//        } else {
//            System.out.println("not empty");
//        }
//        int year = Calendar.getInstance().get(Calendar.YEAR) + 1;
//        System.out.println(year);
//        
//        int oyear = new Date().getYear();
//        System.out.println(oyear);
//        
//        Calendar c = Calendar.getInstance();
//        System.out.println(c.get(Calendar.YEAR));
//        
//        c.setTime(new Date());
//        c.add(Calendar.YEAR, 1);
//        System.out.println(c.get(Calendar.YEAR));
//        
//        if(new Date().before(c.getTime())){
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
//        
//        Calendar cal = Calendar.getInstance();
//        int res = cal.getActualMaximum(Calendar.DATE);
//        System.out.println(res);
//        
//        Calendar c1 = Calendar.getInstance();
//        c1.setTime(new Date());
//        int month = c1.get(Calendar.MONTH) + 1;
//        System.out.println(month);
////////////////////////////////////////////////////////////////////////////////
//        int currentValue = 50;
//        taste s = new taste();
//        s.printCurrentValue();
////////////////////////////////////////////////////////////////////////////////
//        char d = "d";
//        float f = 3.1415;
//        int i = 34;
//        byte b = 257;
//        boolean isPresent = true;
////////////////////////////////////////////////////////////////////////////////
//        int inndex = 5;
//        switch(inndex){
//            case 1:
//                System.out.println("One");
//                break;
//            default: 
//                System.out.println("default");
//            case 2:
//                System.out.println("Two");
//        }
////////////////////////////////////////////////////////////////////////////////
//        String s1 = "Java";
//        String s2 = "Java";
//        String s3 = new String("Java");
//
//        if(s1 == s2){
//            System.out.println("Equal");
//        } else {
//            System.out.println("Not Equal");
//        }
//
//        if(s1 == s3){
//            System.out.println("Equal2");
//        } else {
//            System.out.println("Not Equal2");
//        }
////////////////////////////////////////////////////////////////////////////////
//        System.out.println(2 + 4 * 3 - 7);
//        System.out.println((2 + 4) * (3 - 7));
//        System.out.println(2 + (4 * 3) - 7);
//        System.out.println(((2 + 4) * 3) - 7);
////////////////////////////////////////////////////////////////////////////////
//        taste sc = new taste();
//        System.out.println(i);
//        System.out.println(sc.i);
//        System.out.println(taste.i);
//        System.out.println((new taste()).i);
////////////////////////////////////////////////////////////////////////////////
//        int i;
//        int j;
//
//        for(i = 1; i < 4; i++){
//            for(j = 2; j < 4; j++){
//                if(j == 3){
//                    continue;
//                }
//                System.out.println("i: " + i + " j: " + j);
//            }
//        }
////////////////////////////////////////////////////////////////////////////////
//        int i = 3;
//        int j = 3;
//        int k = 3;
//
//        if(i > j){}
//        if(i > j > k){}
//        if(i > j && i > k){}
//        if(i > j && > k){}
////////////////////////////////////////////////////////////////////////////////
//        int x = 4;
//        long y = x * 4 - x++;
//        if(y < 10)System.out.println("Too Low");
//        else System.out.println("Just Right");
//        else System.out.println("Too High");
////////////////////////////////////////////////////////////////////////////////
//        int myArray[];
//        int myArray1[5];
//        int myArray2[5] = {1, 2, 3, 4, 5};
//        int myArray3[] = {1, 2, 3, 4, 5};
////////////////////////////////////////////////////////////////////////////////
//        String ASB = "";
//        String _helloWorld = "";
//        String true = "";
//        String java.lang = "";
//        String Public = "";
//        String 1980_s = "";
////////////////////////////////////////////////////////////////////////////////
//        int a = 0;
//        int b = 50;
//
//        try {
//            int answer = b / a;
//        } catch (Exception e) {
//            System.out.println("catching exception: " + e);
//        } 
//        catch (ArithmeticException ae) {
//            System.out.println("catching arithemtic exception: " + ae);
//        }
//        System.out.println("Done");
////////////////////////////////////////////////////////////////////////////////
//        System.out.println(testStrings("this", "siht"));
////////////////////////////////////////////////////////////////////////////////
//        char[] chars = {103, 111, 111, 100, 32, 108, 117, 99, 107, 32, 119, 105, 116, 104, 32, 121, 111, 117, 114, 32, 101, 120, 97, 109, 115, 33, 33, 65535};//255*257
//        System.out.println(new String(chars));
//        String s = null;
//        System.out.println(s);
//        Class.forName("java.lang.String");
//        int k = args.length;
//        k++;
//        k = 3 + ++k;
//        System.out.println(k);
//        for (int i = 1; i < 101; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                System.out.println("FizzBuzz");
//            } else if (i % 5 == 0 && i % 3 != 0) {
//                System.out.println("Buzz");
//            } else if (i % 3 == 0 && i % 5 != 0) {
//                System.out.println("Fizz");
//            } else {
//                System.out.println(i);
//            }
//        }
//        char[] chars = new char[256];
//        for(int i = 0; i < 256; i++){
//            chars[i] = (char) i;
//        }
//        System.out.println(new String(chars));
//        System.out.print("-------------------------------------------------");
//        for(int i = 0; i < chars.length; i++){
//            System.out.print("  " + i + "|" + chars[i]);
//            if(i % 20 == 0){
//                System.out.println("");
//            }
//        }
//        System.out.println("\n-------------------------------------------------");
//        byte i = 50;
//	// No casting needed for below conversion
//        short j = i;
//	int k = j;
//	long l = k;
//	float m = l;
//	double n = m;
//	    
//	System.out.println("byte value : "+i);
//	System.out.println("short value : "+j);
//	System.out.println("int value : "+k);
//	System.out.println("long value : "+l);
//	System.out.println("float value : "+m);
//	System.out.println("double value : "+n);
//
//        double dd = 257.0;
//	// Explicit casting is needed for below conversion
//	float ff = (float) dd;
//	long ll = (long) ff;
//	int ii  = (int) ll;
//	short ss = (short) ii;
//	byte bb = (byte) ss;
//		
//	System.out.println("\ndouble value : "+dd);
//	System.out.println("float value : "+ff);
//	System.out.println("long value : "+ll);
//	System.out.println("int value : "+ii);
//	System.out.println("short value : "+ss);
//	System.out.println("byte value : "+bb);
//        boolean test = false;
//        int myInt = (true) ? 1 : 0;
//        System.out.println(myInt);
//    }
    public static void printCurrentValue() {
//        System.out.println(currentValue);
    }

    public static boolean testStrings(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        List<String> la = new ArrayList<String>();
        for (char c : ca) {
            la.add(String.valueOf(c));
        }
        List<String> lb = new ArrayList<String>();
        for (char cc : cb) {
            lb.add(String.valueOf(cc));
        }

        if (a.length() != b.length()) {
            return false;
        } else {
            for (String s : la) {
                if (!lb.contains(s)) {
                    return false;
                }
            }
        }

        return true;
    }

    public interface CanHop {
    }

    public class Frog implements CanHop {

        public void main(String[] args) {
//            Long frog = new TurtleFrog();
        }
    }

    public class BrazilianHornedFrog extends Frog {
    }

    public class TurtleFrog extends Frog {
    }

}
