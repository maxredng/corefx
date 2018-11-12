/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecrivus;

import helper.Localized;
import helper.MySimpleMail;
import html.feed;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Mess {
    
    
    public static void handle(HttpServletRequest request)
    {
        
        feed f = new feed();
        String ml = f.ordermail;
        String cat = request.getParameter("categ");
        String category = cat;
        
      if(cat.equals("general"))
      {
      category = "common";
      }
        
        Localized lo = new Localized(request,"pro",category);
        String subj = lo.value;
        String title = request.getParameter("title");
        String mytext = request.getParameter("mytext");
        
        MySimpleMail.sendTLS(ml, subj,title+'\n'+'\n'+'\n'+ mytext);
    }
    
}
