/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import common.Delta;
import data.connection;
import data.data;

/**
 *
 * @author Maxkarpov
 */
public class Updatequery {
    
   public static String handle(String query)
   {
       String result = null;
       boolean OK = true;
       connection con = common.Com.getConnection(query);
       
       data da = new data(con);
       
       try
       {
           result = da.Execute(query);
       
       
       }
       catch(Exception ex)
       {
       result = ex.getMessage();
       OK = false;
       }
       
       if(OK)
       {
       Delta.saveQuery(query);
       }
       
       return result;
   }
    
}
