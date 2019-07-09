package cn.edu.lingnan.dao;
import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OrdertableDAO {
	private Connection conn=null;
	private Statement stat=null;
	private PreparedStatement pre=null;
	private ResultSet rs=null;
	//查找所有订单
	public Vector <OrdertableDTO> findAllOrder()
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from Ordertable where isDelete=0");
			while(rs.next())
			{
				OrdertableDTO ordto =new OrdertableDTO();
				ordto.setOrderid(rs.getInt("orderid"));
				ordto.setUserid(rs.getInt("userid"));
				ordto.setDishid(rs.getInt("dishid"));
				ordto.setBuynumber(rs.getInt("buynumber"));
				ordto.setSumprice(rs.getFloat("sumprice"));
				ordto.setOrdertime(rs.getString("ordertime"));
				ordto.setCreatedate(rs.getString("createdate"));
				ordto.setOrderstatus(rs.getString("orderstatus"));
				ordto.setIsDelete(rs.getInt("isDelete"));
				v.add(ordto);
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
	//通过用户号查询订单状态
	public Vector <OrdertableDTO> findOrderByuserid(int userid)
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Ordertable where userid=? and isDelete=0");
			pre.setInt(1, userid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				OrdertableDTO ordto =new OrdertableDTO();
				ordto.setOrderid(rs.getInt("orderid"));
				ordto.setUserid(rs.getInt("userid"));
				ordto.setDishid(rs.getInt("dishid"));			
				ordto.setBuynumber(rs.getInt("buynumber"));
				ordto.setSumprice(rs.getFloat("sumprice"));
				ordto.setOrdertime(rs.getString("ordertime"));
				ordto.setCreatedate(rs.getString("createdate"));
				ordto.setOrderstatus(rs.getString("orderstatus"));
				ordto.setIsDelete(rs.getInt("isDelete"));
				v.add(ordto);
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
	//查询未完成订单
	public Vector <OrdertableDTO> findtUnfinishOrder()
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Ordertable where orderstatus='未完成' and isDelete=0");			
			rs=pre.executeQuery();
			while(rs.next())
			{
				OrdertableDTO ordto =new OrdertableDTO();
				ordto.setOrderid(rs.getInt("orderid"));
				ordto.setUserid(rs.getInt("userid"));
				ordto.setDishid(rs.getInt("dishid"));			
				ordto.setBuynumber(rs.getInt("buynumber"));
				ordto.setSumprice(rs.getFloat("sumprice"));
				ordto.setOrdertime(rs.getString("ordertime"));
				ordto.setCreatedate(rs.getString("createdate"));
				ordto.setOrderstatus(rs.getString("orderstatus"));
				//ordto.setIsDelete(rs.getInt("isDelete"));
				v.add(ordto);
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
	
	public Vector <OrdertableDTO> findtHifinishOrder()
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Ordertable where orderstatus='预定中' and isDelete=0");			
			rs=pre.executeQuery();
			while(rs.next())
			{
				OrdertableDTO ordto =new OrdertableDTO();
				ordto.setOrderid(rs.getInt("orderid"));
				ordto.setUserid(rs.getInt("userid"));
				ordto.setDishid(rs.getInt("dishid"));			
				ordto.setBuynumber(rs.getInt("buynumber"));
				ordto.setSumprice(rs.getFloat("sumprice"));
				ordto.setOrdertime(rs.getString("ordertime"));
				ordto.setCreatedate(rs.getString("createdate"));
				ordto.setOrderstatus(rs.getString("orderstatus"));
				//ordto.setIsDelete(rs.getInt("isDelete"));
				v.add(ordto);
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
	
	
	//通过用户id查询未完成订单
	public Vector <OrdertableDTO> selectUnfinishOrderByuserid(int userid)
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Ordertable where userid=? and orderstatus='未完成' and isDelete=0");
			pre.setInt(1, userid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				OrdertableDTO ordto =new OrdertableDTO();
				ordto.setOrderid(rs.getInt("orderid"));
				ordto.setUserid(rs.getInt("userid"));
				ordto.setDishid(rs.getInt("dishid"));
				ordto.setBuynumber(rs.getInt("buynumber"));
				ordto.setSumprice(rs.getFloat("sumprice"));
				ordto.setOrdertime(rs.getString("ordertime"));
				ordto.setCreatedate(rs.getString("createdate"));
				ordto.setOrderstatus(rs.getString("orderstatus"));
				//ordto.setIsDelete(rs.getInt("isDelete"));
				v.add(ordto);
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
	//根据用户号查询正在预订中的订单
	public Vector <OrdertableDTO> selectOrderByuserid(int userid)
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Ordertable where userid=? and orderstatus='预定中' and isDelete=0");
			pre.setInt(1, userid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				OrdertableDTO ordto =new OrdertableDTO();
				ordto.setOrderid(rs.getInt("orderid"));
				ordto.setUserid(rs.getInt("userid"));
				ordto.setDishid(rs.getInt("dishid"));
				ordto.setBuynumber(rs.getInt("buynumber"));
				ordto.setSumprice(rs.getFloat("sumprice"));
				ordto.setOrdertime(rs.getString("ordertime"));
				ordto.setCreatedate(rs.getString("createdate"));
				ordto.setOrderstatus(rs.getString("orderstatus"));
				//ordto.setIsDelete(rs.getInt("isDelete"));
				v.add(ordto);
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
	//根据用户号查询已完成的订单（历史订单）
	public Vector <OrdertableDTO> selecthistoryOrderByuserid(int userid)
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Ordertable where userid=? and orderstatus='已完成' and isDelete=0");
			pre.setInt(1, userid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				OrdertableDTO ordto =new OrdertableDTO();
				ordto.setOrderid(rs.getInt("orderid"));
				ordto.setUserid(rs.getInt("userid"));
				ordto.setDishid(rs.getInt("dishid"));				
				ordto.setBuynumber(rs.getInt("buynumber"));
				ordto.setSumprice(rs.getFloat("sumprice"));
				ordto.setOrdertime(rs.getString("ordertime"));
				ordto.setCreatedate(rs.getString("createdate"));
				ordto.setOrderstatus(rs.getString("orderstatus"));
				//ordto.setIsDelete(rs.getInt("isDelete"));
				v.add(ordto);
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
	
	
	//根据订单号删除订单
	public boolean delOrder(int _orderid)
	{
		boolean flag=false;
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Ordertable set isDelete=1 where orderid=?");
			pre.setInt(1, _orderid);
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
	//下订单
	public boolean insertOrder(OrdertableDTO orderdto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("insert into Ordertable(userid,dishid,buynumber,sumprice,ordertime,createdate,orderstatus,isDelete) "
					+ "values(?,?,?,?,?,?,'未完成',0)");
			pre.setInt(1, orderdto.getUserid());
			pre.setInt(2, orderdto.getDishid());
			pre.setInt(3, orderdto.getBuynumber());
			pre.setFloat(4, orderdto.getSumprice());
			pre.setString(5, orderdto.getOrdertime());
			pre.setString(6, orderdto.getCreatedate());
			pre.executeUpdate();
			/*int orderid=0;
			pre=conn.prepareStatement("select orderid from Ordertable where userid=? and orderstatus='未完成' and isDelete=0");
			rs=pre.executeQuery();
			while(rs.next())
			{
				orderid=rs.getInt("orderid");
				pre=conn.prepareStatement("update Ordertable set sumprice=? where orderid='"+orderid+"'");
				pre.setFloat(1, arg1);
			}*/
			flag=true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	//更新订单
	public boolean updateOrder(OrdertableDTO orderdto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Ordertable set userid=?,dishid=?,buynumber=?,sumprice=?,ordertime,createdate=?,orderstatus=?,isDelete=? where orderid=?");
			pre.setInt(1, orderdto.getUserid());
			pre.setInt(2, orderdto.getDishid());
			pre.setInt(3, orderdto.getBuynumber());
			pre.setFloat(4, orderdto.getSumprice());
			pre.setString(5, orderdto.getOrdertime());
			pre.setString(6, orderdto.getCreatedate());
			pre.setString(7, orderdto.getOrderstatus());
			pre.setInt(8, orderdto.getIsDelete());
			pre.setInt(9, orderdto.getOrderid());
			pre.executeUpdate();
			flag=true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	//确认订单
	public boolean confirmOrder(OrdertableDTO orderdto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Ordertable set orderstatus='预定中' where orderid=? and isDelete=0");			
			pre.setInt(1, orderdto.getOrderid());
			pre.executeUpdate();
			flag=true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	//把订单设置为已完成（订单已完成）
	public boolean confirmHistoryOrder(OrdertableDTO orderdto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Ordertable set orderstatus='已完成' where orderid=? and isDelete=0");			
			pre.setInt(1, orderdto.getOrderid());
			pre.executeUpdate();
			flag=true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}

}
