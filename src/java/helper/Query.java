/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import data.connection;
import data.data;
import html.feed;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxkarpov
 */
public class Query {
    
    public String query;
    public String schema;
    public String tab;
    public String[] cols;
    public String[] selected;
    public int colnum;
    
    public Query(String q)
    {
        query = q;
        populate();
    }
    
    final void populate()
    {
        schema = common.Com.parseFrom(query, "from ", "\\.");
        tab = common.Com.parseFrom(query,schema+"."," where");
        List<String[]> l = new ArrayList<>();
        feed f = new feed();
        String qr = "select count(*) from information_schema.columns where `table_schema`='"+schema+"' and `table_name`='"+tab+"'";
        String q = "show columns from " + schema + "." + tab;
        String middle = common.Com.parseFrom(query, "select ", " from");
                
        boolean allaf = false;
        
        if(query.contains("\\*"))
        {
            allaf = true;
        }
        
        
        
        try
        {
            connection con = f.getConnection(schema);
            data dc = new data(con);
            data d = new data(con);
            data da = new data(con);
            
            colnum = dc.pullInt(qr);
                    
            List<String> temp = new ArrayList<>();
            
            temp = da.pullList(q, 1);
            
            cols = new String[temp.size()];        
            cols = temp.toArray(cols);
             if(allaf)
            {
            selected = cols;
            }else
            {
            selected = middle.split(",");
            }           
            int cln = selected.length;
            l = d.pullTable(query, cln);


            
        }catch(Exception wx)
        {}
        
        
    }
}
