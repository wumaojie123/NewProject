package cn.edu.lingnan.dto;

public class DeskDTO {
	private int deskid;
	private int seatnumber;
	private String deskstatus;
	private int roomid;
	private int userid;
	private int isDelete;
	public int getDeskid() {
		return deskid;
	}
	public void setDeskid(int deskid) {
		this.deskid = deskid;
	}
	public int getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}
	public String getDeskstatus() {
		return deskstatus;
	}
	public void setDeskstatus(String deskstatus) {
		this.deskstatus = deskstatus;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	

}
