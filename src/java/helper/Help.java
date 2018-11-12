/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.connection;
import data.data;
import html.feed;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import ogurez.Com;

/**
 *
 * @author Maxkarpov
 */
public class Help {
    
    public static String getJSFile(HttpServletRequest r)
    {
//    
//        String pro = r.getParameter("project");
//        String pre = "";
//        if(Com.isThing(pro))
//        {
//            pre = pro;
//        }
//        
//        feed f = new feed();
//        data d = new data(f.cof);
//        String qr = "select version from config.js";
//        String ver = "";
//        
//        try
//        {
//            ver = d.pullString(qr);
//        }catch(Exception x)
//        {}
//        
//       
//        
//          String result = pre+ "logic" + ver + ".js"; 
//          
//          String dir =  r.getServletContext().getRealPath("js");
//          
//          if(!Com.isThing(dir))
//          {
//              testlabone.JSGen.runJS("1", pro, "js/"+result);
//              
//          }else
//          {
//              
//              String fl = r.getServletContext().getRealPath("js/"+result);
//                        if(!Com.isThing(fl))
//              {
//             
//                  String path = dir+"/" +result;
//                  testlabone.JSGen.runJS("1", pro, path);
//              }
//          
//          }
//      
//    return "js/" + result;
//        
        return "redlogic070.js";
    }
    
    public static void setVersion(String pa,String bod)
    {
        data dard = new data((new feed()).cof);
        try
        {
            String scope = common.Com.parseFrom(pa, "scopeequaLs", "&");
            String q = "delete from config.store where sign like '%scopeequaLs" + scope + "'";
            dard.Execute("delete from config.store where sign like '%scopeequaLs" + scope + "'");
            dard.Execute("insert into config.store values('" + pa + "','" + bod + "')");
            dard.Execute("delete from config.calc where name='" + scope + "'");
        }
        catch(Exception x)
        {
        }
    }
    
    
    public static boolean containsAlfaOrDigit(String st)
    {
        boolean result = false;
            char[] ch = st.toCharArray();
            for(int i = 0; i<ch.length; i++)
            {
                if(isAlfaOrDigit(ch[i]))
                {
                    result = true;
                    break;
                
                }
            
            }
    
        return result;
    }
    
    public static String moveThing(String line,String start,char end)
    {
        String result = "";
        char space = '\0';  
        boolean notit = false;
            int n = line.indexOf(start);
            
            char[] row = line.toCharArray();
            
            for(int i = 0; i<row.length; i++)
            {
                char ch = row[i];
                if(i < n + start.length() || notit)
                {
                    result = result + ch;
                }
                    else
                {
                    if(isAlfaOrDigit(ch))
                    {
                    result = result + ch;
                    notit = true;
                    }else
                    {
                        if(ch == end)
                        {
                        result = result + ch;
                        notit = true;
                        }
                    }
                }
            
            }
            
        return result;
    }
    
    public static String moveLeft(String st)
    {
        String result = "";
        
        boolean notstarted = true;
        
        char[] row = st.toCharArray();
        
        for(int i = 0; i<row.length; i++)
        {
        char ch = row[i];
            if(notstarted)
            {
                
                
                if(isAlfaOrDigit(ch))
                {
                    notstarted = false;
                    result = result + ch;
                
                }
            
            }else
            {
                result = result + ch;
            }
        
        }  
            
           
        
        return result;
    
    }
    
    
    public static boolean isAlfaOrDigit(char ch)
    {
    boolean result = false;
        
        if(Character.isAlphabetic(ch)||Character.isDigit(ch))
        {
            result = true;
        }
    return result;
    }
    
    
    public static String getVersion(String scope)
    {
        feed f = new feed();
        data daf = new data(f.cof);
        String result = "";
        try
        {
         result = daf.pullString("select version from config.version where scope='" + scope +"'");
        
        }
        catch(Exception ex)
        {
            result = null;
        }
        
        return result;
    }
    
    public static List<String[]> getQueryMap(String query)  
{  
    String[] params = query.split("&");  
    List<String[]> map = new ArrayList<>();  
    for (String param : params)  
    {          
        try
        {
        String name = param.split("=")[0];  
        String value = param.split("=")[1];  

        String[] tmp = {name,value};
        map.add(tmp);        
        }catch(Exception x)
        {}

    }  
    return map;  
}
    
    
    
    
    public static void cleanCache(String scope)
    {
        String qr = "delete from config.store where sign like'%scopeequals"+scope+"%'";
    
        feed f = new feed();
        data da = new data(f.cof);
        
        try
        {
        da.Execute(qr);
        
        }
        catch(Exception ex)
        {}
    }
    
    
    public static String maxUnderscore(connection con, String qr)
    {
        String result = null;
        String pref = "";
        List<String> l = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        
        data d = new data(con);
        
        try
        {
            l = d.pullList(qr, 1);
            
            
        
        }catch(Exception ex)
        {}
        
        for(int i = 0; i<l.size(); i++)
        {
            String[] pr = l.get(i).split("_");
            if(i == 0)
            {
                pref = pr[0];
            }
            
            int ig = Integer.parseInt(pr[1]);
            li.add(ig);
        
        }
        
        int max = 0;
        
        for(int i = 0; i<li.size(); i++)
        {
            if(li.get(i) > max)
            {
                max = li.get(i);
            }
        }
        result = pref + "_" + Integer.toString(max + 1);
        return result;
    }
    
    
    public static int getId(String isl)
    {
        int result = -1;
            
           feed f = new feed();
           
           data da = new data(f.cof);
           
           String q = "select max(ord) from config.list where isel='"+isl+"'";
           
           try
           {
               result = da.pullInt(q)+1;
           
           }catch(Exception ex)
           {
           result = -2;
           }
        
        return result;
    
    }
    
}
