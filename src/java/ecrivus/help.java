/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecrivus;

import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class help {
    
    public static String getURL(HttpServletRequest request)
    {
        String result = null;
    
                    StringBuffer requestURL = request.getRequestURL();
        
         String queryString = request.getQueryString();
         String rl = "";
             if (queryString == null) {
        rl = requestURL.toString();
    } else {
        rl = requestURL.append('?').append(queryString).toString();
    }
             result = rl;
        
        return result;
    }
    
    public static String getPassword()
    {
    
        String result = "Dome123";
                
                try
                {
                    result = helper.RandomString.getString(6);
                }
                catch(Exception x)
                {}
        return result;
    }
    
    public static String getStamp()
    {
        String result = "";
            Date date=new Date();

            Timestamp ts=new Timestamp(date.getTime());

            String stamp=ts.toString();     
            result = stamp;
                     
        return result;
    
    }
}
