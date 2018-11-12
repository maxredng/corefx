/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import html.tag;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Temp {
    
    public static void handle(HttpServletRequest request)
    {

        String select = request.getParameter("selected");
        String scope = request.getParameter("area");
        String name = request.getParameter("name");
        
        String qr = "update config.col set num='template:"+name+"' where name='"+select+"' and scope='template'";
        
        feed f = new feed();
        
        data d = new data(f.cof);
        
        try
        {
            d.Execute(qr);
            
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            
            d.Execute("insert into config.delta values('"+qr.replace("'", "\'")+",'"+timestamp.toString()+"')");
        
        }catch(Exception x)
        {}
                
        tag tg = new tag(select,scope,new feed(),true);
        String tmp = request.getParameter("temp");
 
        tg.populateTag();
        tg.SaveTag("template", false);    

    }
    
}
