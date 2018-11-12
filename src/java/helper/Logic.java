/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import helper.props.Prop;
import html.feed;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Logic {
    
        public static String handle(HttpServletRequest request,String cs)
    {
        String result = "";
        
        String event = cs;
        List<String[]> children = new ArrayList<>();
        List<String[]> emails = new ArrayList<>();
            
         
                String us = request.getParameter("agent");
                String pr = request.getParameter("project");
                String ln = (String)request.getSession().getAttribute("language");
                        

                
                feed f = new feed();
                data da = new data(f.cop);
                data dao = new data(f.cop);
                data dal = new data(f.cof);
                if(!common.Com.isThing(us))
                {
                        if(cs.equals("reset")||cs.equals("doreset")||cs.equals("cleanup"))
                        {
                            us = "admin";
                        }
                
                }

           
                    
                try
                {
                  Event reg = new Event(event,us,pr);
                String ev = reg.fields.get(0).table;
                InsertQuery iq = new InsertQuery(ev,reg.fields,request);                    
                    
                    if(!iq.query.contains("values('',''"))
                    {
                    da.Execute(iq.query);
                    }
                    
                    
                    
                    children = dal.pullTable("select * from config.cms where type='event' and parent='"+event+"' and user='"+us+"' and project='"+pr+"'", 3);
                
                }
                catch(Exception ex)
                {
                    result = "error";
                    
                }        
                
                for(int i = 0; i<children.size(); i++)
                {
                    Logic.handle(request, children.get(i)[0]);
                    String vnt = children.get(i)[0];
                    Switch.handle(request, vnt);
                
                }

    
                try
                {
                emails = dao.pullTable("select * from config.email where project='"+pr+"' and user='"+us+"' and event='"+event+"' and lan='"+ln+"'", 19);
                }catch(Exception mex)
                {}
        
                for(int k = 0; k<emails.size(); k++)
                {
                    //(String emailid, String project, String user, String event,String lan, HttpServletRequest request)
                    Email.handle(emails.get(k)[0], pr, us, event, ln, request);
                
                }
               String add = request.getParameter("addfunc");
       
       if(add!=null)
       {

           try
           {
             //  Prop prop = new Prop();
               Class<?> prp = Class.forName("helper.props." + add);
               Prop p = (Prop)prp.newInstance();
               p.populate(request);
               p.doStuff();
                
           }catch(Exception x)
           {
           System.out.print(x);
           }
                                 try
           {
             //  String dr = System.getProperty("user.dir");
                Class.forName("com.corefx.helper.props." + add);
                
           }catch(Exception x)
           {
           System.out.print(x);
           }
       } 
        return result;
    }
    
    public static String handle(HttpServletRequest request)
    {
        String result = "";
        
        String event = request.getParameter("case");
        List<String[]> children = new ArrayList<>();
        
            
        
                String us = request.getParameter("agent");
                String pr = request.getParameter("project");
                 
                Event reg = new Event(event,us,pr);
                
                InsertQuery iq = new InsertQuery("ppl",reg.fields,request);
                
                feed f = new feed();
                data da = new data(f.cop);
                data dao = new data(f.cop);
                data dal = new data(f.cop);
                
                
                try
                {
                    result = da.Execute(iq.query);
                    
                    children = dal.pullTable("select * from config.cms where type='event' and parent='"+event+"'", 3);
                
                }
                catch(Exception ex)
                {
                    result = "error";
                    
                }        
                
                for(int i = 0; i<children.size(); i++)
                {
                    
                
                }
        
       String add = request.getParameter("addfunc");
       
       if(!add.isEmpty())
       {
           try
           {
                Class.forName("corefx.helper.props." + add);
                
           }catch(Exception x)
           {}
           
       
       }
        
        return result;
    }
    
    
    public static String getExtra(String a)
{
   String result = "";
    switch(a)
    {
        case "pay":
        {
            result = "accept payments";
            break;
        }
        case "integrate":
        {
            result = "integration with external systems";
            break;
        }
                case "integration":
        {
            result = "integration with external systems";
            break;
        }
        case "booking":
        {
            result = "booking wizard";
            break;
        }
        case "cont":
        {
            result = "content management system";
            break;
        }
        case "rate":
        {
            result = "allow to rate your products";
            break;
        }
        case "forum":
        {
            result = "add community forum";
            break;
        }
        case "review":
        {
            result = "customer reviews";
            break;
        }
        case "hr":
        {
            result = "HR tools";
            break;
        }
         case "client":
        {
            result = "client base management tools";
            break;
        }
        case "admin":
        {
            result = "admin screen";
            break;
        }
        case "catalog":
        {
            result = "any tree catalog";
            break;
        }
        case "redextra":
        {
            result = "e-commerce application";
            break;
        }
        case "redcorp":
        {
            result = "corporate web-site";
            break;
        }
         case "redpers":
        {
            result = "personal web-site";
            break;
        }
        case "redother":
        {
            result = "custom made web application";
            break;
        }
    }
    
    return result;
}
}
