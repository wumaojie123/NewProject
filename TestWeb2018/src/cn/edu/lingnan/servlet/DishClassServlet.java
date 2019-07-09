package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.DishDAO;
import cn.edu.lingnan.dto.DishDTO;

public class DishClassServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		int _deptsno=Integer.parseInt(req.getParameter("deptsno"));
		DishDAO dishdao=new DishDAO();
		Vector<DishDTO> v2=new Vector<DishDTO>();
		v2=dishdao.selectDihsBydetpsno(_deptsno);
		HttpSession session=req.getSession();
		session.setAttribute("v2", v2);
		req.getRequestDispatcher("newproducts.jsp").forward(req, resp);
			}
}
