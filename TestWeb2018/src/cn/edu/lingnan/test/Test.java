package cn.edu.lingnan.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dao.*;
import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.*;

public class Test {
	public static void main(String[] args)
	{
		Test test1=new Test();
		/*Scanner input=new Scanner(System.in);
		int num=-1;
		boolean isExit=false;
		System.out.println("-----------------欢迎使用本订餐系统-------------------------");
		System.out.println("--------------请选择操作------------------");
		do{
		System.out.println("1.管理员登录");
		System.out.println("2.用户登录");
		System.out.println("3.用户注册");
		System.out.println("4.退出系统");
		System.out.println("-------------------------------");
		System.out.print("请选择：");
		//System.out.print("\n");
		int choose=input.nextInt();		
		switch(choose)
		{   
			case 1:
				 
				isExit=true; break;
			case 2:
				int id=-1;	
				id=test1.findUserNamePassword();
			 if(id!=0)
			{	 
			System.out.println("成功登陆");
			System.out.println("您的用户id是："+id+",请记住！");
			int num_1=-1;
			 do{
			System.out.println("***********开始进入预约***************"); 
			System.out.println("1.进入预定餐桌");
			System.out.println("2.开始订餐");
			System.out.println("3.退出");
			System.out.println("**************************");
			System.out.println("您的选择为：");
			int choose_1=input.nextInt();
			boolean isExit_1=false;
			switch(choose_1)
			{
			case 1:
				test1.findfreedesk();
				System.out.println("*******************************");
				System.out.println("是否要预定餐桌？Y/N");
				String select=input.next();								
				if(select.equals("Y"))
				{				
				System.out.println("您的选择：");
				test1.updatedeskuser();
				System.out.println("预约餐桌成功");
				isExit_1=true; break;
				}
				else if(select.equals("N"))
				{ isExit_1=true; break;}
			case 2:
				System.out.println("**************请选择菜品******************");
				test1.findAllDish();
				System.out.println("***************************************");
				System.out.println("是否要定餐？Y/N");
				String select_1=input.next();								
				if(select_1.equals("Y"))
				{	
				System.out.println("您的选择：");
				test1.inserOrder();
				System.out.println("订餐成功");
				
				isExit_1=true; break;}
				else if(select_1.equals("N"))
				{
					isExit_1=true; break;
				}
			case 3: isExit_1=true; break;
			default:isExit_1=true; break;
			}	
			if (isExit_1) 
			{
				System.out.println("输入10返回预约界面，其他数字则退出（请输入数字）：");
				num_1 = input.nextInt();			
				}else {
					
					break;
				}
			 }while(num_1==10);
			 }
			 
			 else 
					System.out.println("登陆失败");
			 isExit=true;
			break;
			case 3: test1.insertUser(); 
			System.out.println("恭喜您已完成注册");
			break;
			case 4: isExit=true;break;
			default:isExit=true; break;
			
		}	
		if (isExit) {
			System.out.println("输入0返回主菜单，其他数字则退出（请输入数字）：");
			num = input.nextInt();
			} else {
			break;
			}
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次光临！");*/
		//test1.findUserNamePassword();
		//test1.getPage();
		//test1.findAllUser();		
		//test1.selectById();
		//test1.updateUsername();
		//test1.updataUser();
		//test1.insertUser();
		//test1.selectBydeptsno();
		//test1.selectBydeptsname();
		//test1.selectBydeptsnames();
		//test1.updateDepts();
		//test1.selectByroomid();
		//test1.findFreeRoom();
		//test1.findBusyRoom();
		//test1.findAllDesk();
		//test1.findfreedesk();
		//test1.updatedeskstatus();
		//test1.updatedeskuser();
		//test1.canceldeskuser();
		//test1.finddeptsno();
		//test1.finddeptsnanme();
		//test1.selectDihsByid();
		//test1.updateDish();
		//test1.insertDish();
		//test1.findAllOrder();
		//test1.findtUnfinishOrder();
		//test1.selectUnfinishOrderByuserid();
		//test1.inserOrder();
		//test1.findperprice();
		//test1.updateOrder();
		//test1.confirmorder();
		//test1.confirmHistoryOrder();
		//test1.findUserNamePassword();
		//String _name=input.next();
		//test1.findUserid(_name);
		//test1.findAllOrder();
		test1.findRoomid();
	}
	/*public int findUserNamePassword()
	{	int _id=0;
	    boolean flag=false;
		Scanner reader=new Scanner(System.in);
		UsertableDAO userdao=new UsertableDAO();
		System.out.println("姓名：");
		String _name=reader.next();
		System.out.println("密码：");
		String _password=reader.next();
		flag=userdao.findUserNamePassword(_name, _password);
		if(flag)
			_id=userdao.findUserid(_name);
		return _id;						
	}*/
	public int findRoomid()
	{
		int roomid;
		DeskDAO deskdao=new DeskDAO();
		Scanner reader=new Scanner(System.in);
		roomid=deskdao.findRoomid(reader.nextInt());
		System.out.println(roomid);
		return roomid;
	}
	public void  findUserNamePassword()
	{   int usersuper;
		Scanner reader=new Scanner(System.in);
		UsertableDAO userdao=new UsertableDAO();
		System.out.println("姓名：");
		String _name=reader.next();
		System.out.println("密码：");
		String _password=reader.next();
		usersuper=userdao.findUserNamePassword(_name, _password);
		System.out.println(usersuper);
		//return usersuper;
	}
	
