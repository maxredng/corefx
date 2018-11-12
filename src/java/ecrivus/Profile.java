/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecrivus;

import data.data;
import helper.Params;
import html.feed;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Profile {
    
    public String error;
    public boolean OK;
    public HttpServletRequest request;
    private feed Feed;
    public Profile(HttpServletRequest r)
    {
        request = r;
        Feed = new feed();
        populate();
    }
    
    final void populate()
    {
        String[] str = {"first","last","phone","gender","postcode","address","city","dob","experience","second","brands","term","country","language","time"};
        String url = help.getURL(request);
        String username = request.getParameter("username");
        String sum = request.getParameter("summ");
      //  String qus = "insert into prod.loc values('"+username+"','"+username+"','"+sum+"','"+request.getLocale().getLanguage()+"','"+Category.getId()+"')";
        Params par = new Params(url);
        
        if(common.Com.isThing(par.getValue("language")))
        {
          String qr = "update prod.actor set ";
        
        for(int i = 0; i<str.length; i++)
        {
            
            if(i==12)
            {
            System.out.println("integer");
            }
            String val = par.getValue(str[i]).replace("%20"," ");
            
            if(i<str.length-1)
            {
                qr = qr+str[i]+"='"+val+"',";
            
            }else
            {
            qr = qr+str[i]+"='"+val+"' ";
            }
        }
        qr = qr + "where email='"+request.getSession().getAttribute("user")+"'";
        
        data da = new data(Feed.cop);
        data dap = new data(Feed.cop);
        try
        {
        da.Execute(qr);
     //   dap.Execute(qus);
        OK = true;
        
        }
        catch(Exception ex)
        {
        OK = false;
        error = ex.getMessage();
        }      
        }
        

    }
}
