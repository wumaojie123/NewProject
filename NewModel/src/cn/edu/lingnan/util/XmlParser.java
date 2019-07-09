package cn.edu.lingnan.util;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class XmlParser {
  public static HashMap <String,String> parser(String xmlPath)
    {
	  HashMap<String,String> hm=new HashMap<String,String>();
	try {			
		SAXParserFactory factory=SAXParserFactory.newInstance();//创建工厂
		SAXParser saxParser= factory.newSAXParser();//创建解析器
		File f=new File(xmlPath);
		XmlHandler xh=new XmlHandler();	
			saxParser.parse(f, xh);	 //进行解析
			hm=xh.getHashMap();
	} catch (ParserConfigurationException e) {
		
		e.printStackTrace();
	} catch (SAXException e) {		
		e.printStackTrace();
	}
	catch (IOException e) {		
		e.printStackTrace();
	}			
	return hm;
	}
  /*public static void main(String [] args)
  {
	  String xmlPath="src//database.conf.xml";	
	  HashMap <String,String> hm=XmlParser.parser(xmlPath);
	  System.out.println(hm.get("password"));
  }*/
}
