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
	String b_title,b_content,u_nicname,b_file,query="",u_id,g_id;
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
	public ArrayList<BoardDto> p_listSelect(String category, String sword, int startRow, int endRow,String g_id) {
		
		try {
			conn = getConnection();
			if(category==null) {
				query = "select * from (select row_number() over(order by b_group desc, b_step asc) rnum, a.* from boards a) where rnum between ? and ? and g_id = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				pstmt.setString(3, g_id);
			}else if(category.equals("all")) {
				query = "select * from (select row_number() over(order by b_group desc, b_step asc) rnum, a.* from boards a where b_title like  '%'||?||'%' or b_content like '%'||?||'%')where rnum between ? and ? and g_id =?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, sword);
				pstmt.setString(2, sword);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				pstmt.setString(5, g_id);
			}else if(category.equals("btitle")) {
				query = "select * from (select row_number() over(order by b_group desc, b_step asc) rnum, a.* from boards a where b_title like  '%'||?||'%') where rnum between ? and ? and g_id =?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, sword);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				pstmt.setString(4, g_id);
			}else {
				query = "select * from (select row_number() over(order by b_group desc, b_step asc) rnum, a.* from boards a where b_content like '%'||?||'%')where rnum between ? and ? and g_id =?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, sword);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				pstmt.setString(4, g_id);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				b_no = rs.getInt("b_no");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				u_nicname = rs.getString("u_nickname");
				g_id = rs.getString("g_id");
				b_group = rs.getInt("b_group");
				b_step = rs.getInt("b_step");
				b_indent = rs.getInt("b_indent");
				b_hit = rs.getInt("b_hit");
				b_file = rs.getString("b_file");
				b_date = rs.getTimestamp("b_date");
				list.add(new BoardDto(b_no, b_title, b_content, u_nicname,g_id, b_group, b_step, b_indent, b_hit, b_file, b_date));
				
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
			query = "select * from boards where b_no=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_no2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b_no = rs.getInt("b_no");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				u_nicname = rs.getString("u_nickname");
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
			query = "insert into boards (b_no,b_title,b_content,u_nickname,g_id,u_id,b_group,b_step,b_indent,b_hit,b_file,b_date) values(boards_seq.nextval,?,?,?,?,?,boards_seq.currval,0,0,1,?,sysdate)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bdto2.getB_title());
			pstmt.setString(2, bdto2.getB_content());
			pstmt.setString(3, bdto2.getU_nicname());
			pstmt.setString(4, bdto2.getG_id());
			System.out.println("bdao g_id :"+bdto2.getG_id());
			pstmt.setString(5, bdto2.getU_id());
			pstmt.setString(6, bdto2.getB_file());
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
		  query = "update boards set b_title=?,b_content=?,b_file=? where b_no=?";
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
			query = "delete boards where b_no = ?";
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
			query = "update boards set b_step = b_step+1 where b_group=? and b_step>?";
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
			query = "insert into boards (b_no,b_title,b_content,u_nickname,g_id,u_id,b_group,b_step,b_indent,b_hit,b_file,b_date) values(boards_seq.nextval,?,?,?,?,?,?,?,?,1,?,sysdate)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,bdto2.getB_title());
			pstmt.setString(2,bdto2.getB_content());
			pstmt.setString(3,bdto2.getU_nicname());
			pstmt.setString(4,bdto2.getG_id());
			pstmt.setString(5,bdto2.getU_id());
			pstmt.setInt(6,bdto2.getB_group());
			pstmt.setInt(7,bdto2.getB_step()+1);
			pstmt.setInt(8,bdto2.getB_indent()+1);
			pstmt.setString(9,bdto2.getB_file());
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
	//검색한 게시글 가져오기 
	public int pListCount(String category, String sword, String g_id) {
		try {
			conn = getConnection();
			//검색을 안할때
			if(category == null) {
				query = "select count(*) listCount from boards where g_id=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, g_id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					listCount = rs.getInt("listCount");
				}//next
				//전체  검색
			}else if (category.equals("all")) {
				query = "select count(*) listCount from boards where (b_title like '%'||?||'%' or b_content like '%'||?||'%') and g_id = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, sword);
				pstmt.setString(2, sword);
				pstmt.setString(3, g_id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					listCount = rs.getInt("listCount");
				}
				//제목검색
			}else if (category.equals("btitle")) {
				query = "select count(*) listCount from boards where (b_title like '%'||?||'%') and g_id = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, sword);
				pstmt.setString(2, g_id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					listCount = rs.getInt("listCount");
				}
				//내용 검색
			}else {
				query = "select count(*) listCount from boards where (b_content like '%'||?||'%') and g_id = ? ";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, sword);
				pstmt.setString(2, g_id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					listCount = rs.getInt("listCount");
				}
				
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
		
		return listCount;
	}
	//이전글 가져오기
	public BoardDto preSelectOne(int b_no2) {
		
		try {
			conn = getConnection();
			bdto = null;
			query = "select * from (select row_number() over (order by b_group desc, b_step asc) rnum, a.* from boards a) where rnum = (select rnum from(select row_number() over (order by b_group desc, b_step asc) rnum, a.* from boards a) where b_no=?)-1";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_no2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b_no = rs.getInt("b_no");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				u_nicname = rs.getString("u_nickname");
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
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { e2.printStackTrace();}
		}//
		System.out.println("bdao PreSelectOne :"+ bdto);
		return bdto;
	}
	//다음글 가져오기
	public BoardDto nextSelectOne(int b_no2) {
		try {
			conn = getConnection();
			bdto = null;
			query = "select * from (select row_number() over (order by b_group desc, b_step asc) rnum, a.* from boards a) where rnum = (select rnum from(select row_number() over (order by b_group desc, b_step asc) rnum, a.* from boards a) where b_no=?)+1";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_no2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b_no = rs.getInt("b_no");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				u_nicname = rs.getString("u_nickname");
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
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { e2.printStackTrace();}
		}//
		System.out.println("bdao NextSelectOne :"+ bdto);
		return bdto;
	}

	//조회수 증가
	public void hitPlus(int b_no2) {
		
		try {
			conn = getConnection();
			query = "update boards set b_hit=b_hit+1 where b_no = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_no2);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { e2.printStackTrace();}
		}//
		
	}
	//이전글이 없습니다. 메소드
	public BoardDto prenull(int b_no2) {
		try {
			conn = getConnection();
			query = "select * from (select row_number() over (order by b_group desc, b_step asc) rnum, a.* from boards a) where rnum = (select rnum from(select row_number() over (order by b_group desc, b_step asc) rnum, a.* from boards a) where b_no=?)+1";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_no2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b_no = rs.getInt("b_no");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				u_nicname = rs.getString("u_nickname");
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
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { e2.printStackTrace();}
		}//
		return bdto;
	}
	//다음글이 없습니다. 메소드
	public BoardDto nextnull(int b_no2) {
		try {
			conn = getConnection();
			query = "select * from (select row_number() over (order by b_group desc, b_step asc) rnum, a.* from boards a) where rnum = (select rnum from(select row_number() over (order by b_group desc, b_step asc) rnum, a.* from boards a) where b_no=?)-1";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_no2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b_no = rs.getInt("b_no");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				u_nicname = rs.getString("u_nickname");
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
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { e2.printStackTrace();}
		}//
		return bdto;
	}
	//자유게시판 게시글 가져오기
	public int pfreeListCount(String category, String sword) {
			try {
				conn = getConnection();
				//검색을 안할때
				if(category == null) {
					query = "select count(*) listCount from boards";
					pstmt = conn.prepareStatement(query);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						listCount = rs.getInt("listCount");
					}//next
					//전체  검색
				}else if (category.equals("all")) {
					query = "select count(*) listCount from boards where (b_title like '%'||?||'%' or b_content like '%'||?||'%')";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, sword);
					pstmt.setString(2, sword);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						listCount = rs.getInt("listCount");
					}
					//제목검색
				}else if (category.equals("btitle")) {
					query = "select count(*) listCount from boards where (b_title like '%'||?||'%')";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, sword);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						listCount = rs.getInt("listCount");
					}
					//내용 검색
				}else {
					query = "select count(*) listCount from boards where (b_content like '%'||?||'%')";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, sword);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						listCount = rs.getInt("listCount");
					}
					
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
			
			return listCount;
		}

	public ArrayList<BoardDto> p_freelistSelect(String category, String sword, int startRow, int endRow) {
			
			try {
				conn = getConnection();
				if(category==null) {
					query = "select * from (select row_number() over(order by b_group desc, b_step asc) rnum, a.* from boards a) where rnum between ? and ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
				}else if(category.equals("all")) {
					query = "select * from (select row_number() over(order by b_group desc, b_step asc) rnum, a.* from boards a where b_title like  '%'||?||'%' or b_content like '%'||?||'%')where rnum between ? and ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, sword);
					pstmt.setString(2, sword);
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
				}else if(category.equals("btitle")) {
					query = "select * from (select row_number() over(order by b_group desc, b_step asc) rnum, a.* from boards a where b_title like  '%'||?||'%') where rnum between ? and ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, sword);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
				}else {
					query = "select * from (select row_number() over(order by b_group desc, b_step asc) rnum, a.* from boards a where b_content like '%'||?||'%')where rnum between ? and ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, sword);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
				}
				rs = pstmt.executeQuery();
				while(rs.next()) {
					b_no = rs.getInt("b_no");
					b_title = rs.getString("b_title");
					b_content = rs.getString("b_content");
					u_nicname = rs.getString("u_nickname");
					g_id = rs.getString("g_id");
					b_group = rs.getInt("b_group");
					b_step = rs.getInt("b_step");
					b_indent = rs.getInt("b_indent");
					b_hit = rs.getInt("b_hit");
					b_file = rs.getString("b_file");
					b_date = rs.getTimestamp("b_date");
					list.add(new BoardDto(b_no, b_title, b_content, u_nicname,g_id, b_group, b_step, b_indent, b_hit, b_file, b_date));
					
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
	//자유게시판 게시글 작성 메소드
	public int freeinsert(BoardDto bdto2) {
		try {
			
			conn = getConnection();
			query = "insert into boards (b_no,b_title,b_content,u_nickname,u_id,b_group,b_step,b_indent,b_hit,b_file,b_date) values(boards_seq.nextval,?,?,?,?,boards_seq.currval,0,0,1,?,sysdate)";
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

		
		
}
