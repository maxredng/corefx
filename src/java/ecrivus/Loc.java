/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecrivus;

import data.data;
import html.feed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maxkarpov
 */
public class Loc {
    
    public static void handle(HttpServletRequest request)
    {
        String user = request.getParameter("voiceid");
        String sum = request.getParameter("summ");
        HttpSession session  = request.getSession();
        String use = (String)session.getAttribute("user");
        String qus = "insert into prod.loc values('"+user+"','"+use+"','"+sum+"','"+request.getLocale().getLanguage()+"','"+Category.getId()+"')";
    
        feed f = new feed();
        
        data da = new data(f.cop);
        
        try
        {
        da.Execute(qus);
        }catch(Exception ex)
        {}
    }
}
