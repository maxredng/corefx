/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class Event {
    
     public List<DBField> fields;
     
     private String event;
     private String project;
     private String user;
     public String table;
     public feed f;
     String error;
     
     public Event(String ev, String us,String pro)
     {
         fields = new ArrayList<>();
         event = ev;
         project = pro;
         user = us;
         f = new feed();
         populate();
     }
    
     public Event(String ev,String pro)
     {
          fields = new ArrayList<>();
         event = ev;
         project = pro;
         user = "admin";
         f = new feed();
         populate();    
     
     }
     
    
     
     final void populate()
     {
         data da = new data(f.cof);
         List<String[]> l = new ArrayList<>();
         String query = "select tab,field,parameter,action from config.event where project='"+project+"' and user='"+user+"' and event='"+event+"'";
         try
         {
             l = da.pullTable(query, 4);
         }
         catch(Exception ex)
         {
             error = ex.getMessage();
         }
         
         for (String[] row : l) 
         {
             DBField field = new DBField(row[0],row[1],row[2],row[3]);
             if(table == null)
             {
                 table = field.table;
             }
             
             fields.add(field);
         }
     }
}
