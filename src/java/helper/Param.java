/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import html.param;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Param extends param{
    
    public HttpServletRequest request;
    public param Par;
    public boolean isThing;
    public Param(String key,HttpServletRequest r)
    {
        super(key,"");
        request=r;
        
        isThing=true;
        pop();
    }
    
    final void pop()
    {
        String vl=request.getParameter(name);
        if(common.Com.isThing(vl))
        {
        value=vl;
        if(name.equals("selected")&&value.equals("main"))
        {
        value="paravoz";
        }
            
        Par=new param(name,value);
        
        }else
        {isThing=false;}
        
        
        
        
    
    }
    
}
