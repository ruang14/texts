/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

//import java.awt.Graphics;
//import java.io.IOException;
//import java.util.Random;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
 *
 * @author ruang
 */
public class CalculatorApplet extends Applet implements ActionListener {

    private Button keysArray[];
    private Panel keyPad;
    private TextField lcdField;
    private double result;
    private boolean first;
    private boolean foundKey;
    static boolean clearText;
    private int prevOperator;

    @Override
    public void init() {
        lcdField = new TextField(20);
        keyPad = new Panel();
        keysArray = new Button[17];
        result = 0.0;
        prevOperator = 0;
        first = true;
        clearText = true;

        //Set fram layout manager setLayout(new BorderLayout());
        lcdField.setEditable(false);

        //Create buttons        
        for (int i = 0; i <= 9; i++) {
            keysArray[i] = new Button(String.valueOf(i));
        }
        
        keysArray[10] = new Button("/");
        keysArray[11] = new Button("*");
        keysArray[12] = new Button("-");
        keysArray[13] = new Button("+");
        keysArray[14] = new Button("=");
        keysArray[15] = new Button(".");
        keysArray[16] = new Button("CLR");

        //Set panel layout manager
        keyPad.setLayout(new GridLayout(4, 4));

        //Add buttons to keyPad panel
        for (int j = 7; j <= 10; j++) { //Adds buttons 7, 8, 9 and / to panel
            keyPad.add(keysArray[j]);
        }
        for (int k = 4; k <= 6; k++) { //Adds buttons 4, 5, 6 to panel
            keyPad.add(keysArray[k]);
        }

        keyPad.add(keysArray[11]); //Adds * button to panel

        for (int l = 1; l <= 3; l++) { //Adds buttons 1, 2, 3 to panel
            keyPad.add(keysArray[l]);
        }

        keyPad.add(keysArray[12]); //Adds - button to panel
        keyPad.add(keysArray[0]); //Adds button 0 to panel

        for (int m = 15; m >= 13; m--) { //Adds buttons ., =, + to panel
            keyPad.add(keysArray[m]);
        }

        add(lcdField, BorderLayout.NORTH); //Adds text field to top of frame
        add(keyPad, BorderLayout.CENTER); //Adds panel to center of frame
        add(keysArray[16], BorderLayout.EAST); // Adds clear key to right side of applet

        for (int n = 0; n < keysArray.length; n++) {
            keysArray[n].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        foundKey = false;
        
        //Search for the key pressed
        for(int i = 0; i <keysArray.length && !foundKey; i++){
            if(e.getSource() == keysArray[i]){ //Key match found
                foundKey = true;
                switch(i){
                    case 0: case 1: case 2: case 3: case 4: //Number buttons
                    case 5: case 6: case 7: case 8: case 9: //0-9
                    case 15:
                        if(clearText){
                            lcdField.setText("");
                            clearText = false;
                        }
                        lcdField.setText(lcdField.getText() + keysArray[i].getLabel());
                        break;
                        
                    case 10: // / button
                    case 11: // * button
                    case 12: // - button
                    case 13: // + button
                    case 14: // = button
                        clearText = true;
                        if(first){ //First operand
                            if(lcdField.getText().length() == 0){
                                result = 0.0;
                            } else {
                                result = Double.parseDouble(lcdField.getText());
                            }
                            first = false;
                            prevOperator = i; //Save previous operator
                        } else { //Second operand already enter, so calculator total
                            switch(prevOperator){
                                case 10: // / button
                                    result /= Double.parseDouble(lcdField.getText());
                                    break;
                                case 11: // * button
                                    result *= Double.parseDouble(lcdField.getText());
                                    break;
                                case 12: // - button
                                    result -= Double.parseDouble(lcdField.getText());
                                    break;
                                case 13: // + button
                                    result += Double.parseDouble(lcdField.getText());
                                    break;
                            }
                            lcdField.setText(Double.toString(result));
                            if(i == 14){ // = button
                                first = true;
                            } else {
                                prevOperator = i; //Save previous operator
                            }
                        }
                        break;
                        
                    case 16: //Clear button
                        clearText = true;
                        first = true;
                        lcdField.setText("");
                        result = 0.0;
                        prevOperator = 0;
                        break;
                }
            }
        }
    }
}

//public class Texts {
//
//    /**
//     * @param args the command line arguments
//     */
//    
//    
//    
////   public static void main(String[] args) {
//       
//       
//       
////        // TODO code application logic here
////        Calculator cal = new Calculator();
////        
////        Circle ci = new Circle();
////        ci.DrawMeACircle(5, 15, 5);
////        
////        Scanner sc = new Scanner(System.in);
////        String advName = "";
////        int advHP = 100;
////        int specialPoints = 0;
////        int advStrength = 0;
////        boolean s = true;
////        int advPerception = 0;
////        boolean p = true;
////        int advEndurance = 0;
////        boolean e = true;
////        int advCharisma = 0;
////        boolean c = true;
////        int advIntelligence = 0;
////        boolean i = true;
////        int advAgility = 0;
////        boolean a = true;
////        int advLuck = 0;
////        boolean l = true;
////
////        
////
////        System.out.println("Enter your adventurer name");
////        advName = JOptionPane.showInputDialog("Adventurer Name", "Enter Name");
////        JOptionPane.showMessageDialog(null, advName, "Name", JOptionPane.INFORMATION_MESSAGE);
////        System.out.println("You have 10 S.P.E.C.I.A.L. points to use");
////        specialPoints = 10;
////
////        while (s == true) {
////            System.out.println("Points for Strength?");
////            advStrength = sc.nextInt();
////            if (advStrength > specialPoints) {
////                System.out.println("Not enough points!");
////                s = true;
////            } else {
////                specialPoints = specialPoints - advStrength;
////                s = false;
////            }
////        }
////        System.out.println(specialPoints + " points remaining");
////
////        while (p == true) {
////            System.out.println("Points for Perception?");
////            advPerception = sc.nextInt();
////            if (advPerception > specialPoints) {
////                System.out.println("Not enough points!");
////                p = true;
////            } else {
////                specialPoints = specialPoints - advPerception;
////                p = false;
////            }
////        }
////        System.out.println(specialPoints + " points remaining");
////
////        while (e == true) {
////            System.out.println("Points for Endurance?");
////            advEndurance = sc.nextInt();
////            if (advEndurance > specialPoints) {
////                System.out.println("Not enough points!");
////                e = true;
////            } else {
////                specialPoints = specialPoints - advEndurance;
////                e = false;
////            }
////        }
////        System.out.println(specialPoints + " points remaining");
////
////        while (c == true) {
////            System.out.println("Points for Charisma?");
////            advCharisma = sc.nextInt();
////            if (advCharisma > specialPoints) {
////                System.out.println("Not enough points!");
////                c = true;
////            } else {
////                specialPoints = specialPoints - advCharisma;
////                c = false;
////            }
////        }
////        System.out.println(specialPoints + " points remaining");
////
////        while (i == true) {
////            System.out.println("Points for Intelligence?");
////            advIntelligence = sc.nextInt();
////            if (advIntelligence > specialPoints) {
////                System.out.println("Not enough points!");
////                i = true;
////            } else {
////                specialPoints = specialPoints - advIntelligence;
////                i = false;
////            }
////        }
////        System.out.println(specialPoints + " points remaining");
////
////        while (a == true) {
////            System.out.println("Points for Agility?");
////            advAgility = sc.nextInt();
////            if (advAgility > specialPoints) {
////                System.out.println("Not enough points!");
////                a = true;
////            } else {
////                specialPoints = specialPoints - advAgility;
////                a = false;
////            }
////        }
////        System.out.println(specialPoints + " points remaining");
////
////        while (l == true) {
////            System.out.println("Points for Luck?");
////            advLuck = sc.nextInt();
////            if (advLuck > specialPoints) {
////                System.out.println("Not enough points!");
////                l = true;
////            } else {
////                specialPoints = specialPoints - advLuck;
////                l = false;
////            }
////        }
////
////        System.out.println(advName + "'s S.P.E.C.I.A.L. attributes are: \n"
////                + "Strength: " + advStrength + "\n"
////                + "Perception: " + advPerception + "\n"
////                + "Endurance: " + advEndurance + "\n"
////                + "Charisma: " + advCharisma + "\n"
////                + "Intelligence: " + advIntelligence + "\n"
////                + "Agility: " + advAgility + "\n"
////                + "Luck: " + advLuck);
////
////        System.out.println("Go on an adventure?");
////        try {
////            System.in.read();
////        } catch (IOException ex) {
////            Logger.getLogger(Texts.class.getName()).log(Level.SEVERE, null, ex);
////        }
////
////        System.out.println("You are a Bronze Class Adventurer starting your first Adventure.");
////        System.out.println("You have a Rusty Old Shortsword and Frail and Torn Light Leather Armor equipped with a Small Backpack.");
////
////        int advDMG = 4;
////        int advARM = 6;
////        int advINV = 4;
////
////        System.out.println("You begin exploring the world.");
////        System.out.println("You spot a Molerat Tunnel. What do you do?");
////        System.out.println("Walk past it (W) or Investigate it (I) ?");
////        String choice1 = sc.next();
////        if (choice1.equalsIgnoreCase("W")) {
////            System.out.println("You decide to Walk past the Molerat Tunnel and continue about your Adventure.");
////        }
////        if (choice1.equalsIgnoreCase("I")) {
////            System.out.println("You decide to Investigate the Molerat Tunnel.");
////            System.out.println("You found an Old Slingshot!");
////            
////        }
////
////   }
//
//}
