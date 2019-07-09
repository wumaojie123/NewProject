package com.neuedu.room.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.room.dao.UserMapper;
import com.neuedu.room.domain.User;
import com.neuedu.room.query.UserQuery;
import com.neuedu.room.service.UserService;
import com.neuedu.room.service.base.impl.BaseServiceImpl;
import com.neuedu.room.utils.Sys;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserQuery> implements UserService{
	
	@Autowired 
    public void setUserMapper(UserMapper userMapper)
    {
		this.mapper=userMapper;
    }
		
    @Override
    public User login(String loginName,String password)
    {
    	return ((UserMapper)mapper).login(loginName, password);
    }
    
    @Override
    public void add(User user)
    {
    	user.setUserpass(sys.getDefaultPassword());
    	super.add(user);
    }

    
   }
   