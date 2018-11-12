/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import common.RoCol;
import data.data;
import helper.Cleaner;
import helper.Editor;
import html.GenTable;
import html.Numeric;
import html.attribute;
import html.feed;
import html.tag;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "table", urlPatterns = {"/start/table"})
public class table extends HttpServlet {
 
    
    public String error;
    public feed Feed=new feed();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");       
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>table constructor</title>");    
            
            out.println("<META HTTP-EQUIV='Pragma' CONTENT='no-cache'> ");
//            out.println("<style src='miss.css'></style> ");
            out.println("<LINK REL=stylesheet TYPE='text/css' HREF='/corefx/mrs.css'>");
            out.println("<script type='text/javascript' src='/corefx/"+helper.Help
                    .getJSFile(request)+"'></script>");
            out.println("</head>");
            
            out.println("</head>");
            out.println("<body onload='on_load()'>");
            error="";
            String mytab="_col";
            String real=request.getParameter("real");
            boolean stage=true;
            String elcode="element";
            String realpar="";
            boolean prod=false;
            if(common.Com.isThing(real))
            {
            mytab="col";
            stage=false;
            elcode="tag";
            realpar="&real=true";
            prod=true;
            }
            if(common.Com.isThing("fromsel"))
            {
                realpar=realpar+"&fromsel=true";
            }
            feed Feed=new feed();
            
            // clean store when saving something from CMS

    if(common.Com.isThing(request.getParameter("persistevent")))
    {
        Cleaner.Handle(request);
    
    }

            
            
            HttpSession session = request.getSession();
            String rows=request.getParameter("row");

            
            String cols=request.getParameter("col");
            String ele=request.getParameter("element");
            String selected=request.getParameter("selected");
            String scope=request.getParameter("area");       
            String name=request.getParameter("name");
            String parent=request.getParameter("parent");
            String edit=request.getParameter("edit");
            String content=request.getParameter("content");
            String lan=request.getLocale().getLanguage();
            String goedit=request.getParameter("goedit");
            String delete=request.getParameter("del");
            String pth=request.getPathInfo();
                String[] pars={"id","name","content","class","src","href","value","onclick","type","intype","onmouse","offmouse","onchange","width","height","row","col"};
                String[] elePar=new String[pars.length];

                String[] ipars={"vinid","vinname","vincontent","vinclass","vinsrc","vinhref","vinvalue","vinonclick","vintype","vinintype","vinonmouse","vinoffmouse","vinonchange","vinwidth","vinheight","vinrow","vincol"};
                String[] iPar=new String[pars.length];
                data dab=new data((new feed()).cof);
                String created="";
                Editor editor=new Editor(request);                
                boolean goon=true;
//this bloc deletes an element and its attributes


                if(common.Com.isThing(delete))
                {
                    String quel="delete from config.col where name='"+delete+"' and scope='"+scope+"'";
                    String quat="delete from config.col where parent='"+delete+"' and scope='"+scope+"'";
                    String qupr="delete from prod.fact where id='"+delete+"'";
                    
                    data datag=new data(Feed.cof);
                    data datel=new data(Feed.cof);
                    data dapro=new data(Feed.cop);
                        String tasta="";
                        String atsta=""; 
                        String prsta="";
                    try
                    {
                        tasta="element deleted: "+datag.Execute(quel);
                        common.Delta.saveQuery(quel);
                        
                        atsta="attribute deleted: "+datel.Execute(quat);
                        common.Delta.saveQuery(quat);
                        
                        prsta="content deleted:"+dapro.Execute(qupr);
                        common.Delta.saveQuery(qupr);
                        
                    }
                       catch(Exception ex) 
                       {
                           error=ex.getMessage();
                       }
                    goon=false;
                     
                    out.println("<div>"+tasta+"</div>");
                    out.println("<div>"+atsta+"</div>");
                    out.println("<div>"+prsta+"</div>");
                    out.print("<div>"+error+"</div>");
                }
                
                
//this block handles values sent to update existing record
            
