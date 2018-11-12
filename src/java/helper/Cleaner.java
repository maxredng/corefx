/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bsati
 */
public class Cleaner {
    
    String error;
    
    public static void Handle(HttpServletRequest request)
    {
        String save = request.getParameter("persistevent");
        String cret = null;
        String el = null;
        String user = (String)request.getSession().getAttribute("user");
        boolean element = false;
        switch(save)
        {
            case "project":
            {
                
            cret = "./uri/corefx~start~mainqueStionscopeequaLsprojects&LinequaLs" + user;
            break;
            }
            case "view":
            {
            String project = request.getParameter("project");
            
            cret = "./uri/corefx~start~mainqueStionscopeequaLsnewboard&projectequaLs"+project;
            
            break;
            }
            case "element":
            {
            String selected = request.getParameter("parent");
            String area = request.getParameter("area");
            el = "area";
            cret = "./uri/corefx~start~mainqueStionscopeequaLsstage&selectedequaLs" + selected + "&areaequaLs" + area;
            element = true;
            break;
            }
            case "template":
            {
            String selected = request.getParameter("selected");
            String area = request.getParameter("mscope");
            el = "selected";
            cret = "./uri/corefx~start~mainqueStionscopeequaLsstage&selectedequaLs" + selected + "&areaequaLs" + area;
            element = true;
            break;
            }            
            case "refresh":
            {
            String selected = request.getParameter("selected");
            String area = request.getParameter("area");
            el = "area";
            cret = "./uri/corefx~start~mainqueStionscopeequaLsstage&selectedequaLs" + selected + "&areaequaLs" + area;
            element = true;
            break;
            }          
        }
    
    feed f = new feed();
    data daf = new data(f.cof);
    
    try
    {
        daf.Execute("delete from config.store where sign like '%" + cret + "%'");
        
        if(element)
        {
                String elc = "./uri/corefx~start~mainqueStionscopeequaLs" + request.getParameter(el);
            String dec = "delete from config.store where sign like '%" + elc + "%'";
            
            daf.Execute(dec);
        }
    
    }
    catch(Exception x)
    {
        x.printStackTrace();
    }
    
    }
    
}
