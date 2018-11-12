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
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Ecrivus {
    
    private HttpServletRequest request;
    public String error;
    public boolean OK;
    private feed Feed;
    
    public Ecrivus(HttpServletRequest r)
    {
        
        Feed = new feed();
        request = r;
        populate();
    }
    
    
    final void populate()
    {
        String voiceid = request.getParameter("voiceid");
        String category = request.getParameter("category");
        String volume = request.getParameter("volume");
        String[] ext = request.getParameter("extra").split(",");
        
        String user = request.getSession().getId();
        
        if(common.Com.isThing(request.getParameter("user")))
        {
            user = request.getParameter("user");
            
        }
                
        

        
        List<String> l = new ArrayList<>();
        
        l.add(voiceid);
        l.add(category);
        l.add(volume);
        
        String priq = "select price from prod.price where item='"+volume+"'";
        String vopr = "";
        data d = new data(Feed.cop);
        
        try
        {
        vopr = d.pullString(priq);
        }catch(Exception exc)
        {}
        
        List<String> str = new ArrayList<>();
        str.add("");
        str.add("");
        str.add(vopr);
        
        for(int i=0;i<ext.length;i++)
        {
            l.add(ext[i]);
            
            data ed = new data(Feed.cop);
            
            try
            {
                String qed = "select price from prod.price where item='"+ext[i]+"'";
                str.add(ed.pullString(qed));
            }
            catch(Exception eex)
            {}
            
        }

    
        
        feed f = new feed();
        
        for(int y=0;y<l.size(); y++)
        {
            data da = new data(f.cop);
            
        String qst = "insert into prod.orders values(null,'";
        String qest = "insert into prod.orders values('dm','";
        String qen = "','"+str.get(y)+"','"+user+"','','pending','')";                
            
            
            try
            {
                if(y==0)
                {
                String query = qest+l.get(y)+qen;
                da.Execute(query);
                }else
                {
                String query = qst+l.get(y)+qen;
                da.Execute(query);
                }
                
            
            }catch(Exception ex)
            {
                OK = false;
                error = ex.getMessage();
                break;
                
            }
        }
        
        
    
    
    }
    
}
