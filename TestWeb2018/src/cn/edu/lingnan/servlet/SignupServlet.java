package cn.edu.lingnan.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.lingnan.dao.UsertableDAO;
import cn.edu.lingnan.dto.UsertableDTO;
public class SignupServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
		String username=new String(req.getParameter("username").getBytes("ISO-8859-1"),"GB2312");
		String usersex=new String(req.getParameter("sex").getBytes("ISO-8859-1"),"GB2312");
		String userphone=req.getParameter("phone");
		String password=req.getParameter("password");
		String Confirmpassword=req.getParameter("ConfirmPassword");
		boolean n;
		if(password.equals(Confirmpassword))
		{
			UsertableDAO userdao=new UsertableDAO();
			UsertableDTO userdto=new UsertableDTO();
			userdto.setUsername(username);
			userdto.setUserpass(password);
			userdto.setUserphone(userphone);
			userdto.setUsersex(usersex);
			n=userdao.insertUser(userdto);
			if(n==true)
			{
				resp.sendRedirect(req.getContextPath()+"/login.jsp");
			}
			else
			{
				resp.sendRedirect(req.getContextPath()+"/signup.jsp");
			}
		}
		else
		{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
			}
}
