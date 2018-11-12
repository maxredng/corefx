/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steamer;

import html.param;
import java.net.MalformedURLException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Maxkarpov
 */
public class Profile {
    
    public String id;
    public String NumericID;
    public String memberSince;
    public String customURL;
    public String avatarSmall;
    public String avatarMedium;
    public String avatarFull;
    public String vacBanned;
    public String tradeBanState;
    public String isLimitedAccount;
    public String xml;
    public String location;
    public String realname;
    public String summary;
    public String error;
    
    public String[] item;
    public param[] parameters;
    
    public Profile(String ID)
    {
    NumericID=ID;
    parameters=new param[13];
    populate();
    
    }
    
    
    String getContent(Document doc,String key)
    {
        String result=null;

        
        NodeList list=doc.getElementsByTagName(key);
        Node SteamIDNode=list.item(0);
        
        result=SteamIDNode.getFirstChild().getTextContent();
                  
            
        
        return result;
    
    }
        
    
    String getDATA(Document doc,String key)
    {
        String result=null;

        NodeList lis=doc.getElementsByTagName("profile");
        Node node=lis.item(0);
        NodeList list=node.getChildNodes();
        int len=list.getLength();
        
        for(int i=0;i<len;i++)
        {
            String tagname=list.item(i).getNodeName();
            
            if(tagname.equals(key))
            {
        Node SteamIDNode=list.item(i);
        String RudeSteamID=SteamIDNode.getFirstChild().getTextContent();
        result=RudeSteamID;
        //result=common.Com.parseFrom(RudeSteamID, "<![CDATA[", "]]>");             
            }
        
        }
         
        
          
     
        return result;
    
    }
    
    
    final void populate()
    {
        try
        {
        xml=XMLer.getXML(NumericID);
        String result=null;
        Document doc=ReadXMLFile.getDoc(xml);
        id=getDATA(doc,"steamID");
        customURL=getDATA(doc,"customURL");
        memberSince=getDATA(doc,"memberSince");    
        avatarSmall=getDATA(doc,"avatarIcon"); 
        avatarMedium=getDATA(doc,"avatarMedium");         
        avatarFull=getDATA(doc,"avatarFull");
        vacBanned=getDATA(doc,"vacBanned");
        tradeBanState=getDATA(doc,"tradeBanState");     
        isLimitedAccount=getDATA(doc,"isLimitedAccount");        
        location=getDATA(doc,"location");        
        realname=getDATA(doc,"realname");    
        summary=getDATA(doc,"summary");
        String[] temp={NumericID,id,customURL,memberSince,avatarSmall,avatarMedium,avatarFull,vacBanned,tradeBanState,isLimitedAccount,location,realname,summary};
        String[] names={"numid","proid","customURL","memberSince","avatarSmall","avatarMedium","avatarFull","vacBanned","tradeBanState","isLimitedAccount","location","realname","summary"};
        item=temp;
        
        for(int i=0;i<temp.length;i++)
        {
            param par=new param(names[i],temp[i]);
            parameters[i]=par;
        
        
        }
        
        }catch(MalformedURLException mex)
        {
            error=mex.getMessage();
        }
        
    
    }
}
