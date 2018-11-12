/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;

/**
 *
 * @author bsati
 */
public class ListObject {
    
    
   public String value;
   protected String src;
   final feed fd;
   final data dat;
   final String language;
   
   
   public ListObject(String str,String lan)
   {
       fd = new feed();
       dat = new data(fd.cop);
       language = lan;
       src = str;
       populate();
   }
    
   
   final void populate() 
   {
       String[] temp = src.split(",");
       value = "";
       String q = "select value from prod.local where id='?' and lan='"+language+"' and project='redpage' and scope='list'";
   
       for(int i=0; i<temp.length; i++)
       {
           String ar = temp[i];
               try
               {
                          
           if(i<temp.length - 1)
           {

               String query = q.replace("?", ar);
               value = value + dat.pullString(query)+",";
               

               
           }else
           {
               value = value + dat.pullString(q.replace("?", "ar"));
           
           }
               }catch(Exception x)
               {
                   System.out.print(x.getMessage());
               }       
       }
       
       
   
   }
   
}
