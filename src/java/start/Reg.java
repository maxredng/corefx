/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import data.data;
import helper.MailMaker;
import helper.MySimpleMail;
import helper.RandomString;
import helper.Sender;
import html.feed;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Maxkarpov
 */
@WebServlet(name = "Reg", urlPatterns = {"/start/Reg"})
public class Reg extends HttpServlet {
String error;
String regstatus;
String prodstatus;
String cancelstatus;

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Core-Main</title>");   
  
            
            out.println("<META HTTP-EQUIV='Pragma' CONTENT='no-cache'> ");
//            out.println("<style src='miss.css'></style> ");
            out.println("<LINK REL=stylesheet TYPE='text/css' HREF='/corefx/mrs.css'>");
            out.println("<script type='text/javascript' src='/corefx/"+helper.Help.getJSFile(request)+"'></script>");
            out.println("</head>");
            out.println("<body onLoad='on_load()'>");
            
                   HttpSession session=request.getSession();         
                String password="";
                String orderstatus;
                String flow=request.getParameter("flow");
                String orid="";
                String confirmed=request.getParameter("conf");
                String finame=request.getParameter("first");
                String laname=request.getParameter("last");
                String phone=request.getParameter("phone");
                String mail=request.getParameter("email");
                String city=request.getParameter("town");
                String region=request.getParameter("region");
                String street=request.getParameter("street");
                String dom=request.getParameter("dom");
                String app=request.getParameter("appartment");  
                String ord=request.getParameter("ord");
                Object ubj=session.getAttribute("user");
                char doublequote='"';
                String user=null;
                if(ubj!=null)
                {
                user=ubj.toString();
                }else
                {
                user=session.getId();
                }
                String comment=request.getParameter("comment");
                String login="";
                feed f=new feed();
                Locale lan=request.getLocale();
                String lang=lan.getLanguage();
                
                //here i put a stub as far as language hardcoding to ru
                
              //  String lang="ru";
                
                     Date date=new Date();
                     
                     Timestamp ts=new Timestamp(date.getTime());
                     long seed=ts.getTime();
                     String stamp=ts.toString();
                
                if(user.length()>12)
                {
                    if(validateEmail(mail)){
                    login=phone;
                    
                    try
                    {
                    password=RandomString.getString(6);
                    }catch(InterruptedException unex)
                    {
                    error=unex.getMessage();
                    }
                    String requer="insert into prod.ppl values('"+phone+"','"+mail+"','"+finame+"','"+laname+"','"
                   +password+"','"+city+"','"+region+"','"+street+"','"+dom+"','"+app+"','','no','"+stamp+"')";
                    
                    data dat=new data(f.cop);
                    try
                    {
                    regstatus=dat.Execute(requer);
                    common.Delta.saveQuery(requer);
                            
                    
                    char ret='\r';
                    session.removeAttribute("user");
                    session.setAttribute("user", phone);
                    String subj="Успешная регистрация на TheParavoz.ru";
                    String txt="Вы успешно зарегестрировались на сайте TheParavoz.ru. "+ret+" Ваш логин для входа на сайт: "
                    +login+ret+" ваш пароль: "+password+ret+"Спасибо!";
                    
                    if(!lang.equals("ru"))
                    {
                    subj="Successfull registration at TheParavoz.ru";
                    txt="You have successfully registered with TheParavoz.ru."+ret+"Your login name:  "+login
                            +ret+"Your password: "+password+ret+"Thank You!";
                    }
                    if(mail.length()>0)
                    {
                    MySimpleMail.sendTLS(mail, subj, txt);
                    }
                    }catch(Exception rex)
                    {
                    error=rex.getMessage();
                    regstatus="failed: "+error;
                    
                    }
                }
                }else
                {
                phone=user;
                
                
                
                }
                
               

