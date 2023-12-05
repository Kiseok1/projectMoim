package com.java.www.dto;

import java.sql.Timestamp;

public class MessageDto {
	
	public MessageDto() {}
	
	public MessageDto(String m_sent_id, String m_recv_id, String m_note) {
		this.m_sent_id = m_sent_id;
		this.m_recv_id = m_recv_id;
		this.m_note = m_note;
	}
	
	

	public MessageDto(int m_no, String m_sent_id, String m_recv_id, String m_note, Timestamp m_date_sent,
			Timestamp m_date_read, int m_recv_read, int m_sent_del, int m_recv_del) {
		this.m_no = m_no;
		this.m_sent_id = m_sent_id;
		this.m_recv_id = m_recv_id;
		this.m_note = m_note;
		this.m_date_sent = m_date_sent;
		this.m_date_read = m_date_read;
		this.m_recv_read = m_recv_read;
		this.m_sent_del = m_sent_del;
		this.m_recv_del = m_recv_del;
	}



	private int m_no;
	private String m_sent_id;
	private String m_recv_id;
	private String m_note;
	private Timestamp m_date_sent;
	private Timestamp m_date_read;
	private int m_recv_read;
	private int m_sent_del;
	private int m_recv_del;
	
	
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_sent_id() {
		return m_sent_id;
	}
	public void setM_sent_id(String m_sent_id) {
		this.m_sent_id = m_sent_id;
	}
	public String getM_recv_id() {
		return m_recv_id;
	}
	public void setM_recv_id(String m_recv_id) {
		this.m_recv_id = m_recv_id;
	}
	public String getM_note() {
		return m_note;
	}
	public void setM_note(String m_note) {
		this.m_note = m_note;
	}
	public Timestamp getM_date_sent() {
		return m_date_sent;
	}
	public void setM_date_sent(Timestamp m_date_sent) {
		this.m_date_sent = m_date_sent;
	}
	public Timestamp getM_date_read() {
		return m_date_read;
	}
	public void setM_date_read(Timestamp m_date_read) {
		this.m_date_read = m_date_read;
	}
	public int getM_recv_read() {
		return m_recv_read;
	}
	public void setM_recv_read(int m_recv_read) {
		this.m_recv_read = m_recv_read;
	}
	public int getM_sent_del() {
		return m_sent_del;
	}
	public void setM_sent_del(int m_sent_del) {
		this.m_sent_del = m_sent_del;
	}
	public int getM_recv_del() {
		return m_recv_del;
	}
	public void setM_recv_del(int m_recv_del) {
		this.m_recv_del = m_recv_del;
	}

	
	
}
