package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.DeskDAO;
import cn.edu.lingnan.dto.DeskDTO;

public class DeskOrderSerlvet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		int dishid;
		DeskDAO deskdao=new DeskDAO();
		Vector<DeskDTO> vdesk=new Vector<DeskDTO>();
		vdesk=deskdao.findFreedesk();	
		HttpSession session=req.getSession();
		session.setAttribute("vdesk", vdesk);
		
		req.getRequestDispatcher("showdesk.jsp").forward(req, resp);
			}
			

}
