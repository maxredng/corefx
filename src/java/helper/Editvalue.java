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
public class Editvalue {
    
    public static void handle(HttpServletRequest request)
    {
        String name = request.getParameter("selected");
        String position = request.getParameter("position");
        String value = request.getParameter("editvalue");
        String scope = request.getParameter("area");
        String editattribute = request.getParameter("editattribute");
        String isl = request.getParameter("isl");
        String[] real = {"name","row","col","element","value","parent","scope","type","isel","block"};
        
        
        
        String query = "update config.col set "+position+"='"+value+"' where name='"+name+"' and scope='"+scope+"'";
           boolean OK = true;
     
        if(!common.Com.contains(real, position)||common.Com.isThing(editattribute))
        {
        query = "update config.col set value='"+value+"', isel='"+isl+"' where name='"+position+"' and parent='"+name+"' and scope='"+scope+"'";
        OK = false;
        }   
        
        
        
        feed f = new feed();
   
        data da = new data(f.cof);
        
        try
        {
        
        da.Execute(query);
        
        }
        catch(Exception ex)
        {
        OK = false;
        }
        
        if(position.equals("name")&&OK)
        {
            data dat = new data(f.cof);
            
            try
            {
            String q = "update config.col set parent='"+value+"' where parent='"+name+"'";
            dat.Execute(q);
            }catch(Exception nex)
                    {}
        
        }
        
        
    }
    
}
