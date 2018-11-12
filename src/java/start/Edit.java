/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import data.data;
import html.feed;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kisa
 */
@WebServlet(name = "Edit", urlPatterns = {"/start/Edit"})
public class Edit extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String PAR=""; 
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session=request.getSession();
        String user=session.getAttribute("user").toString();
        String b="";
        PrintWriter out = response.getWriter();
        try {
//                        if(user.length()>0&user.length()<12)
            
            {
            String row=request.getParameter("v0");
            String col=request.getParameter("v1");
            String element=request.getParameter("v2");
            String name=request.getParameter("v3");
            String value=request.getParameter("v4");
            String parent=request.getParameter("v5");
            String scope=request.getParameter("v6");
            String type=request.getParameter("v7");
            String isel=request.getParameter("v8");
            String block=request.getParameter("v9");
            b=block;
            String id=request.getParameter("selected");
            String pa=request.getParameter("parent");
            
            String[] ar={"row","col","element","name","value","parent","scope","type","isel","block"};
            String[] va={row,col,element,name,value,parent,scope,type,isel,block};
            String qur="update config.col set ";
            
            //common.Com.makeUp(value)
            
            if(type!=null)
            { 
                

            for(int i=0;i<ar.length;i++)
            {
            
                if(i<ar.length-1)
                {
                    qur=qur+ar[i]+"='"+va[i]+"', ";
                }else
                {
                qur=qur+ar[i]+"='"+va[i]+"' ";
                
                }
            }
                        qur=qur+"where name='"+id+"' and parent='"+pa+"'";
                        
                        id=name;
            }else
            {
                            String winprod=request.getParameter("winprod");
                            if(winprod==null)
                {
            qur="update prod.fact set ";
            String Id=request.getParameter("v0");
            PAR=Id;
            String cat=request.getParameter("v1");
            String catpres=request.getParameter("v2");
            String par=request.getParameter("v3");
            String desc=request.getParameter("v6");
            String pardesc=request.getParameter("v4");
            String lan=request.getParameter("v5");  
            
            String[] arp={"id","cat","cat_pres","parent","descr","par_desc","lan"};
            String[] vap={Id,cat,catpres,par,desc,pardesc,lan};            
              for(int i=0;i<arp.length;i++)
            {
            
                if(i<arp.length-1)
                {
                    qur=qur+arp[i]+"='"+vap[i]+"', ";
                }else
                {
                qur=qur+arp[i]+"='"+vap[i]+"' ";
                
                }
            }          
              qur=qur+"where id='"+Id+"'";     
              id=name;
            }else
               {
                   
            String title=request.getParameter("id");
            String wid=request.getParameter("title");
            String descr=request.getParameter("descr");
            String price=request.getParameter("price");
            String avail=request.getParameter("avail");
            String series=request.getParameter("series");
            String cat=request.getParameter("category");
            String pres=request.getParameter("catpres");
            String par=request.getParameter("parent");
            String pardes=request.getParameter("pardesc");
            Locale loc=request.getLocale();
            String lan=loc.getLanguage();
                   
                   
                   
                   
                   
                   if(winprod.equals("true"))
                   {
                       
      qur="update prod.fact set id='"+wid+"', cat='"+cat+"', cat_pres='"+pres+"', descr='"+title+"', parent='"+par
              +"', par_desc='"+pardes+"', lan='"+lan+"', als='1' where id='"+wid+"'";
      
      
            String desquer=common.Com.getUpdateQuery("description", descr, wid, pardes, lan);
            String avaquer=common.Com.getUpdateQuery("avail", avail, wid, pardes, lan);      
            String serquer=common.Com.getUpdateQuery("series", series, wid, pardes, lan);            
            String priquer=common.Com.getUpdateQuery("price", price, wid, pardes, lan);            
            
            
            String[] qrs={desquer,avaquer,serquer,priquer};
            
            feed f=new feed();
            for(int i=0;i<qrs.length;i++)
            {   
                
                data dau=new data(f.cop);
                try
                {
                    dau.Execute(qrs[i]);
                    common.Delta.saveQuery(qrs[i]);
                    
                }catch(Exception ex)
                {
                System.out.print("WindowADDError: "+ex.getMessage());
                
                }
                        
            }
      
                       
                   }else
                   {
                       qur="delete from prod.fact where id='"+wid+"' or parent='"+wid+"'";
                   
                   }
               
               
               
               }
            }

            feed Feed=new feed();
            data da=new data(Feed.cof);
          String status="";
          try
          {
          status=da.Execute(qur);
          common.Delta.saveQuery(qur);
          
          }catch(Exception ex)
          {
          status=ex.getMessage();
          }
           
          try
          {
             common.DB.NullifyNum();
             feed f=new feed();
             data dx=new data(f.cof);
            if(b!=null) 
            {     
             if(b.equals("y"))
             {
             dx.Execute("update config.col set num='1' where name='"+id+"' and scope='"+scope+"'");
             common.Delta.saveQuery("update config.col set num='1' where name='"+id+"' and scope='"+scope+"'");
             
             }else
             {
             dx.Execute("update config.col set num='1' where name='"+parent+"' and scope='"+scope+"'");
             common.Delta.saveQuery("update config.col set num='1' where name='"+parent+"' and scope='"+scope+"'");
             
             }
            }else
            {
            dx.Execute("update config.col set num='1' where name='"+PAR+"'");
            common.Delta.saveQuery("update config.col set num='1' where name='"+PAR+"'");
            
            
            }
          }
          catch(Exception nx)
          {
          System.out.print(nx.getMessage());
          }
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Edit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>executing: " +qur+"</h1>");
            out.println("<h1>Status: " +status+"</h1>");
        

            out.println("</body>");
            out.println("</html>");
        }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
