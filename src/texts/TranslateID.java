/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ruang
 */
public class TranslateID {

    public static void main(String[] args) {
        do {
            System.out.println("Enter ID Number: ");
            Scanner sc = new Scanner(System.in);
            String id = sc.next();

            if (id.length() == 13) {
                try {
                    if (!validateDate(id)) {
                        System.out.println("Invalid ID");
                        continue;
                    }

                    Date tempDate = new Date(Integer.parseInt(id.substring(0, 2)), Integer.parseInt(id.substring(2, 4)) - 1, Integer.parseInt(id.substring(4, 6)));

                    int idGender = Integer.parseInt(id.substring(6, 10));
                    String gender = "Female";

                    if (idGender > 4999) {
                        gender = "Male";
                    }

                    int idResident = Integer.parseInt(id.substring(10, 11));
                    String citizen = "SA Citizen";

                    if (idResident > 1) {
                        System.out.println("Invalid ID");
                        continue;
                    }

                    if (idResident == 1) {
                        citizen = "Permanent Resident";
                    }

                    if (!checkLuhn(id)) {
                        System.out.println("Invalid ID");
                        continue;
                    }

                    System.out.println("\nBirth Date: " + new SimpleDateFormat("E/dd/MMMM/yyyy").format(tempDate));
                    System.out.println("Gender: " + gender);
                    System.out.println("Residency: " + citizen + "\n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Invalid ID");
                }
            } else {
                System.out.println("Invalid ID");
            }
        } while (true);
    }

    private static boolean validateDate(String date) {
        int idYear = Integer.parseInt(date.substring(0, 2));
        int idMonth = Integer.parseInt(date.substring(2, 4));
        int idDay = Integer.parseInt(date.substring(4, 6));

        if (idMonth < 1 || idMonth > 12 || idDay < 1) {
            return false;
        }

        if (idMonth == 0 || idMonth == 2 || idMonth == 4 || idMonth == 6 || idMonth == 7 || idMonth == 9 || idMonth == 11) {
            if (idDay > 31) {
                return false;
            }
        } else if (idMonth != 1) {
            if (idDay > 30) {
                return false;
            }
        } else {
            if ((idYear + 1900) % 4 == 0) {
                if (idDay > 29) {
                    return false;
                }
            } else {
                if (idDay > 28) {
                    return false;
                }
            }
        }

        return true;
    }

    public static Boolean checkLuhn(String identities) {
        char[] idchars = identities.toCharArray();
        int sum = 0;

        for (int i = 1; i <= idchars.length; i++) {
            int digit = Character.getNumericValue(idchars[idchars.length - i]);
            if ((i % 2) != 0) {
                sum += digit;
            } else {
                sum += digit < 5 ? digit * 2 : digit * 2 - 9;
            }
        }
        return (sum % 10) == 0;
    }

}
