package com.neuedu.room.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.room.dao.base.BaseMapper;
import com.neuedu.room.domain.User;
import com.neuedu.room.query.UserQuery;
import com.neuedu.room.query.base.BaseQuery;
import com.neuedu.room.service.base.BaseService;
import com.neuedu.room.utils.Sys;

public class BaseServiceImpl<T,E extends BaseQuery> implements BaseService<T,E> {
	 
	protected BaseMapper<T,E> mapper;
	
	@Autowired
	protected Sys sys;
	
	@Override
	public PageInfo<T> find(E query) {
		
		//userQuery -->select 
		
		Page<T> page = PageHelper.startPage(query.getPageNum(),sys.getPageSize()); //查找第一页(每页显示一条1)
		
		Page<T> list = (Page<T>)mapper.find(query);
		
		return list.toPageInfo();
	}
	
	@Override
    public void add(T t)
    {
    	//user.setUserpass(sys.getDefaultPassword());
    	//user.setUsersuper(0);
    	//user.setIsDelete(0);
    	
    	//usermapper.add(user);
		mapper.add(t);
    }

	@Override
	public T findById(int userid) {
		return (T) mapper.findById(userid);
	}

	@Override
	public int update(T t) {
		
		return mapper.update(t);
	}

	@Override
	public int delete(String... idArray) {
		
		return mapper.deleteByIds(idArray);
	}

}
