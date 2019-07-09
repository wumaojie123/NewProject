package com.college.dto;

public class NewsTypeDTO {
private int newsTypeId;
private String newsTypeName;
private int isDelete;
public int getIsDelete() {
	return isDelete;
}
public void setIsDelete(int isDelete) {
	this.isDelete = isDelete;
}
public int getNewsTypeId() {
	return newsTypeId;
}
public void setNewsTypeId(int newsTypeId) {
	this.newsTypeId = newsTypeId;
}
public String getNewsTypeName() {
	return newsTypeName;
}
public void setNewsTypeName(String newsTypeName) {
	this.newsTypeName = newsTypeName;
}

}
