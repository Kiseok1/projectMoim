package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.catalina.connector.Request;

import com.java.www.dto.BoardDto;

public class BoardDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BoardDto bdto = null;
	ArrayList<BoardDto> list = new ArrayList<BoardDto>();
	int b_no,b_group,b_step,b_indent,b_hit,result,listCount;
	String b_title,b_content,u_nicname,b_file,query="",g_id,u_id;
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
			query = "select * from (select row_number() over(order by b_group desc, b_step asc) rnum, a.* from p_board a) where rnum between 1 and 10";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				b_no = rs.getInt("b_no");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				u_nicname = rs.getString("u_nicname");
				g_id = rs.getString("g_id");
				b_group = rs.getInt("b_group");
				b_step = rs.getInt("b_step");
				b_indent = rs.getInt("b_indent");
				b_hit = rs.getInt("b_hit");
				b_file = rs.getString("b_file");
				b_date = rs.getTimestamp("b_date");
				list.add(new BoardDto(b_no, b_title, b_content, u_nicname, g_id, b_group, b_step, b_indent, b_hit, b_file, b_date));
				
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
	//게시글 한개 불러오기 
	public BoardDto selectOne(int b_no2) {
		
		try {
			conn = getConnection();
			query = "select * from p_board where b_no=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_no2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b_no = rs.getInt("b_no");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				u_nicname = rs.getString("u_nicname");
				g_id = rs.getString("g_id");
				b_group = rs.getInt("b_group");
				b_step = rs.getInt("b_step");
				b_indent = rs.getInt("b_indent");
				b_hit = rs.getInt("b_hit");
				b_file = rs.getString("b_file");
				b_date = rs.getTimestamp("b_date");
				bdto = new BoardDto(b_no, b_title, b_content, u_nicname, g_id, b_group, b_step, b_indent, b_hit, b_file, b_date);
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
		return bdto;
	}

	//게시글 저장 메소드 (작성)
	public int insert(BoardDto bdto2) {
		try {
			
			conn = getConnection();
			query = "insert into p_board (b_no,b_title,b_content,u_nicname,u_id,b_group,b_step,b_indent,b_hit,b_file,b_date) values(p_board_seq.nextval,?,?,?,?,p_board_seq.currval,0,0,1,?,sysdate)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bdto2.getB_title());
			pstmt.setString(2, bdto2.getB_content());
			pstmt.setString(3, bdto2.getU_nicname());
			pstmt.setString(4, bdto2.getU_id());
			pstmt.setString(5, bdto2.getB_file());
			result = pstmt.executeUpdate();
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

	//게시글 수정 메소드	
	public int update(BoardDto bdto2) {
		
		try {
		  conn = getConnection();
		  query = "update p_board set b_title=?,b_content=?,b_file=? where b_no=?";
		  pstmt = conn.prepareStatement(query);
		  pstmt.setString(1, bdto2.getB_title());
		  pstmt.setString(2, bdto2.getB_content());
		  pstmt.setString(3, bdto2.getB_file());
		  pstmt.setInt(4, bdto2.getB_no());
		  result = pstmt.executeUpdate();
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
		System.out.println("dao file:"+bdto2.getB_file());
		return result;
	}
	//게시글 삭제
	public int delete(int b_no2) {
		try {
			conn = getConnection();
			query = "delete p_board where b_no = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_no2);
			result = pstmt.executeUpdate();
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
	
	//step 1씩 증가 메소드
	public void stepUp(int b_group2, int b_step2) {
		try {
			conn = getConnection();
			query = "update p_board set b_step = b_step+1 where b_group=? and b_step=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_group2);
			pstmt.setInt(2, b_step2);
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
	}//stepUp
	//답글 저장 메소드
	public int replyInsert(BoardDto bdto2) {
		try {
			
			conn = getConnection();
			query = "insert into p_board (b_no,b_title,b_content,u_nicname,u_id,b_group,b_step,b_indent,b_hit,b_file,b_date) values(p_board_seq.nextval,?,?,?,?,?,?,?,1,?,sysdate)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,bdto2.getB_title());
			pstmt.setString(2,bdto2.getB_content());
			pstmt.setString(3,bdto2.getU_nicname());
			pstmt.setString(4,bdto2.getU_id());
			pstmt.setInt(5,bdto2.getB_group());
			pstmt.setInt(6,bdto2.getB_step()+1);
			pstmt.setInt(7,bdto2.getB_indent()+1);
			pstmt.setString(8,bdto2.getB_file());
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
