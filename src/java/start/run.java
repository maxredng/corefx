/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import Steamer.Profile;
import data.BlockTab;
import data.ColTab;
import data.ConTab;
import data.aaa;
import data.data;
import helper.Basket;
import helper.Starter;
import html.Post;
import html.Verify;
import html.attribute;
import html.config;
import html.feed;
import html.param;
import html.reg;
import html.tag;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.json.JsonException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import static start.main.getBaseUrl;

/**
 *
 * @author Maxkarpov
 */
@WebServlet(name = "run", urlPatterns = {"/start/run"})
public class run extends HttpServlet {

    public String sel="";
    public String pgo="0";
    public String lang="";
    public String user="";
    public String pass="";
    public String username;
    public String view="welcome";
    public String viewname="";
    public String error="";
    public String cell="";
    public String mysid;
    public String scope;
    public aaa au;
    Profile profile;
    boolean notyet=true;
    feed fd=new feed();    
    String openIDDelimeter = "openid%2Fid%2F";
    boolean nocalc;
    String path;
    String s="";
    feed Feed=new feed();
    List<String[]> newstuff=new ArrayList<String[]>();
    
    public List<String> slc=new ArrayList<String>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String recal=request.getParameter("recalc");
        try {
            
            try
            {
            {
            /* TODO output your page here. You may use following sample code. */
       out.println("<!doctype html>");
                
            out.println("<html>");
            out.println("<head>");
            out.println("<title>RedHotPage.COM</title>");   
  
            fd.params.clear();

            out.println("<META HTTP-EQUIV='Pragma' CONTENT='no-cache'> ");

            out.println("<LINK REL=stylesheet TYPE='text/css' HREF='/corefx/mrs.css'>");
            out.println("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>");
            out.println("<script type='text/javascript' src='/corefx/"+helper.Help.getJSFile(request)+"'></script>");

            out.println("</head>");
            out.println("<body onLoad='on_load()' onmousemove='moveme(event)'>");
            HttpSession session=request.getSession();
            String exit=request.getParameter("exit");            
            Starter starter;
            String testscope=request.getParameter("scope");
            

            

            starter = new Starter(request,true);
            
            starter.addCol();
            starter.addConfig();

            if(starter.isThing("isel"))
            {
                System.out.println("isel");
            
            }
            username=null;
            user=null;


//start of auth block
                  String usr = (String)session.getAttribute("user");          
            if(session.getAttribute("user")==null||usr.length()>25)
            {

                
            user=request.getParameter("lin");
            pass=request.getParameter("pin");        
            
            if(user!=null&&pass!=null)
            {
                
       
            
            session.removeAttribute("user");
            starter.Feed.removeValue("user");
            au=new aaa(user,pass);
            
            if(au.logged)
            {
                
            username=user;
            session.setAttribute("user", username);
            String adm="";
            
            if(au.admin)
            {
   //         adm="&admin=true";
            }
            
             
          //  response.sendRedirect("/corefx/start/main?scope=magazin&selected=paravoz&logged=true");
            exit=null;
            }
            
            
            }else
            {
                if(username!=null)
                {
            session.setAttribute("user", username);
            String adm="";
            if(au!=null)
            {
             if(au.admin)
            {
        //    adm="&admin=true";
            }           
            }

            
             
            
            exit=null;                     
                            
                }else
                {
                    username=session.getId();
                    user=username;
                    param up = new param("user",user);
                    starter.Feed.addParameter(up);
                    session.setAttribute("user", user);
                    session.setAttribute("username", user);
                }
            
            }
            }else
            {
            String usrt=request.getParameter("lin");
            String pasrt=request.getParameter("pin");             
 
            if(usrt!=null&&pasrt!=null)
            {
            aaa au=new aaa(usrt,pasrt);
            
            if(au.logged)
            {
            user = usrt;
            username=user;
            session.setAttribute("user", username);
            String adm="";
            
            if(au.admin)
            {
      //      adm="&admin=true";
            }
            
             
 //           response.sendRedirect("/corefx/start/main?scope=magazin&selected=paravoz&logged=true");
            exit=null;
            }
                        
            
            
            }
            username=(String)session.getAttribute("user");            
          //  view="live";
            }            
            
            if(common.Com.isThing(username))
            {
            if(!starter.isThing("user"))
            {
                param pa=new param("user",username);
                starter.Feed.addParameter(pa);
                   
            }
            }
            
//this is a stub for the time of the construction

if(username == null)
{
String sesid=(String)session.getAttribute("user");

if(common.Com.isThing(sesid))
{
String reid=starter.Feed.getValue("user");
if(!common.Com.isThing(reid))
{
    param fam=new param("user",mysid);
    starter.Feed.addParameter(fam);
    username=sesid;
    user=sesid;
    session.setAttribute("user", user);
    
}
}
else
{
String reid=starter.Feed.getValue("user");
if(!common.Com.isThing(reid))

{    param fam=new param("user",mysid);
    starter.Feed.addParameter(fam);
}
session.setAttribute("user", mysid);
}

}

//end of stub
            
            
            
            
//end of auth block            
            

//populating scope and background on tag, check if not a dupe    
            
            String viewname=request.getParameter("scope");
            scope=viewname;
            String area=request.getParameter("area");    
            String url=request.getRequestURI();
            String sco=request.getParameter("scope");
        if(!common.Com.isThing(sco))
        {
        sco=request.getParameter("area");
        }            
                     tag t=new tag("main",starter.Feed,true);
        t.scope=sco;
        String bgc=common.Com.getBack(sco);
                
                if(bgc!=null)
        {
        attribute bgr=new attribute("bgcolor",bgc);
       
        t.addAttribute(bgr);
        
        
        }
//building path to file
           
            if(request.getQueryString()!=null)
            {
            url=url+"queStion"+request.getQueryString().replace("=", "equaLs");
            
            }
            path=url.replace("/", "~");
            
            path="./uri/"+path.substring(1);
            
            File file=new File(path);
            
             feed fc=new feed();
             data dacl=new data(fc.cof);
             List<String> calc=new ArrayList<>();
             try
             {
             calc=dacl.pullList("select name from config.calc", 1);
             }catch(Exception ec)
             {
                 System.out.print(ec.getMessage());
             }     
            boolean bo=true;
            
            
            
//            if(viewname.equals("user"))
//            {
//            bo=false;
//            }
            
// if the scope name is in the list of views to always calculate then bo=true;

            bo=calc.contains(viewname);
            
            if(!bo)
            {
                if(common.Com.isThing(recal))
                {
                    bo=true;
                }
            }
                String fl=common.Filer.readFileToString(path);    
                
// this block adds prods to cart              
 
            if(request.getParameter("cart")!=null)
            {
               String good=request.getParameter("good");
               String sid="";
                if(username==null)
                {
                    sid=session.getId();
                    username=sid;
                    session.setAttribute("user", username);
                                    
                }else
                {
                sid=username;
                }
            
                String bastat=Basket.toCart(sid, good);
            }
            
                
                
                
 //end of cart block
 
//if the view is not in calc always list then we check if there's a file saved


                

//file does not exist, now need to check if tag exist
                
            mysid=session.getId();
            String proj=request.getParameter("project");
            param prj=new param("project",proj);
            String refresh=request.getParameter("refresh");

            if(refresh!=null)
            {
            session.setAttribute("config", null);
            session.setAttribute("BlockTab", null);
            session.setAttribute("ColTab", null);
            nocalc=true;
            }
            


            String email=request.getParameter("eme");
            String pasp=request.getParameter("pap");
            String name=request.getParameter("nam");
            String mail=request.getParameter("mail");
            String uid=request.getParameter("uid");
            Locale loc=request.getLocale();
            String dir=request.getParameter("dir");
            lang=loc.getLanguage();            
            //this is a stub to test ru location
            lang="en";
            String[] scar={"par","magazin","basket","order"};
            
            
            if(common.Com.StringArContains(scar, scope))
            {
          //  lang="ru";

                
            } 
            if(scope.equals("admin"))
            {
//                au=new aaa();
//                user="maxim";
//                session.setAttribute("user", user);
            
            }              
            
            if(email!=null)
            {
            reg re=new reg(email,pasp,name);
            
                try
    {
    feed fo=new feed();

    
    feed fg=new feed();
    data dac=new data(fg.cop);
    
    String coquer="select descr from "+starter.Feed.cop.name+".fact where id='congrat' and lan='"+lang+"'";
    String lnk=getBaseUrl(request)+"/start/main?scope=register&mail="+re.mymail+"&uid="+re.ID;
    String txt=dac.pullString(coquer);
    Post po=new Post("",txt+" "+lnk,re.mymail,fo);
    }catch(Exception xm)
    {
        System.out.printf(xm.getMessage());
    }
            
            }
            
         
              data da=new data(fd.cof);
              String comp="";
              try
              {
              comp=da.pullString("select vals from config.config where isel='complete'");
              }catch(Exception ex)
              {
              comp="N";
              }
       //       sco="admin";
              if(comp.equals("Y"))
              {
              sco="main";
              }
              
              
              

            
            config conf=new config();
            if(session.getAttribute("config")==null)
            {
            try
            {
            conf=new config(fd.cof);
            }catch(Exception x)
            {
            error=x.getMessage();
            }
            session.setAttribute("config", conf);
            
            }
            
                        if(session.getAttribute("BlockTab")==null)
            {
            BlockTab ct=new BlockTab();                
            try
            {

            ct.pour("select * from "+starter.Feed.cop.name+".block", fd.cop, 7);
            
            }catch(Exception bonx)
            {
                error=bonx.getMessage();
            }
            
            session.setAttribute("BlockTab", ct);
            }
             param blo=new param("BlockTab",session.getAttribute("BlockTab"));
            
            
            
            if(session.getAttribute("ColTab")==null)
            {
            ColTab ct=new ColTab();                
            try
            {

            ct.pour("select * from "+starter.Feed.cof.name+".col", fd.cof, 10);
            
            }catch(Exception colx)
            {
                error=colx.getMessage();
            }
            
            session.setAttribute("ColTab", ct);
            }
            
            
     //       Enumeration<String> parameterNames = request.getParameterNames();


            
            sel=request.getParameter("selected");

            String Pgo=request.getParameter("page");
            String Sco=request.getParameter("scope");
            String recalc=request.getParameter("recalc");
            if(recalc!=null)
            {
              // helper.block.populate(Integer.parseInt(recalc), "bct");
                helper.block.populate(Integer.parseInt(recalc), "bct");
               
            }
            
            if(sel==null)
            {
            sel="";
            }
            
            if(Sco!=null)
            {sco=Sco;}
            
            if(Pgo!=null)
            {pgo=Pgo;}
            
            

            
            if(request.getParameter("scope").equals("register"))
            {
            feed fr=new feed();
            Verify vr=new Verify(fr);
            vr.activate(mail, uid);
            
            if(vr.status.equals("success"))
            {
            sco="live";
            
            }
            
            }
                        if(session.getAttribute("ConTab")==null)
            {
            ConTab ct=new ConTab();                
            try
            {

            ct.pour("select * from "+starter.Feed.cof.name+".config", fd.cof, 9);
            
            }catch(Exception conx)
            {
                error=conx.getMessage();
            }
            
            session.setAttribute("ConTab", ct);
            }
            param can=new param("ConTab",session.getAttribute("ConTab"));
            
            param cam=new param("ColTab",session.getAttribute("ColTab"));
            
            String isel=request.getParameter("isel");
            param isl=new param("isel",isel);
            
            
        
            param are=new param("area",area);
            param pa=new param("selected",sel);
            param sc=new param("scope",sco);
            
//adding block to Cart
            
            if(request.getParameter("cart")!=null)
            {
               String good=request.getParameter("good");
               String sid="";
                if(username==null)
                {
                    sid=session.getId();
                    username=sid;
                    session.setAttribute("user", username);
                                    
                }else
                {
                sid=username;
                }
            
          //      String bastat=Basket.toCart(sid, good);
            }
            
            if(exit!=null)
            {
                if(exit.equals("true"))
                {
                    String sid=session.getId();
                    username=sid;
                    session.removeAttribute("user");
                    session.setAttribute("user", username);       
                    response.sendRedirect("/corefx/start/main?scope=hotpage");
                }
            }
            
            
//            if(area.equals("exit"))
//            {
          
//            }
            
//            param sid=new param("mysid",mysid);
//            param pg=new param("page",pgo);
//            param us=new param("user",username);
//    
//            param lan=new param("language",lang);
//            param con=new param("config",session.getAttribute("config"));
//            param vw=new param("view",view);
            
            if(sco.equals("confirm"))
            {
                String casq="select f.descr*o.amount from fact f,orders o where o.prodid=f.parent and f.id='price' and o.orderid='"+sel+"'";
                
                data dag=new data(fd.cop);
                
                List<String[]> totl=new ArrayList<String[]>();
                
                
                
                try
                {
                totl=dag.pullTable(casq,1);
                int tot=0;
                if(totl.size()>0)
                {
                for(int i=0;i<totl.size();i++)
                {
                    int valc=Integer.parseInt(totl.get(i)[0]);
                    tot=tot+valc;
                
                }
                    
                param cbap=new param("total",Integer.toString(tot));
                starter.Feed.addParameter(cbap);
                }
                }catch(Exception cbex)
                {}            
            
            }
            
            if(sco.equals("demo"))
            {
                if(username!=null)
                {
                   if(username.length()<15) 
                   {
                       String flow=request.getParameter("flow");
                       
                       if(flow!=null)
                       {
                           if(!flow.equals("reg"))
                           {
                response.sendRedirect("/corefx/start/Reg?flow=order");        
                           }else
                           {
                response.sendRedirect("/corefx/start/main?scope=magazin&selected=paravoz");                            
                           }
                       }
                    }

                }
            
            }
            
            if(sco.equals("basket"))
            {
                String prid=request.getParameter("prodid");
                String amt=request.getParameter("amount");
                
                if(amt!=null)
                {
                    String exeq="update prod.orders set amount='"+amt+"' where prodid='"+prid+"' and orderid is NULL and personid='"+username+"'";
                    data dao=new data(fd.cop);
                    try
                    {
                        dao.Execute(exeq);
                        common.Delta.saveQuery(exeq);
                    }
                    catch(Exception exs)
                    {
                    
                    }
                    
                    
                }
                
                String basq="select f.descr*o.amount from fact f,orders o where o.prodid=f.parent and f.id='price' and o.orderid is null and o.personid='"+username+"'";
                
                data dab=new data(fd.cop);
                
                List<String[]> total=new ArrayList<String[]>();
                
                
                
                try
                {
                total=dab.pullTable(basq,1);
                int tot=0;
                if(total.size()>0)
                {
                for(int i=0;i<total.size();i++)
                {
                    int valc=Integer.parseInt(total.get(i)[0]);
                    tot=tot+valc;
                
                }
                    
                param bap=new param("total",Integer.toString(tot));
                starter.Feed.addParameter(bap);
                }
                }catch(Exception bex)
                {}
                

            }
 


            if(fd.error!=null)
            {
//        String st[]={"0","0","0","main","0","root",sco,"table","n"};
//        table tt=new table(st,starter.Feed);
//        attribute tat=new attribute("width","100%");
//
//        attribute tal=new attribute("valign","top");
//        tt.addAttribute(tat);
//        attribute af=new attribute("border","0");
//        attribute aid=new attribute("id","maintab");
//        tt.addAttribute(af);
////        t.addAttribute(tap);
//        tt.addAttribute(tal);
//        tt.addAttribute(aid);

        
            }
        

// @ view not in calc, file not existing, main tag not saved

            String tsin=t.getSignature();
            
            tag dtb=null;
            dtb=tag.class.cast(session.getAttribute(tsin));
            t.item=null;
            if(dtb!=null)
            {
            
            t=dtb;
            
            
            }else
            {
            
            t.populateTag();
            session.removeAttribute(tsin);
            session.setAttribute(tsin, t);
            }
             
            s=t.getOffCode();
            s=beam(s);
           
       //     s=t.getCode();
       
        
       
       
       
            out.println(s);


            File ri=new File("./uri");
            if(!ri.exists())
            {
                
                
                try
                {
                FileUtils.forceMkdir(ri);    
                }catch(Exception ex)
                {
                System.out.print(ex.getMessage());
                }
                    
                        
            }
         //   String curp=System.getProperty("user.dir");
//            OutputStream os=new FileOutputStream(file);
//                os.write(239);
//                os.write(187);
//                os.write(191);            
//            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
//            writer.write(s);
           // writer.close();  


          
                    

          
            out.println(error);
            out.println("</body>");
            out.println("</html>");
            
  
        }
            }catch(JsonException fix)
            {
            error=fix.getMessage();
            }
        } finally {   
            out.print(error);
            out.close();
        }
    }

    String beam(String s)
    {
        String result = null;
        Document doc = Jsoup.parse(s);
    
        Elements el = doc.getAllElements();
        
        for(int i = 0; i< el.size(); i++)
        {
        
            String nm = el.get(i).nodeName();
            
            if(!nm.equals("table")&!nm.equals("td")&!nm.equals("tr"))
            {
                
                Element le = el.get(i);
                
                Attributes att = le.attributes();
                
               String[] keys = {"onmouseover","onmouseout","onclick"};
               String[] fun = {"showdesc(id)","hidedesc(id)","edel(title)"};
                
               for(int j = 0; j<keys.length; j++)
               {
                   if(att.hasKey(keys[j]))
                   {
                       att.remove(keys[j]);
                       att.put(keys[j], fun[j]);
                        
                   }else
                   {
                                      if(att.hasKey(keys[j]))
                   {
                   
                       att.put(keys[j], fun[j]);
                        
                   }
                   }
               
               }
                
            }
            
            
        }
        result = doc.html();
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
