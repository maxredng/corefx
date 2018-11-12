/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bsati
 */
public class Value {
    
    
    public String parameter;
    public String action;
    public String value;
    public boolean isParam;
    private HttpServletRequest request;
    
    public Value(String p,String act,HttpServletRequest r) throws Exception
    {
        request = r;
        parameter = p;
        action = act;
        populate();
    
    }
    public Value()
    {
        isParam = false;
    }
    final void populate() throws Exception
    {
        isParam = false;
        value = request.getParameter(parameter);
        if(value==null)
        {
            if(parameter.equals("cleanup"))
           {
               value = "";
           }       
        }

            if(parameter.startsWith("^"))
            {
                 
                
           if(parameter.contains("^random_"))
           {
               String suff = parameter.split("_")[1];
               int suf = Integer.parseInt(suff);
               value = RandomString.getString(suf);
               
           }
           if(parameter.contains("^timestamp"))
           {
               Date data = new Date();
               DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
               value = df.format(data);
           }            
            if(parameter.contains("^list"))
            {
            
            
            }
            }else
            {
                if(parameter.startsWith("_"))
                {
                    value = parameter.substring(1);
                
                }else
                {
                    if(action.equals("encrypt"))
                    {
                   Encryptor enc = new Encryptor();
                   value = enc.encrypt(value);
                    }else
                    {
                        if(!action.equals("update"))
                        {
                        isParam = true;
                        }
                    
                    }
                    
                }
                    
            
            
            }

   
            
    }
}
