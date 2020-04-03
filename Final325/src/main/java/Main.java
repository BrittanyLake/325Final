/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Crippled Horse
 */
public class Main {
    
    public static void main(String [] args){
        
        /* DO NOT RUN THESE FUNCTIONS THROUGH A LOOP!!!! 
        They connect to external services and may blacklist your ip or mac address if 
        they receive too many requests*/
        
        FindIP ipFinder = new FindIP();        
        String ipAddress =  ipFinder.findIP();
        
        System.out.println("My IP: " + ipAddress);
        
        
        IPAPI ipInfoFinder = new IPAPI();   
        String languages = ipInfoFinder.IPAPI(ipAddress, "languages");
        String country = ipInfoFinder.IPAPI(ipAddress, "country");
        /* a list of more retrievable information, including timezone.. region.. etc can be found at
        https://ipapi.co/api/#complete-location */        
        
        System.out.println("Languages: " + languages);
        System.out.println("Country: " + country);

        
        /* a list of support languages and language codes for yandix can be found at 
        https://tech.yandex.com/translate/doc/dg/concepts/api-overview-docpage/ 
        list of error codes and more for yandix can be found at 
        https://tech.yandex.com/translate/doc/dg/reference/translate-docpage/ */
        
        String language = "en-fr";
        String text = "very nice text to be translated";                
        
        YanTranslateApi translate = new YanTranslateApi();
        Translation trans = new Translation();
        trans = translate.RunTranslate(language, text);
        System.out.println("Translation: " + trans.text.toString());
        
    }
    
}
