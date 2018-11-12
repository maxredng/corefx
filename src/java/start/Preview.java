/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
//import Steamer.Profile;
import common.DB;
import data.*;
import ecrivus.Category;
import ecrivus.Handler;
import ecrivus.Loc;
import ecrivus.Mess;
import ecrivus.Profile;
import ecrivus.Publish;
import ecrivus.Reset;
import ecrivus.Screen;
import ecrivus.Summary;
import ecrivus.Voice;
import helper.Atkey;
import helper.Basket;
import helper.Ecrivus;
import helper.Editvalue;
import helper.Newscope;
import helper.Params;
import helper.Remove;
import helper.Starter;
import helper.Updatequery;
import html.Post;
import html.Verify;
import html.reg;
import html.attribute;
import html.config;
import html.feed;
import html.param;
import html.table;
import html.tag;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;



/**
 *
 * @author kisa
 */
@WebServlet(name = "Preview", urlPatterns = {"/start/Preview"})
public class Preview extends HttpServlet {

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
        
        StringBuffer requestURL = request.getRequestURL();
        
         String queryString = request.getQueryString();
         String rl = "";
             if (queryString == null) {
        rl = requestURL.toString();
    } else {
        rl = requestURL.append('?').append(queryString).toString();
    }
        
        try {
            
            try
            {
            {
            /* TODO output your page here. You may use following sample code. */
       out.println("<!doctype html>");
                
            out.println("<html>");
            out.println("<head>");
            out.println("<title>RedHotPage.COM</title>");   
            path = "";
            fd.params.clear();
//HTTP-EQUIV='Pragma'
            out.println("<META CONTENT='no-cache'> ");

            out.println("<LINK REL=stylesheet TYPE='text/css' HREF='/corefx/mrs.css'>");
         //   out.println("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>");
            out.println("<script type='text/javascript' src='/corefx/menu.js'></script>");
//            out.println("<script type=\"text/javascript\"");
//            out.println("$(window).load(function() {");
//            out.println("$(\".loader\").fadeOut(\"slow\");");
//            out.println("});");
//            out.println("</script>");
            out.println("</head>");
            //onmousemove='moveme(event)'
              String testscope=request.getParameter("scope");          
            out.println("<body onLoad='on_load()' bgcolor='"+common.Com.getBack(testscope)+"'>");
            HttpSession session=request.getSession();
            String exit=request.getParameter("exit");            
            Starter starter;

            
            
            
            if(common.Com.isThing(testscope))
            {
                if(testscope.equals("ecrivus"))
                {
                out.println("<div id='fb-root'></div>");
out.println("<script>(function(d, s, id) {");
out.println("var js, fjs = d.getElementsByTagName(s)[0];");
  out.println("if (d.getElementById(id)) return;");
  out.println("js = d.createElement(s); js.id = id;");
  out.println("js.src = '//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.6\';");
  out.println("fjs.parentNode.insertBefore(js, fjs);");
out.println("}(document, 'script', 'facebook-jssdk'));</script>");
                
                }
                if(testscope.equals("addnew"))
                {
                out.println("<div class='loader' id='load@main_r0c0'></div>");
                
                }
                 if(testscope.equals("type")||testscope.equals("voice"))
                {
                out.println("<div class='lowloader' id='class@load@main_r0c0'></div>");
                
                }           
                
            }
            starter = new Starter(request,true);
            starter.addCol();
            starter.addConfig();
             
            Params pr = new Params(rl);
            
            for(int z=0; z<pr.item.size();z++)
            {
                if(!starter.isThing(pr.item.get(z).name))
                {
                    starter.Feed.params.add(pr.item.get(z));
                }
            }
            

            
            if(starter.isThing("isel"))
            {
                System.out.println("isel");
            
            }
            username=null;
            user=null;
//this is the start of the Steam block
            
//            String DoLog=request.getParameter("dolog");
//            
//            if(common.Com.isThing(DoLog))
//            {
//                try
//                {
//                    
//                steam.SteamGo steam =new steam.SteamGo();                
//                String gfull=getFullUrl(":8080/corefx/start/main?scope=pot&selected=main");
//              //  steam.doNothing();
//                String redir=steam.login(gfull);
//                
//                response.sendRedirect(redir);               
//                
//                }catch(Exception exrp)
//                {
//                System.out.print(exrp.getMessage());
//
//
//                }
//
//                
//                
//
//                
//            }
//            
//            String RudeSteamID = request.getParameter("openid.identity");          
//           
//            String SteamID;
//            if(common.Com.isThing(RudeSteamID))
//            {
//             SteamID=RudeSteamID.substring(36);
//             
//             profile=new Profile(SteamID);
//             
//             for(int i=0;i<profile.parameters.length;i++)
//             {
//             starter.Feed.addParameter(profile.parameters[i]);
//             }
//             username=SteamID;
//             user=username;
//             au=new aaa();
//             starter.Feed.addParameter(new param("user",user));
//             session.setAttribute("user", username);
//             
//           
//             data dlo=new data(fd.cop);
//             data dold=new data(fd.cop);
//             
//             try
//             {
//                 //this line is for debugging only, gotta be removed
//                 
//                 dold.Execute("delete from prod.logged");
//                 
//                 //this will stay ))
//                 dlo.Execute("insert into prod.logged values('"+username+"','"
//                         +profile.id+"','"+profile.avatarSmall+"','"+profile.avatarMedium+"','"+profile.avatarFull+"','"
//                         +profile.customURL+"','"+profile.location+"','"+profile.realname+"')");
//             }
//             catch(Exception dlex)
//             {
//                 error=dlex.getMessage();
//             
//             }
//             
//            }
            
//end of Steam block

//start of auth block


                String signout = request.getParameter("signout");
                
                if(common.Com.isThing(signout))
                {
                    user = null;
                    username=null;
                    session.removeAttribute("user");
                    starter.Feed.removeValue("user");
                
                }

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
            
//this is the block handling initial order creation for ecrivus

            if(testscope.equals("checkout"))
            {
                Ecrivus ec = new Ecrivus(request);
                
            }
            
// this is the block to register client for Ecrivus

    Handler hand = new Handler(request);

    if(common.Com.isThing(request.getParameter("editvalue")))
    {
    Editvalue.handle(request);
    response.sendRedirect("/corefx/start/main?scope=stage&area="+request.getParameter("area")+"&selected="+request.getParameter("selected")+"&refresh=true");
    }    
     if(common.Com.isThing(request.getParameter("atkey")))
    {
    Atkey.handle(request);
    response.sendRedirect("/corefx/start/main?scope=newatt&close=true");
    }     
    
    if(common.Com.isThing(request.getParameter("category")))
    {
    Category.handle(request);
    }
    if(common.Com.isThing(request.getParameter("remove")))
    {
    Remove.handle(request);
    
    response.sendRedirect("/corefx/start/main?scope=board&area=main&mscope="+request.getParameter("mscope"));
    }    
    if(common.Com.isThing(request.getParameter("summary")))
    {
    Summary.handle(request);
    }    

    if(common.Com.isThing(request.getParameter("newscope")))
    {
    Newscope.handle(request);
    }     
    
    
        if(common.Com.isThing(request.getParameter("screen")))
    {
    Screen.handle(request);
    } 
    
            if(common.Com.isThing(request.getParameter("publish")))
    {
    Publish.handle(request);
    } 
        
             if(common.Com.isThing(request.getParameter("summ")))
    {
    Loc.handle(request);
    }    
 
             if(common.Com.isThing(request.getParameter("reset")))
    {
    Reset.handle(request);
    }   
             
                if(common.Com.isThing(request.getParameter("updatequery")))
    {
    Updatequery.handle(request.getParameter("updatequery"));
    }           
             
             if(common.Com.isThing(request.getParameter("categ")))
             {
             Mess.handle(request);
             }
        if(hand.Logged)
        {   
            String uss = starter.Feed.getValue("user");
            String sus = (String)session.getAttribute("user");
            
            if(common.Com.isThing(uss))
            {
                if(!uss.contains("\\@"))
                {
                    username = hand.login;
                    param fam=new param("user",username);
                    starter.Feed.removeValue("user");
                    starter.Feed.addParameter(fam);
                    session.removeAttribute("user");
                    session.setAttribute("user", username);
                }
            }
            
            
            
            
        }

        if(testscope.equals("voice"))
        {
            Voice voice = new Voice(request);
            
            if(voice.OK)
            {
                            String uss = starter.Feed.getValue("user");
                                        if(common.Com.isThing(uss))
            {
                if(!uss.contains("\\@"))
                {
                    username = voice.login;
                    param fam=new param("user",username);
                    starter.Feed.removeValue("user");
                    starter.Feed.addParameter(fam);
                    session.removeAttribute("user");
                    session.setAttribute("user", username);
                }
            }
                            
            }else
            {
                Profile pro = new Profile(request);
            
            }
        
        }
        
//12345 test block



        
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
            
            data dare = new data(Feed.cof);
            String fl="";
            try
            {
            fl = dare.pullString("select bod from config.store where sign='"+path+"'");
            }catch(Exception ex)
            {
            fl=common.Filer.readFileToString(path); 
            }
            
            if(!common.Com.isThing(fl))
            {
            fl=common.Filer.readFileToString(path); 
            }
            
                   
                
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

    data dro = new data(Feed.cof);
    
    String gf = "";
    boolean miss=true;
    try
    {
        gf = dro.pullString("select sign from config.store where sign='"+path+"'");
        
        if(common.Com.isThing(gf))
        {
            miss = false;
        }
        
    }
    catch(Exception gfx)
    {}

             if(!bo)
            {
            if(miss)
            {        

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
            
//this has to do with e-town map building. need to remove and introduce later in a separate project

//
//            String seed=request.getParameter("seed");
//            
//            if(seed==null)
//            {
//            seed="4000";
//            }
//            
//            int range=0;
//            
//            feed fra=new feed();
//            
//            data dr=new data(fra.cof);
//            
//            try
//            {
//                String rg=dr.pullString("select value from "+fra.cof.name+".vars where id='range'");
//                range=Integer.parseInt(rg);
//                
//            }catch(Exception rex)
//            {
//                System.err.println(rex.getMessage());
//            
//            }
//            
//            
//            cell=request.getParameter("cell");
//            param cel=new param("cell",cell);
//            param to=new param("t",Integer.toString(Integer.parseInt(seed)-range-1));
//            param b=new param("b",Integer.toString(Integer.parseInt(seed)+range+1));            
//            param r=new param("r",Integer.toString(Integer.parseInt(seed)+range+1));
//            param l=new param("l",Integer.toString(Integer.parseInt(seed)-range-1));
//            param sd=new param("seed",seed);
//            param rg=new param("range",Integer.toString(range));
            

// these are user profile fields. not going anyware as of now

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
//            writer.close();  
        data dar = new data((new feed()).cof);
        data daf = new data(Feed.cof);
       String qur = "select sign from config.store where sign='"+path+"'";
       String qr = "insert into config.store values('"+path+"','"+s.replace("\'", "\\'")+"')";
       
       String inpat = common.Com.parseFrom(path, "scopeequaLs", "&amp;");
       
              String mf[] = path.split("&");
       
       for(int xc = 0; xc<mf.length;xc++)
       {
       String[] tempor = mf[xc].split("scopeequaLs");
       
       if(tempor.length>1)
       {
       
       inpat = tempor[1];
       break;
       
       }
       }
       String inbod = "";
               //common.Com.parseFrom(s, "<div id=\"inv\"  class=\"hid\">", "</div>");
       
       Document dfc=Jsoup.parse(s);
       
       Element ell = dfc.getElementById("inv");
       
       if(ell!=null)
       {
       inbod = ell.text();
       }
       
       
               
       
       try
       {
           
           
       String sig = daf.pullString(qur);
       
       if(!common.Com.isThing(sig))
       {
       
//          if(inpat.equals(inbod))
//          {
          dar.Execute(qr);
//          }
       
       
       }           
       
       }catch(Exception sx)

       {
       System.out.print(sx.getMessage());
       }
        

            }else
            {

             data dacalc=new data(Feed.cof);
             
             try
             {
                 String myscope=scope;
                 if(scope.equals("selector"))
                 {
                 myscope=area;
                 }
if(miss)
{
                 newstuff=dacalc.pullTable("select * from config.col where scope='"+myscope+"' and num='1'", 9);


}
                 
             }
             catch(Exception er)
             {
                 error=er.getMessage();
             }
             
             
            
            
            

    
            
            Document dc=Jsoup.parse(fl);
            
            Elements el=dc.getElementsByAttribute("calc");
            
             
            

            if(miss)
            {
                
               for(int e=0;e<el.size();e++)
            {
                Element element=el.get(e);
                String tid=element.attr("calc");
                tag tagt=new tag(tid,starter.Feed,true);
                
                String rep=tagt.getCode();
                TextNode nod=new TextNode(rep,"");
                element.replaceWith(nod);

            }             
                
                
            
           //  String curp=System.getProperty("user.dir");
          //   System.out.println(path);
             String reply=dc.html().replace("&lt;", "<").replace("&gt;", ">").replace('\r', '\0').replace('\n', '\0');
             out.println(reply);    
             
        //     delast(reply);
             if(nocalc)
             {
                 try
                 {
                    DB.NullifyNum(); 
                 
                 }catch(Exception ssx)
                 {
                     error=ssx.getMessage();
                 }
                 
                 
                 
             }
              
             
            }else
            {
            out.println(fl);
            notyet=false;
            }            
      
                for(int i=0;i<0;
                        
                        //newstuff.size();
                        i++)
                {
                    String[] temp=newstuff.get(i);
                    tag tacalc=new tag(temp[3],starter.Feed,true);
                    String tast=tacalc.getCode();
                   // tast=common.Com.removeAtt(tast, "calc", common.Com.getAttrValue(tast, "calc"));
                    Element tarst=Jsoup.parse(tast);
                           
                    
                    
                    String parent=tacalc.parent;
                    tag pat;
                    String paid;

                    pat=new tag(parent,fd,true);
                    paid=pat.id;
        


                     
                   
    if(!paid.equals("main"))
    {
        
        
                 String sscp=t.Feed.getValue("scope");
                 
                 if(sscp.equals("user"))
                 {
                 System.out.println(sscp);
                 }
                    if(notyet)
                    {
                        s=t.getCode();
                        out.println(s);                   
                    }

                              
                   
                   }else
    {
                    String pastr=pat.getCode();
                    if(pastr.length()>0)
                    {
                    String myid=paid;
                    if(scope.equals("selector"))
                    {
                    myid=paid+"selectrowrow1";
                    }
                    Element pael=dc.getElementById(paid);
                    
                    if(scope.equals("selector"))
                    {
                        tag tapa=common.DB.getSelector(paid, starter.Feed);
                        
                        pastr=tapa.getCode();
                    
                    }
                    
                    TextNode tael=new TextNode(pastr,"");
                    pael.replaceWith(tael);
                    }
                    
    }
          

            }                   
                   
                   
                   }
                    

            }else
             {
//view in always calculate list;
                 
                // String uusr=t.Feed.getValue("user");
                 String sscp=t.Feed.getValue("scope");
                 
                 if(sscp.equals("user"))
                 {
                 System.out.println(sscp);
                 }
           
            
            mysid=session.getId();
            starter.Feed.addParameter(new param("mysid",mysid));
            String proj=request.getParameter("project");
            param prj=new param("project",proj);
            String refresh=request.getParameter("refresh");
        //    String exit=request.getParameter("exit");
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

            if(scope.equals("admin"))
            {
                au=new aaa();
                user="max";
                session.setAttribute("user", user);
            
            }              
            
            if(email!=null)
            {
            reg re=new reg(email,pasp,name);
            
                try
    {
//    feed fo=new feed();
//    SendMail sm=new SendMail(fo.mailname+"@"+fo.host,re.mymail,"test","test");
//    sm.send();
//    Generic ge=new Generic(lang,"congrat");
//    ge.getCode();
//    String cong=ge.content;
    feed fg=new feed();
    data dac=new data(fg.cop);
    
    String coquer="select descr from "+starter.Feed.cop.name+".fact where id='congrat' and lan='"+lang+"'";
    String lnk=getBaseUrl(request)+"/start/main?scope=register&mail="+re.mymail+"&uid="+re.ID;
    String txt=dac.pullString(coquer);
    Post po=new Post("",txt+" "+lnk,re.mymail,starter.Feed);
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
          //    sco="admin";
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
            

            
      //      Enumeration<String> parameterNames = request.getParameterNames();
            if(session.getAttribute("user")==null)
            {

            user=request.getParameter("lin");
            pass=request.getParameter("pin");        
            
            if(user!=null&&pass!=null)
            {
            au=new aaa(user,pass);
            
            if(au.logged)
            {
            username=user;
            session.setAttribute("user", username);
            String adm="";
            
            if(au.admin)
            {
      //      adm="&admin=true";
            }
            
             
       //     response.sendRedirect("/corefx/start/main?scope=magazin&selected=paravoz&logged=true");
            exit=null;
            }
            
            
            }else
            {
                if(username!=null)
                {
            session.setAttribute("user", username);
            String adm="";
            
            if(au.admin)
            {
       //     adm="&admin=true";
            }
            
             
            
            exit=null;                     
                            
                }
            
            }
            }else
            {
            String usrt=request.getParameter("lin");
            String pasrt=request.getParameter("pin");             
 
            if(usrt!=null&&pasrt!=null)
            {
      //      aaa au=new aaa(user,pass);
            if(au!=null)
                {
            if(au.logged)
            {
   //         username=user;
      //      session.setAttribute("user", username);
          //  String adm="";
            
            if(au.admin)
            {
       //     adm="&admin=true";
            }
            
             
         //   response.sendRedirect("/corefx/start/main?scope=magazin&selected=paravoz&logged=true");
            exit=null;
            }
                                     
                
                }
   
            
            
            if(username == null)
            {
            username=(String)session.getAttribute("user");       
            user = username;               
            }
            
            }
            


            
           // view="live";
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
                    data dao=new data(starter.Feed.cop);
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
                
                data dab=new data(starter.Feed.cop);
                
                List<String[]> total=new ArrayList<>();
                
                
                
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
            
        sco=starter.Feed.getValue("scope");
        
        
        
        String st[]={"0","0","0","main","0","root",sco,"table","n"};
        String ft[] = {"1","0","0","main","0","root",sco,"table","n"};
        
        String le = request.getParameter("element");
        
        tag ini = new tag(le,starter.Feed,true);
 
        
        
        
        attribute tat=new attribute("width","100%");
        
        
        attribute tal=new attribute("valign","top");
        
        String asco=starter.Feed.getValue("scope");

        attribute bg=new attribute("bgcolor",common.Com.getBack(asco));
        ini.addAttribute(tat);
        attribute af=new attribute("border","0");
        attribute aid=new attribute("id","maintab");
        ini.addAttribute(af);
      //  fot.addAttribute(af);
//        t.addAttribute(tap);
        ini.addAttribute(tal);
    //    fot.addAttribute(tal);
    //    tt.addAttribute(aid);
        ini.addAttribute(bg);
     //   fot.addAttribute(bg);
//            }
                        
            s = ini.getCode();
         //   String z = fot.getCode();
            
            out.println(s);
          //  out.println(z);
 
             
             }
      //      out.println(error);
            out.println("</body>");
            out.println("</html>");
            
  
        }
            }catch(JsonException fix)
            {
            error=fix.getMessage();
            }
        } finally {   
          //  out.print(error);
            out.close();
        }
    }

    
    
            
    
    void delast(String html)
    {
    
        data da = new data((new feed()).cof);
        
       String qr = "insert into config.store values('"+path+"','"+html+"')";
       
       try
       {
       da.Execute(qr);
       }catch(Exception sx)
       {
       System.out.print(sx.getMessage());
       }
        
        File file=new File(path);
        try
        {
                OutputStream os=new FileOutputStream(file);
        os.write(239);
        os.write(187);
        os.write(191);            
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(html);
                writer.close();   
     //   common.DB.NullifyNum();            

        }catch(Exception ex)
        {
        error=ex.getMessage();
        }

    }
    public static String getBaseUrl( HttpServletRequest request ) {
    if ( ( request.getServerPort() == 80 ) ||
         ( request.getServerPort() == 443 ) )
      return request.getScheme() + "://" +
             request.getServerName() +
             request.getContextPath();
    else
      return request.getScheme() + "://" +
             request.getServerName() + ":" + request.getServerPort() +
             request.getContextPath();
  }

    private String getFullUrl(String path) {
        StringBuilder builder = new StringBuilder("127.0.0.1");
        builder.insert(0, "http://");
        builder.append(path);
        return builder.toString();

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
     //   processRequest(request, response);
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
