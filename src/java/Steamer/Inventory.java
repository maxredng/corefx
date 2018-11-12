/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steamer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.*;

public class Inventory{
   public JSONObject ob; 
   String ID;
   String App;
   String Type;
    public Inventory(String id, String app, String type)throws Exception
    {
       ID=id;
       App=app;
       Type=type;
       populate();
    }
    
    
    final void populate()throws Exception
    {
    try
    {
        String start="http://steamcommunity.com/profiles/";
        String end="/inventory/json/"+App+"/"+Type+"/";
        String path=start+ID+end;
    
        URL url=new URL(path);
        InputStream is=url.openStream();
        try
        {
            BufferedReader reader=new BufferedReader(new InputStreamReader(is,Charset.forName("UTF-8")));
            StringBuilder builder=new StringBuilder();
            
            int count;
            
            while((count=reader.read())>-1)
            {
            builder.append((char) count);

            }
            
            String str=builder.toString();
            
            ob=new JSONObject(str);
            
            
            
        }finally
        {
            is.close();
        }
        
    }catch(JSONException ex)
    {}
    }
}

  