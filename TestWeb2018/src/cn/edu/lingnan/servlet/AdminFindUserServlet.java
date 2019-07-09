package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UsertableDAO;
import cn.edu.lingnan.dto.UsertableDTO;

public class AdminFindUserServlet extends HttpServlet{
		public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	        doPost(request,response);       
	    }  
	    public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	       response.setCharacterEncoding("utf-8");
	       UsertableDAO userdao=new UsertableDAO();
	       Vector<UsertableDTO> vuser=new Vector<UsertableDTO>();
	       vuser=userdao.findPublicUser();
	       HttpSession session=request.getSession();
	       session.setAttribute("vuser", vuser);
	       request.getRequestDispatcher("UserList.jsp").forward(request, response);
	       
	       
	    }
}

