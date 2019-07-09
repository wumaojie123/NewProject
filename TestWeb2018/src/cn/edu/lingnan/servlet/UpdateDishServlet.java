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

public class UpdateDishServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
    	response.setCharacterEncoding("utf-8");
		  String __dishid=request.getParameter("_dishid");
		  int dishid=Integer.parseInt(__dishid);
		  //System.out.println(dishid);
		  
		  String __dishname=new String(request.getParameter("_dishname").getBytes("ISO-8859-1"),"utf-8");
		  //System.out.println(__dishname);
		  
		  String __original_price=request.getParameter("_original_price");
		  float original_price=Float.parseFloat(__original_price);
		 // System.out.println(original_price);
		  
		  String ___prefer_price=request.getParameter("_prefer_price");
		  float prefer_price=Float.parseFloat(___prefer_price);
		 // System.out.println(prefer_price);
		  
		  String __photopath=new String(request.getParameter("_photopath").getBytes("ISO-8859-1"),"utf-8");
		 // System.out.println(__photopath);
		  
		 
		  String __dishinformation=new String(request.getParameter("_dishinformation").getBytes("ISO-8859-1"),"utf-8");
		 // System.out.println(__dishinformation);
		  String __deptsno=request.getParameter("_deptsno");
		  int deptsno=Integer.parseInt(__deptsno);
		  DishDAO dishdao=new DishDAO();
		  Vector<DishDTO> vdish=new Vector<DishDTO>();
		  DishDTO dishdto=new DishDTO();
		  dishdto.setDishid(dishid);
		  dishdto.setDishname(__dishname);
		  dishdto.setDishinformation(__dishinformation);
		  dishdto.setOriginal_price(original_price);
		  dishdto.setPrefer_price(prefer_price);
		  dishdto.setPhotopath(__photopath);
		  dishdto.setDeptsno(deptsno);
		  boolean flag= dishdao.updateDish(dishdto);
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
