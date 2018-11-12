/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxkarpov
 */
public class MailMaker {
    
    
    public enum Mail
    {
        cancel,confirmed;
    
    }
    
    public Mail type;
    public String orderid;
    public String code;
    public String cancelstat;
    public String error;
    char ret='\n';
    
    
    public MailMaker(Mail tp,String orid)
    {
    type=tp;
    orderid=orid;
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
    
     String getPrice(String lan,String ar)
    {
        String result="";
        String quer="select descr from prod.fact where parent='"+ar+"' and lan='"+lan+"' and id='price'";
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
    
    public void send(String ml,String lan)
    {
    switch(type)
    {
        case cancel:
        {
            String canq1="select descr from prod.fact where id='cancel1' and lan='"+lan+"'";
            String canq2="select descr from prod.fact where id='cancel2' and lan='"+lan+"'";   
            feed f=new feed();
                data dc1=new data(f.cop);
                data dc2=new data(f.cop);                
            try
            {
                String c1=dc1.pullString(canq1);
                String c2=dc2.pullString(canq2);
                
                String line=c1+'\n'+orderid+'\n'+c2;
                
                MySimpleMail.sendTLS(ml, "Order cancelled", line);
                MySimpleMail.sendTLS(f.ordermail, "cancelled order: "+orderid, orderid);
                
            }catch(Exception caex)
            {
                
                error=caex.getMessage();
            }
            

            
            
        break;
        }
        case confirmed:
        {
            String coq1="select descr from prod.fact where id='confirmed1' and lan='"+lan+"'";
            String coq2="select descr from prod.fact where id='confirmed2' and lan='"+lan+"'";
            String coq15="select descr from prod.fact where id='confirmed15' and lan='"+lan+"'"; 
            String coq3="select descr from prod.fact where id='confirmed3' and lan='"+lan+"'"; 
                List<String[]> list=new ArrayList<String[]>();            
            feed f=new feed();
                data dc1=new data(f.cop);
                data dc2=new data(f.cop);   
                data dc15=new data(f.cop);
                data dc3=new data(f.cop);
                data dal=new data(f.cop);
                
                String qul="select f.descr,o.amount,o.prodid from prod.fact f,prod.orders o where f.id=o.prodid "
                        + "and o.orderid='"+orderid+"' and f.lan='"+lan+"'";

            try
            {
                String c1=dc1.pullString(coq1);
                String c2=dc2.pullString(coq2);
                String c15=dc1.pullString(coq15);
                String c3=dc2.pullString(coq2);                
               list=dal.pullTable(qul, 3);
               int Price=0;
               String line=c1+" "+orderid+ret+ret+c15+ret;
               
               for(int i=0;i<list.size();i++)
               {
                String id="";
                String prq="select descr from prod.fact where id='price' and parent='"+list.get(i)[2] +"'";
                
                data dapr=new data(f.cop);
                String prc=dapr.pullString(prq);
                
                int price=Integer.parseInt(prc);
                int numb=Integer.parseInt(list.get(i)[1]);
                
                int toad=price*numb;
                Price=Price+toad;
               String str=list.get(i)[0]+"  "+list.get(i)[1]+getPiece(lan,"pc")+". "+getPiece(lan,"perp")+" "+getPrice(lan,list.get(i)[0])+ret;
               line=line+str;
               }

                line=line+ret+ret;
                
                line=line+getPiece(lan,"total")+Integer.toString(Price)+getPiece(lan,"rubl")+" ";
                
                line=line+c3;
                
                
                MySimpleMail.sendTLS(ml, getPiece(lan,"newor"), line);
                MySimpleMail.sendTLS(f.ordermail, "order: "+orderid, orderid);
                
            }catch(Exception caex)
            {
                
                error=caex.getMessage();
            }
            
            
            
        }
    
    }
    
    
    }
    
}
