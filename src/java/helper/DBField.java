/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author Maxkarpov
 */
public class DBField {
    
    public String table;
    public String name;
    private String value;
    public String parameter;
    public String action;
    
    public DBField(String t, String f,String p,String a)
    {
        table = t;
        name = f;
        parameter = p;
        action = a;
    
    }
    
    public void setValue(String v)
    {
        value = v;
    }
    public String getValue()
    {
        return value;
    }
    
}
