package com.college.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.college.dto.NewsTypeDTO;
import cn.edu.lingnan.util.DataAccess;

public class NewsTypeDAO {
	private Connection conn=null;
	private Statement stat=null;
	private PreparedStatement pre=null;
	private ResultSet rs=null;
	
	//��ѯ������������
	public Vector<NewsTypeDTO> findAllNewsType()
	{
		Vector <NewsTypeDTO> v =new Vector <NewsTypeDTO>();
		try{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from NewsType");				
			while(rs.next())
			{
				NewsTypeDTO u=new NewsTypeDTO();
				u.setNewsTypeId(rs.getInt("newsTypeId"));
				u.setNewsTypeName(rs.getString("newsTypeName"));
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
	//������������
	public boolean insertNewsType(NewsTypeDTO newstype)
	{
		boolean flag=false;
		try{
		conn=DataAccess.getConnection();
		pre=conn.prepareStatement("insert into NewsType values(?,?,0)");
		//pre.setInt(1, user.getUserid());
		pre.setInt(1, newstype.getNewsTypeId());
		pre.setString(2,newstype.getNewsTypeName());
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
	//������������
	public boolean updateNewsType(NewsTypeDTO newstype)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update NewsType set newsTypeName=?,isDelete=? where newsTypeId=?");		
			pre.setString(1, newstype.getNewsTypeName());
			pre.setInt(2,newstype.getIsDelete());
			pre.setInt(3, newstype.getNewsTypeId());		
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
	//ɾ����������
	public boolean delNewsType(int _newsTypeid)
	{
		boolean flag=false;
		try{
		conn=DataAccess.getConnection();
		stat=conn.createStatement();		
		stat.executeUpdate("update NewsType set isDelete=1 where newsTypeId='"+_newsTypeid+"'");				
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
