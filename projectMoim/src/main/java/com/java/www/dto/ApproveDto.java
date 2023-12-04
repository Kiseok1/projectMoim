package com.java.www.dto;

import java.sql.Timestamp;

public class ApproveDto {

	public ApproveDto() {}

	public ApproveDto(int a_no, int g_no, String u_id, int status, Timestamp apply_date, Timestamp approve_date) {
		this.a_no = a_no;
		this.g_no = g_no;
		this.u_id = u_id;
		this.status = status;
		this.apply_date = apply_date;
		this.approve_date = approve_date;
	}

	private int a_no;
	private int g_no;
	private String u_id;
	private int status;
	private Timestamp apply_date;
	private Timestamp approve_date;
	
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getApply_date() {
		return apply_date;
	}
	public void setApply_date(Timestamp apply_date) {
		this.apply_date = apply_date;
	}
	public Timestamp getApprove_date() {
		return approve_date;
	}
	public void setApprove_date(Timestamp approve_date) {
		this.approve_date = approve_date;
	}
	
	
}
