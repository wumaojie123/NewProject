package cn.edu.lingnan.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.*;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("GB2312");		
		String username=new String(req.getParameter("username").getBytes("ISO-8859-1"),"GB2312");
		String password=req.getParameter("password");
		int _id;
		boolean n;
		//System.out.println(username + password);
		
		UsertableDAO userdao=new UsertableDAO();
		int usersuper=userdao.findUserNamePassword(username, password);
		_id=userdao.findUserid(username, password);
		System.out.println(_id);
		HttpSession session=req.getSession();
		session.setAttribute("usersuper", usersuper);
		if(usersuper>=0)
		{   session.setAttribute("username", username);
		    session.setAttribute("_id", _id);
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
			//req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		else
		resp.sendRedirect(req.getContextPath()+"/error.html");
	}
}
