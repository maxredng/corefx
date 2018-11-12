/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bsati
 */
public class JsReader {
    
    
    
    
    static String getFid(String ln)
    {
        String result = "";
        if(ln!=null)
        {
        if(ln.contains("="))
        {
            String res = common.Com.parseFrom(ln, ".", "=");
            result = common.Com.peel(res);
            
        }
        else
        {
            result = common.Com.peel(ln);
        }        
        
        }

        
        return result;
    }
    
        static List<String> getList(String path)
    {
        List<String> result = new ArrayList<>();
        
            InputStream st;
            BufferedReader rd;
            
            
            try
            {
                String curp= "/corefx/" + path;  
                
                rd = new BufferedReader(new FileReader(path));
                String line;
                while((line = rd.readLine())!=null)
                {
                    result.add(line);
                }
            
            }catch(Exception ex)
            {
            result.add("");
            }
        
        return result;
    }
    
    
    public static void getJS(String path)
    {
        feed f = new feed();
        List<String> file = getList(path);
        
        List<JsLine> list = new ArrayList<>();
        boolean open = false;
        boolean closed = false;
        String vq = "select max(version) from config.js";
         int mxver = 0;
         data dau = new data(f.cof);
        try
        {
        mxver = dau.pullInt(vq) + 1;
        }
        catch(Exception vex)
        {
        
        }
        String signature = null;
        String parent = "root";
        
        for(int i = 0; i< file.size(); i++)
        {
               if(file.get(i).contains("replace"))
               {
                   System.out.print("");
               }            
            
            JsLine line = new JsLine(file.get(i),open,closed);
            
                   if(!line.Type.equals(type.blank))  
                  {
                      
                                String mq = "select max(ord) from config.js";
                            
                            data dam = new data(f.cof);
                            int max = 0;
                           
                            try
                            {
                                max = dam.pullInt(mq) + 1;
                                
                            }
                            catch(Exception ex)
                            {
                                
                            }                  
                      

                      
            switch(line.Type)
            {
                case open:
                {
                    open = true;
                    closed = false;
                    break;
                }
            
                case close:
                {
                    closed = true;
                    open = false;
                    break;
                }
                        
                  case global:
                {
                    closed = false;
                    open = false;
                    parent="0";
                    break;
                }
                case local:
                {
                    open = true;
                    closed = false;
                    
                    if(line.closed == true)
                    {
                        open = false;
                        closed = true;
                    
                    }
                    
                    parent = "0";
                    break;
                }
                case signature:
                {
                    parent = signature;
                    
                    if(line.line.contains("function"))
                    {
                        parent = "0";
                    }
                    
                    signature = Integer.toString(max);
                    closed = false;
                    
                    open = false;
                    if(line.open == true)
                    {
                        open = true;
                        closed = false;
                    }
                    break;
                }
                                    
            }



                            
                            String fid = getFid(parent);
                            
                       if(signature==null)
                      {
                          fid = "global";
                      }
                            
                            String name = line.Type.toString();
                            
                            String query = "insert into config.js values('" + fid + "'," + max + ",'"
                                    + name + "','" + line.line.replace("'", "\\'") + "'," + mxver + ")";
                            
                            try
                            {
                                if(!line.line.contains("{")&!line.line.contains("}"))
                                {
                                dam.Execute(query);
                                }else
                                {
                                    if(helper.Help.containsAlfaOrDigit(line.line))
                                    {
                                    dam.Execute(query.replace("{", "").replace("}", ""));
                                    
                                    }
                                
                                }
                            
                            }
                            catch(Exception cex)
                            {
                                
                            }
                                 
                            
                            
                      
                  
                  }
                  
        }    
    
    
    }
}
