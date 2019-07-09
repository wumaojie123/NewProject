package com.neuedu.room.utils;

import java.util.List;

public class JsonModel<T> {
  private boolean success;
  private List<T> rows;
  private String msg;
  private int total;
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public List<T> getRows() {
	return rows;
}
public void setRows(List<T> rows) {
	this.rows = rows;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
  
}
