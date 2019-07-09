package cn.edu.lingnan.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;

public class UsertableDAO {
	private Connection conn=null;
	private Statement stat=null;
	private PreparedStatement pre=null;
	private ResultSet rs=null;
	//用户登录验证
	public int findUserNamePassword(String _name,String _password)
	{ 
		int usersuper=-1;
		try{
		conn=DataAccess.getConnection();
		stat=conn.createStatement();
		rs=stat.executeQuery("select * from Usertable where username='"+_name+"' and userpass='"+_password+"' and isDelete=0");				
		while(rs.next())
		{usersuper=rs.getInt("super");}		
		}				
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			DataAccess.closeConnection(conn, stat, rs);
		}
		
			
			return usersuper;
	}
	
	//用户登录验证
		public int user(String _name)
		{ 
			int usersuper=-1;
			try{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from Usertable where username='"+_name+"' and isDelete=0");				
			while(rs.next())
			{usersuper=rs.getInt("super");}		
			}				
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally{
				DataAccess.closeConnection(conn, stat, rs);
			}
			
				
				return usersuper;
		}
	
	//查找所有用户的信息
	public Vector<UsertableDTO> findAllUser()
	{
		Vector <UsertableDTO> v =new Vector <UsertableDTO>();
		try{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from Usertable");				
			while(rs.next())
			{//每查找一条学生记录，创建一个对象，存入可变数组
				UsertableDTO u=new UsertableDTO();
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setUserpass(rs.getString("userpass"));
				u.setUserphone(rs.getString("userphone"));
				u.setUsersex(rs.getString("usersex"));
				u.setUsersuper(rs.getInt("super"));
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
	
	
	public Vector<UsertableDTO> findPublicUser()
	{
		Vector <UsertableDTO> v =new Vector <UsertableDTO>();
		try{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from Usertable where super=2 and isDelete=0");				
			while(rs.next())
			{//每查找一条学生记录，创建一个对象，存入可变数组
				UsertableDTO u=new UsertableDTO();
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setUserpass(rs.getString("userpass"));
				u.setUserphone(rs.getString("userphone"));
				u.setUsersex(rs.getString("usersex"));
				u.setUsersuper(rs.getInt("super"));
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
	
	public Vector<UsertableDTO> findAllManger()
	{
		Vector <UsertableDTO> v =new Vector <UsertableDTO>();
		try{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from Usertable where super=1 and isDelete=0");				
			while(rs.next())
			{//每查找一条学生记录，创建一个对象，存入可变数组
				UsertableDTO u=new UsertableDTO();
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setUserpass(rs.getString("userpass"));
				u.setUserphone(rs.getString("userphone"));
				u.setUsersex(rs.getString("usersex"));
				u.setUsersuper(rs.getInt("super"));
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
	//根据用户id查询用户信息
	public Vector <UsertableDTO> selectMangerById(int _userid)
	{
		Vector <UsertableDTO> v=new Vector <UsertableDTO>();
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Usertable where userid=?  and isDelete=0 and super=1");
			pre.setInt(1, _userid);
			rs=pre.executeQuery();				
			while(rs.next())
			{//每查找一条学生记录，创建一个对象，存入可变数组
				UsertableDTO u=new UsertableDTO();
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setUserpass(rs.getString("userpass"));
				u.setUserphone(rs.getString("userphone"));
				u.setUsersex(rs.getString("usersex"));	
				v.add(u);				
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
	//根据用户姓名查询用户
	public Vector <UsertableDTO> selectByname(String _username)
	{
		Vector <UsertableDTO> v=new Vector <UsertableDTO>();
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Usertable where username=?  and isDelete=0");
			pre.setString(1, _username);
			rs=pre.executeQuery();				
			while(rs.next())
			{//每查找一条学生记录，创建一个对象，存入可变数组
				UsertableDTO u=new UsertableDTO();
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setUserpass(rs.getString("userpass"));
				u.setUserphone(rs.getString("userphone"));
				u.setUsersex(rs.getString("usersex"));	
				v.add(u);				
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

	public int findUserid(String _name,String _password)
	{
		int _userid=0;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("select * from Usertable where username=? and userpass=?  and isDelete=0");
			pre.setString(1, _name);
			pre.setString(2, _password);
			rs=pre.executeQuery();				
			while(rs.next())
			{
					
				_userid=rs.getInt("userid");				
			}			
			}				
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally{
				DataAccess.closeConnection(conn, pre, rs);
			}
		
		return _userid;
	}
	//添加用户
	public boolean insertUser(UsertableDTO user)
	{
		boolean flag=false;
		try{
		conn=DataAccess.getConnection();
		pre=conn.prepareStatement("insert into Usertable(username,userpass,userphone,usersex,super,isDelete) values(?,?,?,?,2,0)");
		//pre.setInt(1, user.getUserid());
		pre.setString(1, user.getUsername());
		pre.setString(2,user.getUserpass());
		pre.setString(3, user.getUserphone());
		pre.setString(4, user.getUsersex());
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
	//添加管理员
	public boolean insertmanger(UsertableDTO user)
	{
		boolean flag=false;
		try{
		conn=DataAccess.getConnection();
		pre=conn.prepareStatement("insert into Usertable(username,userpass,userphone,usersex,super,isDelete) values(?,?,?,?,1,0)");
		//pre.setInt(1, user.getUserid());
		pre.setString(1, user.getUsername());
		pre.setString(2,user.getUserpass());
		pre.setString(3, user.getUserphone());
		pre.setString(4, user.getUsersex());
		//pre.setInt(6,user.getUsersuper());
		//pre.setInt(7, user.getIsDelete());
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
	//根据用户id删除用户信息
	public boolean delUser(int _userid)
	{
		boolean flag=false;
		try{
		conn=DataAccess.getConnection();
		stat=conn.createStatement();		
		stat.executeUpdate("update Usertable set isDelete=1 where userid='"+_userid+"'");				
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
	//更新用户信息
	public boolean updateUser(UsertableDTO user)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Usertable set username=?,userpass=?,userphone=?,usersex=?,super=2,isDelete=0 where userid=?");		
			pre.setString(1, user.getUsername());
			pre.setString(2,user.getUserpass());
			pre.setString(3, user.getUserphone());
			pre.setString(4, user.getUsersex());
			pre.setInt(5, user.getUserid());
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
	
	
	public boolean updateManger(UsertableDTO user)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
			pre=conn.prepareStatement("update Usertable set username=?,userpass=?,userphone=?,usersex=?,super=1,isDelete=0 where userid=?");		
			pre.setString(1, user.getUsername());
			pre.setString(2,user.getUserpass());
			pre.setString(3, user.getUserphone());
			pre.setString(4, user.getUsersex());
			pre.setInt(5, user.getUserid());
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
	//根据用户id更新用户姓名
	public boolean updateUsername(int _userid,String _username)
	{
		boolean flag=false;
		try{
			conn=DataAccess.getConnection();
		    pre=conn.prepareStatement("update Usertable set username=? where userid=? and isDelete=0");
			pre.setString(1, _username);
			pre.setInt(2, _userid);
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
