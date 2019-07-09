package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;
public class DishDeptsDAO {
	private Connection conn=null;
	private Statement stat=null;
	private PreparedStatement pre=null;
	private ResultSet rs=null;
	
	//查询所有菜系信息
	public Vector<DishDeptsDTO> findAllDepts()
	{
		Vector <DishDeptsDTO> v=new Vector <DishDeptsDTO>();
		try{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from DishDepts");
			while(rs.next())
			{
				DishDeptsDTO  deptsdto=new DishDeptsDTO();
				deptsdto.setDeptsno(rs.getInt("deptsno"));
				deptsdto.setDeptsname(rs.getString("deptsname"));
				deptsdto.setIsDelete(rs.getInt("isDelete"));
				v.add(deptsdto);
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
	//根据菜系号查询菜系
	public Vector<DishDeptsDTO> selectBydeptsno(int _deptsno)
	{
		Vector<DishDeptsDTO> v=new Vector<DishDeptsDTO>();
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from DishDepts where deptsno=? and isDelete=0");
			pre.setInt(1, _deptsno);
			rs=pre.executeQuery();
			while(rs.next())
			{
				DishDeptsDTO  deptsdto=new DishDeptsDTO();
				deptsdto.setDeptsno(rs.getInt("deptsno"));
				deptsdto.setDeptsname(rs.getString("deptsname"));
				v.add(deptsdto);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			DataAccess.closeConnection(conn, pre, rs);
		}
		return v;
	}
	//根据菜系名查询菜系(精确查询)
	public Vector<DishDeptsDTO> selectBydeptsname(String _deptsname)
	{
		Vector<DishDeptsDTO> v=new Vector<DishDeptsDTO>();
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from DishDepts where deptsname=? and isDelete=0");
			pre.setString(1, _deptsname);
			rs=pre.executeQuery();
			while(rs.next())
			{
				DishDeptsDTO  deptsdto=new DishDeptsDTO();
				deptsdto.setDeptsno(rs.getInt("deptsno"));
				deptsdto.setDeptsname(rs.getString("deptsname"));
				v.add(deptsdto);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			DataAccess.closeConnection(conn, pre, rs);
		}
		return v;
	}
	//根据菜系名查询菜系（粗略查询）
	public Vector<DishDeptsDTO> selectBydeptsnames(String _deptsname)
	{
		Vector<DishDeptsDTO> v=new Vector<DishDeptsDTO>();
		try{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();			
			rs=stat.executeQuery("select * from DishDepts where deptsname like '%"+_deptsname+"%' and isDelete=0");
			while(rs.next())
			{
				DishDeptsDTO  deptsdto=new DishDeptsDTO();
				deptsdto.setDeptsno(rs.getInt("deptsno"));
				deptsdto.setDeptsname(rs.getString("deptsname"));
				v.add(deptsdto);
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
	//增加一个菜系
		public boolean insertDepts(DishDeptsDTO dedto)
		{
			boolean flag=false;
			try{
				conn=DataAccess.getConnection();
				pre=conn.prepareStatement("insert into DishDepts values(?,?,?)");
				pre.setInt(1, dedto.getDeptsno());
				pre.setString(2, dedto.getDeptsname());
				pre.setInt(3, dedto.getIsDelete());
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
		//根据菜系no删除菜系
		public boolean delDepts(int _deptsno)
		{
			boolean flag=false;
			try{
				conn=DataAccess.getConnection();
				stat=conn.createStatement();
				stat.executeUpdate("update Dish set isDelete=1 where deptsno='"+_deptsno+"'");
				stat.executeUpdate("update DishDepts set isDelete=1 where deptsno='"+_deptsno+"'");
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
		
	//更新菜系
		public boolean updateDepts(DishDeptsDTO deptdto)
		{
			boolean flag=false;
			try{
				conn=DataAccess.getConnection();
				pre=conn.prepareStatement("update DishDepts set deptsname=?,isDelete=? where deptsno=?");	
				pre.setString(1, deptdto.getDeptsname());
				pre.setInt(2, deptdto.getIsDelete());
				pre.setInt(3, deptdto.getDeptsno());
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
}
