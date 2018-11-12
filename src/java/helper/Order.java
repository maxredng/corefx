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
public class Order {
    
    public String id;
    public String client;
    public String fname;
    public String lname;
    public String product;
    public String amount;
    public String price;
    public String address;
    public String email;
    public String terms;
    final String lang;
    public boolean OK;
    public String error;
    
    public Order(String ID,String lan)
    {
        id=ID;
        lang=lan;
        populate();
    }
    
    
    final void populate()
    {
        feed f = new feed();
        data da = new data(f.cop);
        data dap = new data(f.cop);
        data dar = new data(f.cop);
        data dac = new data(f.cop);
        data dat = new data(f.cop);
        
        List<String[]> lord = new ArrayList<>();
        List<String[]> lperson = new ArrayList<>();
        String query = "select * from prod.orders where orderid='"+id+"'";
        
        
        try
        {
            lord = da.pullTable(query, 6);
            
            if(!lord.isEmpty())
            {
            String[] temp = lord.get(0);
            
            String perid = temp[3];
            
            String qup = "select * from prod.ppl where phone='"+perid+"'";
            lperson = dap.pullTable(qup, 11);
            
            if(!lperson.isEmpty())
            {
                String[] tmp = lperson.get(0);
                
                client = tmp[2]+" "+tmp[3];
                fname = tmp[2];
                lname = tmp[3];
                email = tmp[1];
                
                address = tmp[10]+" "+tmp[9]+" "+tmp[7]+" "+tmp[8]+" "+tmp[9]+" "+tmp[5]+" "+tmp[6];
                
                
            }
            
            String qp = "select descr from prod.fact where id='"+temp[1]+"' and lan='"+lang+"'";
            String qc = "select descr from prod.fact where id='price' and parent='"+temp[1]+"'";
            String qa = "select descr from prod.fact where id='avail' and parent='"+temp[1]+"'";
            
            product = dar.pullString(qp);
            price = dac.pullString(qc);
            amount = temp[2];
        //    address = temp[4];
            terms = dat.pullString(qa);
             
            
            }
            
            
            
        }catch(Exception ex)
        {
        error = ex.getMessage();
        }
    }
    
}
