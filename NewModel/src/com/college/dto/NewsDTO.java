package com.college.dto;

public class NewsDTO {
private int newsId;
private int newsTypeId;
private String newsName;
private String news;
private String newsTime;
private int newsCount;
private int isDelete;
public int getIsDelete() {
	return isDelete;
}
public void setIsDelete(int isDelete) {
	this.isDelete = isDelete;
}
public int getNewsId() {
	return newsId;
}
public void setNewsId(int newsId) {
	this.newsId = newsId;
}
public int getNewsTypeId() {
	return newsTypeId;
}
public void setNewsTypeId(int newsTypeId) {
	this.newsTypeId = newsTypeId;
}
public String getNewsName() {
	return newsName;
}
public void setNewsName(String newsName) {
	this.newsName = newsName;
}
public String getNews() {
	return news;
}
public void setNews(String news) {
	this.news = news;
}
public String getNewsTime() {
	return newsTime;
}
public void setNewsTime(String newsTime) {
	this.newsTime = newsTime;
}
public int getNewsCount() {
	return newsCount;
}
public void setNewsCount(int newsCount) {
	this.newsCount = newsCount;
}
}
