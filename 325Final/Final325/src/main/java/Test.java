
import com.google.gson.Gson;
import java.io.*;
import java.net.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Crippled Horse
 */
public class Test {
    
    public static void main(String [] args){
        String key = "trnsl.1.1.20200402T210544Z.9bfa55a6085e71c3.248262f5f422366fbe3bf947d43fa670ecc70554";
        String header = "/api/v1.5/tr.json/translate?lang=en-ru&key=API-KEY HTTP/1.1";
        String lang = "en-fr";
        String text = "translate";
        int contentLength = text.length();
        String contentType = "application/x-www-form-urlencoded";
        //String Post = "/api/v1.5/tr.json/translate?" + 
        
        try{
            String urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?lang=" + lang + "&key=" 
                    + key + "&text=" + text;
            
            URL url = new URL(urlString);            
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);            
            conn.setRequestMethod("POST");           
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Content-Length", Integer.toString(contentLength));
            conn.setRequestProperty("Content-Type", contentType);
            
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            
            System.out.println(conn.getResponseCode());
            System.out.println(conn.getResponseMessage());
            
            InputStream in = conn.getInputStream();
            BufferedReader bigboi = new BufferedReader(new InputStreamReader(in));
            
            StringBuilder response = new StringBuilder();
            String responseSingle = null;
            while((responseSingle = bigboi.readLine()) != null){
                response.append(responseSingle);
            }
            String poop = response.toString();
            System.out.println(poop);
            
            out.close();
            
            Gson g = new Gson();
            Translation trans = g.fromJson(poop, Translation.class);
            
            String gay = "gay";
            
            
                       
        
       
        }
        catch(Exception exc1){
            exc1.printStackTrace();
        }
    }    
    
}
