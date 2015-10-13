package com.bit2015.mysite.vo;

public class GuestbookVo {
	private Long no;
	private String name;
	private String password;
	private String message;
	private String reg_Date;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRegDate() {
		return reg_Date;
	}
	public void setRegDate(String reg_Date) {
		this.reg_Date = reg_Date;
	}
	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", name=" + name + ", password="
				+ password + ", message=" + message + ", reg_Date=" + reg_Date
				+ "]";
	}
	
	
}
