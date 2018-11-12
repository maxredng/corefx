/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxkarpov
 */
public class Terrain {
    
    
    public static String writeTerrain()
    {
        String result="";
        List<String[]> l=new ArrayList<String[]>();
            feed f=new feed();
            data d=new data(f.cop);
            
            try
            {
                l=d.pullTable("select distinct name from "+f.cop.name+".block", 7);
                
            }catch(Exception ex)
            {
            result=ex.getMessage();
            }
        
            int len=l.size();
            
            for(int i=0;i<len;i++)
            {
                String name=l.get(i)[0];
                
                try
                {
                    List<String[]> li=new ArrayList<String[]>();
                    data da=new data(f.cop);
                    
                    li=da.pullTable("select shape,orient from "+f.cop.name+".block where name='"+name+"'", 2);
                    
                    for(int j=0;j<li.size();j++)
                    {
                        String sp=li.get(j)[0];
                        String[] ar=li.get(j)[1].split(",");
                        
                        if(sp.equals("road"))
                        {
                            
                        }
                        if(sp.equals("river"))
                        {
                        
                        }
                        if(sp.equals("hill"))
                        {
                        
                        }
                        if(sp.equals("lake"))
                        {
                        
                        }
                    
                    }
                    
                }catch(Exception ex)
                {
                
                }
            
            }
            
            
        return result;
    }
    
}
