
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Crippled Horse
 */
public class YanTranslateApi {
        
        String lang;
        String text;
        Translation trans = new Translation();
                
        public Translation RunTranslate(String inLang, String inText){
            String lang = inLang;
            String text = inText;
            
            //replaces all spaces in the text to be translated with ascii code for space        
            String newText = text.replaceAll(" ", "%20");
            
            String key = "trnsl.1.1.20200402T210544Z.9bfa55a6085e71c3.248262f5f422366fbe3bf947d43fa670ecc70554";        
            
            int contentLength = text.length();
            String contentType = "application/x-www-form-urlencoded";
            
        
        try{
            String urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?lang=" + lang + "&key=" 
                    + key + "&text=" + newText;
            
            URL url = new URL(urlString);            
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);            
            conn.setRequestMethod("POST");           
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Content-Length", Integer.toString(contentLength));
            conn.setRequestProperty("Content-Type", contentType);
            
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            
            System.out.println("Response Code: " + conn.getResponseCode());
            System.out.println("Response Message: " + conn.getResponseMessage());
            
            InputStream in = conn.getInputStream();
            BufferedReader bigboi = new BufferedReader(new InputStreamReader(in));
            
            StringBuilder response = new StringBuilder();
            String responseSingle = null;
            while((responseSingle = bigboi.readLine()) != null){
                response.append(responseSingle);
            }
            String poop = response.toString();
            //System.out.println(poop);
            
            out.close();
            
            Gson g = new Gson();
            trans = g.fromJson(poop, Translation.class);
            //System.out.println(trans.text.toString());
                   
        }
        catch(Exception exc1){
            exc1.printStackTrace();
        }
           
        return trans;
        }    
            
            
}

