/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecrivus;

import helper.Params;

/**
 *
 * @author Maxkarpov
 */
public class Person {
    
    public String first;
    public String last;
    public String company;
    public String email;
    public String phone;
    
    public String comment;
    
    private String url;
    
    public Person(String ur)
    {
        url = ur;
        
        populate();
    }
 
    final void populate()
    {
        Params par = new Params(url);
        
        first = par.getValue("first");
        last = par.getValue("last");
        company = par.getValue("company");
        
        email = par.getValue("email");

        phone = par.getValue("phone");
        comment = par.getValue("comment").replace("%20"," ").replace("%20a%"," ");
        
       
        
        
        
        
    
    }
}
