/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ruang
 */
public class Progress_Saver {

    private Connection conn;
    private String FILENAME = "";

    public static void main(String[] args) {
        new Progress_Saver().run();
    }

    private void run() {
        saveProgress(getSaveBar());
    }

    private Connection getConnection() {
        System.out.println("Getting connection....");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@163.197.231.86:1521:SIZWEN", "SIZWEN", "N30p4ss");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Got connection");
        return conn;
    }

    private void cleanup(Connection connection, PreparedStatement preparedStatement, ResultSet rs) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> getSaveBar() {
        System.out.println("Getting save bar....");
        List<String> result = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement("select  from  where sysdate between  and  and  order by 1");
            rs = ps.executeQuery();

            while (rs.next()) {
                result.add(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cleanup(conn, ps, rs);
        }
        System.out.println("Got save bar: " + result.size());
        return result;
    }

    private void saveProgress(List<String> list) {
        try {
            if (!createProgressFolder().trim().isEmpty()) {
//                for(String s : list){
                saveProgressToFolder(list);
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String createProgressFolder() {
        String result = "";

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH-mm-ss");
            File dir = new File("");
            dir.mkdir();
            FILENAME = dir + "\\progress_" + sdf.format(new Date()) + ".txt";
            result = "Created Progress folder: " + FILENAME;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private void saveProgressToFolder(List<String> data) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(FILENAME, true));
            for (String s : data) {
                bw.append(s);
                bw.newLine();
                System.out.println("Appended: " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                }
            }
        }
    }

}
