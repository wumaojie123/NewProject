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

public class InsertMangerServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request,response);       
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
    	response.setCharacterEncoding("utf-8");
    	String username=new String(request.getParameter("_username").getBytes("ISO-8859-1"),"utf-8");
    	String userpass=new String(request.getParameter("_userpass").getBytes("ISO-8859-1"),"utf-8");
    	String userphone=request.getParameter("_userphone");
    	String usersex=new String(request.getParameter("_usersex").getBytes("ISO-8859-1"),"utf-8");    	
    	UsertableDAO userdao=new UsertableDAO();
    	UsertableDTO userdto=new UsertableDTO();   	
    	userdto.setUsername(username);
    	userdto.setUserpass(userpass);
    	userdto.setUserphone(userphone);
    	userdto.setUsersex(usersex);
    	userdao.insertmanger(userdto);
    	
    	Vector<UsertableDTO> vmanger=new Vector<UsertableDTO>();
    	vmanger=userdao.findAllManger();
	    HttpSession session=request.getSession();
	    session.setAttribute("vmanger", vmanger);
	    request.getRequestDispatcher("MangerList.jsp").forward(request, response);
	
}
}
