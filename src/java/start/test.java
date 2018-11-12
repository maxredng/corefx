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

/**
 *
 * @author bsati
 */
@WebServlet(name = "test", urlPatterns = {"/start/test"})
public class test extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String getCat(String s)
    {
        String result = null;
            
            String[] tab = {"venue","capacity","session","type","tif","maxfloor"};
            feed f = new feed();
            for(int i = 0; i<tab.length; i++)
            {
                String tb = tab[i];
                String qr = "select " + tb + " from bank." + tb + " where " + tb + "='" + s + "'";
                data d = new data(f.bank);
                String vl = "";
                try
                {
                    vl = d.pullString(qr);
                
                }
                catch(Exception ex)
                {}
            
                if(vl.equals(s))
                {
                     if(s.equals("Market"))
                     {
                         result = "type";
                         break;
                     }else
                     {
                         result = tb;
                         break;
                     }
                }
            }
            
            
        return result;
    }
    
    String getCategory(String s)
    {
        String result = "";
     //    var ids = ["BATS","BATS_LIS","XETRA","agency","principal","riskless",
     //"close_auction","market","open_auction","Limit","Market","CLOSE",
     //"Day","GTC","GTD","IOC","OPG","no","yes"];
   
        switch(s)
        {
            case "BATS":
            {
                result = "venue";
                break;
            }
             case "BATS_LIS":
            {
                result = "venue";
                break;
            }      
            case "XETRA":
            {
                result = "venue";
                break;
            }   
            
            case "agency":
            {
                result = "capacity";
                break;
            }   
            
          case "principal":
            {
                result = "capacity";
                break;
            }   
         case "riskless":
            {
                result = "capacity";
                break;
            }   
                
            case "open_auction":
            {
                result = "session";
                break;
            }   
            
             case "market":
            {
                result = "session";
                break;
            }   
             case "close_auction":
            {
                result = "session";
                break;
            }   
             case "Limit":
            {
                result = "type";
                break;
            }   
             case "Market":
            {
                result = "type";
                break;
            }   
             case "CLOSE":
            {
                result = "tif";
                break;
            }   
             case "OPG":
            {
                result = "tif";
                break;
            }   
             case "IOC":
            {
                result = "tif";
                break;
            }   
             case "Day":
            {
                result = "tif";
                break;
            }   
             case "GTC":
            {
                result = "tif";
                break;
            }   
             case "GTD":
            {
                result = "tif";
                break;
            }   
             case "FOK":
            {
                result = "tif";
                break;
            }   
             case "yes":
            {
                result = "maxfloor";
                break;
            }           
             case "no":
            {
                result = "maxfloor";
                break;
            }             
        }
    
        return result;
    }
    
    
    List<String[]> getMap(HttpServletRequest request)
    {
        List<String[]> result = new ArrayList<>();
    
            for(int i = 0; i<20; i++)
            {
                String key = "ar" + Integer.toString(i);
                String val = request.getParameter(key);
                
                if(common.Com.isThing(val))
                {
                    String name = getCat(val);
                    String[] temp = {name,val};
                    result.add(temp);
                }
            }
        
        return result;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");            
            out.println("</head>");
            out.println("<body>");
            String suite = request.getParameter("suite");
            String test = request.getParameter("test");
            feed f = new feed();
            String sall = request.getParameter("saveall");
            
                    if(!common.Com.isThing(sall))
                    {
                        List<String[]> l = new ArrayList<>(); 

                        l = getMap(request);

                        String qur = "select * from bank.dimensions where ";

                        String venor = getOr(l,"venue");
                        String capor = getOr(l,"capacity");
                        String sesor = getOr(l,"session");
                        String typor = getOr(l,"type");
                        String tifor = getOr(l,"tif");
                        String maxor = getOr(l,"maxfloor");

                        String[] sb = {venor,capor,sesor,typor,tifor,maxor};

                        for(int i = 0; i<sb.length; i++)
                        {
                            if(sb[i].contains(" or "))
                            {
                            qur = qur + " (" + sb[i] + ")";
                            }else
                            {
                            qur = qur + " " + sb[i];
                            }

                            if(i<sb.length - 1)
                            {
                                qur = qur + " and ";

                            }

                        }

                        List<String[]> tab = new ArrayList<>();

                        
                        data da = new data(f.bank);

                        try
                        {
                        tab = da.pullTable(qur, 7);

                        }
                        catch(Exception ex)
                        {}



               for(int i = 0; i<tab.size(); i++)
               {
            //| dimid    | varchar(100) | YES  |     | NULL    |       |
            //| capacity | varchar(100) | YES  |     | NULL    |       |
            //| venue    | varchar(100) | YES  |     | NULL    |       |
            //| session  | varchar(100) | YES  |     | NULL    |       |
            //| type     | varchar(100) | YES  |     | NULL    |       |
            //| tif      | varchar(100) | YES  |     | NULL    |       |
            //| maxfloor | varchar(100) | YES  |     | NULL    |  


               String[] temp = tab.get(i);

               String id = temp[0];
               String venue = temp[2];
               String capacity = temp[1];
               String session = temp[3];
               String type = temp[4];
               String tif = temp[5];
               String maxfloor = temp[6];
               String space = "   ";
               String toshow = "<td><input id = '" + id + "' type='checkbox' checked/></td><td><div>" + space + venue + space + capacity + space + session + space + type + space + tif + space + maxfloor +space + Integer.toString(i) + "</div></td>";
               out.println("<table>");
               out.println("<tr>");
               out.println(toshow);
               out.println("</tr>");
               out.println("</table>");                      
                    
               }
            
                    }else
                    {
                       List<String> lo = new ArrayList<>();
                        for(int i = 0; i<756; i++)
                        {
                            String vl = request.getParameter("el" + Integer.toString(i));
                            
                            if(common.Com.isThing(vl))
                            {
                            lo.add(vl);
                            }
                        
                        
                        
                        }
                        
                        for(int i = 0; i<lo.size(); i++)
                        {
                            String qd = "select * from bank.dimensions where dimid='" + lo.get(i) + "'";
                            data dad = new data(f.bank);
                            
                            try
                            {
                                List<String[]> ltm = new ArrayList<>();
                                ltm = dad.pullTable(qd, 7);
                                
                                if(ltm.size()>0)
                                {
                                    String[] temp = ltm.get(0);
                                    
//                                    String venue = temp[2];
//                                    String capacity = temp[1];
//                                    String session = temp[3];
//                                    String type = temp[4];
//                                    String tif = temp[5];
//                                    String maxfloor = temp[6];

                                                                          String venue = temp[2];
                                    String capacity = temp[1];
                                    String session = temp[3];
                                    String type = temp[4];
                                    String tif = temp[5];
                                    String maxfloor = temp[6];
                                    
   String g1 = "select testid from bank.test where testid='" + test + "' and suite='" + suite + "' and venue = '" + venue + "' and capacity='" + capacity + "' and session='"
           + session + "' and type='" + type + "' and tif='" + tif + "' and maxfloor='" + maxfloor + "'";
   
   data da1 = new data(f.bank);
   data dai = new data(f.bank);
   data da2 = new data(f.bank);
   String exist = null;
   int max = -1;
   try
   {
        exist = da1.pullString(g1);
        max = dai.pullInt("select max(setid) from bank.test");
        max = max + 1;
   
   }
   catch(Exception ex)
   {}
   
   if(!common.Com.isThing(exist))
   {
   
   String q2 = "insert into bank.test values('"+ test + "','" + venue + "','" + capacity + "','" + session + "','" + type + "','" + tif + "','" + maxfloor + "'," + max + ",'" + suite +"')";
   
   try
   {
        da2.Execute(q2);
        
   }
   catch(Exception hex)
   {}
   
   
   
   }                                        
                                
                                }
                                
                                
                                
                            }catch(Exception x)
                            {
                            
                            }
                        
                        }
               
                    response.sendRedirect("/corefx/start/main?scope=terminate&area=top");
                    }


   
   
   
   
   
   
  
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    String getOr(List<String[]> l,String ar)
    {
        String result = "";
        List<String[]> sub = new ArrayList<>();
            for(int i = 0; i < l.size(); i++)
            {
                String[] temp = l.get(i);
                String val = temp[1];
                String key = getCat(val);
                
                if(key.equals(ar))
                {
                String[] line = {key,val};
                sub.add(line);
                }
                
          
            }
    
            for(int j = 0; j<sub.size(); j++)
            {
                if(j<sub.size()-1)
                {
                    result = result + sub.get(j)[0] + "=" + "'" + sub.get(j)[1] + "' or ";
                }else
                {
                result = result + sub.get(j)[0] + "=" + "'" + sub.get(j)[1] + "'";
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
