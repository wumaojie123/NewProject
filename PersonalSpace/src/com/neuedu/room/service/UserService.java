package com.neuedu.room.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.neuedu.room.query.UserQuery;
import com.neuedu.room.service.base.BaseService;
import com.neuedu.room.domain.User;

public interface UserService extends BaseService<User,UserQuery>{

   User login(String loginName,String password);
    
	
}
