/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import MyDB.Schema;
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
 * @author maxkarpov
 */
@WebServlet(name = "Jump", urlPatterns = {"/start/Jump"})
public class Jump extends HttpServlet {

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
            out.println("<title>Servlet Jump</title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<h1>Servlet Jump at " + request.getContextPath() + "</h1>");           
            feed f=new feed();
            
            String[] ban={"vars","block","terrain"};
            
            for(int i=0;i<f.schemes.length;i++)
            {
                out.println(Integer.toString(i));
                out.println(f.schemes[i].toString());
            }
            
            for(int i=0;i<f.schemes.length;i++)
            {
                out.println("<h1> db: "+f.schemes[i]+"</h1>");        
                
             
                Schema sc=null;
                try
                {
                    sc=new Schema(f.schemes[i]);
                }catch(Exception sex)
                {
                out.print(sex.getMessage());
                }
                        
            out.println("<h1> db: "+sc.name+"</h1>"); 
            out.println("<h1> creating config db: "+sc.name+"</h1><div>status: "+sc.Create()+"</div>");  
            
                for(int j=0; j<sc.tables.length;j++)
                {
                    if(!common.Com.contains(ban, sc.tables[j].name))
                    {
                        try
                        {
                     out.println("<div> creating table: "+sc.tables[j].name+" status: "+sc.tables[j].CreateTable(sc.con)+"</div>");
                   
                    
                    out.println("<div>filling columns. status: "+sc.tables[j].fill()+"</div>");                             
                        
                        
                        }catch(Exception xex)
                        {
                    out.print(xex.getMessage());
                        }
             
                    
                    
                    }


                }
                
            out.println(" completed setting up: "+f.schemes[i].toString());
            }
            
            
            
            out.println("<h1> creating config db: </h1><div>status: </div>");
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
