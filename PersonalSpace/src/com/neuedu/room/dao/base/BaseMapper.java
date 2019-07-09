package com.neuedu.room.dao.base;

import com.github.pagehelper.Page;
import com.neuedu.room.domain.User;
import com.neuedu.room.query.UserQuery;
import com.neuedu.room.query.base.BaseQuery;

public interface BaseMapper<T,E extends BaseQuery> {
    
	
	Page<T> find(E userQuery);

	void add(T user);

	T findById(int userid);

	int update(T user);

	int deleteByIds(String[] idArray);
}
