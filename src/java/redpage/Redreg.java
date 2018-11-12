/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redpage;

import data.data;
import helper.Encryptor;
import html.feed;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Redreg {
    
    public static void handle(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String prod = request.getParameter("area");
        String comment = request.getParameter("comment");
        String[] list = request.getParameter("list").split(",");
        
        String lang = request.getLocale().getLanguage();
        
        String[] items = {};
        int[] prices = {};
        int est = 0;
        
        for (String list1 : list) 
        {
            int pr = getExtraPrice(list1);
            est = est + pr;
        }
    
        String price = Integer.toString(est)+" $";
        boolean OK = true;
        
        try
        {
        String pass = helper.RandomString.getString(7);
        Encryptor enc = new Encryptor();
        String enpass = enc.encrypt(pass);   
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        String tm = ts.toString();       
        String query = "insert into prod.ppl values('"+tm+"','"+email+"','"+name+"','','"+enpass+"','','','','','','','','"+tm+"')";
        String qr = "insert into prod.orders values('"+name+tm+"','"+prod+"','"+price+"','"+email+"','"
                +request.getParameter("list")+"','new','"+comment+"')";
        feed f = new feed();
        data d = new data(f.cop);
        data da = new data(f.cop);
        
        d.Execute(query);
        da.Execute(qr);
        
        }
        catch(Exception ex)
        {
            OK = false;
        }
        
        if(OK)
        {

            String welsub = getVal("redsubj",lang);
            String weltxt = getVal("redtext",lang);
            String ortxt = getVal("redname",lang)+", "+name+"!"+'\n'+getVal("redthank",lang)+'\n';
            
            
            
            
        }
        
    }
    
    static String getVal(String id,String lang)
    {
    String result = "";
    
            String start = "select descr from prod.fact where id='";
            String end = "' and lan='"+lang+"'";
            
            String query = start+id+end;
            data da = new data((new feed()).cop);
            try
            {
                result = da.pullString(query);
            }
            catch(Exception ex)
            {}
            
    return result;
    
    }
    
    static int getExtraPrice(String a)
{
    int result = 0;
    switch(a)
    {
        case "accept payments":
        {
            result = 150;
            break;
        }
        case "integration with external systems":
        {
            result = 100;
            break;
        }

        case "booking wizard":
        {
            result = 70;
            break;
        }
        case "content management system":
        {
            result = 100;
            break;
        }
        case "allow to rate your products":
        {
            result = 50;
            break;
        }
        case "add community forum":
        {
            result = 80;
            break;
        }
        case "customer reviews":
        {
            result = 50;
            break;
        }
        case "HR tools":
        {
            result = 70;
            break;
        }
        case "e-commerce application":
        {
            result = 250;
            break;
        }
        case "corporate web-site":
        {
            result = 200;
            break;
        }
         case "personal web-site":
        {
            result = 100;
            break;
        }
        case "custom made web application":
        {
            result = 100;
            break;
        }
        case "admin screen":
        {
            result = 50;
            break;
        }
        case "client base management tools":
        {
            result = 50;
            break;
        }
    }
    
    return result;
}
    

}
