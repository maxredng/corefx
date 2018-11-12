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
public class SendVerify {
 
    public static Boolstring handle(String st)
    {
        Boolstring result = null;
        
        

        feed Feed = new feed();
        String code = "";

        try
        {
        code = helper.RandomString.getString(6);
        result = new Boolstring(code,true);
        }
        catch(Exception ex)
        {}

        String selpa = "select email from prod.ppl where email='"+st+"'";

        data da = new data(Feed.cop);
        String ml=null;
        try
        {
        ml = da.pullString(selpa);
        }catch(Exception ex)
        {}

        if(!common.Com.isThing(ml))
        {

        String subj = "Код верификации для сайта millionrodine.com";

        String txt = "Ваш код верификации: "+code;
        
        try
        {
        MySimpleMail.sendTLS(st, subj, txt);
        }catch(Exception xex)
        {
        result.OK = false;
        }
        
        
        


        }else
        {
            result.OK = false;
        }


        return result;

    }

}
