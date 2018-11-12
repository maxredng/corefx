/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import ogurez.OrdParams;

/**
 *
 * @author bsati
 */
public class OrderTable {
    
    public String code;
//| Symbol | VOD.L |
//| Type | Limit |
//| Side | Buy |
//| Price | 209.4 |
//| Qty | 1200 |
//| TIF | Day |
    
        public String Symbol;
    public String Type;
    public String Side;
    public String Price;
    public String Qty;
    public String Tif;
    public String Peg;
    public String MaxFloor;
    
    
    
    public OrderTable(OrdParams p)
    {
         
        populate();
    }
    
    final void populate()
    {
    
    
    }
}
