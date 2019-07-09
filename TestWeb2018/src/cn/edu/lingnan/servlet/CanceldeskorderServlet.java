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

public class CanceldeskorderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		String deskid=req.getParameter("deskid_1");		      		      
	      int _deskid;
	      _deskid=Integer.parseInt(deskid);	      
	      HttpSession session=req.getSession();
	      Integer userid=(Integer) session.getAttribute("_id");
	      DeskDAO deskdao=new DeskDAO();
	      DeskDTO deskdto=new DeskDTO();
	      deskdto.setDeskid(_deskid);
	      boolean flag;
	      flag=deskdao.cancelDeskUser(deskdto);
	     // req.getRequestDispatcher("showdesk.jsp").forward(req, resp);
	      
	  
	      Vector<DeskDTO> vdesk=new Vector<DeskDTO>();
			vdesk=deskdao.findFreedesk();	
			//HttpSession session=req.getSession();
			session.setAttribute("vdesk", vdesk);
			
			Vector<DeskDTO> v1desk=new Vector<DeskDTO>();
			v1desk=deskdao.selectBusyDesk(userid);
			session.setAttribute("v1desk", v1desk);
	      
	      resp.sendRedirect(req.getContextPath()+"/showdesk.jsp");
}}
