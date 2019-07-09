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

public class DeleteOrderServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  	       
       response.setCharacterEncoding("utf-8");
       String _orderid=request.getParameter("orderid");
       int orderid=Integer.parseInt(_orderid);
       System.out.println(orderid);
       OrdertableDAO orderdao=new OrdertableDAO();
       orderdao.delOrder(orderid);
       
       Vector<OrdertableDTO> vorder=new Vector<OrdertableDTO>();
       vorder=orderdao.findAllOrder();
       HttpSession session=request.getSession();
       session.setAttribute("vorder", vorder);
       request.getRequestDispatcher("OrderList.jsp").forward(request, response);
       
       
	}
	
}