            if(common.Com.isThing(goedit))
            {
            
                RoCol rc=new RoCol(ele);
                String repo=null;
                String repla=null;
                String newname=null;
                if(editor.isThing("row")&&editor.isThing("col"))
                {
                    repo=rc.suff;
                    repla="r"+rows+"c"+cols;
                    newname=ele.replace(repo,repla);
                
                }
             
             String id=request.getParameter("area")+"@"+request.getParameter("parent")+"_"+request.getParameter("element");
             
             tag t=new tag(id,Feed,prod);
             if(common.Com.isThing(rows)&&common.Com.isThing(cols))
             {
               
             
             }
             if(t.name==null)
             {
             t=new tag(request.getParameter("element"),Feed,prod);
             }
             
             for(int i=0;i<editor.elePar.length;i++)
             {
                String argument=editor.pars[i];
                String vinarg="vin"+argument;
                String vin=null;
                if(common.Com.isThing(request.getParameter(vinarg)))
                {
                vin=request.getParameter(vinarg);
                
                }
                if(editor.isThing(argument))
                {
                    String value=editor.getValue(argument);
                    if(editor.isAttribute(i))
                    {
                        
                    common.DB.updateAttribute(common.Com.mapValueBack(argument), value, vin, t, stage);
                    }else
                    {
                        if(i!=2)
                        {
                        common.DB.updateTag(common.Com.mapValueBack(argument), value, t, stage);
                        }else
                        {
                            String proq="update prod.fact set descr='"+value+"' where id='"+t.id+"' and lan='"+lan+"'";
                            String eqoq="update config.col set isel='pro',element='c' where name='"+t.id+"' and parent='"+t.parent+"' and scope='"+t.scope+"'";
                            String fiqo="select id from prod.fact where id='"+t.id+"' and lan='"+lan+"'";
                            String croq="insert into prod.fact values('"+t.id+"','','','"+value+"','','','"+lan+"','1')";
                            String proquer=proq;
                            
                            List<String> glo=new ArrayList<>();
                            
                            data dag=new data(Feed.cof);
                            data dar=new data(Feed.cop);
                            data dra=new data(Feed.cop);
                            
                            data dape=new data(Feed.cop);
                            
                            try
                            {
                                glo=dar.pullList(fiqo, 1);
                                boolean con=false;
                                if(glo!=null)
                                {
                                    if(glo.size()>0)
                                    {
                                        con=true;
                                    }
                                }
                                
                                if(!con)
                                {
                                proquer=croq;
                                
                                dag.Execute(eqoq);
                                common.Delta.saveQuery(eqoq);
                                }
                            
                               dra.Execute(proquer);
                               common.Delta.saveQuery(proquer);
                                
                            }
                            catch(Exception exp)
                            {
                                error=exp.getMessage();
                            }
                        
                        }
                
                    }
                    
                    
                    
                
                }
                
                
                
                
             
             }
             
             if(newname!=null)
             {
             common.DB.updateTag("id", newname, t, stage);
             
             }

                List<String[]> lost=new ArrayList<>();
                
                try
                {
                    lost=dab.pullTable("select name from config."+mytab+" where block='y' and parent='"+selected+"' and scope='"+scope+"'", 1);
                    
                    for(int j=0;j<lost.size();j++)
                    {
                        String st=lost.get(j)[0];
                        
                        created=created+st+"~";
                    
                    }
                
                }
                catch(Exception ex)
                {}
                                        
                    RoCol rocks=common.Com.GetColCreated(created);
                    response.sendRedirect("/corefx/start/table?row="+rocks.srow+"&col="+rocks.scol+"&created="+created+"&area="+scope+"&parent="+selected+realpar);
                    
            }
            
            
           
//this block test opening edit view

