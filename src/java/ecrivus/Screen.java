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
public class Screen {
    
    public static void handle(HttpServletRequest request)
    {
    
        String voiceid = request.getParameter("voiceid");
        String screen = request.getParameter("screen");
        String qr = "select id from prod.map where id='"+voiceid+"'";
        String qur = "insert into prod.map values('"+voiceid+"','"+screen+"')";
        String qup = "update prod.map set value='"+screen+"' where id='"+voiceid+"'";
        feed f = new feed();
        
        data darp = new data(f.cop);
        data dap = new data(f.cop);
        data dau = new data(f.cop);
        
        try
        {
            String id = darp.pullString(qr);
            
            if(common.Com.isThing(id))
            {
                dap.Execute(qup);
            }else
            {
                dap.Execute(qur);
            }
        
        }
        catch(Exception ex)
        {}
    
    }
    
    
}
