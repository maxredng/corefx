/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import data.data;
import ecrivus.help;
import html.feed;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


//import org.apache.tomcat.util.http.fileupload.FileItem;
//import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author kisa
 */
@WebServlet(name = "Upload", urlPatterns = {"/start/Upload"})
public class Upload extends HttpServlet {

   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 400 * 1024;
   private int maxMemSize = 100 * 1024;
   private File file ;
   
         public void init( ){
      // Get the file location where it would be stored.
      filePath = 
             getServletContext().getInitParameter("file-upload"); 
   }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Upload</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Upload at " + request.getContextPath() + "</h1>");
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
   //     processRequest(request, response);
        
              isMultipart = ServletFileUpload.isMultipartContent(request);
      response.setContentType("text/html");
      java.io.PrintWriter out = response.getWriter( );
      if( !isMultipart ){
         out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");  
                out.println("<script type='text/javascript' src='/corefx/app.js'>");  
                out.println("</script>"); 
                out.println("</head>");
         out.println("<body>");
         out.println("<p>No file uploaded</p>"); 
         out.println("</body>");
         out.println("</html>");
         return;
      }

        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxFileSize);
        factory.setRepository(new File("c:\\NetBeans\\temp"));
        ServletFileUpload upload=new ServletFileUpload(factory);
        upload.setFileSizeMax(maxFileSize);
        upload.setHeaderEncoding("UTF-8");
        try
        {
        List fileItems = upload.parseRequest(request);
        Iterator i = fileItems.iterator();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");  
                out.println("<script type='text/javascript' src='/corefx/menu.js'>");  
                out.println("</script>"); 
                out.println("</head>");
                out.println("<body>");
                String url = help.getURL(request);
                String title="";
                
                File fl=new File("temp.jpg");
                
              while ( i.hasNext () ) 
      {
         FileItem fi = (FileItem)i.next();
         if ( !fi.isFormField () )	
         {
            // Get the uploaded file parameters
            String fieldName = fi.getFieldName();
            String fileName = fi.getName();
            String contentType = fi.getContentType();
            boolean isInMemory = fi.isInMemory();
            long sizeInBytes = fi.getSize();
            // Write the file
            if( fileName.lastIndexOf("\\") >= 0 ){
               file = new File( filePath + 
               fileName.substring( fileName.lastIndexOf("\\"))) ;
            }else{
               file = new File( filePath + 
               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
            }
            fi.getInputStream();
            fi.write( fl ) ;
           // out.println("Uploaded Filename: " + fileName + "<br>");
         }else
         {
         String tit=fi.getString();
         title=tit;
         }
      }

              feed f=new feed();
              data da=new data(f.cop);
              title = request.getParameter("id");
             // String kostyl=request.getSession().getAttribute("user").toString();
              String kostyl="";
              out.println("status saving to db: "+da.ExecuteBin(title, fl,kostyl));
              out.println("<form name='imgform'>");
              out.println("<input type='submit' value='admin' onclick='javascript:toadmin()'/>");
              out.println("<input type='submit' value='prod' onclick='topro()'/>");
              out.println("</form>");
      out.println("</body>");
      out.println("</html>");
          
                
                
        }
        
        catch(Exception ex)
        {
        
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");  
                out.println("<script type='text/javascript' src='/corefx/menu.js'>");  
                out.println("</script>"); 
                out.println("</head>");
                out.println("<body>");
                 out.println(ex.getMessage());
              out.println("<form name='imgform'>");
              out.println("<input type='submit' value='admin' onclick='javascript:navigate("+help.getURL(request)+")'/>");
 
              out.println("</form>");
                out.println("</body>");
                out.println("</html>");
        }
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
