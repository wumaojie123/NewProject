package com.neuedu.room.domain;

import com.neuedu.room.domain.base.BaseDomain;

public class User extends BaseDomain{
	
	private String username;
	private String userpass;
	private String userphone;
	private String usersex;
	private int usersuper;
	private int isDelete;
	private String loginName;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public int getUsersuper() {
		return usersuper;
	}
	public void setUsersuper(int usersuper) {
		this.usersuper = usersuper;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	

}

