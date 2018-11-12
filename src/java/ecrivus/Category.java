/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecrivus;

import data.data;
import html.feed;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Category {
    
    public static void handle(HttpServletRequest re)
    {
        feed f = new feed();
        String cat = re.getParameter("category");
        String noe = re.getParameter("noe");
        String recid = re.getParameter("recid");
        String mediaid = re.getParameter("mediaid");
        String lan = re.getParameter("newlan");
        if(common.Com.isThing(noe))
        {
        String recd = getId();
        String ca = getMedia(mediaid);
        String qr = "insert into prod.loc values('"+ca+"','"+cat+"','','"+lan+"','"+recd+"')";
        data dax = new data(f.cop);
        try
        {
            dax.Execute(qr);
        
        }
        catch(Exception rex)
        {
        }
        }else
        {
        
            String qur = "update prod.loc set title='"+cat+"' where recid='"+recid+"'";

            
            data dat = new data(f.cop);
            
            try
            {
                dat.Execute(qur);
            }
            catch(Exception ex)
            {
            }
            
            
        }
        
    }
    
    
    public static String getMedia(String id)
    {
    String result = null;
    
        feed f = new feed();
        data da = new data(f.cop);    
    
        try
        {
            result = da.pullString("select cat from prod.media where mediaid='"+id+"'");
        }
        catch(Exception ex)
        {}
    
    return result;
    }
    
    public static String getId()
    {
        String result = null;
        feed f = new feed();
        data da = new data(f.cop);
        List<String[]> l = new ArrayList<>();
        int mx = -1;
        
        try
        {
            l = da.pullTable("select recid from prod.loc",1);
        
        }
        catch(Exception x)
        {}
        
        for(int i = 0; i<l.size(); i++)
        {
            int val = Integer.parseInt(l.get(i)[0]);
            if(val>mx)
            {
            mx=val;
            }
        }
        
        result = Integer.toString(mx+1);
        
        return result;
    }
}
