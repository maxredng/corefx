/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.connection;
import data.data;
import html.feed;
import html.tag;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Clone {
    
    public static void handle(HttpServletRequest request)
    {
        String mscope = request.getParameter("mscope");
        String parent = request.getParameter("parent");
        String select = request.getParameter("selected");
        String scope = request.getParameter("area");
        String tmp = request.getParameter("temp");
        String prf = null;
        prf = common.Com.getSec();
        tag tg = new tag(select,scope,new feed(),true);
        tg.parent = parent;
        tg.populateTag();
        tg.SaveTag(mscope, false,prf,parent);
        String nm = common.Com.changeName(select, scope, mscope);
        
           if(common.Com.isThing(tmp))
        {
            String qur = "update config.col set isel='nonsuch', num='template:"+tmp+"' where name='"+prf+nm+"' and scope='"+mscope+"'";
            connection con = new connection(MyDB.Schema.schema.config);
            data da = new data(con);
            
            try
            {
            da.Execute(qur);
            }
            catch(Exception xex)
            {}
            
        } 
        
    }
    
}
