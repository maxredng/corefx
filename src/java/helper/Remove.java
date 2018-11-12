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
public class Remove {
    
    public static void handle(HttpServletRequest request)
    { 
        String remove = request.getParameter("remove");
        
        String qur = "delete from config.list where title='"+remove+"' and isel='scopes'";
        
        feed f = new feed();
        
        data da = new data(f.cof);
        
        try
        {
        da.Execute(qur);
        }catch(Exception ex)
        {
        }
    }
    
}
