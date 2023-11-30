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
	String[] categorys = null;
	
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
			conn=getConnection();
			System.out.println("gdao search : "+search);
			System.out.println("gdao local : "+local);
			System.out.println("gdao category : "+category);
			if(search!=null) {
				query="select * from groups where g_intro like '%'||?||'%' or g_content like '%'||?||'%'";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
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
			} else if(search==null && local != null && category != null) {
				query="select * from groups where g_local=? or g_category like '%'||?||'%'";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, local);
				categorys=category.split(",");
				for(int i=0;i<categorys.length;i++) {
					pstmt.setString(2, categorys[i]);
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
				}
			} else if(search==null && local != null && category == null) {
				query="select * from groups where g_local=? ";
				System.out.println("dao local : "+local);
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, local);
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
			} else if(search==null && local == null && category != null) {
				query="select * from groups where g_category like '%'||?||'%'";
				pstmt=conn.prepareStatement(query);
				categorys=category.split(",");
				for(int i=0;i<categorys.length;i++) {
					pstmt.setString(1, categorys[i]);
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
				}	
			} else { //모두 null
				query="select * from groups";
				pstmt=conn.prepareStatement(query);
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
	}//selectSearch

	//모임 선택
	public GroupDto selectOne(String g_id2) {
		try {
			conn=getConnection();
			query="select * from groups where g_id=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, g_id2);
			rs=pstmt.executeQuery();
			if(rs.next()) {
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
				
				gdto = new GroupDto(g_id, g_name, g_intro, g_content, g_local, g_category, g_file, g_user_id, g_member_id, g_member_cnt, g_date);
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
		return gdto;
	}//selectOne

	//회원가입
	public int join(String g_member_id2, String g_id2) {
		try {
			conn=getConnection();
			query="update groups set g_member_id=?, g_member_cnt=g_member_cnt+1 where g_id=? ";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, g_member_id2);		
			pstmt.setString(2, g_id2);		
			result=pstmt.executeUpdate();
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
		return result;
	}

	//모임 탈퇴
	public int quitGroup(String g_member_id2, String g_id2) {
		try {
			conn=getConnection();
			query="update groups set g_member_id=?, g_member_cnt=g_member_cnt-1 where g_id=? ";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, g_member_id2);		
			pstmt.setString(2, g_id2);		
			result=pstmt.executeUpdate();
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
		return result;
	}//quitGroup

	//가입된 모임 가져오기
	public ArrayList<GroupDto> selectJoinGroup(String[] g_ids) {
		try {
			conn=getConnection();
			for(int i=0;i<g_ids.length;i++) {
				query="select * from groups where g_id=?";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, g_ids[i]);
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
