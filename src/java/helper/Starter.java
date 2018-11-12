/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.ColTab;
import data.ConTab;
import data.data;
import html.feed;
import html.param;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maxkarpov
 */
public class Starter {
    
    public feed Feed;
    public HttpServletRequest request;
    public String error;
    public String project;
    
    public String owner;
    
    public boolean langset;
    
    
    public Starter(HttpServletRequest r)
    {
    Feed=new feed();
    request=r;
    langset=false;
    populate();
    
    }
    
    public Starter(HttpServletRequest r,boolean b)
    {
    Feed=new feed();
    request=r;
    langset=b;
    populate();
    
    }    
    
   public void addConfig()
   {
            ConTab ct=new ConTab();                
            try
            {

            ct.pour("select * from "+Feed.cof.name+".config", Feed.cof, 9);
            param prm=new param("config",ct);
            Feed.addParameter(prm);
            
            }catch(Exception conx)
            {
                error=conx.getMessage();       

            }
    
   }
   public void addCol()
   {
            ColTab ct=new ColTab();                
            try
            {

            ct.pour("select * from "+Feed.cof.name+".col", Feed.cof, 9);
            param prm=new param("ColTab",ct);
            Feed.addParameter(prm);
            
            }catch(Exception conx)
            {
                error=conx.getMessage();       

            }
    
   }    


   
    final void populate()
    {
            HttpSession session = request.getSession();
        
        String[] atr = {"code","email"};
         boolean islan= false;
         String lang="";
         String[] keys={"mscope","scope","area","steamid","dolog","openid.identity","project","refresh","exit","seed","cell","eme","pap","nam","mail","uid","dir","nam","lin","pin","selected","page","recalc","isel","cart","good","flow","prodid","amount","mysid","user","ln","lan","id","mode"};
        
        for (String key : keys) 
        {
            
            Param pa = new Param(key, request);
         
            
            
            if(pa.isThing)
            {
                if(pa.name.equals("lan"))
                        {
     //                   islan=true;
                        }
            Feed.addParameter(pa.Par);
            }
            
            
            
        }
        
        for (String ss : atr) 
        {
            String vl = (String)session.getAttribute(ss);
            Feed.removeValue(ss);
            Feed.addParameter(new param(ss,vl));
        }
        
        Locale loc=request.getLocale();        
        String ln=loc.getLanguage(); 
        //ln = "ru";
        if(islan)
        {

            ln=lang;
            ln = "ru";
        
        }
        param lan=new param("lan",ln);
        param lng=new param("language",ln);
//        if(langset)
//        {
//            lan=new param("lan","ru");
//            lng=new param("language","ru");
//        
//        }        
        
        Feed.addParameter(lan);
        Feed.addParameter(lng);    
        

        if(!common.Com.isThing(Feed.getValue("page")))
                {
                    param pg=new param("page","0");
                    Feed.addParameter(pg);
                
                }
        
        if(!common.Com.isThing(Feed.getValue("scope")))
        {
            if(common.Com.isThing(Feed.getValue("area")))
            {
                param sc=new param("scope",Feed.getValue("area"));
                Feed.addParameter(sc);
            
            }
        }
        String rep = request.getParameter("selected");
        if(!common.Com.isThing(request.getParameter("selected")))
        {
            if(request.getParameter("scope").equals("magazin"))
            {
              param sl = new param("selected","paravoz");
            Feed.addParameter(sl);          
            
            }

        }else
        {
        if(request.getParameter("scope").equals("stage")||request.getParameter("scope").equals("derevo"))
        {
        if(Feed.getValue("selected").equals("paravoz"))
        {
        Feed.removeValue("selected");
            param sl = new param("selected","main");
            Feed.addParameter(sl);         
        
        }
        }
        
        }
        
        List<String> l = (List<String>)session.getAttribute("elements");
        
        
                    if(request.getQueryString()!=null)
            {
            String url=request.getRequestURI();
            url=url+"queStion"+request.getQueryString().replace("=", "equaLs"); 
            
            param urp = new param("page_signature",url);
            Feed.addParameter(urp);
                    
            
                   
            
            }
        
        if(l == null)
        {
            String scope = request.getParameter("scope");
            //WILL NEED TO LOAD NAME OF PROJECT TO STARTER AT FIRST LAUNCH
            
            owner = getThing("select project from config.project where scope='"+scope+"'","project");
            owner = getThing("select project from config.project where scope='"+scope+"'","project");
            
            String elq = "select distinct eid from config.element where project='" + project + "' and user = '" + owner + "'";
            data da = new data(Feed.cof);
            List<String> elements = new ArrayList<>();
            try
            {
            
                elements = da.pullList(elq, 1);
                param pel = new param("elements",elements);
                Feed.addParameter(pel );
            }catch(Exception x)
            {
                error = x.getMessage();
            }
            
            
        }else
        {
            if(l.size() == 0)
            {
              String scope = request.getParameter("scope");
            //WILL NEED TO LOAD NAME OF PROJECT TO STARTER AT FIRST LAUNCH
            
            owner = getThing("select project from config.project where scope='"+scope+"'","project");
            owner = getThing("select project from config.project where scope='"+scope+"'","project");
            
            String elq = "select distinct eid from config.element where project='" + project + "' and user = '" + owner + "'";
            data da = new data(Feed.cof);
            List<String> elements = new ArrayList<>();
            try
            {
            
                elements = da.pullList(elq, 1);
                param pel = new param("elements",elements);
                Feed.addParameter(pel );
            }catch(Exception x)
            {
                error = x.getMessage();
            }
                      
            
            
            }
        
        }
        
            
    }
    
    public String getThing(String q,String name)
    {
        String result = null;
            String re = (String)request.getSession().getAttribute(name);
            
            if(re!=null)
            {
                result = re;
            }else
            {
                data da = new data(Feed.cof);
                try
                {
                result = da.pullString(q);
                }catch(Exception x)
                {
                    x.printStackTrace();
                }
            
            }
            
        return result;
    }
    
    public boolean isThing(String key)
    {
        boolean result=false;
    
            for(int i=0;i<Feed.params.size();i++)
            {
                param pa=Feed.params.get(i);
                
                if(pa.name.equals(key))
                {
              
                    result=true;
                    break;
                    
                }
            
            }
        
        
        return result;
    }
}
