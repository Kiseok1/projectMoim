package com.java.www.dto;

import java.sql.Timestamp;

public class UserDto {

	public UserDto() {}
	
	private String u_id;
	private String u_pw;
	private String u_nickname;
	private String u_email;
	private String u_category;
	private String u_local;
	private String u_profileImg;
	private Timestamp u_date;
	
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_nickname() {
		return u_nickname;
	}
	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_category() {
		return u_category;
	}
	public void setU_category(String u_category) {
		this.u_category = u_category;
	}
	public String getU_local() {
		return u_local;
	}
	public void setU_local(String u_local) {
		this.u_local = u_local;
	}
	public String getU_profileImg() {
		return u_profileImg;
	}
	public void setU_profileImg(String u_profileImg) {
		this.u_profileImg = u_profileImg;
	}
	public Timestamp getU_date() {
		return u_date;
	}
	public void setU_date(Timestamp u_date) {
		this.u_date = u_date;
	}
	
	
	
}
