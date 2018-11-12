package start;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Blob;
import data.connection;
import data.data;
import html.feed;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author kisa
 */
@WebServlet(name = "img", urlPatterns = {"/start/img"})
public class img extends HttpServlet {

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
        response.setContentType("image/jpeg");
        String id=request.getParameter("id");
        Blob photo=null;
        //PrintWriter out = response.getWriter();
        OutputStream out=response.getOutputStream();
        try {

            connection cop=new connection(MyDB.Schema.schema.prod);
            
            feed Feed=new feed();
            data da=new data(cop);
            String query="select image from "+cop.name+".img where id='"+id+"'";
            try
            {
            photo=da.pullBlob(query);
            }catch(Exception ex)
            {
                System.out.println(ex.toString());
            }
            try
            {
                
            InputStream in = photo.getBinaryStream();
            int length = (int) photo.length();

            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];

            while ((length = in.read(buffer)) != -1) 
            {
                System.out.println("writing " + length + " bytes");
                out.write(buffer, 0, length);
            }
            
            in.close();
            out.flush();
            }catch(SQLException ee)
            {}
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
        
          String id=request.getParameter("id");
        processRequest(request, response);
    }

   
    
    
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
