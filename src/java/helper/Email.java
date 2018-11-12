/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author Maxkarpov
 */
public class Email {
    
    public static String handle(String emailid, String project, String user, String event,String lan, HttpServletRequest request)
    {
        String text = null;
        String result = "success";
        String query = "select * from config.email where emailid='"+emailid+"' and project='"+project+"' and user='"
        +user+"' and event='"+event+"' and lan='"+lan+"'";
       
        
        feed f = new feed();
        data d = new data(f.cof);
        List<String[]> l = new ArrayList<>();
        try
        {
            l = d.pullTable(query, 19);
        }
        catch(Exception ex)
        {
            result = "error";
        }
        
        
        if(l.size() > 0)
        {
        String[] st = l.get(0);
        
        String subj = st[7];
        String subq = st[8];
        String gree = st[9];
        String greq = st[10];
        String tex1 = st[11];
        String que1 = st[12];
        String dat1 = st[13];
        String tex2 = st[14];
        String que2 = st[15];
        String dat2 = st[16];  
        String sign = st[17];
        String emai = "";
        
        
        if(st[18].equals("user"))
        {
            emai = request.getParameter("email");
        }else
        {
            if(st[18].equals("guest"))
            {
            emai = request.getParameter("selected");
            }
            else
            {
            emai = st[18];
            }
            
        }
            
        String send = st[4];
        String pass = st[5];
        
        String subquery = "";
        
        Isler isq = new Isler(subq,f.cop,(String)request.getSession().getAttribute("language"));
        isq.populate(request);
        
        subquery = isq.value;
        
        subj = subj + " " + subquery;
        StringBuilder ftext = new StringBuilder();
        ftext.append(gree);
        Isler isg = new Isler(greq,f.cop,(String)request.getSession().getAttribute("language"));
        isg.populate(request);
        ftext.append(isg.value);
        ftext.append("\r\n");
        
        if(common.Com.isThing(que1))
        {
            if(dat1.equals("true"))
            {
                Datatab d1 = new Datatab(que1,request);
                
                List<String[]> ld1 = new ArrayList<>();
                
                ld1 = d1.list;
                StringBuilder bld = new StringBuilder();
                bld.append(tex1+"\r\n");
                if(ld1.size()>0)
                {
//                 for(int i = 0; i< ld1.size(); i++)
//                 {
                     String line = common.Com.concat(ld1.get(0), " ");
                     bld.append(line+"\r\n");
                 
   //              }
                    
                    
                }
                tex1 = bld.toString();
            }else
        {
        boolean dec = false;
        if(que1.contains("_decode"))
        {
            que1 = que1.substring(0,que1.indexOf("_decode"));
            dec = true;
        }
        Isler is1 = new Isler(que1,f.cop,(String)request.getSession().getAttribute("language"));
        is1.populate(request);       
        StringBuilder bl = new StringBuilder();
        bl.append(tex1);
        
        String val1 = is1.value;
        if(dec)
        {
        Encryptor enc = new Encryptor();
        
        try
        {
        val1 = enc.decrypt(is1.value);
        }catch(Exception jd)
        {}
        
        
        }
        bl.append(val1);
        tex1 = bl.toString();
        
        }
        
        }
        
        ftext.append(tex1);
        ftext.append("\r\n");
       
         if(common.Com.isThing(que2))
        {
            if(dat2.equals("true"))
            {
                Datatab d2 = new Datatab(que2,request);
                
                List<String[]> ld2 = new ArrayList<>();
                
                ld2 = d2.list;
                StringBuilder bld2 = new StringBuilder();
                bld2.append(tex2+"\r\n");
                if(ld2.size()>0)
                {
//                 for(int i = 0; i< ld2.size(); i++)
//                 {
                     String line = common.Com.concat(ld2.get(0), " | ");
                     bld2.append(line+"\r\n");
                 
//                 }
                    
                    
                }
                tex2 = bld2.toString();
            }else
        {
            boolean dec = false;
                if(que2.contains("_decode"))
        {
            que2 = que2.substring(0,que2.indexOf("_decode"));
            dec = true;
        }
        Isler is2 = new Isler(que2,f.cop,(String)request.getSession().getAttribute("language"));
        is2.populate(request);       
        StringBuilder bl = new StringBuilder();
        bl.append(tex2);
        
        String val2 = is2.value;
        if(dec)
        {
               Encryptor enc = new Encryptor();
        
        try
        {
        val2 = enc.decrypt(is2.value);
        }catch(Exception jd)
        {
        } 
        
        }
        bl.append(val2);
        tex2 = bl.toString();
        
        }
        
        }
       
        ftext.append(tex2);
        ftext.append("\r\n");       
        ftext.append("\r\n"); 
        ftext.append(sign);
        if(!emailid.equals("resetlink")) 
        {
        MySimpleMail.sendTLS(emai, subj, ftext.toString());
        }else
        {
        HTMLEmail.send(emai, "info@redhotpage.com", subj, ftext.toString());
        }
        
        
        
      
        }
        
        
        return result;
    }
    
}
