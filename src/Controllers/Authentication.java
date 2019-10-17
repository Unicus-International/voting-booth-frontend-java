/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karlw
 */
public class Authentication {

    URL baseURl;
    URLConnection connection;

    public Authentication() {
        try {
            // "http://192.168.210.170:8181"
            baseURl = new URL("http", "192.168.210.170", 8181, "");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(String email, String password) throws MalformedURLException, IOException {
        String rawData = String.format("email=%s&password=%s", email, password);
        String encodedData = URLEncoder.encode(rawData, "ASCII");
        URL loginurl = new URL(baseURl, "user/login");
        String contentType = "application/x-www-form-urlencoded";

        HttpURLConnection conn = (HttpURLConnection) loginurl.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", contentType);
        conn.setRequestProperty("Content-Length",
        String.valueOf(encodedData.length()));
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(encodedData.getBytes());
        int response = conn.getResponseCode();

        if (response == HttpURLConnection.HTTP_NO_CONTENT) {
            //  204: Login successful
        } else if (response == HttpURLConnection.HTTP_FORBIDDEN) {
            // 403: Wrong password
        }

        return true;

        /*
            request parameters:
              name: string
              email_address: string
              password_one: string
              password_two: string

            reply status:
              201: Registration successful
              400: Invalid request
              403: User already exists

            reply body:
              none except:
                400: application/json: { "error": <reason> }
         */
    }

    public boolean register(String email, String password1, String password2) {
        String rawData = String.format("name=%s&password", name);
        URL loginurl = new URL(baseURl, "user/register");

        return false;
    }

    public void jButton2ActionPerformed(ActionEvent evt) throws MalformedURLException {
        login("", "");
    }

}
