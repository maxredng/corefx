/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Maxkarpov
 */
public class Ppl 
{

    public static Boolstring handle(String ml)
    {
        Boolstring result = null;
        
        feed f = new feed();
        
        data dap = new data(f.cop);
        
        String pass = "";
        
        try
        {
        pass = helper.RandomString.getString(7);
         Encryptor enc = new Encryptor();
        String enpass = enc.encrypt(pass);       
         Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        String tm = ts.toString();       
        String re = dap.Execute("insert into prod.ppl values('"+tm+"','"+ml+"','','','"+enpass+"','','','','','','','','"+tm+"')");
        
        String subj = "Успешная регистрация на millionrodine.com";
        
        String txt = "Спасибо за то, что Вы с нами. Теперь Вы сможете заходить на millionrodine.com, используя логин: "+ml+" и пароль: "+pass+'\n'
                +"."
                +" Ваши NONSUCHPPL.";
        MySimpleMail.sendTLS(ml, subj, txt);
        result = new Boolstring(re,true);
       
        
        
        }catch(Exception ex)
        {
            result = new Boolstring(ex.getMessage(),false);
        
        }

        
        return result;
    }
    
}
