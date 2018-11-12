/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steamer;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.StringReader;
import org.xml.sax.InputSource;

public class ReadXMLFile {

  public static Document getDoc(String xml) {

      Document result=null;
    try {


	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = dbFactory.newDocumentBuilder();
	Document doc = builder.parse(new InputSource(new StringReader(xml)));
        doc.getDocumentElement().normalize();
	result=doc;		

		
	}
     catch (Exception e) {
	e.printStackTrace();
    }
    return result;
  }

public static String getElementByTag(Document doc, String tag)
{
    String result=null;

    NodeList list=doc.getElementsByTagName(tag);
    
    

    return result;
}
  
  
}