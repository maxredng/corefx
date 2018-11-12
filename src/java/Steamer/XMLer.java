/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steamer;

import java.net.*;
import java.io.*;

public class XMLer {
    
    public static String getXML(String url)throws MalformedURLException
    {
        
        String result=null;
        URL path=new URL("http://steamcommunity.com/profiles/"+url+"/?xml=1");
        BufferedReader br;
        
        StringBuilder builder=new StringBuilder();
        try
        {
        br= new BufferedReader(new InputStreamReader(path.openStream()));
        
            String line;
           
           while((line=br.readLine())!=null)
           {
               builder.append(line);
           }       
        
        }catch(IOException ex)
        {
        System.out.print(ex.getMessage());
        }

        result=builder.toString();
        return result;
    }
    
    
}
