/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecrivus;

import data.data;
import html.feed;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Publish {
    
    public static void handle(HttpServletRequest request)
    {
        String voiceid = request.getParameter("voiceid");
        
        String qr = "update prod.voice set summary='PUBLISHED' where voiceid='"+voiceid+"'";
        String cl = "delete from config.store where sign like '%scopeequalsactor%'";
        
        feed f = new feed();
        
        data dap = new data(f.cop);
        data dac = new data(f.cof);
        
        try
        {
            dap.Execute(qr);
            dac.Execute(cl);
        }
        catch(Exception ex)
        {
        
        }
        
    
    }
    
}
