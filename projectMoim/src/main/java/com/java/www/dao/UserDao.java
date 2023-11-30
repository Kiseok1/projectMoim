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
	String u_id, u_pw, u_nickname, u_email, u_category, u_local, u_profileImg, g_id, query = "";
	Timestamp u_date;
	int result;

	// getConnection
	public Connection getConnection() {
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle18");
			connection = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}// getConnection

	// 1명 회원정보 가져오기
	public UserDto selectOne(String id) {
		try {
			conn = getConnection();
			query = "select * from users where u_id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				u_id = rs.getString("u_id");
				u_pw = rs.getString("u_pw");
				u_nickname = rs.getString("u_nickname");
				u_email = rs.getString("u_email");
				u_category = rs.getString("u_category");
				u_local = rs.getString("u_local");
				u_profileImg = rs.getString("u_profileImg");
				g_id = rs.getString("g_id");
				u_date = rs.getTimestamp("u_date");

				udto = new UserDto(u_id, u_pw, u_nickname, u_email, u_category, u_local, u_profileImg, g_id, u_date);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return udto;
	}// selectOne

	// 로그인
	public UserDto uLogin(String id, String pw) {
		try {

			conn = getConnection();
			query = "select * from users where u_id=? and u_pw=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				u_id = rs.getString("u_id");
				u_pw = rs.getString("u_pw");
				u_nickname = rs.getString("u_nickname");
				u_email = rs.getString("u_email");
				u_category = rs.getString("u_category");
				u_local = rs.getString("u_local");
				u_profileImg = rs.getString("u_profileImg");
				u_date = rs.getTimestamp("u_date");

				udto = new UserDto(u_id, u_pw, u_nickname, u_email, u_category, u_local, u_profileImg, u_date);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return udto;
	}

	// 모임 가입
	public int join(String g_id, String u_id2) {
		try {
			conn = getConnection();
			query = "update users set g_id=? where u_id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, g_id);
			pstmt.setString(2, u_id2);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	// 모임 탈퇴
	public int quitGroup(String u_gId, String u_id2) {
		try {
			conn = getConnection();
			query = "update users set g_id=? where u_id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u_gId);
			pstmt.setString(2, u_id2);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	// id중복체크 - select
	public UserDto idCheck(String id2) {
		try {
			conn = getConnection();
			query = "select * from users where u_id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id2);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				conn = getConnection();
				query = "select * from users where u_id=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, id2);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					u_id = rs.getString("u_id");
					u_pw = rs.getString("u_pw");
					u_nickname = rs.getString("u_nickname");
					u_email = rs.getString("u_email");
					u_category = rs.getString("u_category");
					u_local = rs.getString("u_local");
					u_profileImg = rs.getString("u_profileImg");
					g_id = rs.getString("g_id");
					u_date = rs.getTimestamp("u_date");

					udto = new UserDto(u_id, u_pw, u_nickname, u_email, u_category, u_local, u_profileImg, g_id,
							u_date);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return udto;
	}// idCheck

	//회원가입
	public int insert(UserDto udto2) {
		try {
			conn=getConnection();
			query="insert into users (u_id,u_pw,u_nickname,u_email,u_local,u_category,u_profileImg,u_date)"
					+ "values (?,?,?,?,?,?,?, sysdate)";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, udto2.getU_id());
			pstmt.setString(2, udto2.getU_pw());
			pstmt.setString(3, udto2.getU_nickname());
			pstmt.setString(4, udto2.getU_email());
			pstmt.setString(5, udto2.getU_local());
			pstmt.setString(6, udto2.getU_category());
			pstmt.setString(7, udto2.getU_profileImg());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	//모임 가입자 정보 가져오기
	public ArrayList<UserDto> selectJoinUser(String[] joinUsers) {
		try {
			conn = getConnection();
			for(int i=0;i<joinUsers.length;i++) {
				query = "select * from users where u_id=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, joinUsers[i]);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					u_id = rs.getString("u_id");
					u_pw = rs.getString("u_pw");
					u_nickname = rs.getString("u_nickname");
					u_email = rs.getString("u_email");
					u_category = rs.getString("u_category");
					u_local = rs.getString("u_local");
					u_profileImg = rs.getString("u_profileImg");
					g_id = rs.getString("g_id");
					u_date = rs.getTimestamp("u_date");
					
					list.add(new UserDto(u_id, u_pw, u_nickname, u_email, u_category, u_local, u_profileImg, g_id, u_date));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
}
