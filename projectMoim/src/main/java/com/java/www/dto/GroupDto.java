package com.java.www.dto;

import java.sql.Timestamp;

public class GroupDto {
	
	public GroupDto() {}//기본생성자



	public GroupDto(int g_id, String g_name, String g_intro, String g_content, String g_local, String g_file,
			int g_member_cnt) {
		this.g_id = g_id;
		this.g_name = g_name;
		this.g_intro = g_intro;
		this.g_content = g_content;
		this.g_local = g_local;
		this.g_file = g_file;
		this.g_member_cnt = g_member_cnt;
		
	}
	


	public GroupDto(int g_id, String g_name, String g_intro, String g_content, String g_local, String g_category,
			String g_file, String g_user_id, String g_member_id, int g_member_cnt, Timestamp g_date) {
		this.g_id = g_id;
		this.g_name = g_name;
		this.g_intro = g_intro;
		this.g_content = g_content;
		this.g_local = g_local;
		this.g_category = g_category;
		this.g_file = g_file;
		this.g_user_id = g_user_id;
		this.g_member_id = g_member_id;
		this.g_member_cnt = g_member_cnt;
		this.g_date = g_date;
	}



	public GroupDto(String g_id2, String g_name2, String g_intro2, String g_content2, String g_local2, String g_file2,
			int g_member_cnt2, Timestamp g_date2) {
		this.g_id = g_id;
		this.g_name = g_name2;
		this.g_intro = g_intro2;
		this.g_content = g_content2;
		this.g_local = g_local2;
		this.g_file = g_file2;
		this.g_member_cnt = g_member_cnt2;
		this.g_date = g_date2;
		
	}



	public GroupDto(String g_id2, String g_name2, String g_intro2, String g_content2, String g_local2, String g_file2,
			int g_member_cnt2) {
		this.g_id = g_id;
		this.g_name = g_name2;
		this.g_intro = g_intro2;
		this.g_content = g_content2;
		this.g_local = g_local2;
		this.g_file = g_file2;
		this.g_member_cnt = g_member_cnt2;
	}



	public GroupDto(String g_id2, String g_name2, String g_intro2, String g_content2, String g_local2, String g_file2,
			int g_member_cnt2, String g_category2) {
		
		this.g_id = g_id;
		this.g_name = g_name2;
		this.g_intro = g_intro2;
		this.g_content = g_content2;
		this.g_local = g_local2;
		this.g_file = g_file2;
		this.g_member_cnt = g_member_cnt2;
		this.g_category = g_category2;
		
		
	}



	private int g_id;
	private String g_name;
	private String g_intro;
	private String g_content;
	private String g_local;
	private String g_category;
	private String g_file;
	private String g_user_id;
	private String g_member_id;
	private int g_member_cnt;
	private Timestamp g_date;
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_intro() {
		return g_intro;
	}
	public void setG_intro(String g_intro) {
		this.g_intro = g_intro;
	}
	public String getG_content() {
		return g_content;
	}
	public void setG_content(String g_content) {
		this.g_content = g_content;
	}
	public String getG_local() {
		return g_local;
	}
	public void setG_local(String g_local) {
		this.g_local = g_local;
	}
	public String getG_category() {
		return g_category;
	}
	public void setG_category(String g_category) {
		this.g_category = g_category;
	}
	public String getG_file() {
		return g_file;
	}
	public void setG_file(String g_file) {
		this.g_file = g_file;
	}
	public String getG_user_id() {
		return g_user_id;
	}
	public void setG_user_id(String g_user_id) {
		this.g_user_id = g_user_id;
	}
	public String getG_member_id() {
		return g_member_id;
	}
	public void setG_member_id(String g_member_id) {
		this.g_member_id = g_member_id;
	}
	public int getG_member_cnt() {
		return g_member_cnt;
	}
	public void setG_member_cnt(int g_member_cnt) {
		this.g_member_cnt = g_member_cnt;
	}
	public Timestamp getG_date() {
		return g_date;
	}
	public void setG_date(Timestamp g_date) {
		this.g_date = g_date;
	}
	
	
}
