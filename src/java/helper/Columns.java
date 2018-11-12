/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import data.data;
import html.feed;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxkarpov
 */
public class Columns {
    
    private String schema = "prod";
    private String table;
    public List<String> columns;
    feed f;
    data d;
    public Columns(String tab)
    {
       f = new feed();
       columns =  new ArrayList<>();
       table = tab;
       populate();
    }
    
    final void populate()
    {
        String query = "select `COLUMN_NAME` from `INFORMATION_SCHEMA`.`COLUMNS` where `TABLE_SCHEMA`='"+schema+"' and `TABLE_NAME`='"+table+"'";
        d = new data(f.cop);
        
        try
        {
            columns = d.pullList(query, 1);
        }
        catch(Exception ex)
        {}
        
    }
    
}
