/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ogurez.Scenario;
 
/**
 *
 * @author bsati
 */
@WebServlet(name = "Ogurez", urlPatterns = {"/start/Ogurez"})
public class Ogurez extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title></title>");            
//            out.println("</head>");
//            out.println("<body>");
            //String symbol = request.getParameter("symbol");
            String symbol = "VOD.L";
            String venue = request.getParameter("venue");
            String session = request.getParameter("session");
            String capacity = request.getParameter("capacity");
            String side = request.getParameter("sider");
            String type = request.getParameter("typer");
            
            String lm = "";
            double lim = 0; 
            String hover = request.getParameter("hover");
            if(common.Com.isThing(hover))
            {
                lm = request.getParameter("lim");
                lim = Double.parseDouble(lm);
            }else
            {
           // lm = Double.toString(ogurez.Com.getPrice());
            lim = ogurez.Com.getPrice();
            }
            String qty = request.getParameter("qty");
            String tif = request.getParameter("tif");
            String id = request.getParameter("selected");
            
            if(id.equals("N1S0R0C1N5S1R2C0N2S0R0C1N5S1R1C0"))
            {
                System.out.println("here");
            }
            
            Scenario sc = new Scenario(id, symbol,venue,session,capacity,
                    side,type,lim,qty,tif,"no");
            
            sc.getScenario();
            int rem = Integer.parseInt(qty);
            
            for(int i = 0; i<sc.rows.size(); i++)
            {
                String str = sc.rows.get(i);
                
                if(sc.rows.get(i).contains("Part Fill execution report"))
                {
                    rem = rem - 400;
                }
                if(sc.rows.get(i).contains("opposite"))
                {
                    if(isFull(sc.rows,i))
                    {
                        str = str.replace(" for qty 1200", " for qty " + Integer.toString(rem));
                    }
                }                
 
                
                out.println(str);
//                out.println('\n');
            
            }
            
            
//            out.println("</body>");
//            out.println("</html>");
        }
    }
    
    boolean isFull(List<String> s, int n)
    {
        boolean result = false;
        
            for(int i = n; i<s.size(); i++)
            {
                String line = s.get(i);
                if(line.contains("reject"))
                {
                    break;
                }
                if(line.contains("Part Fill"))
                {
                    break;
                }
                if(line.contains("Full Fill"))
                {
                    result = true;
                    break;
                }                
            }
    
        return result;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
