package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.DeskDAO;
import cn.edu.lingnan.dao.RoomDAO;
import cn.edu.lingnan.dto.DeskDTO;

public class DeleteDeskServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  	       
       response.setCharacterEncoding("utf-8");
       String deskid=request.getParameter("deskid");
       System.out.println(deskid);
       int _deskid=Integer.parseInt(deskid);
       DeskDAO deskdao=new DeskDAO();
       deskdao.delDesk(_deskid);
       
       int roomid=-2;
       roomid=deskdao.findRoomid(_deskid);
       int desknumber=deskdao.findDeskNumber(roomid);
       RoomDAO roomdao=new RoomDAO();
       roomdao.updateRoomDeskNumber(desknumber, roomid);
 
       Vector<DeskDTO> vdesk=new Vector<DeskDTO>();
       vdesk=deskdao.findAllDesk();
       HttpSession session=request.getSession();
       session.setAttribute("vdesk", vdesk);
       request.getRequestDispatcher("DeskList.jsp").forward(request, response);
	}

}
