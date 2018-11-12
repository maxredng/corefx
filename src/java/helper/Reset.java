/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.aaa;
import data.connection;
import data.data;
import html.feed;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bsati
 */
public class Reset {
    
    public static boolean locked(HttpServletRequest request)
    {
    
     boolean result = false;
     String str = request.getParameter("selected");
     String ema = request.getParameter("email");
     String qry = "select app from prod.ppl where app='" + str + "' and email='" + ema + "'";
     feed f = new feed();
     data da = new data(f.cop);
     String ev = request.getParameter("event");
     switch(ev)
     {
         case "doreset":
         {
     try
     {
         String ap = da.pullString(qry);
         
         if(!common.Com.isThing(ap))
         {
             result = true;
            
             lock(ema);
         }
         
       
         
         
     }catch(Exception x)
     {
         System.out.print(x.getMessage());
     
     }         
         
         break;
         }
         case "reset":
         {
         
             if(locked(str))
             {
                 result = true;
             }
         
         
         break;
         }
     
     }

     return result;
    }
    
       static boolean locked(String us)
   {
       boolean result = false;
        
       
        String query = "select email from prod.locked where email='"+us+"'";
        connection cn = new connection(MyDB.Schema.schema.prod);
        data d = new data(cn);
        
        try
        {
            String mail = d.pullString(query);
            if(mail!=null)
            {
                if(!mail.isEmpty())
                {
                    result = true;
                }
            }
        }
        catch(Exception x)
        {}
   
       
       return result;
   }
    
       static void lock(String us)
   {
       String query = "select failed from prod.fail where email='" + us + "'";
       
        connection cn = new connection(MyDB.Schema.schema.prod);
        data d = new data(cn);
        
        try
        {
            int fail = d.pullInt(query);
            int newf = 0;
            String neq = "";
            if(fail>-1)
            {
                newf = fail+1;
                neq = "update prod.fail set failed=" + newf + " where email = '" + us + "'";
            }else
            {
                newf = 0;
                neq = "insert into prod.fail values('" + us + "'," + newf + ")";
            }
            
            d.Execute(neq);
            
            if(newf>3)
            {
                String loq = "insert into prod.locked values('" + us + "')";
                d.Execute(loq);
            }
        
        }catch(Exception x)
        {
            System.out.print(x.getMessage());
        }
   
   }
}
