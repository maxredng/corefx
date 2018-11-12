/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author bsati
 */
public class JsLine {
    

    
    public boolean open;
    public boolean closed;
    public String line;
    public type Type;
    
    
    public JsLine(String lin,boolean op,boolean cl)
    {
        line = lin;
        open = op;
        closed = cl;
        populate();
    
    }
        static boolean isSignature(String st)
    {
        boolean result = false;
            
            char[] ch = st.toCharArray();
            
            for(int i = 0; i<ch.length; i++)
            {
                if(Character.isAlphabetic(ch[i]) || Character.isDigit(ch[i]))
                {
                    result = true;
                    break;
                }
            
            }
        
        return result;
    }
        
    final void populate()
    {
        Type = type.blank;
        line = helper.Help.moveLeft(line);
        if(!line.contains("//")&!line.contains("*"))
        {
            if(line.contains(";"))
            {
                if(closed)
                {
                    Type = type.global;
                }else
                {
                if(open)
                {
                    Type = type.local;
                
                }else
                {
                    Type = type.global;
                }
                }
                
                if(isFor(line))
                {
                    Type = type.signature;
                }
                
                if(line.contains("else"))
                {
                    line = helper.Help.moveThing(line, "else", '(');
                    
                    if(line.indexOf("else(")==0)
                    {
                        Type = type.signature;
                    }
                            
                
                }
            
            }else
            {
            if(line.contains("{"))
            {
                
                if(!issign(line,'{'))
                {
                Type = type.open;
                
                }else
                {
                Type = type.signature;
                open = true;
                
                }
                
            }else
            {
                if(line.contains("}"))
                {
                    
                    if(issign(line,'}'))
                    {
                    Type = type.close;
                    
                    }
                    else
                    {
                    Type = type.local;
                    closed = true;
                    
                    }
                    
                    
                }else
                {
                    if(isSignature(line))
                    {
//                        if(ifif(line))
//                        {
                        
                        Type = type.signature;
//                        }else
//                        {
//                        
//                        }
                        
                    }
                    
                }
            
            }
            
            }
        
        }
    
    }
    
    
    
    boolean ifif(String ln)
    {
        boolean result = false;
        
        if(ln.contains("if"))
        {
            char[] f = ln.toCharArray();
            
            int n = ln.indexOf("if");
            
            for(int i = 0; i<f.length; i++)
            {
                char ch = f[i];
                if(i<n)
                {
                    if(Character.isAlphabetic(ch)||Character.isDigit(ch))
                    {
                    break;
                    }
                
                }
                else
                {
                if(Character.isAlphabetic(ch)||Character.isDigit(ch))
                {
                    break;
                }else
                {
                if(ch == '(')
                {
                    result = true;
                    break;
                }
                {
                
                
                }
                }
            }
            }
        
        }
        
        
        return result;
    }
    
    
    boolean isFor(String line)
    {
        boolean result = false;
        
        
        if(line.indexOf("for") == 0)
        {
            line = helper.Help.moveThing(line, "for", '(');
            if(line.indexOf("for(") == 0)
            {
                result = true;
            }
        
        }
    
        return result;
    }
            
    
     boolean issign(String ln,char d)
    {
        
        boolean result = false;
            int n = ln.indexOf(d);
            char[] ar = ln.toCharArray();
            
            if(ln.length()>1)
            {
                for(int i = 0; i<ar.length; i++)
                {
                    if(i!=n)
                    {
                        if(Character.isAlphabetic(ar[i]) || Character.isDigit(ar[i]))
                        {
                            result = true;
                            break;
                        }
                    }
                
                }
            
            }

        
        return result;
    }
}
