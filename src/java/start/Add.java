/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import data.data;
import html.feed;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;
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
@WebServlet(name = "Add", urlPatterns = {"/start/Add"})
public class Add extends HttpServlet {

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
    
    private String decod(String str)
    {
    String re="";
    
   re=str.replace("ZZ", "#");
    return re;
    }
    
    
    public feed Feed=new feed();
    public String error="";
    public String ID="";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session=request.getSession();
        String user=session.getAttribute("user").toString();
        String b="";
        String p="";
        String num=null;
        
        try {
            
//            if(user.length()>0&user.length()<12)
            
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
            p=parent;
            String qur="";
             
            if(type!=null)
            {
            try
            {
            common.DB.NullifyNum();
            }catch(Exception nx)
            {
            System.out.print(nx.getMessage());
            }
            
            if(b.equals("y"))
            {
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                num=ts.toString();
                
            }
          
            
            if(num!=null)
            {
            qur="insert into config.col values('"+row+"','"+col+"','"+element+"','"+name+"','"+value+"','"+parent+"','"+scope+"','"+type+"','"+isel.replace("ZZ", "#") +"','"+block+"','"+num+"')";
            }else
            {
            qur="insert into config.col values('"+row+"','"+col+"','"+element+"','"+name+"','"+value+"','"+parent+"','"+scope+"','"+type+"','"+isel.replace("ZZ", "#") +"','"+block+"','"+num+"')";
            }
                
            }else
            {
            String winprod=request.getParameter("winprod");
            
            if(winprod==null)
            {
            String Id=request.getParameter("v0");
            ID=Id;
            String cat=request.getParameter("v1");
            String catpres=request.getParameter("v2");
            String par=request.getParameter("v3");
            String desc=request.getParameter("v6");
            String pardesc=request.getParameter("v4");
            String lan=request.getParameter("v5");     
            
           
            qur="insert into prod.fact values('"+Id+"','"+cat+"','"+catpres+"','"+desc+"','"+par+"','"+num+"','"+lan+"','1')";
            }else
            {
            String title=request.getParameter("id");
            ID=title;
            String wid=request.getParameter("title");
            String descr=request.getParameter("descr");
            String price=request.getParameter("price");
            String avail=request.getParameter("avail");
            String series=request.getParameter("series");
            String cat=request.getParameter("category");
            String pres=request.getParameter("catpres");
            String par=request.getParameter("parent");
            String pardes=num;
            Locale loc=request.getLocale();
            String lan=loc.getLanguage();
            
            
            
            
            qur="insert into prod.fact values('"+wid+"','"+cat+"','"+pres+"','"+title+"','"+par+"','"+num+"','"+lan+"','1')";
            
            String desquer=common.Com.getInsertQuery(wid, "description", descr, pardes, lan);
            String avaquer=common.Com.getInsertQuery(wid, "avail", avail, pardes, lan);      
            String serquer=common.Com.getInsertQuery(wid, "series", series, pardes, lan);            
            String priquer=common.Com.getInsertQuery(wid, "price", price, pardes, lan);            
            
            
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
            
            
            }
            }
            feed Feed=new feed();
            data da=new data(Feed.cof);
            String status="";
            
            try
            {
            status=da.Execute(qur);
            common.Delta.saveQuery(qur);
            if(b!=null)
            {
                                if(b.equals("n"))
                    {
                    feed f=new feed();
                        if(p.length()>0)
                        {
                        data dan=new data(f.cof);
                        dan.Execute("update config.col set num='1' where name='"+parent+"' and scope='"+scope+"'");
                        common.Delta.saveQuery("update config.col set num='1' where name='"+parent+"' and scope='"+scope+"'");
                        }
                    }
            }else
            {
                 data dn=new data(Feed.cof);
                 try
                 {
                     common.DB.NullifyNum();
                     dn.Execute("update config.col set num='1' where name='"+ID+"'");
                     common.Delta.saveQuery("update config.col set num='1' where name='"+ID+"'");
                     
                 }catch(Exception exn)
                 {
                     error=exn.getMessage();
                 }
                     
                
            
            }
            }catch(Exception ex)
            {
            status=ex.getMessage();
            }
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Edit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>executing: " + qur +"</h1>");
            out.println("<h1>" + status +"</h1>");
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
