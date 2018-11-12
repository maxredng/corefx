/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;

/**
 *
 * @author Maxkarpov
 */
public class Basket {
    
    
    
    public static String toCart(String user,String prod)
    {
        
    String result="success";    
    String query="insert into prod.orders values(NULL,'"+prod+"','"+1+"','"+user+"',NULL,NULL,NULL)";
    
    feed f=new feed();
    data da=new data(f.cop);
    
    
    data dar=new data(f.cop);
    int i=0;
    try
    {
        String qor="select amount from prod.orders where orderid is NULL and prodid='"+prod+"' and personid='"+user+"'";
        String I=dar.pullString(qor);
        i=Integer.parseInt(I);
        
    }catch(Exception exo)
    {
    
    }
    
    if(i==0)
    {
    try
    {
    da.Execute(query);
    
    }catch(Exception ex)
    {
    result="error: "+ex.getMessage();
    }
    }else
    {
    String il=Integer.toString(i+1);
    data dup=new data(f.cop);
    String qup="update prod.orders set amount='"+il+"' where orderid is NULL and prodid='"+prod+"' and personid='"+user+"'";
    try
    {
    dup.Execute(qup);
    
    }catch(Exception ns)
    {
    result="error: "+ns.getMessage();
    }
    }
    return result;
    }
    
    
}
