/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ruang
 */
public class PasswordGenerator {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        List<String> chars = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        List<String> integers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        List<String> specials = Arrays.asList("`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+", "[", "{", "]", "}", "\\", "|", ";", ",", ":", "'", "\"", ",", "<", ".", ">", "/", "?");

        Random gen = new Random();
        int con = 0;

        do {
            int length = 0;
            String password;
            boolean isNum = true;

            System.out.println("Insert password");
            password = JOptionPane.showInputDialog(null, "Enter password length", "Begin", JOptionPane.QUESTION_MESSAGE);

            try {
                length = Integer.parseInt(password);
            } catch (NumberFormatException e) {
                isNum = false;
            }

            if (password == null) {
                System.exit(0);
            }
            if (!isNum) {
                System.out.println("Enter a number");
                continue;
            }
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty");
                continue;
            }
            if (password.contains(" ")) {
                System.out.println("Password cannot contain spaces");
                continue;
            }

            if (length < 4) {
                System.out.println("Password too short");
            } else if (length > 16) {
                System.out.println("Password too long");
            } else {
                password = "";
                for (int i = 1; i <= length; i++) {
                    int nextInt = gen.nextInt(4) + 1;
                    int nextChar = gen.nextInt(26);
                    int nextInteger = gen.nextInt(10);
                    int nextSpecial = gen.nextInt(7);
                    switch (nextInt) {
                        case 1:
                            password += chars.get(nextChar);
                            break;
                        case 2:
                            password += chars.get(nextChar).toUpperCase();
                            break;
                        case 3:
                            password += integers.get(nextInteger);
                            break;
                        case 4:
                            password += specials.get(nextSpecial);
                            break;
                        default:
                            System.out.println("Out of range");
                            break;
                    }
                }
                System.out.println("Your password: " + password);

                try {
                    StringSelection selection = new StringSelection(password);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(selection, selection);
                } catch (HeadlessException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                JOptionPane.showMessageDialog(null, "Your generated password: " + password + "\nSaved to Clipboard", "Generated", JOptionPane.INFORMATION_MESSAGE);

                int score = 0;

                if (password.length() < 8) {
                    score -= 1;
                } else if (password.length() >= 10) {
                    score += 2;
                } else {
                    score += 1;
                }

                if (password.matches("(?=.*[0-9].*[0-9]).*")) {
                    score += 2;
                } else if (password.matches("(?=.*[0-9]).*")) {
                    score += 1;
                }

                if (password.matches("(?=.*[a-z].*[a-z]).*")) {
                    score += 2;
                } else if (password.matches("(?=.*[a-z]).*")) {
                    score += 1;
                }

                if (password.matches("(?=.*[A-Z].*[A-Z]).*")) {
                    score += 2;
                } else if (password.matches("(?=.*[A-Z]).*")) {
                    score += 1;
                }

                if (password.matches("(?=.*[`~!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?].*[`~!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?]).*")) {
                    score += 2;
                } else if (password.matches("(?=.*[`~!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?]).*")) {
                    score += 1;
                }

                String scoreString;
                String scoreBar = "";

                if (score < 4) {
                    scoreString = "Very Weak";
                } else if (score >= 4 && score < 8) {
                    scoreString = "Weak";
                } else if (score >= 8 && score <= 9) {
                    scoreString = "Strong";
                } else {
                    scoreString = "Very Strong";
                }

                for (int i = 1; i <= score; i++) {
                    scoreBar += "██";//ALT + 219 
                }

                if (score != 10) {
                    for (int i = 1; i <= 10 - score; i++) {
                        scoreBar += "  ";
                    }
                }

                String veryWeak = "[####][          ][          ][          ]";
                String weak = "[####][####][          ][          ]";
                String strong = "[####][####][####][          ]";
                String veryStrong = "[####][####][####][####]";

                System.out.println("Password strength: " + scoreString);

                if (scoreString.equals("Very Weak")) {
                    System.out.println(ANSI_RESET + "[" + ANSI_RED + scoreBar + ANSI_RESET + "]");
                    JOptionPane.showMessageDialog(null, "Password strength: " + scoreString + "\n" + veryWeak);
                } else if (scoreString.equals("Weak")) {
                    System.out.println(ANSI_RESET + "[" + ANSI_YELLOW + scoreBar + ANSI_RESET + "]");
                    JOptionPane.showMessageDialog(null, "Password strength: " + scoreString + "\n" + weak);
                } else if (scoreString.equals("Strong")) {
                    System.out.println(ANSI_RESET + "[" + ANSI_GREEN + scoreBar + ANSI_RESET + "]");
                    JOptionPane.showMessageDialog(null, "Password strength: " + scoreString + "\n" + strong);
                } else {
                    System.out.println(ANSI_RESET + "[" + ANSI_GREEN + scoreBar + ANSI_RESET + "]");
                    JOptionPane.showMessageDialog(null, "Password strength: " + scoreString + "\n" + veryStrong);
                }

                System.out.println("Generate another password? Y/N");

                con = JOptionPane.showConfirmDialog(null, "Enter another password?", "End", JOptionPane.YES_NO_OPTION);
            }
        } while (con == 0);

    }

}
