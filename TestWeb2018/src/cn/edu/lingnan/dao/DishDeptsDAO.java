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
	
	//��ѯ���в�ϵ��Ϣ
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
	//���ݲ�ϵ�Ų�ѯ��ϵ
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
	//���ݲ�ϵ����ѯ��ϵ(��ȷ��ѯ)
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
	//���ݲ�ϵ����ѯ��ϵ�����Բ�ѯ��
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
	//����һ����ϵ
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
		//���ݲ�ϵnoɾ����ϵ
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
		
	//���²�ϵ
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
