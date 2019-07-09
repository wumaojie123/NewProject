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

public class InsertUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request,response);       
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
       response.setCharacterEncoding("utf-8");  	
   	String username=new String(request.getParameter("_username").getBytes("ISO-8859-1"),"utf-8");
   	//System.out.println(username);
   	String userpass=new String(request.getParameter("_userpass").getBytes("ISO-8859-1"),"utf-8");
   	String userphone=request.getParameter("_userphone");
   	//System.out.println(userphone);
   	String usersex=new String(request.getParameter("_usersex").getBytes("ISO-8859-1"),"utf-8");
   //	System.out.println(usersex);
   	UsertableDAO userdao=new UsertableDAO();
   	UsertableDTO userdto=new UsertableDTO();
   	userdto.setUsername(username);
   	userdto.setUserpass(userpass);
   	userdto.setUserphone(userphone);
   	userdto.setUsersex(usersex);
   	int usersuper=0;
   	usersuper=userdao.findUserNamePassword(username, userpass);
   	if(usersuper==-1)
   	{
   	userdao.insertUser(userdto);
   	
    Vector<UsertableDTO> vuser=new Vector<UsertableDTO>();
    vuser=userdao.findPublicUser();
    HttpSession session=request.getSession();
    session.setAttribute("vuser", vuser);
    request.getRequestDispatcher("UserList.jsp").forward(request, response);
   	}
   	else
   	{
   		
   		request.getRequestDispatcher("Tishi.jsp").forward(request, response);
   	}
}
}
