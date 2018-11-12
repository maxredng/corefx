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
@WebServlet(name = "EditIsel", urlPatterns = {"/start/EditIsel"})
public class EditIsel extends HttpServlet {

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
            out.println("<title>Servlet EditIsel</title>");            
            out.println("</head>");
            out.println("<body>");
            
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
            data dat=new data(Feed.cof);
            feed f1=new feed();
            data d1=new data(f1.cof);
            String quer="update config set scema='"+scheme+"', `table`='"+table+"', col='"+col+"', fields='"+fields+"', vals='"+vals+"', colnum="+colnum
                    +", ord='"+order+"' where isel='"+isel+"'";
            
            String quer2= "update config set scema='"+scheme+"', `table`='"+table+"', col='"+col+"', fields='"+fields+"', vals='"+vals+"', colnum="+colnum
                    +", ord='"+order+"' where isel2='"+isel2+"'";
            
            String query="";
            boolean simple=false;
            
            if(isel.equals(""))
            {
            query=quer2;
            
            }else
            {
            query=quer;
            simple=true;
            }
            
                        try
            {
            if(simple){

               String q=dat.pullString("select isel from config.config where scema='"+scheme+"' and `table`='"+table+"' and col='"+col+"'"
                       + " and fields='"+fields+"' and vals='"+vals+"' and colnum="+colnum          
                       );
            
            if(q!=null)
            {
            if(q.length()>0)
            {
                   out.println("<h1> this query already exist, please use isel = '"+q+"'</h1>");                     
                   
            }
            else
            {
                   out.println("<h1>" + d1.Execute(query) + "</h1>");  
                   common.Delta.saveQuery(query);
            
            }
            
            }
                       }
            else
            {
               String q=dat.pullString("select isel2 from config.config where scema='"+scheme+"' and `table`='"+table+"' and col='"+col+"'"
                       + " and fields='"+fields+"' and vals='"+vals+"' and colnum="+colnum          
                       );
            
            if(q!=null)
            {
            if(q.length()>0)
            {
                   out.println("<h1> this query already exist, please use isel2 = '"+q+"'</h1>");                     
                   
            }
            else
            {
                   out.println("<h1>" + d1.Execute(query) + "</h1>");  
                   common.Delta.saveQuery(query);
            
            }
            
            }            
            
            
            }
            }catch(Exception ex1)
            {
                   out.println("<h1>"+ex1.getMessage()+"</h1>");                
            
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
