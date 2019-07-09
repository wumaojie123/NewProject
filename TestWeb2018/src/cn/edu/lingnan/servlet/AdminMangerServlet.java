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
public class AdminMangerServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request,response);       
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
       response.setCharacterEncoding("utf-8");
       HttpSession session=request.getSession();
       //int adminid=(Integer)session.getAttribute("_id");
      // System.out.println(adminid);
       UsertableDAO userdao=new UsertableDAO();
       Vector<UsertableDTO> vmanger=new Vector<UsertableDTO>();
       vmanger=userdao.findAllManger();    
       session.setAttribute("vmanger", vmanger);
       request.getRequestDispatcher("MangerList.jsp").forward(request, response);
       
}
}
