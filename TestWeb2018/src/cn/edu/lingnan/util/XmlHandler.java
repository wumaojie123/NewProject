package cn.edu.lingnan.util;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class XmlHandler extends DefaultHandler{
	private StringBuffer sb=new StringBuffer();
	private HashMap<String,String> hm=new HashMap<String,String> ();
	public HashMap <String,String> getHashMap()
	{
		return  hm;
	}
	public void startElement
	(String uri,String localName,String qName,Attributes attributes) throws SAXException
	{
		sb.delete(0, sb.length());
	}
	public void characters(char[]ch,int start,int length) throws SAXException
	{
		sb.append(ch,start,length);
	}
	public void endElement(String uri,String localName,String qName) throws SAXException
	{
		hm.put(qName.toLowerCase(), sb.toString().trim());
	}
}
