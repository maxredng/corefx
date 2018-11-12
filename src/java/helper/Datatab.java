/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import html.tag;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Datatab {
    
    public List<String[]> list;
    public String Isel;
    feed f;
    data d;
    tag Tag;
    HttpServletRequest request;
    public Datatab(String isl, HttpServletRequest req)
    {
        Isel=isl;
        list = new ArrayList<>();
        request = req;
        populate();
        
        
    }
    
    final void populate()
    {
         
        
        f = new feed();
        d = new data(f.cop);
        Isler is = new Isler(Isel,f.cop,(String)request.getSession().getAttribute("language"));
        is.populate(request);
        String qr = is.qr;
        
        
        
        
        try
        {
            Query qur = new Query(qr);
            list = d.pullTable(qr, qur.selected.length);
            if(list.size()>0)
            {
            String[] temp = list.get(0);
            
            if(temp.length == 3)
            {
            ListObject obj = new ListObject(temp[2],(String)request.getSession().getAttribute("language"));
            temp[2] = obj.value;
            list.clear();
            list.add(temp);
            
            }
            
            }
            
        
        }
        catch(Exception ex)
        {}
            
     

    
    }
    
}
