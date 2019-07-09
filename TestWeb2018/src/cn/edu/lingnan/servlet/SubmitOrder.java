package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.DishDAO;
import cn.edu.lingnan.dao.OrdertableDAO;
import cn.edu.lingnan.dto.CarDTO;
import cn.edu.lingnan.dto.DishDTO;
import cn.edu.lingnan.dto.OrdertableDTO;
import cn.edu.lingnan.util.UtilMethod;

public class SubmitOrder extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException
            {
		HttpSession session=request.getSession();
	     Integer dishnumber=(Integer)session.getAttribute("_dishnumber");
	     Vector<OrdertableDTO> vorder=new Vector<OrdertableDTO>();
		Integer userid=(Integer) session.getAttribute("_id");
		if(userid!=null)
		{
			for(int i=1;i<=dishnumber;i++)
			{
		OrdertableDTO orderdto=new OrdertableDTO();	
		OrdertableDAO orderdao=new OrdertableDAO();
		orderdto.setUserid(userid);
		String dishname=new String(request.getParameter("_dishnames"+i).getBytes("ISO-8859-1"),"utf-8");
		DishDAO dishdao=new DishDAO();
		DishDTO dishdto=new DishDTO();
		Vector<DishDTO> v4=new Vector<DishDTO>();
		v4=dishdao.selectDihsByName(dishname);
		Iterator<DishDTO> it=v4.iterator();
		int _dishid = 0;
		while(it.hasNext())
		{dishdto=it.next();
		   _dishid=dishdto.getDishid();
		}
		orderdto.setDishid(_dishid);		
		String dishamount=new String(request.getParameter("_dishamounts"+i).getBytes("ISO-8859-1"),"utf-8");
		Integer _dishamount=Integer.parseInt(dishamount);
	    orderdto.setBuynumber(_dishamount);
		 
		String dishvalues=new String(request.getParameter("_dishvalues"+i).getBytes("ISO-8859-1"),"utf-8");
		Float _dishvalues=Float.parseFloat(dishvalues);
		orderdto.setSumprice(_dishvalues);
				
		String ordertime=new String(request.getParameter("_ordertime").getBytes("ISO-8859-1"),"utf-8");
		orderdto.setOrdertime(ordertime);		
		String createdate=UtilMethod.getDate();
		orderdto.setCreatedate(createdate);
		orderdao.insertOrder(orderdto);
		
			}
			response.sendRedirect(request.getContextPath()+"/orderok.jsp");
		}
		else 
			response.sendRedirect(request.getContextPath()+"/login.jsp");
            }

}
