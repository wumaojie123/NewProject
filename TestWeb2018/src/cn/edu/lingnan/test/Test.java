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
		System.out.println("-----------------��ӭʹ�ñ�����ϵͳ-------------------------");
		System.out.println("--------------��ѡ�����------------------");
		do{
		System.out.println("1.����Ա��¼");
		System.out.println("2.�û���¼");
		System.out.println("3.�û�ע��");
		System.out.println("4.�˳�ϵͳ");
		System.out.println("-------------------------------");
		System.out.print("��ѡ��");
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
			System.out.println("�ɹ���½");
			System.out.println("�����û�id�ǣ�"+id+",���ס��");
			int num_1=-1;
			 do{
			System.out.println("***********��ʼ����ԤԼ***************"); 
			System.out.println("1.����Ԥ������");
			System.out.println("2.��ʼ����");
			System.out.println("3.�˳�");
			System.out.println("**************************");
			System.out.println("����ѡ��Ϊ��");
			int choose_1=input.nextInt();
			boolean isExit_1=false;
			switch(choose_1)
			{
			case 1:
				test1.findfreedesk();
				System.out.println("*******************************");
				System.out.println("�Ƿ�ҪԤ��������Y/N");
				String select=input.next();								
				if(select.equals("Y"))
				{				
				System.out.println("����ѡ��");
				test1.updatedeskuser();
				System.out.println("ԤԼ�����ɹ�");
				isExit_1=true; break;
				}
				else if(select.equals("N"))
				{ isExit_1=true; break;}
			case 2:
				System.out.println("**************��ѡ���Ʒ******************");
				test1.findAllDish();
				System.out.println("***************************************");
				System.out.println("�Ƿ�Ҫ���ͣ�Y/N");
				String select_1=input.next();								
				if(select_1.equals("Y"))
				{	
				System.out.println("����ѡ��");
				test1.inserOrder();
				System.out.println("���ͳɹ�");
				
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
				System.out.println("����10����ԤԼ���棬�����������˳������������֣���");
				num_1 = input.nextInt();			
				}else {
					
					break;
				}
			 }while(num_1==10);
			 }
			 
			 else 
					System.out.println("��½ʧ��");
			 isExit=true;
			break;
			case 3: test1.insertUser(); 
			System.out.println("��ϲ�������ע��");
			break;
			case 4: isExit=true;break;
			default:isExit=true; break;
			
		}	
		if (isExit) {
			System.out.println("����0�������˵��������������˳������������֣���");
			num = input.nextInt();
			} else {
			break;
			}
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");*/
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
		System.out.println("������");
		String _name=reader.next();
		System.out.println("���룺");
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
		System.out.println("������");
		String _name=reader.next();
		System.out.println("���룺");
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
	System.out.println("�û�id��" + us.getUserid()+" ");
	System.out.println("�û�����"+us.getUsername()+" ");
	System.out.println("�û��ֻ���Ϊ��"+us.getUserphone()+" ");
	System.out.println("�Ա�"+us.getUsersex()+" ");
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
		System.out.print("������");
		userdto.setUsername(reader.next());
		System.out.print("���룺");
		userdto.setUserpass(reader.next());
		System.out.print("�ֻ����룺");
		userdto.setUserphone(reader.next());
		System.out.print("�Ա�");
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
			System.out.println("��ϵ�ţ� "+us.getDeptsno());
			System.out.println("��ϵ���� "+us.getDeptsname());
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
		
		//System.out.println("��ϵ�ţ� "+deptdto.getDeptsno());
		for(DishDeptsDTO us:v)
		{
			System.out.println("��ϵ�ţ� "+us.getDeptsno());
			System.out.println("��ϵ���� "+us.getDeptsname());
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
			System.out.println("��ϵ�ţ� "+us.getDeptsno());
			System.out.println("��ϵ���� "+us.getDeptsname());
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
	    	System.out.println("���ţ� "+u.getRoomid()+" ");
			System.out.println("������" +u.getRoomname()+" ");
			System.out.println("�����������"+u.getDesknumber()+" ");
			System.out.println("״̬��"+u.getRoomstatus()+" ");
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
			System.out.println("���ţ� "+u.getRoomid()+" ");
			System.out.println("������" +u.getRoomname()+" ");
			System.out.println("�����������"+u.getDesknumber()+" ");
			System.out.println("״̬��"+u.getRoomstatus()+" ");
		}
	}
	public void findBusyRoom()
	{
		RoomDAO roomdao=new RoomDAO();
		Vector<RoomDTO> v=new Vector<RoomDTO>();
		v=roomdao.findBusyRoom();
		for(RoomDTO u:v)
		{
			System.out.println("���ţ� "+u.getRoomid()+" ");
			System.out.println("������" +u.getRoomname()+" ");
			System.out.println("�����������"+u.getDesknumber()+" ");
			System.out.println("״̬��"+u.getRoomstatus()+" ");
		}
	}
	public void findAllDesk()
	{
		DeskDAO deskdao=new DeskDAO();
		Vector <DeskDTO> v=new Vector<DeskDTO>();
		v=deskdao.findAllDesk();
		for(DeskDTO us:v)
		{   System.out.println("���ţ� "+us.getRoomid());
			System.out.println("�����ţ�" +us.getDeskid());
			System.out.println("��λ���� "+us.getSeatnumber());
			System.out.println("״̬�� "+us.getDeskstatus());			
		}
	}
	public void findfreedesk()
	{
		DeskDAO deskdao=new DeskDAO();
		Vector<DeskDTO> v=new Vector<DeskDTO>();
		v=deskdao.findFreedesk();
		for(DeskDTO us:v)
		{   System.out.print("���ţ� "+us.getRoomid()+"\t");
			System.out.print("�����ţ�" +us.getDeskid()+"\t");
			System.out.print("��λ���� "+us.getSeatnumber()+"\t");
			System.out.print("״̬�� "+us.getDeskstatus()+"\t");
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
		System.out.println("�����ţ�");
		deskdto.setDeskid(reader.nextInt());
		System.out.println("�����û�id:");
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
			System.out.print("�˺ţ�"+us.getDishid()+"\t");
			System.out.print("������"+us.getDishname()+"\t");
			System.out.print("ԭ�ۣ�"+us.getOriginal_price()+"\t");
			System.out.print("�Żݼۣ�"+us.getPrefer_price()+"\t");
			System.out.print("��飺"+us.getDishinformation());
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
		{   System.out.println("��ϵ����"+deptsname);
			System.out.println("�˺ţ�"+us.getDishid());
			System.out.println("������"+us.getDishname());
			System.out.println("ԭ�ۣ�"+us.getOriginal_price());
			System.out.println("�Żݼۣ�"+us.getPrefer_price());
			System.out.println("��飺"+us.getDishinformation());
			
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
			System.out.println("�����ţ�"+us.getOrderid());
			System.out.println("�û��ţ�"+us.getUserid());
			System.out.println("��Ʒ�ţ�"+us.getDishid());
			System.out.println("����"+us.getBuynumber());
			System.out.println("�ܼۣ�"+us.getSumprice());
			System.out.println("Ԥ���Ͳ�ʱ�䣺"+us.getOrdertime());
			System.out.println("�µ�ʱ�䣺"+us.getCreatedate());
			System.out.println("����״̬��"+us.getOrderstatus());
			System.out.println("�Ƿ�ɾ����"+us.getIsDelete());
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
			System.out.println("�����ţ�"+us.getOrderid());
			System.out.println("�û��ţ�"+us.getUserid());
			System.out.println("��Ʒ�ţ�"+us.getDishid());
			System.out.println("����"+us.getBuynumber());
			System.out.println("�ܼۣ�"+us.getSumprice());
			System.out.println("Ԥ���Ͳ�ʱ�䣺"+us.getOrdertime());
			System.out.println("�µ�ʱ�䣺"+us.getCreatedate());
			System.out.println("����״̬��"+us.getOrderstatus());
			System.out.println("�Ƿ�ɾ����"+us.getIsDelete());
		}
		
		//else
		//	System.out.println("���޴˶���");
		
	}
	public void inserOrder()
	{   Scanner reader=new Scanner(System.in);
		OrdertableDAO orderdao=new OrdertableDAO();
		OrdertableDTO orderdto=new OrdertableDTO();
		DishDAO dishdao=new DishDAO();				
		float _sumprice=0.0f;
		float _perferprice=0.0f;
		System.out.print("�û�id��");
		orderdto.setUserid(reader.nextInt());
		System.out.print("��Ʒ�ţ�");
		int _dishid=reader.nextInt();
		orderdto.setDishid(_dishid);
		System.out.print("������");
		int _buynumber=reader.nextInt();
		orderdto.setBuynumber(_buynumber);
		_perferprice=dishdao.findPrice(_dishid);
		_sumprice=_perferprice*_buynumber;
		orderdto.setSumprice(_sumprice);
		System.out.print("Ԥ���Ͳ�ʱ�䣺");
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
			System.out.println("�����ţ�"+us.getOrderid());
			System.out.println("�û��ţ�"+us.getUserid());
			System.out.println("��Ʒ�ţ�"+us.getDishid());
			System.out.println("����"+us.getBuynumber());
			System.out.println("�ܼۣ�"+us.getSumprice());
			System.out.println("�µ�ʱ�䣺"+us.getOrdertime());
			System.out.println("�µ�ʱ�䣺"+us.getCreatedate());
			System.out.println("����״̬��"+us.getOrderstatus());
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
    
   

	
	


