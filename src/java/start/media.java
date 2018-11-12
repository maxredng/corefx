/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import data.data;
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

/**
 *
 * @author Maxkarpov
 */
@WebServlet(name = "media", urlPatterns = {"/start/media"})
public class media extends HttpServlet {

   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 1000 * 1024;
   private int maxMemSize = 1000 * 1024;
   private File file ;
   feed Feed = new feed();
            public void init( ){
      // Get the file location where it would be stored.
      filePath = 
             getServletContext().getInitParameter("file-upload"); 
   }
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet media</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet media at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String title = request.getParameter("id");
        String category = request.getParameter("cat");
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
              
                String path = getServletContext().getRealPath("/");
                File dr = new File(path);
                File dir = dr.getParentFile();
                File door = dir.getParentFile();
                File fl=new File(door.getAbsolutePath()+"\\web\\voice\\"+title+".mp3");
                
              while ( i.hasNext () ) 
      {
         FileItem fi = (FileItem)i.next();
         if ( !fi.isFormField () )	
         {
            // Get the uploaded file parameters
            String currentDir = System.getProperty("user.dir");
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
            out.println("<div>success!</div>");
            out.println("</body>");
            out.println("</html>");
          String username = request.getParameter("username");
          String use = (String)request.getSession().getAttribute("user");
          String gender = request.getParameter("gender");
          String first = request.getParameter("first");        
          String last = request.getParameter("last");     
          String lan = request.getParameter("lan"); 
          String pat = "/corefx/voice/"+title+".mp3";
          String lang = request.getLocale().getLanguage();
          String quv = "insert into prod.voice values ('"+username+"','"+use+"','"+gender
                  +"','"+first+"','"+last+"','"+lan+"',null)";
          String qum = "insert into prod.media values('"+title+"','"+username+"','"+use+"','"+category+"','"+pat+"')";    
          String qup = "insert into prod.fact values('"+category+"','','','"+category+"','','','"
                  +lang+"','1')";
          data duq = new data(Feed.cop);
          data dum = new data(Feed.cop);
          data dup = new data(Feed.cop);
          duq.Execute(quv);
          dum.Execute(qum);
          dup.Execute(qup);
          
          response.sendRedirect("/corefx/start/main?scope=media");
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
              out.println("<input type='submit' value='admin' onclick='javascript:toadmin()'/>");
              out.println("<input type='submit' value='prod' onclick='javascript:topro()'/>");
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
