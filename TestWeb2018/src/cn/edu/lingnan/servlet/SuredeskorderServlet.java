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

public class SuredeskorderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		         boolean b;
		      String deskid=req.getParameter("deskid");		      		      
		      int _deskid;
		      _deskid=Integer.parseInt(deskid);
		      
		      HttpSession session=req.getSession();
		      Integer userid=(Integer) session.getAttribute("_id");
		      
		      if(userid!=null)
		     {
		    	  System.out.println(_deskid);
			      DeskDTO deskdto=new DeskDTO();
			      DeskDAO deskdao=new DeskDAO();
			      deskdto.setDeskid(_deskid);
			      deskdto.setUserid(userid);
			     b= deskdao.updateDeskUser(deskdto);			 
					Vector<DeskDTO> vdesk=new Vector<DeskDTO>();
					vdesk=deskdao.findFreedesk();	
					session.setAttribute("vdesk", vdesk);
					
					Vector<DeskDTO> v1desk=new Vector<DeskDTO>();
					v1desk=deskdao.selectBusyDesk(userid);
					session.setAttribute("v1desk", v1desk);
					req.getRequestDispatcher("showdesk.jsp").forward(req, resp);
		   
		      }
		      else
		    	  resp.sendRedirect(req.getContextPath()+"/login.jsp");
		      
			}
}
