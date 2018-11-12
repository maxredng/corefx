/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import html.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maxkarpov
 */
@WebServlet(name = "query", urlPatterns = {"/start/query"})
public class query extends HttpServlet {

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
            out.println("<title>Servlet query</title>");            
            out.println("</head>");
            out.println("<body>");
            String isl=request.getParameter("isel");            
            String row=request.getParameter("row");
            String col=request.getParameter("col");            
            String element=request.getParameter("element");            
            String name=request.getParameter("name");            
            String value=request.getParameter("value");
            String scope=request.getParameter("scope");            
            String type=request.getParameter("type");            
            String block=request.getParameter("block");  
            String parent=request.getParameter("parent");              
            String boss="boss";
            
            tag t=new tag();
            param par=new param("lan","ru");
            
            feed f=new feed();
            config conf=null;
            try
            {
            conf=new config(f.cof);
            }catch(Exception ex)
            {
            }
            
            t.Feed=f;
            t.isel=isl;
            t.line=row;
            t.col=col;
            t.Element=element;
            t.name=type;
            t.value=value;
            t.scope=scope;
            t.id=name;
            t.boss=boss;
            t.parent=parent;
            
            param p=new param("config",conf);
            f.addParameter(p);
            querystring q=new querystring(t,"isel");
            
            String fs="<p>";
            String fe="</p>";
            
            
            out.println("<h1>" + fs+q.query+fe + "</h1>");
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
