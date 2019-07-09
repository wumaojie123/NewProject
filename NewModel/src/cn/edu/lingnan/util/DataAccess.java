package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DataAccess {
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String xmlPath="src//database.conf.xml";
	private static String xsdPath="src//database.conf.xsd";
	public static Connection conn=null;
	public static PreparedStatement pre=null;
	public static Connection getConnection()
	{ HashMap <String,String> hm=new HashMap<String,String>();
		if(XMLValidator.validate(xsdPath, xmlPath))
		{
			hm=XmlParser.parser(xmlPath);
			driver=hm.get("driver");
			url=hm.get("url");
			user=hm.get("user");
			password=hm.get("password");
		}				
		try{
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,password);
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return conn;
	}
	public static void closeConnection(Connection conn,Statement stat)
	{		
			try {
				if(stat!=null) stat.close();
				if(conn!=null) conn.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	public static void closeConnection(Connection conn,Statement stat,ResultSet rs)
	{		
			try {
				if(rs!=null) rs.close();
				if(stat!=null) stat.close();
				if(conn!=null) conn.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	public static void closeConnection(Connection conn,Statement stat,PreparedStatement pre,ResultSet rs)
	{
		try {
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			if(pre!=null) pre.close();
			if(conn!=null) conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection conn,PreparedStatement pre)
	{
		try {
		
			if(pre!=null) pre.close();
			if(conn!=null) conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection conn,PreparedStatement pre,ResultSet rs)
	{
		try {
		    if(rs!=null) rs.close();
			if(pre!=null) pre.close();
			if(conn!=null) conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
	


