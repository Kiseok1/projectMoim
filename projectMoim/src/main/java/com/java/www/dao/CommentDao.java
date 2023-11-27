package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.www.dto.BoardDto;
import com.java.www.dto.CommentDto;

public class CommentDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CommentDto cdto = null;
	ArrayList<CommentDto> list = new ArrayList<CommentDto>();
	int b_no,c_no,result;
	String c_content,u_id,query="";
	Timestamp c_date;
	
	//getConnection
	public Connection getConnection() {
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18");
			connection = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}//getConnection
}
