/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class InsertQuery {
    
    private List<DBField> fields;
    final String table;
    private feed f;
    public String query;
    public String error;
    private HttpServletRequest request;
    
    public InsertQuery(String tab, List<DBField> l, HttpServletRequest r)
    {
        fields = new ArrayList<>();
        fields = l;
        table = tab;
        f = new feed();
        request = r;
        populate();
    }
    
    
  
    final void populate()
    {
        boolean upd = false;
        List<String> cl = new ArrayList<>();
        data da = new data(f.cop);
        String update = request.getParameter("update");
        
        String qr = "show columns from prod."+table;
        try
        {
        cl = da.pullList(qr, 1);
        
        if(!common.Com.isThing(update))
        {
        query = "insert into prod."+table+" values(";
        
        }else
        {
        upd = true;
        query = "update prod."+table+" set ";    
            
        
        }
        
        
        }
        catch(Exception ex)
        {
            error = ex.getMessage();
        }
        
        for(int i = 0; i<cl.size(); i++)
        {
            String val = getValue(cl.get(i));
            if(!upd)
            {
            if(i<cl.size()-1)
            {
            query = query + "'" + val + "',";
            }else
            {
            query = query + "'" + val + "')";
            }
            }else
            {
                if(common.Com.isThing(val))
                {
            if(i<cl.size()-1)
            {
             query = query + cl.get(i)+"='"+val+"', ";
            }else
            {
             query = query + cl.get(i)+"='"+val+"' ";
            }                
                }
            
            }
        }
        if(upd)
        {
            query = query + "where project='"+request.getParameter("project")+"' and user = '" + request.getSession().getAttribute("user")+"'";
        
        }
    
    }
    
    
    private String getAction(String body, String act)
    {
        String result = null;
            
            switch(act)
            {
                case "encrypt":
                {

                    
                    try
                    {
                        
                    Encryptor enc = new Encryptor();
                    String enpass = enc.encrypt(body);                          
                    result = enpass;   
                    }
                    catch(Exception ex)
                    {
                    error = ex.getMessage();
                    }
                    
                    break;
                }
            
            
            }
        
        return result;
    
    }
    
    private String getValue(String ar)
    {
        String result = "";
        
        DBField field = getField(ar);
        
        if(field!=null)
        {
        String parameter = field.parameter;
        String action = field.action;
        
        if(parameter.contains("^"))
        {
           String par = "";
            
           try
           {
           par = common.Com.parseFrom(parameter, "^", "_").substring(1);
           }catch(Exception x)
           {
               par = parameter.substring(1);
           }
           
           
            switch(par)
            {
                case "random":
                {
                    String[] st = parameter.split("_");
                    if(st.length>1)
                    {
                    int seed = Integer.parseInt(st[1]);
                    
                    
                    try
                    {
                        String temp = RandomString.getString(seed);
                        if(common.Com.isThing(action))
                        {
                            result = getAction(temp,action);
                        
                        
                        }else
                        {
                            result = temp;
                        }
                    
                    }catch(Exception ex)
                    {
                        error = "error in RandomString class: " + ex.getMessage();
                    }
                    
                    
                    }
                    
                    break;
                }
                case "timestamp":
                {
                        Date date = new Date();
                        Timestamp ts=new Timestamp(date.getTime());
                        String tm = ts.toString(); 
                        result = tm;
                        break;
                }
                case "list":
                {
                    String st = request.getParameter("list");
                    String[] str = st.split(",");
                    for(int i = 0;i<str.length; i++)
                    {
                        String s = str[i];
                        if(i<str.length-1)
                        {
                            result = result + s +",";
                        }else
                        {
                            result = result + s;
                        }
                    }
                    
                    break;
                }
            
            
            }
            
        
        }else
        {
            if(!parameter.startsWith("_"))
            {
            result = request.getParameter(parameter);
            }else
            {
            result = parameter.substring(1);
            }
            

            
        }
        }
        

        
        
        return result;
    }
    
    private DBField getField(String key)
    {
        DBField result = null;
        
        for(DBField f:fields)
        {
            if(f.name.equals(key) && f.table.equals(table))
            {
                result = f;
                break;
            }
        }
        
        
        return result;
    }
    
}
