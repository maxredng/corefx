/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecrivus;

import data.data;
import helper.Localized;
import helper.MySimpleMail;
import helper.RandomString;
import html.feed;
import javax.servlet.http.HttpServletRequest;
 

/**
 *
 * @author Maxkarpov
 */
public class Reset {
    
    public static void handle(HttpServletRequest request)
    {
        String pass = "";
        try
        {
        pass = RandomString.getString(6);
        }
        catch(Exception ex)
        {}
        
        feed f = new feed();
        
        data dap = new data(f.cop);
        boolean OK = true;
        
        String qr = "update prod.ppl set pass='"+pass+"' where email='"+(String)request.getSession().getAttribute("user")+"'";
        try
        {
            dap.Execute(qr);
        
        }catch(Exception ex)
        {
        OK = false;
        
        }
        Localized los = new Localized(request,"pro","pasabj");
        Localized loc = new Localized(request,"pro","pachange");
        
        
        String sabj = los.value;
        String pachange = loc.value;
        
        MySimpleMail.sendTLS((String)request.getSession().getAttribute("user"), sabj, pachange+" "+pass);
        
        
    }
    
}
