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

public class BoardDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BoardDto bdto = null;
	ArrayList<BoardDto> list = new ArrayList<BoardDto>();
	int b_no,b_group,b_step,b_indent,b_hit,result,listCount;
	String b_title,b_content,u_nickname,b_file,query="",g_id ;
	Timestamp b_date;
	
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
	
	//게시글 가져오기 - select 
	public ArrayList<BoardDto> p_listSelect() {
		
		try {
			conn = getConnection();
			query = "";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				b_no = rs.getInt("b_no");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				u_nickname = rs.getString("u_nickname");
				u_nickname = rs.getString("u_nickname");
				g_id = rs.getString("g_id");
				b_group = rs.getInt("b_group");
				b_step = rs.getInt("b_step");
				b_indent = rs.getInt("b_indent");
				b_hit = rs.getInt("b_hit");
				b_file = rs.getString("b_file");
				b_date = rs.getTimestamp("b_date");
				list.add(new BoardDto(b_no, b_title, b_content, u_nickname, g_id, b_group, b_step, b_indent, b_hit, b_file, b_date));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list; 
	}
}
