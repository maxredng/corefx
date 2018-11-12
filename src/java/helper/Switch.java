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
public class Switch {
    
    public static String handle(HttpServletRequest request)
    {
        String result = "";
        feed f = new feed();
        String ar = request.getParameter("switch");
        boolean OK = true;
        String error = "";
        String us = (String)request.getSession().getAttribute("user");
        
        switch(ar)
        {
            case "version":
            {
            
            String scope = request.getParameter("scope");
            String area = request.getParameter("area");
            
             
            String clear = "delete from config.store where sign like '%scopeequaLs"+scope+"%";
            String clar = "delete from config.store where sign like '%scopeequaLs"+area+"%";
           // String calc = "delete from config.calc where name='"+area+"'";

            String vr = "select version from config.version where scope='"+area+"'";
            
            data dav = new data(f.cof);
            
            
            try
            {
                double ver = Double.parseDouble(dav.pullString(vr));
                ver = ver + 0.1;
             //   dav.Execute("delete from config.version where scope='" + area +"'");
             //   dav.Execute("insert into config.version values('" + area + "'," + Double.toString(ver) + ")");
                dav.Execute(clear);
                dav.Execute(clar);
             //   dav.Execute(calc);
            }
            catch(Exception x)
            {}
                
              result = "/corefx/start/main?scope=stage&area="+area+"&selected="+request.getParameter("selected");  
            break;
            }
            
            case "addnewvenue":
            {
                String sc = request.getParameter("name");
                            String qr = "insert into bank.venue values('" + sc + "')";
                            data dad = new data(f.bank);
                            
                            try
                            {
                                dad.Execute(qr);
                            
                            }
                            catch(Exception ex)
                            {
                                OK = false;
                                error = ex.getMessage();
                            }                
                        if(OK)
                        {
                            result = "/corefx/start/main?scope=venues";
                        }else
                        {
                            result = "/corefx/start/main?scope=error&message="+error;
                        
                        }                    
            
                break;            
            
            
            }
            
            case "addnewscenario":
            {
                String sc = request.getParameter("name");
                            String qr = "insert into bank.scena values('" + sc + "')";
                            data dad = new data(f.bank);
                            
                            try
                            {
                                dad.Execute(qr);
                            
                            }
                            catch(Exception ex)
                            {
                                OK = false;
                                error = ex.getMessage();
                            }                
                        if(OK)
                        {
                            result = "/corefx/start/main?scope=scenario";
                        }else
                        {
                            result = "/corefx/start/main?scope=error&message="+error;
                        
                        }                    
            
                break;
            }
            
            case "delvenue":
            {
                String rq = request.getQueryString();
                
                    String[] els = rq.split("&");
                    
                    for(int i = 0; i<els.length; i++)
                    {
                        String[] temp = els[i].split("=");
                        
                        if(temp[0].contains("el"))
                        {
                            String qr = "delete from bank.venue where venue='" + temp[1] + "'";
                            data dad = new data(f.bank);
                            
                            try
                            {
                                dad.Execute(qr);
                            
                            }
                            catch(Exception ex)
                            {
                                OK = false;
                                error = ex.getMessage();
                            }
                            
                        }
                        
                    
                        if(OK)
                        {
                            result = "/corefx/start/main?scope=venues";
                        }else
                        {
                            result = "/corefx/start/main?scope=error&message="+error;
                        
                        }
                        
                    }
            
                break;                
            
            }
            
            case "delscenario":
            {
                String rq = request.getQueryString();
                
                    String[] els = rq.split("&");
                    
                    for(int i = 0; i<els.length; i++)
                    {
                        String[] temp = els[i].split("=");
                        
                        if(temp[0].contains("el"))
                        {
                            String qr = "delete from bank.scena where scid='" + temp[1] + "'";
                            data dad = new data(f.bank);
                            
                            try
                            {
                                dad.Execute(qr);
                            
                            }
                            catch(Exception ex)
                            {
                                OK = false;
                                error = ex.getMessage();
                            }
                            
                        }
                        
                    
                        if(OK)
                        {
                            result = "/corefx/start/main?scope=scenario";
                        }else
                        {
                            result = "/corefx/start/main?scope=error&message="+error;
                        
                        }
                        
                    }
            
                break;
            }
                case "event":
            {
                String sl = request.getParameter("selected");
                
                String pr = request.getParameter("project");    
                
                data d = new data(f.cof);
                data dp = new data(f.cof);
                
                List<String[]> tab = new ArrayList<>();
                String cms = "";
                
                try
                {
                    tab = d.pullTable("select * from config.event where event='"+sl+"' and project='"+pr+"' and user='"+us+"'", 7);
                    cms = dp.pullString("select parent from config.cms where project='"+pr+"' and user='"+us+"' and event='"+sl+"'");
                }
                catch(Exception ex)
                {
                    OK = false;
                }
                String tb = "";
                if(tab.size()>0)
                {
                    tb = tab.get(0)[0];
                
                }
                
                result = "/corefx/start/main?scope=event&project="+pr+"&selected="+tb+"&type="+sl+"&parent="+cms;
                
                for(int i = 0; i<tab.size(); i++)
                { 
                    String[] rw = tab.get(i);
                    String row = "&row"+i+"="+rw[1]+","+rw[5]+","+rw[6];
                    result = result + row;
                }
                
                if(!OK)
                {
                    result = "ERROR";
                }
                
                
                break;
            }
                case "update":
                {
                
                   
                    
               
                String pr = request.getParameter("project");
                String ev = request.getParameter("event");
                boolean failed = false;
                if(ev.equals("doreset")||ev.equals("reset"))
                {
                   failed = Reset.locked(request);
                }
                
                
                
                if(!failed)
                {
                if(ev.equals("detail"))
                {
                result = "/corefx/start/main?scope=redpro";
                }

                Event event = new Event(ev,pr);
                String table = event.table;
                String query = "update prod." + table + " set ";
                boolean update = false;
                List<DBField> param = new ArrayList<>();
                
                for(int i = 0; i<event.fields.size(); i++)
                {
                    DBField field = event.fields.get(i);
                    String parameter = field.parameter;
                     
                    String name = field.name;
                    String action = field.action;
                    
                    
                        Value value = null; 
                        String val="";
                        try
                        {
                                value = new Value(parameter,field.action,request);
                                val = value.value;
                        }
                        catch(Exception ex)
                        {
                            value = new Value();
                        }
                    if(action.equals("update")||action.equals("encrypt"))
                    {
                        update = true;

                        
                        if(i<event.fields.size() - 1)
                        {
                        query = query + name + "='" + val + "', ";
                        }else
                        {
                        query = query + name + "='" + val + "' ";
                        }
                        
                    }else
                    {
                        if(action.equals(""))
                        {
                             if(value.isParam)
                             {
                                 field.setValue(val);
                                 param.add(field);
                             }
                                                     if(i<event.fields.size() - 1)
                        {
                        query = query + name + "='" + val + "', ";
                        }else
                        {
                        query = query + name + "='" + val + "' ";
                        }
                        }
                    
                    }
                    

                    
                    
                     
                }
                
                          if(query.endsWith(", "))
                    {
                        query = query.substring(0, query.length() - 2);
                    }
                    
                          query = query + " where ";
                          
                          for(int i =0; i<param.size(); i++)
                          {
                              DBField par = param.get(i);
                              
                              String key = par.name;
                              String vl = par.getValue();
                              if(i<param.size() - 1)
                              {
                               query = query + key + "='" + vl + "' and";
                              }
                              else
                              {
                              query = query + key + "='" + vl +"'";
                              }
                              
                              
                          }
                          
                          data da = new data(f.cop);
                          try
                          {
                          da.Execute(query);
                          
                          
                          }catch(Exception x)
                          {}
                          
                Logic.handle(request, ev);
                }else
                {
                    result = "/corefx/start/main?scope=redbad";
                }
                break;
                }
                case "submit":
                {
                String[] pra = {"random","timestamp","list"};
                String[] und = {"text"};
                String tab = request.getParameter("tables");  
                String event = request.getParameter("type");
                Columns cls = new Columns(tab);
                String pro = request.getParameter("project");
                for(int i = 0; i<cls.columns.size(); i++)
                {
                    String col = cls.columns.get(i);
                    String param = "";
                    
                    
                    
                    String par = request.getParameter("zin"+col);
                    String suf = request.getParameter("dro"+col);
                    String txt = request.getParameter("sin"+col);
                    String bxi = request.getParameter("att"+col);
                                          
                    if(common.Com.contains(pra, par))
                    {
                    param = "^"+par;
                    txt = "";
                    if(common.Com.isThing(suf))
                    {
                        if(!suf.equals("0"))
                        {
                        param = param+"_"+suf;
                        }
                            
                        
                    
                    
                    }else
                    {
                    param = par;
                    }

                    }
                    if(common.Com.contains(und, par))
                    {
                        param = "_"+txt;
                    
                    }
                    if(!common.Com.isThing(param))
                    {
                        param = txt;
                    }
                    if(common.Com.isThing(par))
                    {
                        data dq = new data(f.cof);
                        String qr = "select event from config.event where field='"+col+"' and tab='"+tab+"' and project='"+pro+"' and user='"+us+"' and event='"+event+"'";
                        String ev = "";
                        try
                        {
                            ev = dq.pullString(qr);
                        }
                        catch(Exception wx)
                        {}
                        String que = "";
                        if(common.Com.isThing(ev))
                        {
                            que = "update config.event set parameter='"+param+"' ";
                            if(bxi!=null)
                            {
                               if(common.Com.isThing(bxi)&!bxi.equals("-"))
                            {
                                que = que + ",action='"+bxi+"' ";
                            
                            }else
                            {
                                que = que + ",action='' ";
                            }                         
                            
                            
                            }else
                            {
                                que = que + ",action='' ";
                            }    

                            
                            que = que+"where field='"+col+"' and tab='"+tab+"' and project='"+pro+"' and user='"+us+"' and event='"+event+"'";
                            System.out.println(que);                        
                        
                        }else
                        {
                            String action = "";
                                                        if(common.Com.isThing(bxi)&!bxi.equals("-"))
                            {
                                action = bxi;
                            
                            }
                            
                            que = "insert into config.event values('"+tab+"','"+col+"','"+pro+"','"+us+"','"+event+"','"+param+"','"+action+"')";
                        }
                    data dar = new data(f.cof);
                    try
                    {
                        if(!param.equals("null"))
                        {
                        dar.Execute(que);
                        }
                        
                    }
                    catch(Exception xx)
                    {}                      
                    }
                    

                
                }
                
                
                
                String pr = request.getParameter("project");   
                result = "/corefx/start/main?scope=newboard&project="+pr;
                break;
                }
                case "email":
                {
                    String[] st = {"query","greeting","greetquery","text0","query0","datatable0","text1","query1","datatable1","signature"};
                
                    String ln = request.getParameter("lan");
                    String sb = request.getParameter("subj");
                    String qr = request.getParameter("query");
                    String gr = request.getParameter("greeting");
                    String greetquery = request.getParameter("greetquery");
                    String text0 = request.getParameter("text0");
                    String query0 = request.getParameter("query0");
                    String datatable0 = request.getParameter("datatable0");
                    String text1 = request.getParameter("text1");
                    String query1 = request.getParameter("query1");
                    String datatable1 = request.getParameter("datatable1");   
                    String signature = request.getParameter("signature");
                    String label = request.getParameter("label");
                    String pro = request.getParameter("project");
                    String ev = request.getParameter("type");
                    String sender = request.getParameter("sender");
                    String password = request.getParameter("password");
                    String address = request.getParameter("towho");
                    data dai = new data(f.cof);
                    String ml = "";
                    
                    try
                    {
                        if(!common.Com.isThing(address))
                        {
                            address = us;
                        }
                        
                        
                        
                        ml = dai.pullString("select emailid from config.email where emailid='"+label+"' and lan='"+ln+"' and"
                                + " project='"+pro+"' and user='"+us+"'");
                        String qry = "";
                        if(!common.Com.isThing(ml))
                        {
                            qry = "insert into config.email values('"+label+"','"+pro+"','"+us+"','"+ev+"','"+sender+"','"+password+"','"
                                    
                        +ln+"','"+sb+"','"+qr+"','"+gr+"','"+greetquery+"','"+text0+"','"+query0+"','"+datatable0+"','"
                        +text1+"','"+query1+"','"+datatable1+"','"+signature+"','"+address+"')";
                        
                        }else
                        {
                            qry = "update config.email set sender='"+sender+"', pass='"+password+"', subj='"+sb+"', subjquery='"
                        +qr+"', greeting='"+gr+"', greetquery='"+greetquery+"', text1='"+text0+"',textquery1='"+query0+"', datatab1='"+datatable0
                        +"', text2='"+text1+"', textqry2='"+query1+"', datatab2='"+datatable1+"', signature='"+signature+"', email='"+address+"' "
                        +"where emailid='"+label+"' and lan='"+ln+"'";
                        }
                    data dao = new data(f.cof);
                    
                    dao.Execute(qry);
                    
                    result = "/corefx/start/main?scope=terminate";
                        
                    }catch(Exception ex)
                    {}
                   
                    
                    
                 break;   
                }
                case "editemail":
                {
                    String pro = request.getParameter("project");
                    String event = request.getParameter("type");
                    String lan = request.getParameter("lan");
                    String emailid = request.getParameter("id");
                    
                    data dal = new data(f.cof);
                    
                    List<String[]> l = new ArrayList<>();
                    
                    try
                    {
                    l = dal.pullTable("select * from config.email where emailid='"+emailid+"' and lan='"+lan+"' and user='"
                    +us+"' and project='"+pro+"'", 19);
                    }
                    catch(Exception wex)
                    {}
                    
                    if(l.size()>0)
                    {
                        String[] temp = l.get(0);
                        
                        String emid = temp[0];
                        String proj = temp[1];
                        String user = temp[2];
                        String even = temp[3];
                        String send = temp[4];
                        String pass = temp[5];
                        String lang = temp[6];
                        String subj = temp[7];
                        String subq = temp[8];
                        String gree = temp[9];
                        String greq = temp[10];
                        String txt0 = temp[11];
                        String que0 = temp[12];
                        String tab0 = temp[13];
                        String txt1 = temp[14];
                        String que1 = temp[15];
                        String tab1 = temp[16];
                        String sign = temp[17];
                        String emai = temp[18];
                        
                        String[] tma = {"emailid","project","type","sender","password","lan","datatab1","datatab2"
                        ,"email"};
                        String[] tmb = {emid,proj,even,send,pass,lang,tab0,tab1,emai};
                        
                        String pt = "/corefx/start/main?scope=setemail";
                        
                        for(int i = 0; i<tma.length; i++)
                        {
                            pt = pt+"&"+tma[i]+"="+tmb[i].replace("%20", " ");
                        }
                      

                        result = pt;
                    }
                    break;
                }
                case "saverecent":
                {
                    String ur = request.getRequestURI();
                    
                   String url = ur + "?" + request.getQueryString();
                    
                    String URL = url.substring(0,url.indexOf("&switch"));
                    
                    String qudel = "delete from config.recent";
                    String qusav = "insert into config.recent values('"+URL+"')";
                    
                    data dad = new data(f.cof);
                    data das = new data(f.cof);
                    
                    try
                    {
                        dad.Execute(qudel);
                        das.Execute(qusav);
                        
                        result = URL;
                        
                        
                    }catch(Exception x)
                    {
                        result = "/corefx/start/main?scope=error&mess="+x.getMessage();
                    }
                    
                    
                break;
                }
                case "openrecent":
                {
                    String pq = "select line from config.recent";
                    
                    data daf = new data(f.cof);
                    
                    try
                    {
                    result = daf.pullString(pq);
                    }catch(Exception ex)
                    {
                    result = "/corefx/start/main?scope=error&mess="+ex.getMessage();
                    }
                
                    break;
                }
                case "add":
                {
                    String suite = request.getParameter("suite");
                    
                    for(int i = 0; i<300; i++)
                    {
                    String el = request.getParameter("el" + Integer.toString(i));
                    

                    if(common.Com.isThing(el))
                    {
                    String g1 = "select testid from bank.test where testid='" + el + "' and suite='" + suite + "' and venue = '" + request.getParameter("venue") + "' and capacity='" + request.getParameter("capacity") + "' and session='"
                            + request.getParameter("session") + "' and type='" + request.getParameter("type") + "' and tif='" + request.getParameter("tif") + "' and maxfloor='" + request.getParameter("maxfloor") + "'";                    
                     data dar = new data(f.bank);      
                     String exist = null;
                    try
                    {
                    exist = dar.pullString(g1);

                    }
                    catch(Exception xx)
                    {}
   
                    if(!common.Com.isThing(exist))
                    {
                    int max = -1;
                    data dai = new data(f.bank);
                       try
                        {
                              
                             max = dai.pullInt("select max(setid) from bank.test");
                             max = max + 1;

                        }
                        catch(Exception ex)
                        {}       
                       
                    String qro = "insert into bank.test values('"+ el + "','" + request.getParameter("venue") + "','" + request.getParameter("capacity") + "','" + request.getParameter("session") + "','" + request.getParameter("type") + "','" + request.getParameter("tif") + "','" + request.getParameter("maxfloor") + "'," + max + ",'" + suite +"')";                        
                    data din = new data(f.bank);
                       try
                        {
                              
                          din.Execute(qro);

                        }
                        catch(Exception xex)
                        {}                        
                    
                    
                    }

                      
                       
                    
                    }else
                    {
                        break;
                    }
                    
                    
                    }
                    
                    
                    
                    result = "/corefx/start/main?scope=terminate";
   
                    break;
                
                }
                case "newsuite":
                {
                    String name = request.getParameter("name");
                    
                    String max = helper.Help.maxUnderscore(f.bank, "select id from bank.suites");
                    
                    String inq = "insert into bank.suites values('" + max + "','" + name + "','" + us + "')";
                    data da = new data(f.bank);
                    try
                    {
                    da.Execute(inq);
                    
                    }
                    catch(Exception nex)
                    {}
                    
                    String pa = request.getRequestURI();
                    String re = request.getQueryString();
                    String rrq = re.substring(0,re.indexOf("&name"));
                    
                result = pa + "?" + rrq;
                break;
                }
                
        }
        

        
        
        return result;
    }
        public static String handle(HttpServletRequest request,String evnt)
    {
        String result = "";
        feed f = new feed();
        String ar = request.getParameter("switch");
        boolean OK = true;
        String error = "";
        String us = (String)request.getSession().getAttribute("user");
        
        switch(ar)
        {
            case "version":
            {
            
            String scope = request.getParameter("scope");
            String area = request.getParameter("area");
            
             
            String clear = "delete from config.store where sign like '%scopeequaLs"+scope+"%";
            String clar = "delete from config.store where sign like '%scopeequaLs"+area+"%";
           // String calc = "delete from config.calc where name='"+area+"'";

            String vr = "select version from config.version where scope='"+area+"'";
            
            data dav = new data(f.cof);
            
            
            try
            {
                double ver = Double.parseDouble(dav.pullString(vr));
                ver = ver + 0.1;
             //   dav.Execute("delete from config.version where scope='" + area +"'");
             //   dav.Execute("insert into config.version values('" + area + "'," + Double.toString(ver) + ")");
                dav.Execute(clear);
                dav.Execute(clar);
             //   dav.Execute(calc);
            }
            catch(Exception x)
            {}
                
              result = "/corefx/start/main?scope=stage&area="+area+"&selected="+request.getParameter("selected");  
            break;
            }
            
            case "addnewvenue":
            {
                String sc = request.getParameter("name");
                            String qr = "insert into bank.venue values('" + sc + "')";
                            data dad = new data(f.bank);
                            
                            try
                            {
                                dad.Execute(qr);
                            
                            }
                            catch(Exception ex)
                            {
                                OK = false;
                                error = ex.getMessage();
                            }                
                        if(OK)
                        {
                            result = "/corefx/start/main?scope=venues";
                        }else
                        {
                            result = "/corefx/start/main?scope=error&message="+error;
                        
                        }                    
            
                break;            
            
            
            }
            
            case "addnewscenario":
            {
                String sc = request.getParameter("name");
                            String qr = "insert into bank.scena values('" + sc + "')";
                            data dad = new data(f.bank);
                            
                            try
                            {
                                dad.Execute(qr);
                            
                            }
                            catch(Exception ex)
                            {
                                OK = false;
                                error = ex.getMessage();
                            }                
                        if(OK)
                        {
                            result = "/corefx/start/main?scope=scenario";
                        }else
                        {
                            result = "/corefx/start/main?scope=error&message="+error;
                        
                        }                    
            
                break;
            }
            
            case "delvenue":
            {
                String rq = request.getQueryString();
                
                    String[] els = rq.split("&");
                    
                    for(int i = 0; i<els.length; i++)
                    {
                        String[] temp = els[i].split("=");
                        
                        if(temp[0].contains("el"))
                        {
                            String qr = "delete from bank.venue where venue='" + temp[1] + "'";
                            data dad = new data(f.bank);
                            
                            try
                            {
                                dad.Execute(qr);
                            
                            }
                            catch(Exception ex)
                            {
                                OK = false;
                                error = ex.getMessage();
                            }
                            
                        }
                        
                    
                        if(OK)
                        {
                            result = "/corefx/start/main?scope=venues";
                        }else
                        {
                            result = "/corefx/start/main?scope=error&message="+error;
                        
                        }
                        
                    }
            
                break;                
            
            }
            
            case "delscenario":
            {
                String rq = request.getQueryString();
                
                    String[] els = rq.split("&");
                    
                    for(int i = 0; i<els.length; i++)
                    {
                        String[] temp = els[i].split("=");
                        
                        if(temp[0].contains("el"))
                        {
                            String qr = "delete from bank.scena where scid='" + temp[1] + "'";
                            data dad = new data(f.bank);
                            
                            try
                            {
                                dad.Execute(qr);
                            
                            }
                            catch(Exception ex)
                            {
                                OK = false;
                                error = ex.getMessage();
                            }
                            
                        }
                        
                    
                        if(OK)
                        {
                            result = "/corefx/start/main?scope=scenario";
                        }else
                        {
                            result = "/corefx/start/main?scope=error&message="+error;
                        
                        }
                        
                    }
            
                break;
            }
                case "event":
            {
                String sl = request.getParameter("selected");
                
                String pr = request.getParameter("project");    
                
                data d = new data(f.cof);
                data dp = new data(f.cof);
                
                List<String[]> tab = new ArrayList<>();
                String cms = "";
                
                try
                {
                    tab = d.pullTable("select * from config.event where event='"+sl+"' and project='"+pr+"' and user='"+us+"'", 7);
                    cms = dp.pullString("select parent from config.cms where project='"+pr+"' and user='"+us+"' and event='"+sl+"'");
                }
                catch(Exception ex)
                {
                    OK = false;
                }
                String tb = "";
                if(tab.size()>0)
                {
                    tb = tab.get(0)[0];
                
                }
                
                result = "/corefx/start/main?scope=event&project="+pr+"&selected="+tb+"&type="+sl+"&parent="+cms;
                
                for(int i = 0; i<tab.size(); i++)
                { 
                    String[] rw = tab.get(i);
                    String row = "&row"+i+"="+rw[1]+","+rw[5]+","+rw[6];
                    result = result + row;
                }
                
                if(!OK)
                {
                    result = "ERROR";
                }
                
                
                break;
            }
                case "update":
                {
                
                    
                    
               
                String pr = request.getParameter("project");
                String ev = evnt;
                
                if(ev.equals("detail"))
                {
                result = "/corefx/start/main?scope=redpro";
                }

                Event event = new Event(ev,pr);
                String table = event.table;
                String query = "update prod." + table + " set ";
                boolean update = false;
                List<DBField> param = new ArrayList<>();
                
                for(int i = 0; i<event.fields.size(); i++)
                {
                    DBField field = event.fields.get(i);
                    String parameter = field.parameter;
                     
                    String name = field.name;
                    String action = field.action;
                    
                    
                        Value value = null; 
                        String val="";
                        try
                        {
                                value = new Value(parameter,field.action,request);
                                val = value.value;
                        }
                        catch(Exception ex)
                        {
                            value = new Value();
                        }
                    if(action.equals("update")||action.equals("encrypt"))
                    {
                        update = true;

                        
                        if(i<event.fields.size() - 1)
                        {
                        query = query + name + "='" + val + "', ";
                        }else
                        {
                        query = query + name + "='" + val + "' ";
                        }
                        
                    }else
                    {
                        if(action.equals(""))
                        {
                             if(value.isParam)
                             {
                                 field.setValue(val);
                                 param.add(field);
                             }
                                                     if(i<event.fields.size() - 1)
                        {
                        query = query + name + "='" + val + "', ";
                        }else
                        {
                        query = query + name + "='" + val + "' ";
                        }
                        }
                    
                    }
                    

                    
                    
                     
                }
                
                          if(query.endsWith(", "))
                    {
                        query = query.substring(0, query.length() - 2);
                    }
                    
                          query = query + " where ";
                          
                          for(int i =0; i<param.size(); i++)
                          {
                              DBField par = param.get(i);
                              
                              String key = par.name;
                              String vl = par.getValue();
                              if(i<param.size() - 1)
                              {
                               query = query + key + "='" + vl + "' and";
                              }
                              else
                              {
                              query = query + key + "='" + vl +"'";
                              }
                              
                              
                          }
                          
                          data da = new data(f.cop);
                          try
                          {
                          da.Execute(query);
                          
                          
                          }catch(Exception x)
                          {}
                          
                Logic.handle(request, ev);
                break;
                }
                case "submit":
                {
                String[] pra = {"random","timestamp","list"};
                String[] und = {"text"};
                String tab = request.getParameter("tables");  
                String event = request.getParameter("type");
                Columns cls = new Columns(tab);
                String pro = request.getParameter("project");
                for(int i = 0; i<cls.columns.size(); i++)
                {
                    String col = cls.columns.get(i);
                    String param = "";
                    
                    
                    
                    String par = request.getParameter("zin"+col);
                    String suf = request.getParameter("dro"+col);
                    String txt = request.getParameter("sin"+col);
                    String bxi = request.getParameter("att"+col);
                                          
                    if(common.Com.contains(pra, par))
                    {
                    param = "^"+par;
                    txt = "";
                    if(common.Com.isThing(suf))
                    {
                        if(!suf.equals("0"))
                        {
                        param = param+"_"+suf;
                        }
                            
                        
                    
                    
                    }else
                    {
                    param = par;
                    }

                    }
                    if(common.Com.contains(und, par))
                    {
                        param = "_"+txt;
                    
                    }
                    if(!common.Com.isThing(param))
                    {
                        param = txt;
                    }
                    if(common.Com.isThing(par))
                    {
                        data dq = new data(f.cof);
                        String qr = "select event from config.event where field='"+col+"' and tab='"+tab+"' and project='"+pro+"' and user='"+us+"' and event='"+event+"'";
                        String ev = "";
                        try
                        {
                            ev = dq.pullString(qr);
                        }
                        catch(Exception wx)
                        {}
                        String que = "";
                        if(common.Com.isThing(ev))
                        {
                            que = "update config.event set parameter='"+param+"' ";
                            if(common.Com.isThing(bxi)&!bxi.equals("-"))
                            {
                                que = que + ",action='"+bxi+"' ";
                            
                            }else
                            {
                                que = que + ",action='' ";
                            }
                            
                            que = que+"where field='"+col+"' and tab='"+tab+"' and project='"+pro+"' and user='"+us+"' and event='"+event+"'";
                            System.out.println(que);                        
                        
                        }else
                        {
                            String action = "";
                                                        if(common.Com.isThing(bxi)&!bxi.equals("-"))
                            {
                                action = bxi;
                            
                            }
                            
                            que = "insert into config.event values('"+tab+"','"+col+"','"+pro+"','"+us+"','"+event+"','"+param+"','"+action+"')";
                        }
                    data dar = new data(f.cof);
                    try
                    {
                        if(!param.equals("null"))
                        {
                        dar.Execute(que);
                        }
                        
                    }
                    catch(Exception xx)
                    {}                      
                    }
                    

                
                }
                
                
                
                String pr = request.getParameter("project");   
                result = "/corefx/start/main?scope=newboard&project="+pr;
                break;
                }
                case "email":
                {
                    String[] st = {"query","greeting","greetquery","text0","query0","datatable0","text1","query1","datatable1","signature"};
                
                    String ln = request.getParameter("lan");
                    String sb = request.getParameter("subj");
                    String qr = request.getParameter("query");
                    String gr = request.getParameter("greeting");
                    String greetquery = request.getParameter("greetquery");
                    String text0 = request.getParameter("text0");
                    String query0 = request.getParameter("query0");
                    String datatable0 = request.getParameter("datatable0");
                    String text1 = request.getParameter("text1");
                    String query1 = request.getParameter("query1");
                    String datatable1 = request.getParameter("datatable1");   
                    String signature = request.getParameter("signature");
                    String label = request.getParameter("label");
                    String pro = request.getParameter("project");
                    String ev = request.getParameter("type");
                    String sender = request.getParameter("sender");
                    String password = request.getParameter("password");
                    String address = request.getParameter("towho");
                    data dai = new data(f.cof);
                    String ml = "";
                    
                    try
                    {
                        if(!common.Com.isThing(address))
                        {
                            address = us;
                        }
                        
                        
                        
                        ml = dai.pullString("select emailid from config.email where emailid='"+label+"' and lan='"+ln+"' and"
                                + " project='"+pro+"' and user='"+us+"'");
                        String qry = "";
                        if(!common.Com.isThing(ml))
                        {
                            qry = "insert into config.email values('"+label+"','"+pro+"','"+us+"','"+ev+"','"+sender+"','"+password+"','"
                                    
                        +ln+"','"+sb+"','"+qr+"','"+gr+"','"+greetquery+"','"+text0+"','"+query0+"','"+datatable0+"','"
                        +text1+"','"+query1+"','"+datatable1+"','"+signature+"','"+address+"')";
                        
                        }else
                        {
                            qry = "update config.email set sender='"+sender+"', pass='"+password+"', subj='"+sb+"', subjquery='"
                        +qr+"', greeting='"+gr+"', greetquery='"+greetquery+"', text1='"+text0+"',textquery1='"+query0+"', datatab1='"+datatable0
                        +"', text2='"+text1+"', textqry2='"+query1+"', datatab2='"+datatable1+"', signature='"+signature+"', email='"+address+"' "
                        +"where emailid='"+label+"' and lan='"+ln+"'";
                        }
                    data dao = new data(f.cof);
                    
                    dao.Execute(qry);
                    
                    result = "/corefx/start/main?scope=terminate";
                        
                    }catch(Exception ex)
                    {}
                   
                    
                    
                 break;   
                }
                case "editemail":
                {
                    String pro = request.getParameter("project");
                    String event = request.getParameter("type");
                    String lan = request.getParameter("lan");
                    String emailid = request.getParameter("id");
                    
                    data dal = new data(f.cof);
                    
                    List<String[]> l = new ArrayList<>();
                    
                    try
                    {
                    l = dal.pullTable("select * from config.email where emailid='"+emailid+"' and lan='"+lan+"' and user='"
                    +us+"' and project='"+pro+"'", 19);
                    }
                    catch(Exception wex)
                    {}
                    
                    if(l.size()>0)
                    {
                        String[] temp = l.get(0);
                        
                        String emid = temp[0];
                        String proj = temp[1];
                        String user = temp[2];
                        String even = temp[3];
                        String send = temp[4];
                        String pass = temp[5];
                        String lang = temp[6];
                        String subj = temp[7];
                        String subq = temp[8];
                        String gree = temp[9];
                        String greq = temp[10];
                        String txt0 = temp[11];
                        String que0 = temp[12];
                        String tab0 = temp[13];
                        String txt1 = temp[14];
                        String que1 = temp[15];
                        String tab1 = temp[16];
                        String sign = temp[17];
                        String emai = temp[18];
                        
                        String[] tma = {"emailid","project","type","sender","password","lan","datatab1","datatab2"
                        ,"email"};
                        String[] tmb = {emid,proj,even,send,pass,lang,tab0,tab1,emai};
                        
                        String pt = "/corefx/start/main?scope=setemail";
                        
                        for(int i = 0; i<tma.length; i++)
                        {
                            pt = pt+"&"+tma[i]+"="+tmb[i].replace("%20", " ");
                        }
                      

                        result = pt;
                    }
                    break;
                }
                case "saverecent":
                {
                    String ur = request.getRequestURI();
                    
                   String url = ur + "?" + request.getQueryString();
                    
                    String URL = url.substring(0,url.indexOf("&switch"));
                    
                    String qudel = "delete from config.recent";
                    String qusav = "insert into config.recent values('"+URL+"')";
                    
                    data dad = new data(f.cof);
                    data das = new data(f.cof);
                    
                    try
                    {
                        dad.Execute(qudel);
                        das.Execute(qusav);
                        
                        result = URL;
                        
                        
                    }catch(Exception x)
                    {
                        result = "/corefx/start/main?scope=error&mess="+x.getMessage();
                    }
                    
                    
                break;
                }
                case "openrecent":
                {
                    String pq = "select line from config.recent";
                    
                    data daf = new data(f.cof);
                    
                    try
                    {
                    result = daf.pullString(pq);
                    }catch(Exception ex)
                    {
                    result = "/corefx/start/main?scope=error&mess="+ex.getMessage();
                    }
                
                    break;
                }
                case "add":
                {
                    String suite = request.getParameter("suite");
                    
                    for(int i = 0; i<300; i++)
                    {
                    String el = request.getParameter("el" + Integer.toString(i));
                    

                    if(common.Com.isThing(el))
                    {
                    String g1 = "select testid from bank.test where testid='" + el + "' and suite='" + suite + "' and venue = '" + request.getParameter("venue") + "' and capacity='" + request.getParameter("capacity") + "' and session='"
                            + request.getParameter("session") + "' and type='" + request.getParameter("type") + "' and tif='" + request.getParameter("tif") + "' and maxfloor='" + request.getParameter("maxfloor") + "'";                    
                     data dar = new data(f.bank);      
                     String exist = null;
                    try
                    {
                    exist = dar.pullString(g1);

                    }
                    catch(Exception xx)
                    {}
   
                    if(!common.Com.isThing(exist))
                    {
                    int max = -1;
                    data dai = new data(f.bank);
                       try
                        {
                              
                             max = dai.pullInt("select max(setid) from bank.test");
                             max = max + 1;

                        }
                        catch(Exception ex)
                        {}       
                       
                    String qro = "insert into bank.test values('"+ el + "','" + request.getParameter("venue") + "','" + request.getParameter("capacity") + "','" + request.getParameter("session") + "','" + request.getParameter("type") + "','" + request.getParameter("tif") + "','" + request.getParameter("maxfloor") + "'," + max + ",'" + suite +"')";                        
                    data din = new data(f.bank);
                       try
                        {
                              
                          din.Execute(qro);

                        }
                        catch(Exception xex)
                        {}                        
                    
                    
                    }

                      
                       
                    
                    }else
                    {
                        break;
                    }
                    
                    
                    }
                    
                    
                    
                    result = "/corefx/start/main?scope=terminate";
   
                    break;
                
                }
                case "newsuite":
                {
                    String name = request.getParameter("name");
                    
                    String max = helper.Help.maxUnderscore(f.bank, "select id from bank.suites");
                    
                    String inq = "insert into bank.suites values('" + max + "','" + name + "','" + us + "')";
                    data da = new data(f.bank);
                    try
                    {
                    da.Execute(inq);
                    
                    }
                    catch(Exception nex)
                    {}
                    
                    String pa = request.getRequestURI();
                    String re = request.getQueryString();
                    String rrq = re.substring(0,re.indexOf("&name"));
                    
                result = pa + "?" + rrq;
                break;
                }
                
                case "insert":
                {
                
                result = "/corefx/start/main/scope=redme";
                }
                
        }
        

        
        
        return result;
    }
}
