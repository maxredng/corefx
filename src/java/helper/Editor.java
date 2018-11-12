/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maxkarpov
 */
public class Editor {
    
    public HttpServletRequest request;
    
    public String[] pars={"id","name","content","class","src","href","value","onclick","type","intype","onmouse","offmouse","onchange","width","height","row","col"};
    public String[] elePar=new String[pars.length];

    public String[] ipars={"vinid","vinname","vincontent","vinclass","vinsrc","vinhref","vinvalue","vinonclick","vintype","vinintype","vinonmouse","vinoffmouse","vinonchange","vinwidth","vinheight","row","col"};
    public String[] iPar=new String[pars.length];
    
    public boolean[] isAtt={true,false,false,true,true,true,true,true,false,true,true,true,true,true,true,false,false};
    
            public Editor(HttpServletRequest req)
            {
            request=req;

            populate();

            }
            
            
            final void populate()
            {
            
                for(int i=0;i<pars.length;i++)
                {
                    String temp=request.getParameter(pars[i]);
                    
                    if(common.Com.isThing(temp))
                    {
                        elePar[i]=temp;
                    }
                    
                    String tem=request.getParameter(ipars[i]);
                    
                    if(common.Com.isThing(tem))
                    {
                        iPar[i]=tem;
                    }
                
                }
                
                
            }
            
            public boolean isAttribute(int i)
            {
                boolean result=isAtt[i];
            
                return result;
            }
            
            public boolean isThing(String key)
            {
                boolean result=false;
                
                for(int i=0;i<pars.length;i++)
                {
                    String field=pars[i];
                    String isel=ipars[i];
                    
                    if(field.equals(key)||isel.equals(key))
                    {
                        if(elePar[i]!=null)
                        {
                            if(elePar[i].length()>0)
                            {
                                result=true;
                                break;
                            }
                        }
                        if(iPar[i]!=null)
                        {
                            if(iPar[i].length()>0)
                            {
                                result=true;
                                break;
                            }
                        }                    
                    }
                        
                
                }
            return result;
            
            }

            public String getValue(String key)
            {
                String result=null;
                
                for(int i=0;i<pars.length;i++)
                {
                    String field=pars[i];
                    String isel=ipars[i];
                    
                    if(field.equals(key)||isel.equals(key))
                    {
                        if(elePar[i]!=null)
                        {
                            if(elePar[i].length()>0)
                            {
                                result=elePar[i];
                                break;
                            }
                        }
                        if(iPar[i]!=null)
                        {
                            if(iPar[i].length()>0)
                            {
                                result=iPar[i];
                                break;
                            }
                        }                    
                    }
                        
                
                }
            return result;
            
            }            

}
