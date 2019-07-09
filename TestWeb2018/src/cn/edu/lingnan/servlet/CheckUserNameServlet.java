package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.UsertableDAO;

public class CheckUserNameServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public CheckUserNameServlet() {
	        super();
	    }
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
	    	String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"GB2312");
	        UsertableDAO userdao=new UsertableDAO();
	        int usersuper=0;
	        usersuper=userdao.user(username);     
	        if(usersuper==-1){
	            response.getWriter().print("1");	            
	        }else{
	            response.getWriter().print("0");	           
	        }
	    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }

	
}
