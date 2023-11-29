package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.www.dto.UserDto;

public class UserDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	UserDto udto = null;
	ArrayList<UserDto> list = new ArrayList<UserDto>();
	String u_id,u_pw,u_nicname,u_email,u_category,u_local,u_profileImg,g_id,query="";
	Timestamp u_date;
	int result;
	
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
	//1명 회원정보 가져오기
	public UserDto selectOne(String id) {
		try {
			conn=getConnection();
			query="select * from users where u_id=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				u_id=rs.getString("u_id");
				u_pw=rs.getString("u_pw");
				u_nicname=rs.getString("u_nicname");
				u_email=rs.getString("u_email");
				u_category=rs.getString("u_category");
				u_local=rs.getString("u_local");
				u_profileImg=rs.getString("u_profileImg");
				g_id=rs.getString("g_id");
				u_date=rs.getTimestamp("u_date");
				
				udto = new UserDto(u_id, u_pw, u_nicname, u_email, u_category, u_local, u_profileImg, g_id, u_date);
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
		return udto;
	}//selectOne
	//로그인
	public UserDto uLogin(String id, String pw) {
		try {
			
			conn=getConnection();
			query="select * from users where u_id=? and u_pw=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				u_id=rs.getString("u_id");
				u_pw=rs.getString("u_pw");
				u_nicname=rs.getString("u_nickname");
				u_email=rs.getString("u_email");
				u_category=rs.getString("u_category");
				u_local=rs.getString("u_local");
				u_profileImg=rs.getString("u_profileImg");
				u_date=rs.getTimestamp("u_date");
				
				udto = new UserDto(u_id, u_pw, u_nicname, u_email, u_category, u_local, u_profileImg, u_date);
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
		return udto;
	
		}
	
}
