/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper.props;

import data.data;
import html.feed;
import javax.servlet.http.HttpServletRequest;

public class Prop {
    
    public HttpServletRequest request;
    public feed f;
    public data daf;
    public data dap;
    public String user;
    public String project;
    public String scope;
    public String error;
    
    public Prop()
    {
        
        
    }
    
    public void populate(HttpServletRequest r)
    {
        request = r;
        user = (String)r.getSession().getAttribute("user");
        project = getParameter("project");
        f = new feed();
        dap = new data(f.cop);
        daf = new data(f.cof);
    }
    
    public void doStuff()
    {
    }
    
    public String getParameter(String key)
    {
    return request.getParameter(key);
    }
    
    
}
