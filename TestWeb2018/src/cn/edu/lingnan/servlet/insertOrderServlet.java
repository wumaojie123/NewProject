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
import cn.edu.lingnan.util.UtilMethod;

public class insertOrderServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request,response);       
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
    	response.setCharacterEncoding("utf-8");
    	String _userid=request.getParameter("_userid");
    	int userid=Integer.parseInt(_userid);
    	String _dishid=request.getParameter("_dishid");
    	int dishid=Integer.parseInt(_dishid);
    	String _buynumber=request.getParameter("_buynumber");
    	int buynumber=Integer.parseInt(_buynumber);
    	String _sumprice=request.getParameter("_sumprice");
    	float sumprice=Float.parseFloat(_sumprice);
    	String ordertime=request.getParameter("_ordertime");
    	String createdate=UtilMethod.getDate();
    	OrdertableDAO orderdao=new OrdertableDAO();
    	OrdertableDTO orderdto=new OrdertableDTO();
    	orderdto.setUserid(userid);
    	orderdto.setDishid(dishid);
    	orderdto.setBuynumber(buynumber);
    	orderdto.setSumprice(sumprice);
    	orderdto.setOrdertime(ordertime);
    	orderdto.setCreatedate(createdate);
    	orderdao.insertOrder(orderdto);
    	
    	Vector<OrdertableDTO> vorder=new Vector<OrdertableDTO>();
        vorder=orderdao.findAllOrder();
        HttpSession session=request.getSession();
        session.setAttribute("vorder", vorder);
        request.getRequestDispatcher("OrderList.jsp").forward(request, response);
    	
    }
    }


