package cn.edu.lingnan.dao;
import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DishDAO {
	private Connection conn=null;
	private Statement stat=null;
	private PreparedStatement pre=null;
	private ResultSet rs=null;
	//查找所有菜品
	public Vector <DishDTO> findDish()
	{
		Vector <DishDTO> v=new Vector <DishDTO>();
		try
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from Dish");
			while(rs.next())
			{   
				DishDTO dsdto=new DishDTO();
				dsdto.setDishid(rs.getInt("dishid"));
				dsdto.setDishname(rs.getString("dishname"));
				dsdto.setOriginal_price(rs.getFloat("original_price"));
				dsdto.setPrefer_price(rs.getFloat("prefer_price"));
				dsdto.setPhotopath(rs.getString("photopath"));
				dsdto.setDishinformation(rs.getString("dishinformation"));
				dsdto.setDeptsno(rs.getInt("deptsno"));
				dsdto.setIsDelete(rs.getInt("isDelete"));
				v.add(dsdto);
				
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
			pre=conn.prepareStatement("select count(*) from Dish where isDelete=0");
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
	
	//根据
	public Vector<DishDTO> listDish(int pageNo)
	{
		//List<DishDTO> list=new  ArrayList<DishDTO>();
		Vector<DishDTO> list=new Vector<DishDTO>();
		int pageSize=5;
		int page=(pageNo-1)*5;
		
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Dish where isDelete=0 order by dishid limit ?,?");
			pre.setInt(1, page);
			pre.setInt(2, pageSize);
			rs=pre.executeQuery();
			while(rs.next())
			{   
				DishDTO dsdto=new DishDTO();
				dsdto.setDishid(rs.getInt("dishid"));
				dsdto.setDishname(rs.getString("dishname"));
				dsdto.setOriginal_price(rs.getFloat("original_price"));
				dsdto.setPrefer_price(rs.getFloat("prefer_price"));
				dsdto.setPhotopath(rs.getString("photopath"));
				dsdto.setDishinformation(rs.getString("dishinformation"));
				dsdto.setDeptsno(rs.getInt("deptsno"));
				dsdto.setIsDelete(rs.getInt("isDelete"));
				list.add(dsdto);
				
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
	
	//根据菜号查询菜系号
	public int finddeptsno(int _dishid)
	{
		int deptsno1=0;
		try
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select deptsno from Dish where dishid='"+_dishid+"' and isDelete=0");
			while(rs.next())
			{
				deptsno1=rs.getInt("deptsno");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataAccess.closeConnection(conn, stat, rs);
		}
		return deptsno1;
	}
	//根据菜号查询对应的菜系名
	public String finddeptsname(int _dishid)
	{
		String deptsname1=null;
		try
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select deptsname from Dish,DishDepts where dishid='"+_dishid+"' and Dish.deptsno=DishDepts.deptsno and isDelete=0");
			while(rs.next())
			{
				deptsname1=rs.getString("deptsname");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataAccess.closeConnection(conn, stat, rs);
		}
		return deptsname1;
	}
	
	//根据dishid查询菜品信息
	public Vector <DishDTO>  selectDihsByid(int _dishid)
	{
		Vector <DishDTO> v=new Vector <DishDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Dish where dishid=? and isDelete=0");
			pre.setInt(1, _dishid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				DishDTO dsdto=new DishDTO();
				dsdto.setDishid(rs.getInt("dishid"));
				dsdto.setDishname(rs.getString("dishname"));
				dsdto.setOriginal_price(rs.getFloat("original_price"));
				dsdto.setPrefer_price(rs.getFloat("prefer_price"));
				dsdto.setPhotopath(rs.getString("photopath"));
				dsdto.setDishinformation(rs.getString("dishinformation"));
				dsdto.setDeptsno(rs.getInt("deptsno"));
				dsdto.setIsDelete(rs.getInt("isDelete"));
				v.add(dsdto);			
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
	public float findPrice(int _dishid)
	{
	
		float _preferprice=0.0f;
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select prefer_price from Dish where dishid=? and isDelete=0");
			pre.setInt(1, _dishid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				_preferprice=rs.getFloat("prefer_price");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			DataAccess.closeConnection(conn, pre, rs);
		}
		return _preferprice;
	}
	//根据菜品名查询菜品
	public Vector <DishDTO> selectDihsByName(String _dishname)
	{
		Vector <DishDTO> v=new Vector <DishDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Dish where dishname=? and isDelete=0");
			pre.setString(1, _dishname);
			rs=pre.executeQuery();
			while(rs.next())
			{
				DishDTO dsdto=new DishDTO();
				dsdto.setDishid(rs.getInt("dishid"));
				dsdto.setDishname(rs.getString("dishname"));
				dsdto.setOriginal_price(rs.getFloat("original_price"));
				dsdto.setPrefer_price(rs.getFloat("prefer_price"));
				dsdto.setPhotopath(rs.getString("photopath"));
				dsdto.setDishinformation(rs.getString("dishinformation"));
				dsdto.setDeptsno(rs.getInt("deptsno"));
				dsdto.setIsDelete(rs.getInt("isDelete"));
				v.add(dsdto);
				
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
	
	public Vector <DishDTO> selectDihsBydetpsno(int _deptsno)
	{
		Vector <DishDTO> v=new Vector <DishDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Dish where deptsno=? and isDelete=0");
			pre.setInt(1, _deptsno);
			rs=pre.executeQuery();
			while(rs.next())
			{
				DishDTO dsdto=new DishDTO();
				dsdto.setDishid(rs.getInt("dishid"));
				dsdto.setDishname(rs.getString("dishname"));
				dsdto.setOriginal_price(rs.getFloat("original_price"));
				dsdto.setPrefer_price(rs.getFloat("prefer_price"));
				dsdto.setPhotopath(rs.getString("photopath"));
				dsdto.setDishinformation(rs.getString("dishinformation"));
				dsdto.setDeptsno(rs.getInt("deptsno"));
				dsdto.setIsDelete(rs.getInt("isDelete"));
				v.add(dsdto);
				
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
	
	
	
	//插入菜品
   public boolean insertDish(DishDTO didto)
   {
	   boolean flag=false;
	   try{
		   conn=DataAccess.getConnection();
		   pre=conn.prepareStatement("insert into Dish values(?,?,?,?,?,?,?,0)");
		   pre.setInt(1, didto.getDishid());
		   pre.setString(2, didto.getDishname());
		   pre.setFloat(3, didto.getOriginal_price());
		   pre.setFloat(4, didto.getPrefer_price());
		   pre.setString(5, didto.getPhotopath());
		   pre.setString(6, didto.getDishinformation());
		   pre.setInt(7, didto.getDeptsno());
		  // pre.setInt(8, didto.getIsDelete());
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
   //根据菜品id删除菜品
   public boolean delDish(int _dishid)
   {
	   boolean flag=false;
	   try{
		   conn=DataAccess.getConnection();
		   pre=conn.prepareStatement("update Ordertabel set isDelete=1 where dishid=?");
		   pre=conn.prepareStatement("update Dish set isDelete=1 where dishid=?");
		   pre.setInt(1, _dishid);
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
   //更新菜品表
   public boolean updateDish(DishDTO didto)
   {
	   boolean flag=false;
	   try{
		   conn=DataAccess.getConnection();
		   pre=conn.prepareStatement("update dish set dishname=?,original_price=?,prefer_price=?,"
		   		+ "photopath=?,dishinformation=?,deptsno=?,isDelete=0 where dishid=?");
		   pre.setString(1, didto.getDishname());
		   pre.setFloat(2, didto.getOriginal_price());
		   pre.setFloat(3, didto.getPrefer_price());
		   pre.setString(4, didto.getPhotopath());
		   pre.setString(5, didto.getDishinformation());
		   pre.setInt(6, didto.getDeptsno());
		  // pre.setInt(7, didto.getIsDelete());
		   pre.setInt(7, didto.getDishid());
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


public boolean updateDishPhoto(String _photopath,int _dishid)
{
	   boolean flag=false;
	   try{
		   conn=DataAccess.getConnection();
		   pre=conn.prepareStatement("update dish set photopath=? where dishid=?");
		   
		   pre.setString(1, _photopath);	  
		   pre.setInt(2, _dishid);
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
