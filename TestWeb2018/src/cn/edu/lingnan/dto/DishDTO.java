package cn.edu.lingnan.dto;

public class DishDTO {
	private int dishid;
	private String dishname;
	private float original_price;
	private float prefer_price;
	private String photopath;
	private String dishinformation;
	private int deptsno;
	private int isDelete;
	public int getDishid() {
		return dishid;
	}
	public void setDishid(int dishid) {
		this.dishid = dishid;
	}
	public String getDishname() {
		return dishname;
	}
	public void setDishname(String dishname) {
		this.dishname = dishname;
	}
	public float getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(float original_price) {
		this.original_price = original_price;
	}
	public float getPrefer_price() {
		return prefer_price;
	}
	public void setPrefer_price(float prefer_price) {
		this.prefer_price = prefer_price;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	public String getDishinformation() {
		return dishinformation;
	}
	public void setDishinformation(String dishinformation) {
		this.dishinformation = dishinformation;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getDeptsno() {
		return deptsno;
	}
	public void setDeptsno(int deptsno) {
		this.deptsno = deptsno;
	}

}
