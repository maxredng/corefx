/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import html.feed;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;




/**
 *
 * @author Maxkarpov
 */
public class MySimpleMail {
    
    
        public static void sendTLS(String ml,String subj,String txt)
    {
        feed f=new feed();
        
        try {
            Email email = new SimpleEmail();
            email.setHostName(f.host);
            email.setSmtpPort(f.mailport);
            email.setCharset("utf-8");
            email.setAuthenticator(new DefaultAuthenticator(f.mailname, f.mailpas));
            email.setTLS(true);
            email.setFrom(f.mailname);
            email.setSubject(subj);
            email.setMsg(txt);
            email.addTo(ml);
            email.send();
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }
            public static void sendTLS(String ml,String subj,String txt,String send,String pass)
    {
        feed f=new feed();
        
        try {
            Email email = new SimpleEmail();
            email.setHostName(f.host);
            email.setSmtpPort(f.mailport);
            email.setCharset("utf-8");
            email.setAuthenticator(new DefaultAuthenticator(f.mailname, f.mailpas));
            email.setTLS(true);
            email.setFrom(f.mailname);
            email.setSubject(subj);
            email.setMsg(txt);
            email.addTo(ml);
            email.send();
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }
}
