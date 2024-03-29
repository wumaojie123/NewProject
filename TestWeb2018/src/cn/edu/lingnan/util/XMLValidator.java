package cn.edu.lingnan.util;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class XMLValidator {
	public static boolean validate(String xsdPath,String xmlPath)
	{
		boolean flag=false;		
		try {		
			SchemaFactory sf=SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			File f=new File(xsdPath);
			Schema s=sf.newSchema(f);
			Validator v=s.newValidator();
			Source source=new StreamSource(xmlPath);		
				v.validate(source);
				flag=true;			 
		} catch (SAXException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return flag;
	}
			
	
  /*public static void main(String[] args)
  {
	  String xmlPath="src//database.conf.xml";
	  String xsdPath="src//database.conf.xsd";
	  System.out.println(XMLValidator.validate(xsdPath, xmlPath));
  }*/
}
