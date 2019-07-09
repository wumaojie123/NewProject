package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.OrdertableDAO;
import cn.edu.lingnan.dto.OrdertableDTO;

public class UpdateHiOrderServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
		response.setCharacterEncoding("utf-8");
		String _orderid=request.getParameter("orderid");
		int orderid=Integer.parseInt(_orderid);
		System.out.println(orderid);
		OrdertableDAO orderdao=new OrdertableDAO();
		OrdertableDTO orderdto=new OrdertableDTO();
		orderdto.setOrderid(orderid);
		orderdao.confirmHistoryOrder(orderdto);
				
        Vector<OrdertableDTO> vorder_2=new Vector<OrdertableDTO>();
        vorder_2=orderdao.findtHifinishOrder();
        HttpSession session=request.getSession();
        session.setAttribute("vorder_2", vorder_2);
        request.getRequestDispatcher("HiOrderList.jsp").forward(request, response);
		
	}
}