	public void findAllUser()
	{
	UsertableDAO udto=new UsertableDAO();
	Vector<UsertableDTO> u=new Vector <UsertableDTO>();
	u=udto.findAllUser();
	for(UsertableDTO us : u)
	{
	System.out.println("用户id：" + us.getUserid()+" ");
	System.out.println("用户名："+us.getUsername()+" ");
	System.out.println("用户手机号为："+us.getUserphone()+" ");
	System.out.println("性别："+us.getUsersex()+" ");
	}
	}
	public int findUserid(String _name,String _password)
	{   int _userid=0;
		UsertableDAO userdao=new UsertableDAO();
		_userid=userdao.findUserid(_name,_password);
		//System.out.println(_userid);
		return _userid;
	}
	

	public void updateUsername()
	{
		UsertableDAO userdao=new UsertableDAO();
		Scanner reader=new Scanner(System.in);
		int _userid=reader.nextInt();
		String _username=reader.next();
		userdao.updateUsername(_userid, _username);
		reader.close();		
	}
	public void updataUser()
	{   Scanner reader=new Scanner(System.in);
		UsertableDAO userdao=new UsertableDAO();
		UsertableDTO userdto=new UsertableDTO();
		userdto.setUserid(reader.nextInt());
		userdto.setUsername(reader.next());
		userdao.updateUser(userdto);
		reader.close();
	}
	
	public void insertUser()
	{
		Scanner reader=new Scanner(System.in);
		UsertableDAO userdao=new UsertableDAO();
		UsertableDTO userdto=new UsertableDTO();
		//Vector<UsertableDTO> v=new Vector<UsertableDTO>();
		System.out.print("姓名：");
		userdto.setUsername(reader.next());
		System.out.print("密码：");
		userdto.setUserpass(reader.next());
		System.out.print("手机号码：");
		userdto.setUserphone(reader.next());
		System.out.print("性别：");
		userdto.setUsersex(reader.next());
		userdao.insertUser(userdto);
		
	}
	public void selectBydeptsno()
	{
		Scanner reader=new Scanner(System.in);
		DishDeptsDAO didao=new DishDeptsDAO();
		Vector <DishDeptsDTO> v=new Vector<DishDeptsDTO>();
		int _deptsno=reader.nextInt();
		v=didao.selectBydeptsno(_deptsno);
		for(DishDeptsDTO us:v)
		{
			System.out.println("菜系号： "+us.getDeptsno());
			System.out.println("菜系名： "+us.getDeptsname());
		}
		reader.close();
	}
	
	public void selectBydeptsname()
	{
		Scanner reader=new Scanner(System.in);
		DishDeptsDAO didao=new DishDeptsDAO();
		Vector <DishDeptsDTO> v=new Vector<DishDeptsDTO>();
		//DishDeptsDTO deptdto=new DishDeptsDTO();
		String _name=reader.next();
		v=didao.selectBydeptsname(_name);
		
		//System.out.println("菜系号： "+deptdto.getDeptsno());
		for(DishDeptsDTO us:v)
		{
			System.out.println("菜系号： "+us.getDeptsno());
			System.out.println("菜系名： "+us.getDeptsname());
		}
		reader.close();
	}
	
