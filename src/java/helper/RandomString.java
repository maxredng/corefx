/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Maxkarpov
 */
public class RandomString {
    
    public static String getString(int len)throws InterruptedException
    {
        String result="";
        Object tema;
           char[] alphabet = new char[26]; 
          
               
           for(char ch = 'a'; ch <= 'z'; ++ch)
           {
               alphabet[ch-'a']=ch;
           } 
        
        String[] tar=new String[36];
        
        for(int i=0;i<tar.length;i++)
        {
            if(i<10)
            {
                tar[i]=Integer.toString(i);
            }else
            {
                tar[i]=""+alphabet[i-10];
            
            }
        
        }
       
        for(int j=0;j<len;j++)
        {
                              Date date=new Date();
                     
                     Timestamp ts=new Timestamp(date.getTime());
                     Thread.sleep(300);
                     long seed=ts.getTime();
                     
         Random r=new Random();
         r.setSeed(seed);
         int temp=r.nextInt(36);
         String tem=tar[temp];
         result=result+tem;
         
         
        
        }
        

        
        
        
        
        
        return result;
    }
    
}
