/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import data.data;
import html.feed;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maxkarpov
 */
@WebServlet(name = "AddIsel", urlPatterns = {"/start/AddIsel"})
public class AddIsel extends HttpServlet {

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
    
    boolean unique;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddIsel</title>");            
            out.println("</head>");
            out.println("<body>");
            String complex = request.getParameter("complex");
            String isel=request.getParameter("isel");
            String scheme=request.getParameter("scheme");
            String table=request.getParameter("table");            
            String col=request.getParameter("col");     
            String fields=request.getParameter("fields");
            String vals=request.getParameter("vals"); 
            String colnum=request.getParameter("colnum");            
            String order=request.getParameter("order");        
            String isel2=request.getParameter("isel2");      
            feed Feed=new feed();
            boolean isComplex = false;
            data dat=new data(Feed.cof);
            
            try
            {
            if(isel!=null&!isel.equals(""))
            {
                String isl=dat.pullString("select isel from config.config where isel='"+isel+"'");
            
                if(isl.equals(isel))
                {
                out.println("<h1>isel "+isel+" already exists. please try another one</h1>");                
                unique=false;                
                }else
                {
                unique=true;
                }
            
            }else
            {
            
            
            unique=true;
            
            }
            
            
            }catch(Exception ex)
            {
                   out.println("<h1>"+ex.getMessage()+"</h1>");         
            
            }
            
            feed f1=new feed();
            data d1=new data(f1.cof);
            try
            {
            if(unique){

               String q=d1.pullString("select isel from config.config where scema='"+scheme+"' and `table`='"+table+"' and col='"+col+"'"
                       + " and fields='"+fields+"' and vals='"+vals+"' and colnum="+colnum          
                       );
            
            if(q!=null)
            {
            if(q.length()>0)
            {
                   out.println("<h1> this query already exist, please use isel = '"+q+"'</h1>");                     
                   unique=false;
            }
            
            }
                       }
            }catch(Exception ex1)
            {
                   out.println("<h1>"+ex1.getMessage()+"</h1>");                
            
            }   
            
            feed f2=new feed();
            data d2=new data(f2.cof);
            data dc = new data(f2.cof);
            try
            {
                if(unique)
                {

                    if(isel!=null&!isel.equals(""))
                    {
String stat=d2.Execute("insert into config.config values('"+isel+"','"+scheme+"','"+table+"','"+col+"','"+fields+"','"+vals+"',"+colnum+",'"+order+"',"+null+")");               
common.Delta.saveQuery("insert into config.config values('"+isel+"','"+scheme+"','"+table+"','"+col+"','"+fields+"','"+vals+"',"+colnum+",'"+order+"',"+null+")");

if(common.Com.isThing(complex))
{
    dc.Execute("insert into config.config values(null,'config','col','*','parent,block','id,y',9,'row,col','"+isel+"')");
    common.Delta.saveQuery("insert into config.config values(null,'config','col','*','parent,block','id,y',9,'row,col','"+isel+"'");
}
out.println("<h1>"+stat+"</h1>");                     
                    }else
                    {
String stat=d2.Execute("insert into config.config values("+null+",'"+scheme+"','"+table+"','"+col+"','"+fields+"','"+vals+"',"+colnum+",'"+order+"','"+isel2+"')");               
common.Delta.saveQuery("insert into config.config values("+null+",'"+scheme+"','"+table+"','"+col+"','"+fields+"','"+vals+"',"+colnum+",'"+order+"','"+isel2+"')");
out.println("<h1>"+stat+"</h1>");                     
                    }
                  
                
                }
            
            
            }catch(Exception ex2)
            {
            
            
            }            
            //out.println("<h1>Servlet AddIsel at " + request.getContextPath() + "</h1>");
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
