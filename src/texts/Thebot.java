/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *
 * @author ruang
 */
public class Thebot {

    static Robot robot;

    public static void main(String[] args) throws AWTException {
        new StartMusic();
//        new StartCalculator();
//        new StartSlack();
//        new SendMessage("Slack");
    }

    private static class StartMusic {

        public StartMusic() throws AWTException {
            new StartBot("Groove Music", true, true);
        }
    }

    private static class StartCalculator {

        public StartCalculator() throws AWTException {
            new StartBot("Calculator", false, false);
        }
    }

    private static class StartSlack {

        public StartSlack() throws AWTException {
            new StartBot("Slack", false, false);
        }
    }

    private static class SendMessage {

        public SendMessage(String application) throws AWTException {
            if (application.equals("Slack")) {
                new SendSlackMessage("I am a bot sending you a message. I am awake", "Ruben");
            }
        }
    }

    private static class StartBot {

        public StartBot(String application, boolean minimized, boolean play) throws AWTException {
            new Search(application, minimized, play);
        }

    }

    private static class Search {

        public Search(String application, boolean minimized, boolean play) throws AWTException {
            robot = new Robot();
            BotCommand bot = new BotCommand();

            robot.setAutoWaitForIdle(true);
            robot.setAutoDelay(100);

            //Search in windows
            bot.type(KeyEvent.VK_WINDOWS);
            bot.type(application);

            //Open application
            bot.type(KeyEvent.VK_ENTER);

            //Play
            if (play) {
                bot.type(KeyEvent.VK_SPACE);
            }

            //Minimise
            if (minimized) {
                bot.doubleType(KeyEvent.VK_WINDOWS, KeyEvent.VK_DOWN);
            }

            robot.delay(4000);

        }

    }

    private static class SendSlackMessage {

        public SendSlackMessage(String message, String recipient) throws AWTException {
            robot = new Robot();
            BotCommand bot = new BotCommand();

            robot.setAutoWaitForIdle(true);
            robot.setAutoDelay(100);

            //Search recipient
            bot.doubleType(KeyEvent.VK_CONTROL, KeyEvent.VK_K);
            bot.type(recipient);
            bot.type(KeyEvent.VK_ENTER);

            //Send message
            bot.type(message);
            bot.type(KeyEvent.VK_ENTER);

        }
    }

    private static class BotCommand {

        public BotCommand() throws AWTException {
            robot = new Robot();
        }

        private void type(int i) {
            robot.delay(3000);
            robot.keyPress(i);
            robot.delay(250);
            robot.keyRelease(i);
        }

        private void type(String s) {
            byte[] bytes = s.getBytes();
            robot.delay(2000);
            for (byte b : bytes) {
                int code = b;
                if (code > 96 && code < 123) {
                    code = code - 32;
                }
                robot.delay(50);
                robot.keyPress(code);
                robot.keyRelease(code);
            }
        }

        //Example               Alt   +   F4
        private void doubleType(int i, int j) {
            robot.delay(2000);
            robot.keyPress(i);
            robot.delay(100);
            robot.keyPress(j);
            robot.delay(100);
            robot.keyRelease(j);
            robot.delay(100);
            robot.keyRelease(i);
        }

    }

}
