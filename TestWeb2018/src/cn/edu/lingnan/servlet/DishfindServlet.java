package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.DishDAO;
import cn.edu.lingnan.dao.DishDeptsDAO;
import cn.edu.lingnan.dto.*;
public class DishfindServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		int _deptsno=0;
		req.setCharacterEncoding("GB2312");
		String deptsno=req.getParameter("food");
		
	    _deptsno=Integer.parseInt(deptsno);
		//System.out.println(deptsno);
		DishDAO dishdao=new DishDAO();
		Vector<DishDTO> v1=new Vector<DishDTO>();
		v1=dishdao.selectDihsBydetpsno(_deptsno);
		HttpSession session=req.getSession();
		session.setAttribute("v1", v1);
		//req.setAttribute("v1", v1);
		
		req.getRequestDispatcher("menu.jsp").forward(req, resp);
			}
}
