package com.java.www.dto;

import java.sql.Timestamp;

public class UserDto {

	public UserDto() {}
	
	public UserDto(String u_id, String u_pw, String u_nicname, String u_email, String u_category, String u_local,
			String u_profileImg) {
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_nicname = u_nicname;
		this.u_email = u_email;
		this.u_category = u_category;
		this.u_local = u_local;
		this.u_profileImg = u_profileImg;
	}

	public UserDto(String u_id, String u_pw, String u_nicname, String u_email, String u_category, String u_local,
			String u_profileImg, Timestamp u_date) {
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_nicname = u_nicname;
		this.u_email = u_email;
		this.u_category = u_category;
		this.u_local = u_local;
		this.u_profileImg = u_profileImg;
		this.u_date = u_date;
	}

	public UserDto(String u_id, String u_pw, String u_nicname, String u_email, String u_category, String u_local,
			String u_profileImg, String g_id, Timestamp u_date) {
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_nicname = u_nicname;
		this.u_email = u_email;
		this.u_category = u_category;
		this.u_local = u_local;
		this.u_profileImg = u_profileImg;
		this.g_id = g_id;
		this.u_date = u_date;
	}

	private String u_id;
	private String u_pw;
	private String u_nicname;
	private String u_email;
	private String u_category;
	private String u_local;
	private String u_profileImg;
	private String g_id;
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
	public String getU_nicname() {
		return u_nicname;
	}
	public void setU_nicname(String u_nickname) {
		this.u_nicname = u_nicname;
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
	public String getG_id() {
		return g_id;
	}
	public void setG_id(String g_id) {
		this.g_id = g_id;
	}
	public Timestamp getU_date() {
		return u_date;
	}
	public void setU_date(Timestamp u_date) {
		this.u_date = u_date;
	}
	
	
	
}
