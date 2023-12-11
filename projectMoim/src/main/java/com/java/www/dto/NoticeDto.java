package com.java.www.dto;

import java.sql.Timestamp;

public class NoticeDto {

	public NoticeDto() {}
	
	
	
	
		public NoticeDto(String l_title, String l_content, String l_file, Timestamp l_date, int l_bno) {
			this.l_title = l_title;
			this.l_content = l_content;
			this.l_file = l_file;
			this.l_date = l_date;
			this.l_bno = l_bno;
	}

		public NoticeDto(String l_title2, String l_content2, String l_file2, int l_bno2) {
			this.l_title = l_title2;
			this.l_content = l_content2;
			this.l_file = l_file2;
			this.l_bno = l_bno2;
	}

		public NoticeDto(String l_title2, String l_content2, String l_file2) {
			this.l_title = l_title2;
			this.l_content = l_content2;
			this.l_file = l_file2;
		}

		private String l_title;
		private String l_content;
		private String l_file;
		private Timestamp l_date;
		private int l_bno;
		public String getL_title() {
			return l_title;
		}




		public void setL_title(String l_title) {
			this.l_title = l_title;
		}




		public String getL_content() {
			return l_content;
		}




		public void setL_content(String l_content) {
			this.l_content = l_content;
		}




		public String getL_file() {
			return l_file;
		}




		public void setL_file(String l_file) {
			this.l_file = l_file;
		}




		public Timestamp getL_date() {
			return l_date;
		}




		public void setL_date(Timestamp l_date) {
			this.l_date = l_date;
		}




		public int getL_bno() {
			return l_bno;
		}




		public void setL_bno(int l_bno) {
			this.l_bno = l_bno;
		}
		
		
	
}
