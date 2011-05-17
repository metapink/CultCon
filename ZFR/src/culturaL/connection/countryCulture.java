/**
 * 
 */
package culturaL.connection;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.os.Environment;

/**
 * @author BASSman
 *
 */
public class countryCulture 
{
	
	private String countryName;
	private String picturePathName;
	private String theDescription;
	public countryCulture(String file)
	{
		
		File filepath = new File(file);	
		readTheXml(filepath);				
	}
	public String getDescription()
	{
		return theDescription;
	}
	public String getName()
	{
		return countryName;
	}
	public String getPicturePath()
	{
		return picturePathName;
	}
	public void readTheXml(File filepath)
	{	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try 
	    {
	    	//C:\Users\BASSman\workspace\culturalConnect\res\raw
	        //Using factory get an instance of document builder
	        DocumentBuilder db = dbf.newDocumentBuilder();

	        //parse using builder to get DOM representation of the XML file
	        Document dom =  db.parse(filepath);

	        dom.getDocumentElement().normalize();

	        NodeList fstNmElmntLst = dom.getElementsByTagName("countryName");
	        Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
	        NodeList fstNm = fstNmElmnt.getChildNodes();
	        System.out.println("countryName : "  + ((Node) fstNm.item(0)).getNodeValue());

	        NodeList sndNmElmntLst = dom.getElementsByTagName("countryPicturPath");
	        Element sndNmElmnt = (Element) sndNmElmntLst.item(0);
	        NodeList sndNm = sndNmElmnt.getChildNodes();
	        System.out.println("countryPicturPath : "  + ((Node) sndNm.item(0)).getNodeValue());

	        NodeList trdNmElmntLst = dom.getElementsByTagName("description");
	        Element trdNmElmnt = (Element) trdNmElmntLst.item(0);
	        NodeList trdNm = trdNmElmnt.getChildNodes();
	        System.out.println("description : "  + ((Node) trdNm.item(0)).getNodeValue());                   
	        
	        countryName = ((Node) fstNm.item(0)).getNodeValue();
	        picturePathName = ((Node) sndNm.item(0)).getNodeValue();
	    	theDescription = ((Node) trdNm.item(0)).getNodeValue();
	    }
	    catch(Exception pce)
	    {		              
	    	pce.printStackTrace();		        
	    }
	    
	}
	


}
