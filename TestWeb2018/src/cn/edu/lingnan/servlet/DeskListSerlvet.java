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
public class DeskListSerlvet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request,response);
     
    }  


    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
       response.setCharacterEncoding("utf-8");
       DeskDAO deskdao=new DeskDAO();
       Vector<DeskDTO> vdesk=new Vector<DeskDTO>();
       vdesk=deskdao.findAllDesk();
       HttpSession session=request.getSession();
       session.setAttribute("vdesk", vdesk);
       request.getRequestDispatcher("DeskList.jsp").forward(request, response);
    }
}
