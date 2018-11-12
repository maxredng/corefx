package start;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import data.data;
import html.feed;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shapes.Block;

/**
 *
 * @author Maxkarpov
 */
@WebServlet(name = "Cell", urlPatterns = {"/start/Cell"})
public class Cell extends HttpServlet {

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
//        PrintWriter out = response.getWriter();
//        try {
//            /*
//             * TODO output your page here. You may use following sample code.
//             */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Cell</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Cell at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }
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

String error="";

public void vangog(Graphics2D g,Block bl)
{

  
    
    
  for(int i=0;i<bl.rivers.size();i++)
  {
      bl.rivers.get(i).setRoad();
  }
 // bl.rivers.clear();

  
  for(int i=0;i<bl.lakes.size();i++)
  {
      bl.lakes.get(i).setLake();
  }
//  bl.lakes.clear();
  
    for(int i=0;i<bl.hills.size();i++)
  {
      bl.hills.get(i).setHill();
  }
  
 // bl.hills.clear();
  
  
      for(int i=0;i<bl.roads.size();i++)
  {
      bl.roads.get(i).setRoad();
  }

      
      
      

}

@Override
 protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
     float[] flo={0,153,0};
     Color col=new Color(0,153,0);
     
     
  BufferedImage image = new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB); // 123 wide, 123 tall
  Graphics2D g = image.createGraphics();
  g.setColor(col);
  String region=req.getParameter("re");
  String X=req.getParameter("y");
  int left=Integer.parseInt(X);
  
  String Y=req.getParameter("x");  
  
  int top=Integer.parseInt(Y);
  
  
    
g.fill3DRect(0, 0, 140, 140, true);

if("3999x4000".equals(Y+"x"+X))
{
//System.out.println();
}


  feed f=new feed();
  data da=new data(f.cop);
  
  String name="x="+X+"&y="+Y+"&re="+region;
  String nm="";
  try
  {
  nm=da.pullString("select id from prod.img where id='"+name+"'");
  }catch(Exception exx)
  {
  error=exx.getMessage();
  }
  
//  if(!nm.equals(name))
//  {   
    Block bl=new Block(g, region,X,Y);
    vangog(g,bl);
    
      
  response.setContentType("image/jpeg");
  OutputStream outputStream = response.getOutputStream();
  ImageIO.write(image, "jpeg", outputStream);
  outputStream.close();
  
//  ByteArrayOutputStream bs=new ByteArrayOutputStream();
//  
//  ImageIO.write(image, "jpeg", bs);
//  InputStream ips=new ByteArrayInputStream(bs.toByteArray());
//  
//  try
//  {
//     data dat=new data(f.cop);
//      
//     dat.ExecuteBin(name, ips);
//      
//      
//  }
//  catch(Exception sx)
//  {
//  
//  error=sx.getMessage();
//  }
  
//  }else
//  {
//      
//  data dat=new data(f.cop);
//  
//  Blob photo=null;
//  
//  try
//  {
//      photo=dat.pullBlob("select image from prod.img where id='"+name+"'");
//  
//  }catch(Exception bx)
//  {
//  error=bx.getMessage();
//  
//  }
//  
//  InputStream streem=null;
//  try
//  {
//  streem=photo.getBinaryStream();
//  
//  int length = (int) photo.length();
//
//            int bufferSize = 1024;
//            byte[] buffer = new byte[bufferSize];
//                OutputStream out=response.getOutputStream();
//            while ((length = streem.read(buffer)) != -1) 
//            {
//
//                System.out.println("writing " + length + " bytes");
//                out.write(buffer, 0, length);
//                
//            }
//            streem.close();
//            out.close();
//  
//  }catch(Exception ix)
//  {
//      error=ix.getMessage();
//  
//  }
//  }
 
  g.dispose();
  
 

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
 
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
