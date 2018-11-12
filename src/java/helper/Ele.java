/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author maxkarpov
 */
public class Ele {
    
    public static void handle(HttpServletRequest re)
    {
        feed f = new feed();
        String id = re.getParameter("ele");
        String vl = re.getParameter("val");
        String sc = re.getParameter("area");
        String lan = re.getLocale().getLanguage();
        String qr = "select value from prod.local where id='"+id+"' and lan='"+lan+"' and scope='"+sc+"'";
        String query = "update prod.local set value='"+vl+"' where id='"+id+"' and lan='"+lan+"' and scope='"+sc+"'";
        data d = new data(f.cop);
       
        String value = "";
        try
        {
            value = d.pullString(qr);
            if(!common.Com.isThing(value))
            {
                query = "insert into prod.local values('"+id+"','"+vl+"','"+sc+"','"+lan+"','')";
            }
        
            
        }
        catch(Exception ex)
        {}
        
        data dat = new data(f.cop);
        
        try
        {
            dat.Execute(query);
        
        }catch(Exception mex)
        {}
        
    }
    
}
