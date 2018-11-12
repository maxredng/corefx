/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;

/**
 *
 * @author Maxkarpov
 */
public class Sender {
    
    
    public static void sendSeller(String id)
    {
        String subj = "New order: "+id;
        String txt = subj;
        String mail = (new feed()).ordermail;
        
                                try{
                    MySimpleMail.sendTLS(mail, subj, txt);
                   
                    }catch(Exception rex)
                    {
                   
                    
                    
                    }
        
        
    
    }
    
    
    
    public static String sendOrder(String id,String lang)
    {
        String result=null;
        String subj="order";
        Order order = new Order(id,lang);
        
        String ord="";
        String succ="";
        String cong="";
        String on="";
        String det="";
        String prod="";
        String prais="";
        String del="";
        String term="";
        String our="";
        String amt="";
        String add="";
        String[] st = {ord,succ,cong,on,det,prod,prais,del,term,our,amt,add};
        
        String qur = "select descr from prod.fact where id='";
        
        
        
        String[] names = {"ord","succ","cong","on","det","prod","price","del","term","our","amt","add"};
        for(int i=0; i<st.length;i++)
        {
            data da = new data((new feed()).cop);
            String query = qur+names[i]+"' and lan='"+lang+"'";
            
            try
            {
                
                String res = da.pullString(query);
                switch(names[i])
                {
                    case "ord":
                    {
                        ord = res;
                        break;
                    }
                
                    case "succ":
                    {
                        succ = res;
                        break;
                    }               
                    case "cong":
                    {
                        cong = res;
                        break;
                    }                
                    case "on":
                    {
                        on = res;
                        break;
                    }     
                    case "det":
                    {
                        det = res;
                        break;
                    }                         
                    case "prod":
                    {
                        prod = res;
                        break;
                    }  

                    case "prais":
                    {
                        prais = res;
                        break;
                    }  
                    case "del":
                    {
                        del = res;
                        break;
                    }  
                    case "term":
                    {
                        term = res;
                        break;
                    }  
                    case "our":
                    {
                        our = res;
                        break;
                    }    
                    case "amt":
                    {
                    amt = res;
                    break;
                    }
                    case "add":
                    {
                    add = res;
                    break;
                    }                    
                }
                
                
                
                
                
                
 
            }catch(Exception sc)
            {
            System.out.printf(sc.getMessage());
            }
            
            
           
        
        }
        
        
         String txt="";           

                    subj= ord+": "+id;
                    txt = cong+id+" "+on+" RedHotPage.com! "+'\n'+
                    '\n'+det+'\n'+'\n'+prod+order.product+'\n'+
                      prais+order.price+'\n'+amt+order.amount+'\n'+add+
                            del+order.address+'\n'+
                       term+order.terms+'\n'+'\n'+our;

                    if(order.email.length()>0)
                    {
                        try{
                    MySimpleMail.sendTLS(order.email, subj, txt);
                    result="success";
                    }catch(Exception rex)
                    {
                    result=rex.getMessage();
                    
                    
                    }
    }
    return result;
    }
    
}
