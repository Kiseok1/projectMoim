package com.java.www.dto;

import java.sql.Timestamp;

public class BoardDto {

	public BoardDto() {}
	
	private int b_no;
	private String b_title;
	private String b_content;
	private String u_nickname;
	private String g_id;
	private int b_group;
	private int b_step;
	private int b_indent;
	private int b_hit;
	private String b_file;
	private Timestamp b_date;
	public int getB_no() {
		return b_no;
	}
	public BoardDto(int b_no, String b_title, String b_content, String u_nickname, String g_id, int b_group, int b_step,
			int b_indent, int b_hit, String b_file, Timestamp b_date) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_content = b_content;
		this.u_nickname = u_nickname;
		this.g_id = g_id;
		this.b_group = b_group;
		this.b_step = b_step;
		this.b_indent = b_indent;
		this.b_hit = b_hit;
		this.b_file = b_file;
		this.b_date = b_date;
	}
	
	
	public BoardDto(int b_no, String b_title, String u_nickname, int b_hit, Timestamp b_date) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.u_nickname = u_nickname;
		this.b_hit = b_hit;
		this.b_date = b_date;
	}
	
	
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getU_nickname() {
		return u_nickname;
	}
	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}
	public String getG_id() {
		return g_id;
	}
	public void setG_id(String g_id) {
		this.g_id = g_id;
	}
	public int getB_group() {
		return b_group;
	}
	public void setB_group(int b_group) {
		this.b_group = b_group;
	}
	public int getB_step() {
		return b_step;
	}
	public void setB_step(int b_step) {
		this.b_step = b_step;
	}
	public int getB_indent() {
		return b_indent;
	}
	public void setB_indent(int b_indent) {
		this.b_indent = b_indent;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public String getB_file() {
		return b_file;
	}
	public void setB_file(String b_file) {
		this.b_file = b_file;
	}
	public Timestamp getB_date() {
		return b_date;
	}
	public void setB_date(Timestamp b_date) {
		this.b_date = b_date;
	}
	
	
}
