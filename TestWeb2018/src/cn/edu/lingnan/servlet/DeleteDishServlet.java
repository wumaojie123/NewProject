package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.DishDAO;
import cn.edu.lingnan.dto.DishDTO;

public class DeleteDishServlet extends HttpServlet{
		
		public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  	       
	       response.setCharacterEncoding("utf-8");
	       String dishid=request.getParameter("dishid");
           int _dishid=Integer.parseInt(dishid);
           DishDAO dishdao=new DishDAO();
           dishdao.delDish(_dishid);           
           int pageNo=1;
           HttpSession session=request.getSession();             
           Vector<DishDTO> lists=new Vector<DishDTO>();
           String pageno=request.getParameter("pageNos");
           if(pageno!=null)
           {
        	   pageNo=Integer.parseInt(pageno);   	   
           }
           lists=dishdao.listDish(pageNo);     
           int recordCount=dishdao.getPage();
           session.setAttribute("recordCount", recordCount);
           session.setAttribute("listss", lists);   
           session.setAttribute("pageNos", pageNo);           
           request.getRequestDispatcher("ProductsList.jsp").forward(request, response);
	    }

}

