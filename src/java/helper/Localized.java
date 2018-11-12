/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.attribute;
import html.feed;
import html.param;
import html.querystring;
import html.tag;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Localized {
    
    private HttpServletRequest request;
    public String isel;
    public String value;
    public String query;
    public String id;
    public boolean OK;
    public String error;
    public feed Feed;
    
    public Localized(HttpServletRequest r, String isl, String ID)
    {
        id = ID;
        isel = isl;
        request = r;
        OK = false;
        Feed = new feed();
        populate();
    }
    
    final void populate()
    {
        //public tag(String na, String Id, attribute[] at, feed fd)
        
                StringBuffer requestURL = request.getRequestURL();
        
         String queryString = request.getQueryString();
         String rl = "";
             if (queryString == null) {
        rl = requestURL.toString();
    } else {
        rl = requestURL.append('?').append(queryString).toString();
    }
        Params par = new Params(rl);
        
        
        Feed.params = par.item;
        
        String lan = request.getLocale().getLanguage();
        
        Feed.addParameter(new param("language",lan));
        
        tag t = new tag("div",id,new attribute[0],Feed);
        t.isel = isel;
        t.Element = "c";
        querystring q = new querystring(t,"isel");
        
        query = q.query;
        
        data da = new data(t.Feed.cop);
        
        try
        {
        value = da.pullString(q.query);
        OK = true;
        }catch(Exception ex)
        {
            error = ex.getMessage();
        }
                
    }
}