            if(common.Com.isThing(edit))
            {

                 String pa=parent.replace(" ", "");
 
                String ed=scope+"@"+pa+"_"+edit;
                
                
           tag gta=new tag(ed,Feed,prod);
           
           if(gta.name==null)
           {
           gta=new tag(edit,Feed,prod);
           }
           
           String par=gta.parent;
           String scp=gta.scope;
           String typ=gta.name;
           String rw=common.Com.parseFrom(edit, "r", "c");
           
           String atr="";
           if(gta.att!=null)
           {
           for(int i=0;i<gta.att.length;i++)
           {
               attribute tmp=gta.att[i];
               
               String aname=tmp.name;
               String avalue=tmp.value;
               String aisel=tmp.isel;
               
               atr=atr+common.Com.mapValue(aname)+"="+avalue+"&"+common.Com.mapValue(aname)+"isel="+aisel+"&";
               
           
           }           
           
           
           }

           
           
                int ic=edit.indexOf("c");
                String cl=edit.substring(ic+1);           
           
           String coq="select descr from prod.fact where id='"+gta.id+"' and lan='"+lan+"'";
              
           data dp=new data(Feed.cop);
           String cont="";
           try
           {
               cont=dp.pullString(coq);
           
           }
           catch(Exception cx)
           {
               error=cx.getMessage();
           }
                
           String adcon="";
           
           if(common.Com.isThing(cont))
           {
           adcon="&content="+cont;
           }
           String pat="/corefx/start/main?scope="+elcode+"&area="+scp+"&parent="+par+"&type="+typ+"&element="+edit+"&ro="+rw+"&co="+cl+"&"+atr+"&edit="+edit+adcon+realpar;
            
           response.sendRedirect(pat);
           goon=false;
            }
 //this handles the first saving of the element
 if(goon)
 {
            if(common.Com.isThing(name)&!common.Com.isThing(goedit))
            {
                tag t=new tag();
                t.Feed=new feed();
                String ro=request.getParameter("ro");
                String co=request.getParameter("co");

                
                for(int i=0;i<ipars.length;i++)
                {
                    
                iPar[i]=request.getParameter(ipars[i]);
                }
                
                
                for(int i=0;i<pars.length;i++)
                {
                    elePar[i]=request.getParameter(pars[i]);
                    if(editor.isAttribute(i))
                    {       
//                    if(i<1||i>2)
//                    {
//                        if(i!=8)
//                        {
                            if(common.Com.isThing(elePar[i]))
                            {
                                attribute at=new attribute(getFieldValue(pars[i]),elePar[i]);
                                if(common.Com.isThing(iPar[i]))
                                {
                                    at.isel=iPar[i];
                                }else
                                {
                                    at.isel="a";
                                }
                                
                                if(at.name.equals("intype"))
                                {
                                    at.name = "type";
                                }
                                
                                t.addAttribute(at);
                            }                       
                        
                        
                }
//                        }
//
//                    
//                    
//                    }
                    
                    
                
                }
                
                try
                {
                String row=common.Com.parseFrom(ele, "r", "c");
                int ic=ele.indexOf("c");
                String col=ele.substring(ic+1);

                try
                {
                int arow=Integer.parseInt(row);
                int acol=Integer.parseInt(col);
                
                t.line=row;
                t.col=col;
                
                }catch(Exception nsx)
                {
                    RoCol rock=new RoCol(ele);
                    t.line=Integer.toString(rock.row);
                    t.col=Integer.toString(rock.col);
                }
                
                
               
                
                }catch(Exception ex)
                        {
                        t.line=request.getParameter("row");
                        t.col=request.getParameter("col");
                        
                        
                        }
                

               if(common.Com.isThing(iPar[1]))
               {
               t.Element="c";
               
               }
                
                
                if(common.Com.isThing(elePar[2]))
                {
                    t.content=elePar[2];
                    t.Element="c";
                    t.isel="pro";
                    
                }else
                {
               if(common.Com.isThing(iPar[1]))
               {
               t.Element="c";
               
               } else
               {
               t.Element="0";
               }
                    
                
                }
                
                t.id=elePar[1];
                t.value="0";
                t.parent=parent;
                t.scope=scope;
                t.name=elePar[8];
                if(t.isel==null)
                {
                    if(common.Com.isThing(iPar[1]))
                    {
                    t.isel=iPar[1];
                    
                    }else
                    {
                        t.isel="n";
                    }
                }
                
                if(common.Com.isThing(goedit))
                {
                common.DB.deleteElement(t.id, t.parent, t.scope);
                List<String[]> lost=new ArrayList<>();
                
                try
                {
                    lost=dab.pullTable("select name from config."+mytab+" where block='y' and parent='"+selected+"' and scope='"+scope+"'", 1);
                    
                    for(int j=0;j<lost.size();j++)
                    {
                        String st=lost.get(j)[0];
                        
                        created=created+st+"~";
                    
                    }
                
                }
                catch(Exception ex)
                {}                
                
                
                response.sendRedirect("/corefx/start/table?row="+ro+"&col="+co+"&created="+created+"&area="+scope+"&parent="+selected+realpar);                
                
                
                
                
                
                
                
                }
                
                out.println("<div>"+t.SaveTag(stage)+"</div>");
                

                if(t.error!=null)
                {
                out.print(t.error);
                }
                
                
                if(common.Com.isThing(content))
                {
                    
                    
                    
                    String proq="insert into prod.fact values('"+t.id+"','','','"+content+"','','','"+lan+"','1')";
                    String proc="select id from prod.fact where id='"+t.id+"'";
                    data dap=new data(Feed.cop);
                    data dac=new data(Feed.cop);
                    try
                    {
                    String exist=dac.pullString(proc);
                    
                    if(!common.Com.isThing(exist))
                    {
                        dap.Execute(proq);
                        common.Delta.saveQuery(proq);
                    }else
                    {
                        String equer="update prod.fact set descr='"+content+"' where id='"+t.id+"' and lan='"+lan+"'";
                    
                        dap.Execute(equer);
                        common.Delta.saveQuery(equer);
                    }
                    
                    
                    
                    }catch(Exception pex)
                    {
                        error=pex.getMessage();
                    }
                    
                }
 
                List<String[]> lost=new ArrayList<>();
                
                try
                {
                    lost=dab.pullTable("select name from config."+mytab+" where block='y' and parent='"+selected+"' and scope='"+scope+"'", 1);
                    
                    for(int j=0;j<lost.size();j++)
                    {
                        String st=lost.get(j)[0];
                        
                        created=created+st+"~";
                    
                    }
                
                }
                catch(Exception ex)
                {}                
                
                
                response.sendRedirect("/corefx/start/table?row="+ro+"&col="+co+"&created="+created+"&area="+scope+"&parent="+selected+realpar);
            }else
            {
             if(common.Com.isThing(ele)&!common.Com.isThing(goedit))
            {
                String val=request.getParameter("val");
                response.sendRedirect("/corefx/start/main?scope="+elcode+"&area="+scope+"&parent="+selected+"&type="+val+"&element="+ele+"&ro="+rows+"&co="+cols);
            
            }else
            {
                if(!common.Com.isThing(goedit))
                {
            if(common.Com.isThing(rows))
            {
              

                tag t=new tag("table",new feed());
                t.id="testid";

                GenTable tab=new GenTable(t);
                tab.scope=scope;
                tab.id=selected;
                tab.setCells(Integer.parseInt(rows));
                tab.setRows(Integer.parseInt(cols));
                tab.create();

                out.print(tab.getOfflineCode());

                String but="<input id='comm' name='"+tab.sellid+"' type='submit' value='select' onclick='selected(name)'/>";
                out.println("<br>");
                out.println(but);
                
                
                
            } else
            {
                
                String qu=""+'"';
           
                Numeric row=new Numeric("row");
                Numeric cow=new Numeric("col");
                
                String ro=row.getOfflineCode();
                String co=cow.getOfflineCode();
             
                String bu="<input id='row:col' type='submit' value='proceed' onclick='addParams(id)'/>";
            
                out.print(ro+co+"<br>"+bu);
            
            }      
            }
            }               
            
            }
            
            

                

            
        }
            out.println("</body>");
            out.println("</html>");
        }
    }

    String getFieldValue(String a)
{
    String result=a;
    
    switch(a)
    {
        case "onmouse":
        {
            result="onmouseover";
            break;
        }
        case "offmouse":
        {
            result="onmouseout";
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
