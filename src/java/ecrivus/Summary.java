package ecrivus;

import data.data;
import html.feed;
import javax.servlet.http.HttpServletRequest;



public class Summary {
    
    public static void handle(HttpServletRequest request)
    {
    
        String summary = request.getParameter("summary");
        String recid = request.getParameter("recid");
        String update = request.getParameter("update");
        String voiceid = request.getParameter("voiceid");
        String newlan = request.getParameter("newlan");
        feed f = new feed();
        
        String id = Category.getId();
        
        if(common.Com.isThing(update))
        {
            String req = "update prod.loc set value='"+summary+"' where recid='"+recid+"'";
            
            data da = new data(f.cop);
        
            try
            {
            da.Execute(req);
            }catch(Exception ex)
            {}
        }else
        {
            String qur = "insert into prod.loc values('"+voiceid+"','"+voiceid+"','"+summary+"','"+newlan+"','"+id+"')";
            data dap = new data(f.cop);
            
            try
            {
                dap.Execute(qur);
                
            }
            catch(Exception ex)
            {}
        }   
        
        
        
    }
    
}
