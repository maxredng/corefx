/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import html.feed;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class UserView {
    
    public HttpServletRequest request;
    public feed Feed;
    
    public UserView(HttpServletRequest r)
    {
        Feed=new feed();
        request=r;
        
        
    }
    
}
