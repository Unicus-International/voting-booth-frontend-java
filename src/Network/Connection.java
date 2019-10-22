/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Controllers.AuthenticationController;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karlw
 */
public class Connection {
    
    URL baseURl;
    URLConnection connection;
    String subUrl;

    public Connection() {
        try {
            // "http://192.168.210.170:8181"
            baseURl = new URL("http", "192.168.210.170", 8181, "");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(String email, String password) throws MalformedURLException, IOException {
        subUrl = "user/login";
        String rawData = String.format("email_address=%s&password=%s", email, password);
        
        int response = send(rawData);
        
        if (response == HttpURLConnection.HTTP_NO_CONTENT) {
            //  204: Login successful
            
            return true;
        } else if (response == HttpURLConnection.HTTP_FORBIDDEN) {
            // 403: Wrong password
            return false;
        }
        return false;
    }
    
    public boolean register(String email, String password1, String password2) throws IOException {
        subUrl = "user/register";
        String rawData = String.format("email=%s&password=%s", email, password1);
        
        send(rawData);
 
        return false;
    }
    
    private int send(String rawData) throws ProtocolException, MalformedURLException, UnsupportedEncodingException, IOException {
        String encodedData = URLEncoder.encode(rawData, "ASCII");
        URL loginurl = new URL(baseURl, subUrl);
        String contentType = "application/x-www-form-urlencoded";
        HttpURLConnection conn = (HttpURLConnection) loginurl.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", contentType);
        conn.setRequestProperty("Content-Length", String.valueOf(rawData.length()));
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(rawData.getBytes());
        int response = conn.getResponseCode();
        return response;
    }


    
}
