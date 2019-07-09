package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.OrdertableDAO;
import cn.edu.lingnan.dto.OrdertableDTO;

public class SureUnOrderServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request,response);
     
    }  


    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
       response.setCharacterEncoding("utf-8");
       OrdertableDAO orderdao=new OrdertableDAO();
       Vector<OrdertableDTO> vorder_1=new Vector<OrdertableDTO>();
       vorder_1=orderdao.findtUnfinishOrder();
       HttpSession session=request.getSession();
       session.setAttribute("vorder_1", vorder_1);
       request.getRequestDispatcher("UnOrderList.jsp").forward(request, response);
       
    }
}
