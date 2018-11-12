/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import data.data;
import html.config;
import html.feed;
import html.param;
import html.table;
import html.tag;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "proup", urlPatterns = {"/start/proup"})
public class proup extends HttpServlet {

 String status="";
 String error="";
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Save</title>");      
            out.println("<script type='text/javascript' src='/corefx/saved.js'></script>");
            out.println("</head>");
            out.println("<body>");

            HttpSession session=request.getSession();
            if(session.getAttribute("user")!=null)
            {
            String back=request.getParameter("back");
            String st[]={"0","0","0","main","0","root","proup","table","n"};  
            String er[]={"1","0","0","err","0","main","proup","table","n"}; 
            Locale loc=request.getLocale();
            String lang=loc.getLanguage();
            feed fd=new feed();
                        config conf=new config();
            if(session.getAttribute("config")==null)
            {
            try
            {
            conf=new config(fd.cof);
            }catch(Exception x)
            {}
            session.setAttribute("config", conf);
            
            }
            param con=new param("config",session.getAttribute("config"));
            param lan=new param("language",lang);
            fd.addParameter(con);
            fd.addParameter(lan);
            if(back.equals("profile"))
            {
//    var v0=document.getElementById("textemail2").value;
//    var v1=document.getElementById("textfirst").value;
//    var v2=document.getElementById("textlast").value;
//    var v3=document.getElementById("textcountry").value;
//    var v4=document.getElementById("textcity").value;
//    var v5=document.getElementById("textphone").value;
                String[] ar={"email2","first","last","country","city","phone"};
                String[] v={"v0","v1","v2","v3","v4","v5"};
                String query="update prod.people set ";
                for(int i=0;i<v.length;i++)
                {
                    String val=request.getParameter(v[i]);
                    
                    if(val!=null)
                    {
                        query=query+ar[i]+"='"+val+"', ";
                    
                    }
                
                }
                        
                query=query.substring(0,query.length()-2);
                String qry=query+" where email='"+(String)session.getAttribute("user")+"'";
                data da=new data(fd.cop);
                try
                {
                    status=da.Execute(qry);
                    common.Delta.saveQuery(qry);
                }
                catch(Exception ex)
                {
                    error=ex.getLocalizedMessage();
                }
                
                
            }
                
                    table t=new table(st,fd);
                    t.boss=status;
                    
                    table r=new table(er,fd);
                    r.boss=error;
            out.println(t.getCode());
            out.println(r.getCode());
            
            
            }
            out.println("</body>");
            out.println("</html>");
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
