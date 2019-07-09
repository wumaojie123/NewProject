package cn.edu.lingnan.servlet;
import cn.edu.lingnan.dao.*;
import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;
import cn.edu.lingnan.util.PageView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request,response);
       
    }  


    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
       response.setCharacterEncoding("utf-8");
       int pageNo=1;
       DishDAO dishdao=new DishDAO();
       List<DishDTO> lists=new ArrayList<DishDTO>();
       String pageno=request.getParameter("pageNos");
       if(pageno!=null)
       {
    	   pageNo=Integer.parseInt(pageno);
    	   System.out.println(pageNo);
       }
       lists=dishdao.listDish(pageNo);
       
       int recordCount=dishdao.getPage();
       request.setAttribute("recordCount", recordCount);
       request.setAttribute("listss", lists);
       
       request.setAttribute("pageNos", pageNo);
       request.getRequestDispatcher("showdish.jsp").forward(request, response);
    } 
   
    
    }
    

