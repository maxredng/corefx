/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper.props;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bsati
 */
public class CreatePages extends Prop{
    
    public CreatePages()
    {
        
    }
    
    @Override
    public void doStuff()
    {
        
        String query = "select concat(nav1,',',nav2,',',nav3) from prod.maincontent where user='"
                + user + "' and project = '" + project + "'";
       
       try
       {
           String[] row = dap.pullString(query).split(",");
           List<String> scopes = new ArrayList<>();
           
           for(String sc:row)
           {
               if(!scopes.contains(sc))
               {
                   scopes.add(sc);
               }
           }
           // TODO: get list of scopes, then add new
           
           String qoexist = "select scope from config.project where project='" + project + "' and user = '" + user + "'";
           
           List<String> l = daf.pullList(query, 1);
           
           for(String s:l)
           {
               scopes.add(s);
           }
           
           String kiq = "delete from config.project where project='" + project + "' and user = '" + user + "'";
           daf.Execute(kiq);
           
           for(String scop:scopes)
           {
               String qr = "insert into config.project values('" + project + 
                       "','" + scop + "','" + user + "')";
               
               try
               {
                   daf.Execute(qr);
               
               }
               catch(Exception xex)
               {
                   error = "error with scope = '" + scope + "' \r\n" + xex.getMessage();
               }
           
           }
           
       }catch(Exception sx)
       {
           error = sx.getMessage();
       }
    }
}
