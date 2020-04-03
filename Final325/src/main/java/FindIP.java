
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
public class FindIP {
    
    public String findIP(){

    String ipaddr = "";

        try
        { 
            URL whatMyIP = new URL("http://bot.whatismyipaddress.com");   
            BufferedReader bigboi = new BufferedReader(new InputStreamReader(whatMyIP.openStream())); 
            ipaddr = bigboi.readLine().trim(); 
        } 
        catch (Exception e) 
        { 
            e.printStackTrace();
        }  
        
        return ipaddr;
    }
}
