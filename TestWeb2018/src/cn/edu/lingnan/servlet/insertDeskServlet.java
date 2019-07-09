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

public class insertDeskServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request,response);       
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
       response.setCharacterEncoding("utf-8"); 
       String _deskid=request.getParameter("_deskid");
       int deskid=Integer.parseInt(_deskid);
       String _seatnumber=request.getParameter("_seatnumber");
       int seatnumber=Integer.parseInt(_seatnumber);
       String _roomid=request.getParameter("_roomid");
       int roomid=Integer.parseInt(_roomid);
       
       DeskDAO deskdao=new DeskDAO();
       DeskDTO deskdto=new DeskDTO();
       deskdto.setDeskid(deskid);
       deskdto.setSeatnumber(seatnumber);
       deskdto.setRoomid(roomid);
       deskdao.insertDesk(deskdto);
       
       roomid=deskdao.findRoomid(deskid);
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
