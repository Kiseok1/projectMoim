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
import com.java.www.dto.GroupDto;

public class GroupDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	GroupDto gdto = null;
	ArrayList<GroupDto> list = new ArrayList<GroupDto>();
	int g_id,g_member_cnt,result;
	String g_name,g_intro,g_content,g_local,g_category,g_file,g_user_id,g_member_id,query="";
	Timestamp g_date;
	
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
	
	
	
	//회원정보수정페이지
	public int g_Update(GroupDto gdto2) {
		try {
		conn = getConnection();
		query = "update group_data set g_name=?,g_local=?,g_intro=?,g_content=?,g_file=?,g_member_cnt=? where g_id=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, gdto2.getG_name());
		pstmt.setString(2, gdto2.getG_local());
		pstmt.setString(3, gdto2.getG_intro());
		pstmt.setString(4, gdto2.getG_content());
		pstmt.setString(5, gdto2.getG_file());
		pstmt.setInt(6, gdto2.getG_member_cnt());
		result = pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e2) { e2.printStackTrace();}
	}//
	return result;
	}
	
}
	
