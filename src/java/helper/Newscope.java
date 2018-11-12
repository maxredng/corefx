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
 * @author Maxkarpov
 */
public class Newscope {
    
    public static void handle(HttpServletRequest request)
    {        
        feed f = new feed();
        
        data da = new data(f.cof);
        String scope = request.getParameter("newscope");
        String proscope = request.getParameter("proscope");
        String newscope = request.getParameter("newscope");
        if(common.Com.isThing(scope))
        {
        
                int ord = helper.Help.getId("scopes");
        
        String qr = "insert into config.list values('"+scope+"','scopes',"+Integer.toString(ord)+")";
        
        try
        {
            da.Execute(qr);
            helper.Help.cleanCache("board");
        
        }catch(Exception ex)
        {
        }
        }else
        {
        
        if(common.Com.isThing(proscope))
        {
            String pro = request.getParameter("project");
            String user = request.getSession().getAttribute("user").toString();
            String qr = "insert into config.project values('"+pro+"','"+proscope+"','"+user+"')";
            try
            {
            da.Execute(qr);
            helper.Help.cleanCache("newboard");
            }
            catch(Exception ex)
            {
                
            }
        
        }else
        {
            String pro = request.getParameter("newproject");
            String user = request.getSession().getAttribute("user").toString();
            String qr = "insert into config.project values('"+pro+"','','"+user+"')";
            try
            {
            da.Execute(qr);
            helper.Help.cleanCache("projects");
            }
            catch(Exception ex)
            {
                
            }  
        
        }
        
        }


        
    }
    
}
