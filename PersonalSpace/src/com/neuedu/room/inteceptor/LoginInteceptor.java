package com.neuedu.room.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.room.utils.ConstanUtil;

public class LoginInteceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		HttpSession session = request.getSession();
		Object sessionData = session.getAttribute(ConstanUtil.SESSION_KEY);
		if(sessionData==null){
			if(!request.getRequestURI().startsWith(request.getContextPath()+"/users/login")){
				response.sendRedirect(request.getContextPath()+"/users/loginUI");
				return false;
			}			
		}
		else
		{
			if(request.getRequestURI().startsWith(request.getContextPath()+"/users/login"))
			{
				response.sendRedirect(request.getContextPath()+"/index");
			}
		}
		return true;
	}

}
