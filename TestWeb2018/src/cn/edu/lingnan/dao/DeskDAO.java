package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;

public class DeskDAO {
	private Connection conn=null;
	private Statement stat=null;
	private PreparedStatement pre=null;
	private ResultSet rs=null;
	//查询所有餐桌
	public Vector <DeskDTO> findAllDesk()
	{
		Vector <DeskDTO> v=new Vector <DeskDTO>();
		try
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from Desk where isDelete=0");
			while(rs.next())
			{
				DeskDTO Ddto=new DeskDTO();
				Ddto.setDeskid(rs.getInt("deskid"));
				Ddto.setSeatnumber(rs.getInt("seatnumber"));
				Ddto.setDeskstatus(rs.getString("deskstatus"));
				Ddto.setRoomid(rs.getInt("roomid"));
				Ddto.setUserid(rs.getInt("userid"));
				Ddto.setIsDelete(rs.getInt("isDelete"));
				v.add(Ddto);
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
	//根据餐桌号查询餐桌
	public Vector<DeskDTO> selectByideskid(int _deskid)
	{
		Vector <DeskDTO> v=new Vector <DeskDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Desk where deskid=? and isDelete=0");
			pre.setInt(1, _deskid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				DeskDTO Ddto=new DeskDTO();
				Ddto.setDeskid(rs.getInt("deskid"));
				Ddto.setSeatnumber(rs.getInt("seatnumber"));
				Ddto.setDeskstatus(rs.getString("deskstatus"));
				Ddto.setRoomid(rs.getInt("roomid"));
				Ddto.setIsDelete(rs.getInt("isDelete"));
				v.add(Ddto);
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
	//查询空闲餐桌（查询可预订餐桌）
	public Vector<DeskDTO> findFreedesk()
	{
		Vector <DeskDTO> v=new Vector <DeskDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Desk where isDelete=0 and deskstatus='空闲'");
			rs=pre.executeQuery();
			while(rs.next())
			{
				DeskDTO Ddto=new DeskDTO();
				Ddto.setDeskid(rs.getInt("deskid"));
				Ddto.setSeatnumber(rs.getInt("seatnumber"));
				Ddto.setDeskstatus(rs.getString("deskstatus"));
				Ddto.setRoomid(rs.getInt("roomid"));
				Ddto.setIsDelete(rs.getInt("isDelete"));
				v.add(Ddto);
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
	
	public Vector<DeskDTO> selectBusyDesk(int _userid)
	{
		Vector <DeskDTO> v=new Vector <DeskDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Desk where userid=? and isDelete=0 and deskstatus='客满'");
			pre.setInt(1, _userid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				DeskDTO Ddto=new DeskDTO();
				Ddto.setDeskid(rs.getInt("deskid"));
				Ddto.setSeatnumber(rs.getInt("seatnumber"));
				Ddto.setDeskstatus(rs.getString("deskstatus"));
				Ddto.setRoomid(rs.getInt("roomid"));
				Ddto.setIsDelete(rs.getInt("isDelete"));
				v.add(Ddto);
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
	
	public int findRoomid(int _deskid)
	{
		int roomid=-1;
		try
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from Desk where deskid='"+_deskid + "'");
			//pre=conn.prepareStatement("select * from Desk where deskid=? and isDelete=0");
			//pre.setInt(1, _deskid);
			//rs=pre.executeQuery();
			while(rs.next())
			{
				roomid=rs.getInt("roomid");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			DataAccess.closeConnection(conn, stat, rs);
		}
		return roomid;
		
	}
	
	public int findDeskNumber(int _roomid)
	{
		int desknumber=-1;
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select count(deskid) from Desk where roomid=? and isDelete=0");
			pre.setInt(1, _roomid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				desknumber=rs.getInt("count(deskid)");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			DataAccess.closeConnection(conn, pre, rs);
		}
		return desknumber;
		
	}
	
	
	//增加一张桌子
	public boolean insertDesk(DeskDTO dedto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("insert into Desk(deskid,seatnumber,deskstatus,roomid,userid,isDelete)"
					+ " values(?,?,'空闲',?,null,0)");
			pre.setInt(1, dedto.getDeskid());
			pre.setInt(2, dedto.getSeatnumber());
			//pre.setString(3,dedto.getDeskstatus());
			pre.setInt(3,dedto.getRoomid());
			//pre.setInt(5, dedto.getIsDelete());
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
	//根据餐桌号删除一张餐桌
	public boolean delDesk(int _deskid)
	{
		boolean flag=false;
		try{
		conn=DataAccess.getConnection();
		pre=conn.prepareStatement("update Desk set isDelete=1 where deskid=?");
		pre.setInt(1,_deskid);	
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
	//更新餐桌
	public boolean updateDesk(DeskDTO dedto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Desk set seatnumber=?,deskstatus=?,roomid=?,userid=?,isDelete=0 where deskid=?");
			pre.setInt(1, dedto.getSeatnumber());
			pre.setString(2,dedto.getDeskstatus());
			pre.setInt(3,dedto.getRoomid());
			pre.setInt(4, dedto.getUserid());
			pre.setInt(5, dedto.getDeskid());	
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
	
	
	public boolean updateDesk_1(DeskDTO dedto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Desk set seatnumber=?,deskstatus=?,roomid=?,userid=null,isDelete=0 where deskid=?");
			pre.setInt(1, dedto.getSeatnumber());
			pre.setString(2,dedto.getDeskstatus());
			pre.setInt(3,dedto.getRoomid());
			pre.setInt(4, dedto.getDeskid());	
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
	
	
	//根据餐桌号更新餐桌状态
	public boolean updateDeskStatus(DeskDTO dedto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Desk set deskstatus=? where deskid=?");
			pre.setString(1,dedto.getDeskstatus());
			pre.setInt(2, dedto.getDeskid());	
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
	//更新餐桌信息（预订餐桌）
	public boolean updateDeskUser(DeskDTO dedto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Desk set deskstatus='客满',userid=? where deskid=?");
			pre.setInt(1, dedto.getUserid());
			pre.setInt(2, dedto.getDeskid());	
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
	//更新餐桌信息（取消预订）
	public boolean cancelDeskUser(DeskDTO dedto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Desk set deskstatus='空闲',userid=null where deskid=?");
			//pre.setInt(1, dedto.getUserid());
			pre.setInt(1, dedto.getDeskid());			
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