	public void selectBydeptsnames()
	{
		Scanner reader=new Scanner(System.in);
		DishDeptsDAO didao=new DishDeptsDAO();
		Vector <DishDeptsDTO> v=new Vector<DishDeptsDTO>();
		String _deptsname=reader.next();
		v=didao.selectBydeptsnames(_deptsname);
		for(DishDeptsDTO us:v)
		{
			System.out.println("菜系号： "+us.getDeptsno());
			System.out.println("菜系名： "+us.getDeptsname());
		}
		reader.close();
	}
	public void updateDepts()
	{
		DishDeptsDAO dishdao=new DishDeptsDAO();
		Scanner reader=new Scanner(System.in);
		DishDeptsDTO dishdto=new DishDeptsDTO();
		dishdto.setDeptsno(reader.nextInt());
		dishdto.setDeptsname(reader.next());
		dishdto.setIsDelete(reader.nextInt());
		dishdao.updateDepts(dishdto);
		reader.close();
	}
	public void selectByroomid()
	 {
	    Scanner reader=new Scanner(System.in);	
		RoomDAO roomdao=new RoomDAO();
	    Vector <RoomDTO> v=new Vector<RoomDTO>();
	    v=roomdao.selectByroomid(reader.nextInt());
	    for(RoomDTO u:v)
	    {
	    	System.out.println("房号： "+u.getRoomid()+" ");
			System.out.println("房名：" +u.getRoomname()+" ");
			System.out.println("房间餐桌数："+u.getDesknumber()+" ");
			System.out.println("状态："+u.getRoomstatus()+" ");
	    }
	    reader.close();
	    	
     }
	
	public void findFreeRoom()
	{
		RoomDAO roomdao=new RoomDAO();
		Vector<RoomDTO> v=new Vector<RoomDTO>();
		v=roomdao.findFreeRoom();
		for(RoomDTO u:v)
		{
			System.out.println("房号： "+u.getRoomid()+" ");
			System.out.println("房名：" +u.getRoomname()+" ");
			System.out.println("房间餐桌数："+u.getDesknumber()+" ");
			System.out.println("状态："+u.getRoomstatus()+" ");
		}
	}
	public void findBusyRoom()
	{
		RoomDAO roomdao=new RoomDAO();
		Vector<RoomDTO> v=new Vector<RoomDTO>();
		v=roomdao.findBusyRoom();
		for(RoomDTO u:v)
		{
			System.out.println("房号： "+u.getRoomid()+" ");
			System.out.println("房名：" +u.getRoomname()+" ");
			System.out.println("房间餐桌数："+u.getDesknumber()+" ");
			System.out.println("状态："+u.getRoomstatus()+" ");
		}
	}
	public void findAllDesk()
	{
		DeskDAO deskdao=new DeskDAO();
		Vector <DeskDTO> v=new Vector<DeskDTO>();
		v=deskdao.findAllDesk();
		for(DeskDTO us:v)
		{   System.out.println("房号： "+us.getRoomid());
			System.out.println("餐桌号：" +us.getDeskid());
			System.out.println("座位数： "+us.getSeatnumber());
			System.out.println("状态： "+us.getDeskstatus());			
		}
	}
	public void findfreedesk()
	{
		DeskDAO deskdao=new DeskDAO();
		Vector<DeskDTO> v=new Vector<DeskDTO>();
		v=deskdao.findFreedesk();
		for(DeskDTO us:v)
		{   System.out.print("房号： "+us.getRoomid()+"\t");
			System.out.print("餐桌号：" +us.getDeskid()+"\t");
			System.out.print("座位数： "+us.getSeatnumber()+"\t");
			System.out.print("状态： "+us.getDeskstatus()+"\t");
			System.out.println("");
		}	
	}
	public void updatedeskstatus()
	{   Scanner reader=new Scanner(System.in);
		DeskDAO deskdao=new DeskDAO();
		DeskDTO deskdto=new DeskDTO();
		deskdto.setDeskid(reader.nextInt());
		deskdto.setDeskstatus(reader.next());
		deskdao.updateDeskStatus(deskdto);
		reader.close();
	}
	public void getPage()
	{
		DishDAO dishdao=new DishDAO();
		int a;
		a=dishdao.getPage();
		System.out.println(a);
	
	}
	public void updatedeskuser()
	{
		DeskDAO deskdao=new DeskDAO();
		DeskDTO deskdto=new DeskDTO();
		Scanner reader=new Scanner(System.in);
		System.out.println("餐桌号：");
		deskdto.setDeskid(reader.nextInt());
		System.out.println("您的用户id:");
		deskdto.setUserid(reader.nextInt());
		deskdao.updateDeskUser(deskdto);
		
	}
	public void canceldeskuser()
	{
		DeskDAO deskdao=new DeskDAO();
		DeskDTO deskdto=new DeskDTO();
		Scanner reader=new Scanner(System.in);
		deskdto.setDeskid(reader.nextInt());
		deskdao.cancelDeskUser(deskdto);
		reader.close();
	}

