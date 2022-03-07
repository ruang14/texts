/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author ruang
 */
public class altcodes {

    static Robot robot;
    static final String DIR = System.getProperty("user.dir");
    static final String FILEPATH = "robottest.txt";

    public static void main(String[] args) throws AWTException, IOException {
        woke();
        new StartBot();
    }

    private static void woke() throws AWTException{
        robot = new Robot();
        //windows run
        while (true) {
            robot.delay(2000);
            robot.keyPress(KeyEvent.VK_E);
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.delay(250);
//            robot.keyRelease(KeyEvent.VK_R);
//            robot.delay(250);
//            robot.keyRelease(KeyEvent.VK_WINDOWS);
            robot.delay(1000);
        }

    }

    private static class StartBot {

        public StartBot() throws AWTException {
            System.out.print("Please be patient while the bot is loading");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.print(".");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.print(".");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println("\nWARNING: Avoid using the keyboard or mouse while the bot is active");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }
            System.out.println("If you need to force the bot to stop, click here and click on stop");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }
            System.out.println("Please close all documents the bot used after it is done");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }
            new CreateTestFolder();
            new FindFolder();
            new JavaRobot();
        }
    }

    private static class CreateTestFolder {

        public CreateTestFolder() {
            System.out.println("Creating the test folder...");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }
            Writer writer = null;
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILEPATH), "utf-8"));
                System.out.println("Test folder created");
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                try {
                    writer.close();
                } catch (Exception e) {
                }
            }
        }

    }

    private static class FindFolder {

        public FindFolder() throws AWTException {
            System.out.println("Finding the test folder...");
            try {
                Thread.sleep(3500);
            } catch (Exception e) {
            }

            robot = new Robot();
            RobotCommands bot = new RobotCommands();

            //copy Directory to clipboard
            try {
                StringSelection selection = new StringSelection(DIR);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("Test folder found");
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
            }

            System.out.println("Activating bot...");
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
            }

            System.out.println("Bot activated, please avoid using the keyboard and mouse while the bot is active");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

            //windows run
            robot.delay(2000);
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_R);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_R);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            robot.delay(1000);

            //go to Folder        
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);

            //search for file
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_F);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_F);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1000);

            //open RobotTest.txt
            bot.type(FILEPATH);
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_SPACE);
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(2000);
        }
    }

    private static class JavaRobot {

        public JavaRobot() throws AWTException {
            robot = new Robot();
            RobotCommands bot = new RobotCommands();
            int[] numpadKeys = {KeyEvent.VK_NUMPAD0,
                KeyEvent.VK_NUMPAD1,
                KeyEvent.VK_NUMPAD2,
                KeyEvent.VK_NUMPAD3,
                KeyEvent.VK_NUMPAD4,
                KeyEvent.VK_NUMPAD5,
                KeyEvent.VK_NUMPAD6,
                KeyEvent.VK_NUMPAD7,
                KeyEvent.VK_NUMPAD8,
                KeyEvent.VK_NUMPAD9};

            robot.setAutoDelay(40);
            robot.setAutoWaitForIdle(true);

            robot.delay(3000);
//            robot.mouseMove(150, 250);
            robot.delay(50);

//            bot.leftClick();
            robot.delay(50);
            bot.type("hello user\n");

            robot.delay(500);
            bot.type("i am a bot\n");

            robot.delay(500);
            bot.type("please allow  me to borrow your computer for a bit\n");

            robot.delay(500);
            bot.type("i am programmed to write all the alt codes...\n\n");
            robot.delay(1000);

            int oneCode = 0;
            int ones = 0;
            int tenCode = 0;
            int tens = 0;
            int hundredCode = 0;
            int hundreds = 0;

            for (int i = 0; i <= 255; i++) {
                robot.delay(250);
                bot.type("Alt " + i + " ");
                robot.delay(150);

                if (tens < 1 && hundreds < 1) {
                    if (ones > 9) {
                        tens++;
                        ones = 0;
                    } else {
                        oneCode = numpadKeys[ones];
                        bot.typeAltOnes(oneCode);
                        ones++;
                    }
                }

                if (hundreds < 1 && tens >= 1) {
                    if (tens > 9) {
                        hundreds++;
                        tens = 0;
                    } else {
                        oneCode = numpadKeys[ones];
                        tenCode = numpadKeys[tens];
                        bot.typeAltTens(tenCode, oneCode);

                        if (ones == 9) {
                            tens++;
                            ones = 0;
                        } else {
                            ones++;
                        }
                    }
                }

                if (hundreds >= 1) {
                    if (tens > 9) {
                        hundreds++;
                        tens = 0;
                        ones = 0;
                    }

                    oneCode = numpadKeys[ones];
                    tenCode = numpadKeys[tens];
                    hundredCode = numpadKeys[hundreds];
                    bot.typeAltHundreds(hundredCode, tenCode, oneCode);

                    if (ones == 9) {
                        tens++;
                        ones = 0;
                    } else {
                        ones++;
                    }
                }

                robot.delay(150);

                bot.type(KeyEvent.VK_ENTER);
            }

            robot.delay(3000);
            bot.type("\nThat is all i am programmed to do...");

            robot.delay(1000);
            bot.type("\nyou can take over from here");

            robot.delay(500);
            bot.type("\nbye bye");

            System.out.println("Deactivating bot...");
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
            }

            System.out.println("Bot deactivated");

            System.exit(0);
        }
    }

    private static class RobotCommands {

        private void leftClick() throws AWTException {
            robot = new Robot();

            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(200);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.delay(200);
        }

        private void type(int i) throws AWTException {
            robot = new Robot();

            robot.delay(40);
            robot.keyPress(i);
            robot.keyRelease(i);
        }

        private void type(String s) throws AWTException {
            robot = new Robot();
            byte[] bytes = s.getBytes();

            for (byte b : bytes) {
                int code = b;
                if (code > 96 && code < 123) {
                    code = code - 32;
                }

                robot.delay(40);
                robot.keyPress(code);
                robot.keyRelease(code);
            }
        }

        private void typeAltOnes(int i) throws AWTException {
            robot = new Robot();

            robot.delay(40);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(i);
            robot.keyRelease(i);
            robot.keyRelease(KeyEvent.VK_ALT);
        }

        private void typeAltTens(int i, int j) throws AWTException {
            robot = new Robot();

            robot.delay(40);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(i);
            robot.keyRelease(i);
            robot.keyPress(j);
            robot.keyRelease(j);
            robot.keyRelease(KeyEvent.VK_ALT);
        }

        private void typeAltHundreds(int i, int j, int k) throws AWTException {
            robot = new Robot();

            robot.delay(40);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(i);
            robot.keyRelease(i);
            robot.keyPress(j);
            robot.keyRelease(j);
            robot.keyPress(k);
            robot.keyRelease(k);
            robot.keyRelease(KeyEvent.VK_ALT);
        }

    }

}
