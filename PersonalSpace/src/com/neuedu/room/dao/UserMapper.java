package com.neuedu.room.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.neuedu.room.dao.base.BaseMapper;
import com.neuedu.room.domain.User;
import com.neuedu.room.query.UserQuery;

    public interface UserMapper extends BaseMapper<User,UserQuery>
    {
     // List<User> find(UserQuery userQuery);//mybatis 提供动态sql
     User login(@Param("loginName")String loginName,@Param("password")String password);


	
   }