	public void finddeptsno()
	{
		DishDAO dishdao=new DishDAO();
		Scanner reader=new Scanner(System.in);
		int a;
		a=dishdao.finddeptsno(reader.nextInt());
		System.out.println(a);
		reader.close();
	}
	public void finddeptsnanme()
	{
		DishDAO dishdao=new DishDAO();
		Scanner reader=new Scanner(System.in);
		String b;
		b=dishdao.finddeptsname(reader.nextInt());
		System.out.println(b);
		reader.close();
	}
	public void findAllDish()
	{
		DishDAO dishdao=new DishDAO();
		Vector <DishDTO> v=new Vector<DishDTO>();
		v=dishdao.findDish();
		for(DishDTO us:v)
		{   			
			System.out.print("菜号："+us.getDishid()+"\t");
			System.out.print("菜名："+us.getDishname()+"\t");
			System.out.print("原价："+us.getOriginal_price()+"\t");
			System.out.print("优惠价："+us.getPrefer_price()+"\t");
			System.out.print("简介："+us.getDishinformation());
			System.out.println("");
		}
	}
	public void selectDihsByid ()
	{
		DishDAO dishdao=new DishDAO();
		Vector<DishDTO> v=new Vector<DishDTO>();
		Scanner reader=new Scanner(System.in);
		int _dishid=reader.nextInt();
		v=dishdao.selectDihsByid(_dishid);
		String deptsname=dishdao.finddeptsname(_dishid);
		for(DishDTO us:v)
		{   System.out.println("菜系名："+deptsname);
			System.out.println("菜号："+us.getDishid());
			System.out.println("菜名："+us.getDishname());
			System.out.println("原价："+us.getOriginal_price());
			System.out.println("优惠价："+us.getPrefer_price());
			System.out.println("简介："+us.getDishinformation());
			
		}
		reader.close();
	}
	public void findperprice()
	{   float _preferprice=0.0f;
		DishDAO dishdao=new DishDAO();
		Scanner reader=new Scanner(System.in);	
		_preferprice=dishdao.findPrice(reader.nextInt());
		System.out.println(_preferprice);
		//return _preferprice;
	}
	public void updateDish()
	{
		DishDAO dishdao=new DishDAO();
		DishDTO dishdto=new DishDTO();
		Scanner reader=new Scanner(System.in);
		dishdto.setDishid(reader.nextInt());
		dishdto.setDishname(reader.next());
		dishdto.setOriginal_price(reader.nextFloat());
		dishdto.setPrefer_price(reader.nextFloat());
		dishdto.setDishinformation(reader.next());
		dishdto.setDeptsno(reader.nextInt());
		dishdto.setIsDelete(reader.nextInt());
		dishdao.updateDish(dishdto);
		reader.close();
	}
	public void insertDish()
	{
		DishDAO dishdao=new DishDAO();
		DishDTO dishdto=new DishDTO();
		Scanner reader=new Scanner(System.in);
		dishdto.setDishid(reader.nextInt());
		dishdto.setDishname(reader.next());
		dishdto.setOriginal_price(reader.nextFloat());
		dishdto.setPrefer_price(reader.nextFloat());
		dishdto.setDishinformation(reader.next());
		dishdto.setDeptsno(reader.nextInt());
		dishdao.insertDish(dishdto);
		reader.close();
	}
	public void findAllOrder()
	{
		OrdertableDAO orderdao=new OrdertableDAO();
		Vector <OrdertableDTO> v=new Vector<OrdertableDTO>();
		v=orderdao.findAllOrder();
		
		for(OrdertableDTO us:v)
		{
			System.out.println("订单号："+us.getOrderid());
			System.out.println("用户号："+us.getUserid());
			System.out.println("菜品号："+us.getDishid());
			System.out.println("数量"+us.getBuynumber());
			System.out.println("总价："+us.getSumprice());
			System.out.println("预定就餐时间："+us.getOrdertime());
			System.out.println("下单时间："+us.getCreatedate());
			System.out.println("订单状态："+us.getOrderstatus());
			System.out.println("是否删除："+us.getIsDelete());
		}
		
		
	}
	public void selectUnfinishOrderByuserid()
	{
		Scanner reader=new Scanner(System.in);
		OrdertableDAO orderdao=new OrdertableDAO();
		Vector <OrdertableDTO> v=new Vector<OrdertableDTO>();
		v=orderdao.selectUnfinishOrderByuserid(reader.nextInt());
		for(OrdertableDTO us:v)
		{
			System.out.println("订单号："+us.getOrderid());
			System.out.println("用户号："+us.getUserid());
			System.out.println("菜品号："+us.getDishid());
			System.out.println("数量"+us.getBuynumber());
			System.out.println("总价："+us.getSumprice());
			System.out.println("预定就餐时间："+us.getOrdertime());
			System.out.println("下单时间："+us.getCreatedate());
			System.out.println("订单状态："+us.getOrderstatus());
			System.out.println("是否删除："+us.getIsDelete());
		}
		
		//else
		//	System.out.println("查无此订单");
		
	}
	public void inserOrder()
	{   Scanner reader=new Scanner(System.in);
		OrdertableDAO orderdao=new OrdertableDAO();
		OrdertableDTO orderdto=new OrdertableDTO();
		DishDAO dishdao=new DishDAO();				
		float _sumprice=0.0f;
		float _perferprice=0.0f;
		System.out.print("用户id：");
		orderdto.setUserid(reader.nextInt());
		System.out.print("菜品号：");
		int _dishid=reader.nextInt();
		orderdto.setDishid(_dishid);
		System.out.print("数量：");
		int _buynumber=reader.nextInt();
		orderdto.setBuynumber(_buynumber);
		_perferprice=dishdao.findPrice(_dishid);
		_sumprice=_perferprice*_buynumber;
		orderdto.setSumprice(_sumprice);
		System.out.print("预定就餐时间：");
		String _ordertime=reader.next();
		orderdto.setCreatedate(UtilMethod.getDate());
		orderdao.insertOrder(orderdto);
		
	}
	public void findtUnfinishOrder()
	{
		OrdertableDAO orderdao=new OrdertableDAO();
		Vector<OrdertableDTO> v=new Vector<OrdertableDTO>();
		v=orderdao.findtUnfinishOrder();
		for(OrdertableDTO us:v)
		{
			System.out.println("订单号："+us.getOrderid());
			System.out.println("用户号："+us.getUserid());
			System.out.println("菜品号："+us.getDishid());
			System.out.println("数量"+us.getBuynumber());
			System.out.println("总价："+us.getSumprice());
			System.out.println("下单时间："+us.getOrdertime());
			System.out.println("下单时间："+us.getCreatedate());
			System.out.println("订单状态："+us.getOrderstatus());
		}
	}
	public void updateOrder()
	{	Scanner reader=new Scanner(System.in);
		OrdertableDAO orderdao=new OrdertableDAO();
		OrdertableDTO orderdto=new OrdertableDTO();
		orderdto.setOrderid(reader.nextInt());
		orderdto.setUserid(reader.nextInt());
		orderdto.setDishid(reader.nextInt());
		orderdto.setBuynumber(reader.nextInt());
		orderdto.setSumprice(reader.nextFloat());
		orderdto.setOrdertime(reader.next());
		orderdto.setCreatedate(UtilMethod.getDate());
		//orderdto.setOrderstatus(reader.next());
		orderdto.setIsDelete(reader.nextInt());		
		orderdao.updateOrder(orderdto);
		
	}
	public void confirmorder()
	{	Scanner reader=new Scanner(System.in);
		OrdertableDAO orderdao=new OrdertableDAO();
		OrdertableDTO orderdto=new OrdertableDTO();
		orderdto.setOrderid(reader.nextInt());
		orderdao.confirmOrder(orderdto);
		
	}
	public void confirmHistoryOrder()
	{
		Scanner reader=new Scanner(System.in);
		OrdertableDAO orderdao=new OrdertableDAO();
		OrdertableDTO orderdto=new OrdertableDTO();
		orderdto.setOrderid(reader.nextInt());
		orderdao.confirmHistoryOrder(orderdto);
		
	}
}
    
   

	
	


