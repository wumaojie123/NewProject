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

public class UpdateDeskServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
		response.setCharacterEncoding("utf-8");
		String _deskid=request.getParameter("_deskid");
		int deskid=Integer.parseInt(_deskid);
		//System.out.println(deskid);
		String _seatnumber=request.getParameter("_seatnumber");
		int seatnumber=Integer.parseInt(_seatnumber);
		//System.out.println(seatnumber);
		String _roomid=request.getParameter("_roomid");		
		int roomid=Integer.parseInt(_roomid);
		//System.out.println(roomid);
		String _userid=request.getParameter("_userid");
		int userid=Integer.parseInt(_userid);
		//System.out.println(userid);
		String _deskstatus=new String(request.getParameter("_deskstatus").getBytes("ISO-8859-1"),"utf-8");
		//System.out.println(_deskstatus);
		DeskDAO deskdao=new DeskDAO();
		DeskDTO deskdto=new DeskDTO();
		if(userid!=0){		
		deskdto.setDeskid(deskid);
		deskdto.setSeatnumber(seatnumber);
		deskdto.setRoomid(roomid);
		deskdto.setUserid(userid);
		deskdto.setDeskstatus(_deskstatus);
		deskdao.updateDesk(deskdto);
		}
		else
		{
			deskdto.setDeskid(deskid);
			deskdto.setSeatnumber(seatnumber);
			deskdto.setRoomid(roomid);
			deskdto.setDeskstatus(_deskstatus);
			deskdao.updateDesk_1(deskdto);
		}
	       Vector<DeskDTO> vdesk=new Vector<DeskDTO>();
	       vdesk=deskdao.findAllDesk();
	       HttpSession session=request.getSession();
	       session.setAttribute("vdesk", vdesk);
	       request.getRequestDispatcher("DeskList.jsp").forward(request, response);
		
	}
	
}
