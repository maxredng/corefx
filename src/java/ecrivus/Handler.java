/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecrivus;

import data.data;
import helper.Localized;
import helper.MySimpleMail;
import html.feed;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Handler {
    public boolean Logged;
    private HttpServletRequest request;
    public String scope;
    public String error;
    public String login;
    public char ret = '\n';
    private String uid;
    
    
    final Localized seller0;
    final Localized seller1;
    
    public Handler(HttpServletRequest r)
    {
        request = r;
        seller0 = new Localized(request,"pro","nor");
        seller1 = new Localized(request,"pro","received");
        populate();
    }
    
    final void populate()
    {
        scope = request.getParameter("scope");
        uid = (String)request.getSession().getAttribute("user");
        switch (scope)
        {
            case "confex":
            {
                
        StringBuffer requestURL = request.getRequestURL();
        
         String queryString = request.getQueryString();
         String rl = "";
             if (queryString == null) {
        rl = requestURL.toString();
    } else {
        rl = requestURL.append('?').append(queryString).toString();
    }
                        
                
                
                Person per = new Person(rl);
                login = per.email;
                     Date date=new Date();
                     
                     Timestamp ts=new Timestamp(date.getTime());
                    
                     String stamp=ts.toString();                
                
                
                String pass = "Dome123";
                
                try
                {
                    pass = helper.RandomString.getString(6);
                }
                catch(Exception x)
                {}
                

                
                String req = "insert into prod.ppl values('"+per.phone+"','"+per.email+"','"
                        +per.first+"','"+per.last+"','"+pass+"','','"+per.company+"','','','','','','"+stamp+"')";
                
                feed f = new feed();
                
                data da = new data(f.cop);
                  boolean OK = false;
                try
                {
                    da.Execute(req);
                    OK = true;
                }
                catch(Exception ex)
                {
                error = ex.getMessage();
                }
                
                        String sub=per.phone.substring(0,3);
                        Date d2=new Date();
                        Timestamp stm=new Timestamp(d2.getTime());
                        long sdi=ts.getTime();     
                        String orid=sub+Objects.toString(sdi,null);
                //"update prod.orders set orderid='"+orid+"',comment='"+per.comment+"',personid='"+per.email+"',status='new' where personid='"+uid+"' and (orderid is NULL or orderid='dm')";
                        String orq ="update prod.orders set orderid='"+orid+"',comment='comment: "+per.comment+"',personid='"+per.email+"',status='new' where personid='"+uid+"' and orderid='dm'";
                        String oryq="update prod.orders set orderid='"+orid+"',comment=NULL, personid='"+per.email+"',status='new' where personid='"+uid+"' and orderid is NULL";
                        data dup=new data(f.cop);
                        data doup = new data(f.cop);
                        if(OK)
                        {
                            try
                            {
                                dup.Execute(orq);
                                doup.Execute(oryq);
                                
                            }catch(Exception erx)
                                {
                                    error = "error updating orders: "+erx.getMessage();
                                
                                }
                        
                        
                        }
                      
               data dor = new data(f.cop);
               
               List<String[]> l = new ArrayList<>();
               
                try
               {
                       l = dor.pullTable("select prodid,amount from prod.orders where orderid='"+orid+"'", 2);


               }catch(Exception x)
               {
                   error = x.getMessage();
               }              
                      
                String orders ="";

                for(int z = 0; z<l.size(); z++)
                {
                    data dav = new data(f.cop);
                    
                    
                    String prod = "";                    

                    
                  try
                    {
                       
                        prod = dav.pullString("select personid from prod.voice where voiceid='"+l.get(z)[0]+"' and lan='"+request.getLocale().getLanguage()+"'");

                        if(!common.Com.isThing(prod))
                        {
                        prod = dav.pullString("select personid from prod.voice where voiceid='"+l.get(z)[0]+"'");
                        }
                          
                        
                    }catch(Exception dx)
                    {

                    }
                    
                    
                    if(l.get(z)[1].length()<1)
                    {
                       orders = orders+prod+" "+l.get(z)[1]+ret; 
                    }else
                    {
                    orders = orders+prod+" "+l.get(z)[1]+"€"+ret;
                    }
                }
                
                if(OK)
                {
                    
                    //public Localized(HttpServletRequest r, String isl, String ID)
                Localized loc0 = new Localized(request,"pro","hi");
                Localized loc1 = new Localized(request,"pro","ecsubj");
                Localized loc2 = new Localized(request,"pro","ectx");
                Localized loc3 = new Localized(request,"pro","ecpass");
                
                String subj = loc1.value;
                String log = loc0.value+", "+per.first+"."+ret+loc2.value;
                String pas = loc3.value;
                
                try
                {
                MySimpleMail.sendTLS(per.email, subj, log+": "+ret+per.email+ret+pas+ret+pass);
                }catch(Exception mex)
                {
                error = "error sending mail: "+mex.getMessage();
                }
                
                Localized seller0 = new Localized(request,"pro","nor");
                Localized seller1 = new Localized(request,"pro","received");
                
                try
                {
                
                    MySimpleMail.sendTLS(f.ordermail, seller0.value+" "+orid, seller1.value+" "+orid+ret+orders);
                    
                    
                }catch(Exception selx)
                {
                error = selx.getMessage();
                }
                
                }
                
                Localized buy1 = new Localized(request,"pro","thanks");
                Localized buy2 = new Localized(request,"pro","your");
                
                try
                {
                MySimpleMail.sendTLS(per.email, seller0.value+" "+orid, buy1.value+" "+orid+ret+orders+ret+buy2.value);
                }catch(Exception nx)
                {}
                    
                if(OK)
                {
                Logged = true;
                }
                break;
            }
        }
        
    }
    
    
}
