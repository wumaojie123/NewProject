package com.college.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import cn.edu.lingnan.util.DataAccess;
import com.college.dto.NewsDTO;


public class NewsDAO {
	private Connection conn=null;
	private Statement stat=null;
	private PreparedStatement pre=null;
	private ResultSet rs=null;
	//查询所有的新闻
	public Vector<NewsDTO> findAllNews()
	{
		Vector <NewsDTO> v =new Vector <NewsDTO>();
		try{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from News where isDelete=0");				
			while(rs.next())
			{
				NewsDTO u=new NewsDTO();
				u.setNewsId(rs.getInt("newsId"));
				u.setNewsTypeId(rs.getInt("newsTypeId"));
				u.setNewsName(rs.getString("newsName"));
				u.setNews(rs.getString("news"));
				u.setNewsTime(rs.getString("newsTime"));
				u.setNewsCount(rs.getInt("newsCount"));
				u.setIsDelete(rs.getInt("isDelete"));
				v.add(u);				
			}			
			}				
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally{
				DataAccess.closeConnection(conn, stat, rs);
			}
		return v;
	}
	
	//计算总的页数
	public int getPage()
	{
		int recordCount=0,t1=0,t2=0;
		try {
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select count(*) from News where isDelete=0");
		    rs=pre.executeQuery();
		    rs.next();
		    recordCount=rs.getInt(1);
		    t1=recordCount%5;
		    t2=recordCount/5;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DataAccess.closeConnection(conn, pre, rs);
		}
		if(t1!=0)
		{
			t2=t2+1;
		}
		return t2;
	}
	
	//每页列出前五项新闻
	public Vector<NewsDTO> listNews(int pageNo)
	{
		//List<DishDTO> list=new  ArrayList<DishDTO>();
		Vector<NewsDTO> list=new Vector<NewsDTO>();
		int pageSize=5;
		int page=(pageNo-1)*5;
		
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from News where isDelete=0 order by dishid limit ?,?");
			pre.setInt(1, page);
			pre.setInt(2, pageSize);
			rs=pre.executeQuery();
			while(rs.next())
			{   
				NewsDTO u=new NewsDTO();
				u.setNewsId(rs.getInt("newsId"));
				u.setNewsTypeId(rs.getInt("newsTypeId"));
				u.setNewsName(rs.getString("newsName"));
				u.setNews(rs.getString("news"));
				u.setNewsTime(rs.getString("newsTime"));
				u.setNewsCount(rs.getInt("newsCount"));
				u.setIsDelete(rs.getInt("isDelete"));
				
				list.add(u);
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			DataAccess.closeConnection(conn, pre, rs);
		}
		
		return list;
	}	
	
	
	//增加新闻类型
		public boolean insertNews(NewsDTO news)
		{
			boolean flag=false;
			try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("insert into News values(?,?,?,?,?,?0)");
			//pre.setInt(1, user.getUserid());
			pre.setInt(1, news.getNewsId());
			pre.setInt(2,news.getNewsTypeId());
			pre.setString(3,news.getNewsName());
			pre.setString(4, news.getNews());
			pre.setString(4, news.getNewsTime());
			pre.setInt(6, news.getIsDelete());
			pre.executeUpdate();
			flag=true;
			}				
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally{
				DataAccess.closeConnection(conn, pre);
			}			
				return flag;
		}
		//更新新闻内容
		public boolean updateNews(NewsDTO news)
		{
			boolean flag=false;
			try{
				conn=DataAccess.getConnection();
				pre=conn.prepareStatement("update News set newsTypeId=?,newsName=?,news=?,newsTime=?,newsCount=?,isDelete=? where newsId=?");		
				pre.setInt(1, news.getNewsTypeId());
				pre.setString(2, news.getNewsName());
				pre.setString(3, news.getNews());
				pre.setString(4, news.getNewsTime());
				pre.setInt(5, news.getNewsCount());
				pre.setInt(6,news.getIsDelete());
				pre.setInt(7, news.getNewsId());		
				pre.executeUpdate();
				flag=true;
				}				
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				finally{
					DataAccess.closeConnection(conn, pre);
				}	
			return flag;
		}
		//删除新闻
		public boolean delNews(int _newsid)
		{
			boolean flag=false;
			try{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();		
			stat.executeUpdate("update News set isDelete=1 where newsTypeId='"+_newsid+"'");				
			flag=true;
			}				
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally{
				DataAccess.closeConnection(conn, stat);
			}			
				return flag;
		}
	
}
