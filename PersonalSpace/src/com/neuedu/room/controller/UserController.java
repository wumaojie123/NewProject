package com.neuedu.room.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.neuedu.room.controller.base.BaseController;
import com.neuedu.room.domain.User;
import com.neuedu.room.query.UserQuery;
import com.neuedu.room.service.UserService;
import com.neuedu.room.utils.ConstanUtil;
import com.neuedu.room.utils.JsonModel;
@Controller  //<bean>
@RequestMapping("users")
public class UserController extends BaseController<User,UserQuery> {
	
    @Autowired
   public void setUserService(UserService userService)
   {
    	this.baseService=userService;
   }

    
    @RequestMapping("/centerUI")
    public String centerUI() throws ServletException, IOException
    {
    	return "users/centerUI";
    }
    
    
    
    @RequestMapping("/loginUI")
    public String loginUI()throws ServletException, IOException
    {  
    	return "users/loginUI";

    }
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(String loginName,String password,ModelMap modeMap,HttpSession session)throws ServletException, IOException
    {   
    	User user=((UserService)baseService).login(loginName, password);
    	if(user!=null)
    		{
    		session.setAttribute(ConstanUtil.SESSION_KEY, user);
    		
    	return "redirect:/index";
    }
    	else
    	{
    		return "users/loginUI";
    	}
    } 	
    }
   


