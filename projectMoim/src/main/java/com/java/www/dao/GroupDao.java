package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.java.www.dto.GroupDto;

public class GroupDao {

	private static final String gdate = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	GroupDto gdto = null;
	ArrayList<GroupDto> list = new ArrayList<GroupDto>();
	String g_id;
	int g_member_cnt,result;
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
	
	
	
	//모임정보수정
	public int g_Update(GroupDto gdto2) {
		try {
		conn = getConnection();
		query = "update groups set g_name=?,g_intro=?,g_content=?,g_local=?,g_category=?,g_file=?,g_member_cnt=?,g_date=? where g_id=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, gdto2.getG_id());
		pstmt.setString(2, gdto2.getG_name());
		pstmt.setString(3, gdto2.getG_intro());
		pstmt.setString(4, gdto2.getG_content());
		pstmt.setString(5, gdto2.getG_local());
		pstmt.setString(6, gdto2.getG_category());
		pstmt.setString(7, gdto2.getG_file());
		pstmt.setString(8, gdto2.getG_user_id());
		pstmt.setString(9, gdto2.getG_member_id() );
		result = pstmt.executeUpdate();
		if(rs.next()) {
			g_id = rs.getString("g_id");
			g_name = rs.getString("g_name");
			g_local = rs.getString("g_local");
			g_intro = rs.getString("g_intro");
			g_content = rs.getString("g_content");
			g_file = rs.getString("g_file");
			g_member_cnt = rs.getInt("g_member_cnt");
			g_date = rs.getTimestamp("g_date");
			gdto = new GroupDto(g_id, g_name, g_intro, g_content, g_local, g_file, g_member_cnt, g_date);
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e2) { e2.printStackTrace();}
	}
	return result;
	}


	//모임정보1개가져오기
	public GroupDto selectOne(String g_id2) {
		try {
			conn = getConnection();
			query = "select * from groups where g_id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, g_id2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				g_id = rs.getString("g_id");
				g_name = rs.getString("g_name");
				g_intro = rs.getString("g_intro");
				g_content = rs.getString("g_content");
				g_local = rs.getString("g_local");
				g_file = rs.getString("g_file");
				g_member_cnt = rs.getInt("g_member_cnt");
				g_date = rs.getTimestamp("g_date");
				gdto = new GroupDto(g_id,g_name,g_intro,g_content,g_local,g_file,g_member_cnt,g_date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { e2.printStackTrace();}
		}//
		return gdto;
	}


	//모임정보입력
	public int g_create(GroupDto gdto2) {
		try {
			conn = getConnection();
			query = "insert into groups values(?,?,?,?,?,?,?,?,?,1,sysdate)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, gdto2.getG_id());
			pstmt.setString(2, gdto2.getG_name());
			pstmt.setString(3, gdto2.getG_intro());
			pstmt.setString(4, gdto2.getG_content());
			pstmt.setString(5, gdto2.getG_local());
			pstmt.setString(6, gdto2.getG_category());
			pstmt.setString(7, gdto2.getG_file());
			pstmt.setString(8, gdto2.getG_user_id());
			pstmt.setString(9, gdto2.getG_member_id() );
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { e2.printStackTrace();}
		}
		return result;
		}
	
}
	
