/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxkarpov
 */
public class bar {
    
        public static List<String[]> Replace(List<String[]> l)
    {
        List<String[]> result=new ArrayList<String[]>();
    
        String[] first=new String[2];
        int j=0;
       if(l.get(0)[0].equals("name")||l.get(0)[0].equals("id"))
       {
       result=l;
       
       
       }else
       {
        for(int i=1;i<l.size();i++)
        {
            String fi=l.get(i)[0];
            if(fi.equals("id")||fi.equals("name"))
            {
            first=l.get(i);
            j=i;
            }
            
            
  
        }
        
        for(int k=0;k<l.size();k++)
        {
            if(k==0)
            {
            result.add(first);
            }

        }

for(int z=0;z<l.size();z++)
{
if(!l.get(z)[0].equals("id")&!l.get(z)[0].equals("name"))
{
result.add(l.get(z));

}
}
        
        
       }
        return result;
    }
  
    
}
