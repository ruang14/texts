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
public class ArrayTesting {

    public static void main(String[] args) {
        List<List<String>> lls = new ArrayList<List<String>>();

        List<String> ls = new ArrayList<String>();
        ls.add("A Alpha");
        ls.add("A Atac");
        ls.add("B Beta");
        ls.add("B Bears");
        ls.add("C Catch");
        ls.add("C Cant");

        for (String s : ls) {
            System.out.println(s);

            String[] sArr = s.split("\\s");
            List<String> A = new ArrayList<String>();
            for (int i = 0; i < sArr.length; i++) {
                System.out.println("sarr[ " + i + " ]: " + sArr[i]);
                
                A.add(sArr[1]);
                System.out.println("added: " + sArr[1]);
            }
            lls.add(A);
        }

        for (List<String> mls : lls) {
            System.out.println("mls: " + mls);
        }
    }

}
