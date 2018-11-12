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
public class Atkey {
    
    public static void handle(HttpServletRequest request)
    {
        String parent = request.getParameter("parent");
        String scope = request.getParameter("area");
        String key = request.getParameter("atkey");
        String val = request.getParameter("atval");
        String isl = request.getParameter("isl");
        String query = "select max(row) from config.col where parent='"+parent+"' and scope='"+scope+"' and block='n'";
        
        feed f = new feed();
        data dar = new data(f.cof);
        data dae = new data(f.cof);
        int max = 0;
        String st = "";
        try
        {
        st = dar.pullString(query);
        }
        catch(Exception ex)
        {}
        try
        {
        max = max + Integer.parseInt(st);
        }
        catch(Exception hex)
        {
        max = 0;
        }        
        
        String smax = Integer.toString(max);
        
        String qr = "insert into config.col values('"+smax+"','0','0','"+key+"','"+val+"','"+parent+"','"+scope+"','0','"+isl+"','n',"
        +null+")";
        
        try
        {
        dae.Execute(qr);
        
        }catch(Exception wex)
        {}
    }
    
}
