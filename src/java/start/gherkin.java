/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import data.data;
import html.feed;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ogurez.Flow;
import ogurez.Scenario;

/**
 *
 * @author bsati
 */
@WebServlet(name = "gherkin", urlPatterns = {"/start/gherkin"})
public class gherkin extends HttpServlet {

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
//            out.println("<title>Servlet gherkin</title>");            
//            out.println("</head>");
//            out.println("<body>");
            
            feed f = new feed();
            

            
            
            String suite = request.getParameter("suite");
            String side = request.getParameter("side");
            String q1 = "select venue,capacity,session,type,tif,maxfloor,testid from bank.test where suite='" + suite + "'";
            List<String[]> tab = new ArrayList<>();
            data da = new data(f.bank);
            //venue    | capacity  | session | type   | tif  | maxfloor
            try
            {
                tab = da.pullTable(q1, 7);
            }
            catch(Exception x)
            {}            
            {    
            for(int i = 0; i<tab.size(); i++)
            {
                String[] temp = tab.get(i);
                String Symbol = "VOD.L";
                String venue = temp[0];
                String capacity = temp[1];
                String session = temp[2];
                String type = temp[3];
                String tif = temp[4];
                String maxfloor = temp[5];
                String test = temp[6];
                String qty = "1200";
                
                // Limit has got to be pulled by API going forward
                double lmt = ogurez.Com.getPrice();
                Scenario sc = new Scenario(test, Symbol,venue,session,capacity,
                    side,type,lmt,qty,tif,maxfloor);
                 
                sc.getScenario();
                out.println();
                out.println();
                out.println("Scenario: " + ogurez.Flow.getScenarioName(test) +" dimensions: " + venue + " " + capacity + " " + session + " " + 
                        type + " " + tif + " " + side);
                out.println();
                
                if(test.equals("N1S0R0C1N5S1R2C0N2S0R0C1N5S1R1C0"))
                {
                    System.out.println();
                }
                int rem = Integer.parseInt(qty);
                for(int j = 0; j<sc.rows.size(); j++)
                {
                    String str = sc.rows.get(j);
                     
                if(sc.rows.get(j).contains("Part Fill execution report"))
                {
                    rem = rem - 400;
                }
                if(sc.rows.get(j).contains("opposite"))
                {
                    if(isFull(sc.rows,j))
                    {
                        str = str.replace(" for qty 1200", " for qty " + Integer.toString(rem));
                    }
                }                     
                    out.println(str);
                
                
                }
            
            }
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
