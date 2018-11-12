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
public class Voice {
    
    final HttpServletRequest request;
    public boolean OK;
    public String error;
    final feed Feed;
    public String login;
    public Voice(HttpServletRequest r)
    {
         
        request = r;
        Feed = new feed();
        populate();
    }
 
    final void populate()
    {
        OK = true;
        
        
        
        String url = help.getURL(request);
        
        Params par = new Params(url);
        String email = par.getValue("email");
        String username=par.getValue("Username");
          String gender = request.getParameter("gender");
          String first = request.getParameter("first");        
          String last = request.getParameter("last");     
          String lan = request.getParameter("lan"); 
          String sum = request.getParameter("summ");
        if(common.Com.isThing(email))
        {
        // String[] pr = {"Username","email","phone","first","last","lai","cosel"};
        String ps = help.getPassword();
//                  String quv = "insert into prod.voice values ('"+username+"','"+email+"','"+gender
//                  +"','"+first+"','"+last+"','"+lan+"',null)";
        String qus = "insert into prod.loc values('"+username+"','"+username+"','"+sum+"','"+request.getLocale().getLanguage()+"','"+Category.getId()+"')";
        String query = "insert into prod.actor values('"+par.getValue("Username")+"','"+par.getValue("first")+"','"
                +par.getValue("last")+"','','','','','','"+par.getValue("cosel")+"','"+par.getValue("lai")+"','"
                +"','"+par.getValue("email")+"','','','','','','','','')";
        String pqr = "insert into prod.ppl values('"+par.getValue("Username")+"','"+par.getValue("email")+"','"+par.getValue("first")
        +"','"+par.getValue("last")+"','"+ps+"','','','','','','','voice','"+help.getStamp()+"')";     
        data da = new data(Feed.cop);
        data dapl = new data(Feed.cop);
        data dav = new data(Feed.cop);
        login = par.getValue("email");
        try
        {
            da.Execute(query);
            dapl.Execute(pqr);
      //      dav.Execute(qus);
            //dav.Execute(query);
        }
        catch(Exception ex)
        {
            OK = false;
            error = ex.getMessage();
        }       
        
        
        }else
        {
        OK = false;
        }
        

        
        
    }
    
}
