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
	//�������ж���
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
	//ͨ���û��Ų�ѯ����״̬
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
	//��ѯδ��ɶ���
	public Vector <OrdertableDTO> findtUnfinishOrder()
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Ordertable where orderstatus='δ���' and isDelete=0");			
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
			pre=conn.prepareStatement("select * from Ordertable where orderstatus='Ԥ����' and isDelete=0");			
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
	
	
	//ͨ���û�id��ѯδ��ɶ���
	public Vector <OrdertableDTO> selectUnfinishOrderByuserid(int userid)
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Ordertable where userid=? and orderstatus='δ���' and isDelete=0");
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
	//�����û��Ų�ѯ����Ԥ���еĶ���
	public Vector <OrdertableDTO> selectOrderByuserid(int userid)
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Ordertable where userid=? and orderstatus='Ԥ����' and isDelete=0");
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
	//�����û��Ų�ѯ����ɵĶ�������ʷ������
	public Vector <OrdertableDTO> selecthistoryOrderByuserid(int userid)
	{
		Vector <OrdertableDTO> v=new Vector <OrdertableDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Ordertable where userid=? and orderstatus='�����' and isDelete=0");
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
	
	
	//���ݶ�����ɾ������
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
	//�¶���
	public boolean insertOrder(OrdertableDTO orderdto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("insert into Ordertable(userid,dishid,buynumber,sumprice,ordertime,createdate,orderstatus,isDelete) "
					+ "values(?,?,?,?,?,?,'δ���',0)");
			pre.setInt(1, orderdto.getUserid());
			pre.setInt(2, orderdto.getDishid());
			pre.setInt(3, orderdto.getBuynumber());
			pre.setFloat(4, orderdto.getSumprice());
			pre.setString(5, orderdto.getOrdertime());
			pre.setString(6, orderdto.getCreatedate());
			pre.executeUpdate();
			/*int orderid=0;
			pre=conn.prepareStatement("select orderid from Ordertable where userid=? and orderstatus='δ���' and isDelete=0");
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
	//���¶���
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
	//ȷ�϶���
	public boolean confirmOrder(OrdertableDTO orderdto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Ordertable set orderstatus='Ԥ����' where orderid=? and isDelete=0");			
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
	//�Ѷ�������Ϊ����ɣ���������ɣ�
	public boolean confirmHistoryOrder(OrdertableDTO orderdto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Ordertable set orderstatus='�����' where orderid=? and isDelete=0");			
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
