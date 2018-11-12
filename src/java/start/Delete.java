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
 * @author kisa
 */
@WebServlet(name = "Delete", urlPatterns = {"/start/Delete"})
public class Delete extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String confirmed=request.getParameter("confirmed");
            
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
            
            String status="";
            String back="";
            String qur="delete from config.col where ";
            String[] ar={"row","col","element","name","value","parent","scope","type","isel","block"};
            String[] va={row,col,element,name,value,parent,scope,type,isel,block};          
            
                        for(int i=0;i<ar.length;i++)
            {
            
                if(i<ar.length-1)
                {
                    qur=qur+ar[i]+"='"+va[i]+"' and ";
                }else
                {
                qur=qur+ar[i]+"='"+va[i]+"' ";
                
                }
            }
                        
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Delete</title>");  
            out.println("<script type='text/javascript' src='/corefx/app.js'>");  
            out.println("</script>"); 
            out.println("</head>");
            out.println("<body>");
             if(confirmed.equals("n"))
             {
            out.println("<h1>" + qur + "</h1>");
            
             out.println("<form id='slay' method='post'>");       
             out.println("<input type='submit' value='delete' onclick='kill()'/>");  
                          
             out.println("</form>");   
             }else
             {
                 if(confirmed.equals("y"))
                 {
                        feed Feed=new feed();
                        data da=new data(Feed.cof);
                        try
                        {
                        status=da.Execute(qur);
                        common.Delta.saveQuery(qur);
                        
                        out.println("<h1>" + status + "</h1>");
                        back="insert into config.col values('"+row+"','"+col+"','"+element+"','"+name+"','"+value+"','"+parent+"','"+scope+"','"+type+"','"+isel+"','"+block+"',null)";
                        
                        data dat=new data(Feed.cof);
                        String dedtat=dat.Execute("delete from config.query");
                        common.Delta.saveQuery("delete from config.query");
                        
                        out.println("<p>"+dedtat+"</p>");
                        data dam=new data(Feed.cof);
                        
                       
                        String sastat=dam.Execute(qur);
                        common.Delta.saveQuery(qur);
                        
            data dx=new data(Feed.cof);            
            String b="";
            if(block!=null)
            {
            b=block;
            
            
            }
     
             common.DB.NullifyNum();
             dx.Execute("update config.col set num='1' where name='"+parent+"' and scope='"+scope+"'");
             common.Delta.saveQuery("update config.col set num='1' where name='"+parent+"' and scope='"+scope+"'");
                     
                        out.println("<p>"+dedtat+"</p>");
                        }catch(Exception ex)
                        {
                        status=ex.getMessage();
                        }
                 }
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
