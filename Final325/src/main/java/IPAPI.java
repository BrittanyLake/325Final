import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Crippled Horse
 */

public class IPAPI {
    
    public String IPAPI(String ipaddr, String info){
           
        String ipapiURL = "https://ipapi.co/" + ipaddr + "/" + info + "/";
        String outInfo = "";
        
        try{

            URL ipapi = new URL(ipapiURL);

            URLConnection conn = ipapi.openConnection();
            conn.setRequestProperty("User-Agent", "java-ipapi-client");

            BufferedReader bigboi = new BufferedReader(new InputStreamReader(conn.getInputStream()));        
            outInfo = bigboi.readLine();
            bigboi.close();

            //System.out.println(outInfo);
        }
        catch (Exception e) 
        { 
            e.printStackTrace();
        }
        return outInfo;
    }
    
}
