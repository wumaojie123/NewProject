package cn.edu.lingnan.dao;
import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class RoomDAO {
	private Connection conn=null;
	private Statement stat=null;
	private PreparedStatement pre=null;
	private ResultSet rs=null;
	//��ѯ���з�����Ϣ
	public Vector<RoomDTO> findAllRoom()
	{
		Vector <RoomDTO> v=new Vector<RoomDTO>();
		try
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from Room");
			while(rs.next())
			{
				RoomDTO Rdto=new RoomDTO();
				Rdto.setRoomid(rs.getInt("roomid"));
				Rdto.setRoomname(rs.getString("roomname"));
				Rdto.setDesknumber(rs.getInt("desknumber"));
				Rdto.setRoomstatus(rs.getString("roomstatus"));
				Rdto.setIsDelete(rs.getInt("isDelete"));
			   v.add(Rdto);
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
	//���ݷ��Ų�ѯ����
	public Vector<RoomDTO> selectByroomid(int _roomid)
	{
		Vector <RoomDTO> v=new Vector<RoomDTO>();
		try
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from Room where roomid='"+_roomid+"' and isDelete=0");
			while(rs.next())
			{
				RoomDTO Rdto=new RoomDTO();
				Rdto.setRoomid(rs.getInt("roomid"));
				Rdto.setRoomname(rs.getString("roomname"));
				Rdto.setDesknumber(rs.getInt("desknumber"));
				Rdto.setRoomstatus(rs.getString("roomstatus"));
				//Rdto.setIsDelete(rs.getInt("isDelete"));
			   v.add(Rdto);
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
	//��ѯ���з���(��ѯ��Ԥ������)
	public Vector<RoomDTO> findFreeRoom()
	{
		Vector <RoomDTO> v=new Vector<RoomDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Room where roomstatus='����' and isDelete=0");
			rs=pre.executeQuery();
			while(rs.next())
			{
				RoomDTO Rdto=new RoomDTO();
				Rdto.setRoomid(rs.getInt("roomid"));
				Rdto.setRoomname(rs.getString("roomname"));
				Rdto.setDesknumber(rs.getInt("desknumber"));
				Rdto.setRoomstatus(rs.getString("roomstatus"));
				//Rdto.setIsDelete(rs.getInt("isDelete"));
			   v.add(Rdto);
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
	//��ѯ��������
	public Vector<RoomDTO> findBusyRoom()
	{
		Vector <RoomDTO> v=new Vector<RoomDTO>();
		try
		{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Room where roomstatus='����' and isDelete=0");
			rs=pre.executeQuery();
			while(rs.next())
			{
				RoomDTO Rdto=new RoomDTO();
				Rdto.setRoomid(rs.getInt("roomid"));
				Rdto.setRoomname(rs.getString("roomname"));
				Rdto.setDesknumber(rs.getInt("desknumber"));
				Rdto.setRoomstatus(rs.getString("roomstatus"));
				//Rdto.setIsDelete(rs.getInt("isDelete"));
			   v.add(Rdto);
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
	
	//����һ������
	public boolean insertRoom(RoomDTO rdto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("insert into Room values(?,?,?,?,?)");
			pre.setInt(1, rdto.getRoomid());
			pre.setString(2, rdto.getRoomname());
			pre.setInt(3, rdto.getDesknumber());
			pre.setString(4, rdto.getRoomstatus());
			pre.setInt(5, rdto.getIsDelete());
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
	//���ݷ���idɾ������
	public boolean delRoom(int _roomid)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			stat.executeUpdate("update Desk set isDelete=1 where roomid='"+_roomid+"'");
			stat.executeUpdate("update Room set isDelete=1 where roomid='"+_roomid+"'");
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
	//���·�����Ϣ
	public boolean updateRoom(RoomDTO roomdto)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Room set roomname=?,desknumber=?,roomstatus=?,isDelete=? where roomid=?");
			pre.setString(1, roomdto.getRoomname());
			pre.setInt(2, roomdto.getDesknumber());
			pre.setString(3, roomdto.getRoomstatus());
			pre.setInt(4, roomdto.getIsDelete());
			pre.setInt(5, roomdto.getRoomid());
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
	//���ݷ���Ÿ��·������״̬
	public boolean updateRoomStatus(int _roomid,String _status)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Room set roomstatus=? where roomid=?");
			pre.setString(1, _status);
			pre.setInt(2, _roomid);					
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
	
	public boolean updateRoomDeskNumber(int _desknumber,int _roomid)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Room set desknumber=? where roomid=?");
			pre.setInt(1, _desknumber);
			pre.setInt(2, _roomid);					
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
