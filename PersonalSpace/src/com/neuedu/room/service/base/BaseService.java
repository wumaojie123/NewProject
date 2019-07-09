package com.neuedu.room.service.base;

import com.github.pagehelper.PageInfo;
import com.neuedu.room.domain.User;
import com.neuedu.room.query.UserQuery;
import com.neuedu.room.query.base.BaseQuery;

public interface BaseService<T,E extends BaseQuery> {
	PageInfo<T> find(E query);
	
	void add(T domain);
    
	T findById(int userid);
	
	int update(T domain);
	
	int delete(String ... idArray);
}
