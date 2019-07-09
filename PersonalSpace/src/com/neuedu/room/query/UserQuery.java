package com.neuedu.room.query;

import com.neuedu.room.query.base.BaseQuery;
import com.neuedu.room.utils.StringUtil;

public class UserQuery extends BaseQuery{
	
private String username;
private String loginName;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = StringUtil.parseEncoding(username);
}
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = StringUtil.parseEncoding(loginName);
}
}
