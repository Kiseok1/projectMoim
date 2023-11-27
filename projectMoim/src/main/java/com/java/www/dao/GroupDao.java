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

	//모임 검색(검색 없는 최초의 경우는 추천소모임 보여주기)
	public ArrayList<GroupDto> selectSearch(String search, String local, String category) {
		try {
			System.out.println("dao : "+local);
			conn=getConnection();
			if(search!=null) {
				query="select * from groups where g_intro like '%'||?||'%' or g_content like '%'||?||'%'";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				
			} else if(local != null && category != null) {
				
				query="select * from groups where g_local=? and g_category like '%'||?||'%'";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, local);
				pstmt.setString(2, category);
			} else if(local != null && category == null) {
				query="select * from groups where g_local=? ";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, local);
			} else if(local == null && category != null) {
				query="select * from groups where g_category like '%'||?||'%'";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, category);
			} else {
				query="select * from groups";
				pstmt=conn.prepareStatement(query);
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				g_id=rs.getInt("g_id");
				g_member_cnt=rs.getInt("g_member_cnt");
				g_name=rs.getString("g_name");
				g_intro=rs.getString("g_intro");
				g_content=rs.getString("g_content");
				g_local=rs.getString("g_local");
				g_category=rs.getString("g_category");
				g_file=rs.getString("g_file");
				g_user_id=rs.getString("g_user_id");
				g_member_id=rs.getString("g_member_id");
				g_date=rs.getTimestamp("g_date");
				
				list.add(new GroupDto(g_id, g_name, g_intro, g_content, g_local, g_category, g_file, g_user_id, g_member_id, g_member_cnt, g_date));
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
