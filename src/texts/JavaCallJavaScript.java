/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author ruang
 */
public class JavaCallJavaScript {

    static final String DIR = System.getProperty("user.dir");
    static final String FILENAME = "JavascriptScript.js";

    public static void main(String[] args) {
//        CallLocalJavascript();
        CallFileJavascript();
    }

    public static void CallLocalJavascript() {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");

            String script1 = (String) "var name = 'Ruan';"
                    + "function hello(name) {"
                    + "    print ('Hello ' + name + '!');"
                    + "}"
                    + "hello(name);";

            String script2 = (String) "var a = 7;"
                    + "var b = 7;"
                    + "function getValue(a,b) {"
                    + "    if (a == b) {"
                    + "        print(a + ' equals ' + b);"
                    + "    } else {"
                    + "        print(a + ' not equals ' + b);"
                    + "    }"
                    + "}"
                    + "getValue(a, b);";

            String script3 = (String) "var idNo = \"2007045095085\";"
                    + "print(idNo.substring(0, 2));"
                    + "print(idNo.substring(2, 4));"
                    + "print(idNo.substring(4, 6));"
                    + "print('Month = ' + new Date().getMonth() + 1);"
                    + "print('Day = ' + new Date().getDate());"
                    + "if (idNo.substring(0, 2) <= (new Date().getFullYear() % 100)) {"
                    + "    if (idNo.substring(2, 4) < (new Date().getMonth() + 1)) {"
                    + "        print('true1');"
                    + "    } else if (idNo.substring(2, 4) == (new Date().getMonth() + 1)) {"
                    + "        if (idNo.substring(4, 6) <= (new Date().getDate())) {"
                    + "            print('true2');"
                    + "        } else {"
                    + "            print('false1');"
                    + "        }"
                    + "    } else {"
                    + "        print('false2');"
                    + "    }"
                    + "} else {"
                    + "    print('false3');"
                    + "}"
                    + "if (idNo.substring(0, 2) <= (new Date().getFullYear() % 100)) {"
                    + "    print('1');"
                    + "}"
                    + "if (idNo.substring(2, 4) <= (new Date().getMonth() + 1)) {"
                    + "    print('2');"
                    + "}"
                    + "if (idNo.substring(4, 6) <= (new Date().getDate())) {"
                    + "    print('3');"
                    + "}";

//            engine.eval(script1);
            engine.eval(script2);
//            engine.eval(script3);
            Invocable inv = (Invocable) engine;

//            inv.invokeFunction("hello", "World");
//            inv.invokeFunction("getValue", "Number", "Number");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void CallFileJavascript() {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            FileInputStream fileInputStream = new FileInputStream(DIR + "\\src\\JavascriptScripts\\" + FILENAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

            engine.eval(reader);
            Invocable invocableEngine = (Invocable) engine;

            invocableEngine.invokeFunction("test");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