                if(flow.equals("order"))
                {
                    
                    if(phone.length()>3)
                    {
                        String sub=phone.substring(0,3);
                        Date d2=new Date();
                        Timestamp stm=new Timestamp(d2.getTime());
                        long sdi=ts.getTime();     
                        orid=sub+Objects.toString(sdi,null);
                        
                        
                        String uq="update prod.orders set orderid='"+orid+"',personid='"+phone+"',status='new' where personid='"+user+"' and orderid is NULL and amount!='0'";
                        data dup=new data(f.cop);
                        
                        try
                        {
                            if(phone==null)
                            {
                            phone="11111111111";
                            }
                            if(orid==null)
                            {
                            orid="111111111";
                            
                            }
                            
                        orderstatus=dup.Execute(uq);
                        common.Delta.saveQuery(uq);
                        
                        Sender.sendOrder(orid, lang);
                        Sender.sendSeller(orid);
                        response.sendRedirect("/corefx/start/main?scope=confirm&selected="+orid+"&user="+phone);
                       
                        }catch(Exception uex)
                        {
 
                        error=uex.getMessage();
                         response.sendRedirect("/corefx/start/main?scope=error");                       
                        }
                    }
                
                }else
                {
                    if(flow.equals("cancel")&&ord!=null)
                    {
                        
                    if(confirmed!=null)
                    { 
                        if(confirmed.equals("true"))
                        {
                    String caquer="update prod.orders set orderid=NULL,status=NULL where personid='"+user+"' and orderid='"+ord+"'";
                    data dac=new data(f.cop);
                    

                    
                    try
                    {
                    data dop=new data(f.cop);      
                    data dam=new data(f.cop);
                    String qqq="select personid from prod.orders where orderid='"+ord+"'";

                    String ml=dop.pullString(qqq); 
                    
                     String qoq="select email from prod.ppl where phone='"+ml+"'";  
                     
                     String myl=dam.pullString(qoq);
                    cancelstatus=dac.Execute(caquer);
                    common.Delta.saveQuery(caquer);

                    MailMaker maker=new MailMaker(MailMaker.Mail.cancel,ord);
                    maker.send(myl, lang);    
                    response.sendRedirect("/corefx/start/main?scope=magazin&selected=paravoz&dir=1");                   
                    }catch(Exception cex)
                    {
                    error="error cancelling the order";
                    }                    
                    
                        }else
                        {
                        response.sendRedirect("/corefx/start/main?scope=magazin&selected=paravoz&dir=2");
                        }

                    
                    } else
                    {
                    
             out.println("<div class='pmi'>");                   
            out.println(getPiece(lang,"please"));        
                    
             out.println("</div>");      
              out.println('\n');   
              
              String ys=getPiece(lang,"yep");
              
            out.println("<input type='submit' value='"+ys+"' onclick='yes("+doublequote+ord+doublequote+")'>");              
            out.println("<input type='submit' value='"+getPiece(lang,"nope")+"' onclick='nono()'>");             
            
            
            
                    }
                }
                    if(flow.equals("confirmed"))
                    {
                        
                    String mal=getMylo(ord);
                        
                    String conquer="update prod.orders set comment='"+comment+"' where orderid='"+ord+"'";
                    
                    data daqr=new data(f.cop);
                    
                    try
                    {
                    daqr.Execute(conquer);
                    common.Delta.saveQuery(conquer);
                    
                    }catch(Exception cex)
                    {
                    error=cex.getMessage();
                    }
                    
                    
                    MailMaker make=new MailMaker(MailMaker.Mail.confirmed,ord);
                    make.send(mal, lang);
                    
                    
                    response.sendRedirect("/corefx/start/main?scope=magazin&selected=paravoz&dir=3");                    
                    }
                    if(flow.equals("reg"))
                    {
                    response.sendRedirect("/corefx/start/main?scope=magazin&selected=paravoz&dir=reg");                    
                    }
                    if(flow.equals("amend"))
                    {
                        String first = request.getParameter("first");
                        String last = request.getParameter("last");
                        String flat = request.getParameter("app");
                        String bldg = request.getParameter("bldg");
                        String strt = request.getParameter("street");
                        String regn = request.getParameter("region");
                        String town = request.getParameter("city");
                        String post = request.getParameter("postcode");
                        
                        String usr = (String)session.getAttribute("user");
                        
                        String aqur = "update prod.ppl set first='"+first+"',last='"+last+"',app='"+flat+"',bldg='"+
                                bldg+"',street='"+strt+"',region='"+regn+"',city='"+town+"',postcode='"+post+"' where phone='"+session.getAttribute("user")+"'";
                        
                        data daa = new data(f.cop);
                        
                        try
                        {
                        daa.Execute(aqur);
                        common.Delta.saveQuery(aqur);
                        
                        response.sendRedirect("/corefx/start/main?scope=magazin&selected=paravoz");
                        
                        
                        }catch(Exception aa)
                        {
                            System.out.print(aa.getMessage());
                            
                        }
                        
                    }
                    
                
                }
            
        
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    
    String getMylo(String ordd)
    {
    String result="";
    feed f=new feed();
                    data dop=new data(f.cop);      
                    data dam=new data(f.cop);    
    try
    {
                
                    String qqq="select personid from prod.orders where orderid='"+ordd+"'";

                    String ml=dop.pullString(qqq); 
                    
                     String qoq="select email from prod.ppl where phone='"+ml+"'";  
                     
                     result=dam.pullString(qoq);   
    
    
    }catch(Exception ex)
    {
    
    }
    
    return result;
    
    }
    
     String getPiece(String lan,String ar)
    {
        String result="";
        String quer="select descr from prod.fact where id='"+ar+"' and lan='"+lan+"'";
        feed f=new feed();
        data da=new data(f.cop);
        
                    try
            {
                result=da.pullString(quer);
                
            }catch(Exception caex)
            {
                
                error=caex.getMessage();
            }
    return result;
    }
   
    
    boolean validateEmail(String em)
    {
    boolean result=true;
   
    String empat = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    
    
    Pattern pat=Pattern.compile(empat);
    Matcher matcher=pat.matcher(em);
    result=matcher.matches();
    return result;
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
        //processRequest(request, response);
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
