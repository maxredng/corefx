/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import html.feed;
import java.util.Properties;
import javax.mail.BodyPart;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Maxkarpov
 */
public class HTMLEmail {
    
public static void send(String to,String from,String subj,String txt)
{
// Recipient's email ID needs to be mentioned.
      //to = "destinationemail@gmail.com";

      // Sender's email ID needs to be mentioned
    //  from = "mkarpoff@mail.ru";


      // Assuming you are sending email through relay.jangosmtp.net
      feed f = new feed();
      String host = f.host;
final String username=f.mailname;      
final String password=f.mailpas;
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "25");
      props.put("mail.mime.charset", "utf-8");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
	});

      try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
             
   	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));

	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
              InternetAddress.parse(to));

	   // Set Subject: header field
	   message.setSubject(subj,"utf-8");
           BodyPart messageBodyPart = new MimeBodyPart(); 
           messageBodyPart.setContent( "<p>"+txt.replace("/corefx", "http://"+f.mailhostname+"/corefx")+"</p>", "text/html; charset=utf-8" );

           Multipart multipart = new MimeMultipart(); 

           multipart.addBodyPart( messageBodyPart ); 


	   message.setContent(multipart);

	   // Send message
	   Transport.send(message);

	   System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
	   e.printStackTrace();
	   throw new RuntimeException(e);
      }

}
    
}
