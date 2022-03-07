/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ruang
 */
public class Ai {

    static final List<String> ALPHABET = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
    static final int WORDLENGTH = 3;
    static List<String> recognized = new ArrayList();
    static List<String> unrecognized = new ArrayList();
    static Random gen = new Random();
    static Scanner sc = new Scanner(System.in);
    static long wordCount = 0;

    public static void main(String[] args) {
        new RememberWords();
        new StartAI();
    }

    private static class RememberWords {

        public RememberWords() {
            Converse.ReadFromFile("recognized");
            Converse.ReadFromFile("unrecognized");
        }
    }

    private static class StartAI {

        public StartAI() {
            if (Converse.Assign()) {
                if (wordCount == 0) {
                    Converse.ShowRecognized();
                    Converse.ShowUnRecognized();
                }
                new StartAI();
            } else {
                System.exit(0);
            }
        }
    }

    private static class Converse {

        public static String Word() {
            int length = gen.nextInt(WORDLENGTH);
            int letter;
            StringBuilder word = new StringBuilder();
            boolean exists = false;

            for (int i = 0; i <= length; i++) {
                letter = gen.nextInt(26);

                word.append(ALPHABET.get(letter));

            }

            for (String s : unrecognized) {
                if (s.equals(word.toString())) {
                    exists = true;
                }
            }

            for (String s : recognized) {
                if (s.equals(word.toString())) {
                    exists = true;
                }
            }

            if (exists) {
                wordCount++;
                return null;
            } else {
                wordCount = 0;
                System.out.println("\n\nAI says: " + word);
            }

            return word.toString();
        }

        public static boolean Recognized() {
            boolean recognized = false;
            String input;

            System.out.println("User, do you recognize this word? Y/N");

            input = sc.next().toUpperCase();

            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("Yes")) {
                recognized = true;
            }

            return recognized;
        }

        public static boolean Assign() {
            String word = Word();

            if (word != null) {
                boolean r = Recognized();

                if (r) {
                    recognized.add(word);
                    WritetoFile(word, "recognized");
                } else {
                    unrecognized.add(word);
                    WritetoFile(word, "unrecognized");
                }
            } else {
                if (wordCount >= Math.pow(ALPHABET.size(), WORDLENGTH) && (recognized.size() + unrecognized.size()) >= ALPHABET.size()) {
                    System.out.println("\nNo more solutions");
                    ShowRecognized();
                    ShowUnRecognized();
                    return false;
                } else {
                    return true;
                }
            }

            return true;
        }

        public static void ShowRecognized() {
            System.out.print("Recognized words: ");
            Collections.sort(recognized);

            for (String s : recognized) {
                if (!s.isEmpty()) {
                    System.out.print(s + ", ");
                }
            }
        }

        public static void ShowUnRecognized() {
            System.out.print("\nUnrecognized words: ");
            Collections.sort(unrecognized);

            for (String s : unrecognized) {
                if (!s.isEmpty()) {
                    System.out.print(s + ", ");
                }
            }

            System.out.println("\nSize: " + ((recognized.size() + unrecognized.size()) - 2));
        }

        public static void WritetoFile(String writable, String file) {
            BufferedWriter writer = null;

            try {
                if (file.equalsIgnoreCase("recognized")) {
                    writer = new BufferedWriter(new FileWriter("recognizedwords.txt", true));
                } else {
                    writer = new BufferedWriter(new FileWriter("unrecognizedwords.txt", true));
                }

                writer.append(writable + ", ");
            } catch (IOException ex) {
                Logger.getLogger(Ai.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Ai.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        public static void ReadFromFile(String readfile) {
            File file = null;
            BufferedReader reader = null;
            List<String> readables = new ArrayList<String>();

            try {
                if (readfile.equalsIgnoreCase("recognized")) {
                    file = new File(System.getProperty("user.dir") + "\\recognizedwords.txt");
                } else {
                    file = new File(System.getProperty("user.dir") + "\\unrecognizedwords.txt");
                }

                reader = new BufferedReader(new FileReader(file));

                if (file.exists()) {
                    readables.add(reader.readLine());
                }

                if (readfile.equalsIgnoreCase("recognized")) {
                    for (String line : readables) {
                        String[] recs = line.split(", ");
                        recognized.addAll(Arrays.asList(recs));
                    }
                } else {
                    for (String line : readables) {
                        String[] recs = line.split(", ");
                        unrecognized.addAll(Arrays.asList(recs));
                    }
                }

            } catch (Exception ex) {
                WritetoFile("", "recognized");
                WritetoFile("", "unrecognized");
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Ai.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
