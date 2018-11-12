/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import html.param;
import java.util.ArrayList;
import java.util.List;



public class Params {
  public List<param> item;  
  
  public Params(String url)
  {
      item = new ArrayList<>();
      populate(url);
  }
  
  final void populate(String r)
  {
  String[] temp = r.split("\\?");
  
  if(temp.length>1)
  {
  String[] tm = temp[1].split("&");
  
  for(int i = 0; i < tm.length; i++)
  {
      
      try
      {
        String[] par = tm[i].split("=");

        param pa = new param(par[0],par[1]);
        item.add(pa);      
        
      }catch(Exception x)
      {}
          

  }
  }
  
  }
  
  public String getValue(String key)
  {
      String result=null;
      
            for(int i = 0; i< item.size(); i++)
            {
                String k = item.get(i).name;
                String val = (String)item.get(i).value;
                
                if(k.equals(key))
                {
                    result = val;
                    break;
                }
            }
      
      return result;
  
  }
  
  
}
