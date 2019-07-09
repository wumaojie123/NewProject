package cn.edu.lingnan.dto;

public class RoomDTO {
	private int roomid;
	private String roomname;
	private int desknumber;
	private String roomstatus;
	private int isDelete;
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public int getDesknumber() {
		return desknumber;
	}
	public void setDesknumber(int desknumber) {
		this.desknumber = desknumber;
	}
	public String getRoomstatus() {
		return roomstatus;
	}
	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
