package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dto.CarDTO;

public class Cartservlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        //doPost(request,response);
        request.setCharacterEncoding("GBK");
        String dishnumber=new String(request.getParameter("num").getBytes("ISO-8859-1"),"utf-8");
        int _dishnumber=Integer.parseInt(dishnumber);
    	System.out.println(_dishnumber);
    	Vector<CarDTO> v3=new Vector<CarDTO>();
    	String s="w3ls_item_";
    	String ss;
    	String d="quantity_";
    	String dd;
    	String u="amount_";
    	String uu;
    	int _amount;
    	float _unitprice;
    	float values;
    	for(int i=1;i<=_dishnumber;i++)		
    	{    ss=s + String.valueOf(i);
    	     dd=d+ String.valueOf(i);
    	     uu=u+String.valueOf(i);
    		CarDTO cardto=new CarDTO();
    	String dishname=new String(request.getParameter(ss).getBytes("ISO-8859-1"),"utf-8");
    	    cardto.setDishname(dishname);
    	String amount=new String(request.getParameter(dd).getBytes("ISO-8859-1"),"utf-8"); 
    	_amount=Integer.parseInt(amount);
    	  cardto.setAmount(_amount);
    	  String unitprice=new String(request.getParameter(uu).getBytes("ISO-8859-1"),"utf-8");
    	  _unitprice=Float.parseFloat(unitprice);
    	  cardto.setUnitprice(_unitprice);
    	  values=_amount*_unitprice;
    	  cardto.setValues(values);
    	    v3.add(cardto);
    	}
    	HttpSession session=request.getSession();
    	session.setAttribute("v3", v3);
    	session.setAttribute("_dishnumber", _dishnumber);
    	request.getRequestDispatcher("showorder.jsp").forward(request, response);
    }  
 
}
