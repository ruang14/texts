/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.awt.AWTException;
import java.awt.Robot;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ruang
 */
public class Talkingbot {

    static Robot bot;
    static final String BOTNAME = "BOT";
    static final String[] APLHABET = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static void main(String[] args) {
//        new InitiateConversation();
    }

    private static class InitiateConversation {

        public InitiateConversation() {
            new CreateTextArea();
        }
    }

    private static class CreateTextArea {

        public CreateTextArea() {
            JTextArea textArea = new JTextArea();
            textArea.setColumns(50);
            textArea.setRows(50);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Hello", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private static class StartBot {

        public StartBot() {

        }

    }

    private static class TalkingBot {

        public TalkingBot() throws AWTException {
            bot = new Robot();
            BotCommand command = new BotCommand();
            
            
            
        }

    }

    private static class BotCommand {

        public BotCommand() throws AWTException {
            bot = new Robot();
        }

        private void type(int i) {
            bot.keyPress(i);
            bot.delay(100);
            bot.keyRelease(i);
        }

        private void doubleType(int i, int j) {
            bot.keyPress(i);
            bot.delay(100);
            bot.keyPress(j);
            bot.delay(100);
            bot.keyRelease(j);
            bot.delay(100);
            bot.keyRelease(i);
        }

        private void write(String s) {
            byte[] bytes = s.getBytes();
            for (byte b : bytes) {
                int code = b;
                if (code > 96 && code < 123) {
                    code = code - 32;
                }
                bot.keyPress(code);
                bot.delay(50);
                bot.keyRelease(code);
            }
        }

    }

}
