/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ruang
 */
public class URLConnection {

    private static final String USER_AGENT = "Java Client; Windows 10";//Mozilla/5.0

    private static final String GET_URL = "https://google.com";//"https://localhost:9494/ManagedCare";

    private static final String POST_URL = "https://google.com";//"https://localhost:9494/ManagedCare/index.jsp";https://twitter.com/sessions

    private static final String POST_PARAMS = "?username=what&password=123";//"userName=superu";

    public static void main(String[] args) throws IOException {
//        testConnection(GET_URL, "Google.html");
//        System.setProperty("https.protocols", "TLSv1");//TLSv1,TLSv1.1,TLSv1.2
//        System.out.println("property: " + System.getProperty("https.protocols"));
        sendGET();
        System.out.println("------------------->GET DONE\n");
//        sendPOST();
//        System.out.println("------------------->POST DONE");
    }

    private static void sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        System.out.println("getting connection");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        System.out.println("got connection");
        con.setRequestMethod("GET");
        System.out.println("set get method");
        con.setRequestProperty("User-Agent", USER_AGENT);
        System.out.println("set user agent");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code : " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println("Response: " + response.toString());
        } else {
            System.out.println("GET request not worked");
            System.out.println("GET Response Message : " + con.getResponseMessage());
        }

    }

    private static void sendPOST() throws IOException {
        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        System.out.println("got connection");
        con.setRequestMethod("POST");
        System.out.println("set post");
        con.setRequestProperty("User-Agent", USER_AGENT);
        System.out.println("set user-agent");

        // For POST only - START
        con.setDoOutput(true);
        System.out.println("set do output");
        OutputStream os = con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        System.out.println("output done");
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
            System.out.println("POST Response Message :: " + con.getResponseMessage());
        }
    }

    private static void testConnection(String url, String filePath) {
//        String url = "https://google.com";
//        String filePath = "Google.html";

        try {
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestProperty("User-Agent", "Java Client; Windows 10");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("Accept-Language", "en-US");
            conn.setRequestProperty("Connection", "close");
//            conn.setRequestMethod("HEAD");
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            
//            String parameters = "username=" + email;
//            parameters += "password=" + password;
            
//            OutputStreamWriter outWriter = new OutputStreamWriter(conn.getOutputStream());
//            outWriter.write(parameters);
//            outWriter.flush();

            Map<String, List<String>> map = conn.getHeaderFields();

            System.out.println("--------------------------------key values");
            for (String key : map.keySet()) {
                System.out.println("key: " + key + ": ");
                List<String> values = map.get(key);

                for (String aValue : values) {
                    System.out.println("value: " + aValue);
                }
            }
            System.out.println("");

            int responseCode = conn.getResponseCode();
            String responseMessage = conn.getResponseMessage();
            String contentType = conn.getContentType();
            String contentEncoding = conn.getContentEncoding();
            int contentLength = conn.getContentLength();
            long date = conn.getDate();
            long expiration = conn.getExpiration();
            long lastModified = conn.getLastModified();

            System.out.println("--------------------------------headers");
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Message: " + responseMessage);
            System.out.println("Content Type: " + contentType);
            System.out.println("Content Encoding: " + contentEncoding);
            System.out.println("Content Length: " + contentLength);
            System.out.println("Date: " + new Date(date));
            System.out.println("Expiration: " + new Date(expiration));
            System.out.println("Last Modified: " + new Date(lastModified));
            System.out.println("");

            System.out.println("--------------------------------code");
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Server returned response code " + responseCode + ". Download failed.");
                System.exit(0);
            } else {
                System.out.println("HTTP_OK");
            }
            System.out.println("");

            InputStream input = conn.getInputStream();
            BufferedInputStream reader = new BufferedInputStream(input);
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filePath));

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);
            }

            writer.close();
            reader.close();

            System.out.println("--------------------------------");
            System.out.println("Web page saved");
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
