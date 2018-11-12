/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.connection;
import data.data;
import html.feed;
import html.param;
import html.querystring;
import html.tag;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Isler {
    
    public String value;
    public String Isel;
    public connection Con;
    public String error;
    public tag Tag;
    public String qr;
    final String language;
    
    
    public Isler(String isel, connection con,String lan)
    {
    Isel=isel;
    Con=con;
    language = lan;
    Tag=new tag();
    
            Tag.Element="0";
            Tag.id="0";
            Tag.name="div";
            Tag.parent="main";
            Tag.isel=Isel;
            Tag.scope="temp";
           
            Tag.line="0";
            Tag.col="0";
            Tag.value="0";       
    
    
    }
    
    public void populate()
    {
    
        tag t=new tag();
        

                
       querystring qs=new querystring(t,"isel");
       qr = qs.query;
       data da=new data(Con);
       
       try
       {
           value=da.pullString(qs.query);
       
       }catch(Exception ex)
       {
       error=ex.getMessage();
       }
        
        
    }
    
        public void populate(HttpServletRequest request)
    {
    

        Tag.Feed = new feed();
        
        StringBuffer requestURL = request.getRequestURL();
    if (request.getQueryString() != null) {
        requestURL.append("?").append(request.getQueryString());
    }
    String url = requestURL.toString();
        
        Params par = new Params(url);

        for(int j = 0; j<par.item.size(); j++)
        {
            param pa = par.item.get(j);
            Tag.Feed.addParameter(pa);
        }
            
        String user = (String)request.getSession().getAttribute("user");
        param pau = new param("user",user);
        Tag.Feed.addParameter(pau);
        String lan = language;
        param pam = new param("language",lan);
        Tag.Feed.addParameter(pam);
       querystring qs=new querystring(Tag,"isel",true);
       qr = qs.query;
       data da=new data(Con);
       
       try
       {
           value=da.pullString(qs.query);
       
       }catch(Exception ex)
       {
       error=ex.getMessage();
       }
        
        
    }
    
}
