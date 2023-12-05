package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.www.dto.MessageDto;
import com.java.www.dto.UserDto;

public class MessageDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MessageDto mdto = null;
	ArrayList<MessageDto> list = new ArrayList<MessageDto>();
	String m_sent_id,m_recv_id,m_note,query="";
	Timestamp m_date_sent,m_date_read;
	int m_no,m_recv_read,m_sent_del,m_recv_del,result;

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

	//메세지 보내기
	public int sendMessage(MessageDto mdto2) {
		try {
			conn=getConnection();
			query="insert into messages (m_no,m_sent_id,m_recv_id,m_note,m_date_sent,m_recv_read,m_sent_del,m_recv_del) "
					+ "values(messages_seq.nextval,?,?,?,sysdate,0,0,0)";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, mdto2.getM_sent_id());
			pstmt.setString(2, mdto2.getM_recv_id());
			pstmt.setString(3, mdto2.getM_note());
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

	//받은 쪽지함 정보확인
	public ArrayList<MessageDto> selectReceiveOne(String id) {
		try {
			conn=getConnection();
			query="select * from messages where m_recv_id=? and m_recv_del=0 order by m_no desc";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				m_no=rs.getInt("m_no");
				m_sent_id=rs.getString("m_sent_id");
				m_recv_id=rs.getString("m_recv_id");
				m_note=rs.getString("m_note");
				m_date_sent=rs.getTimestamp("m_date_sent");
				m_date_read=rs.getTimestamp("m_date_read");
				m_recv_read=rs.getInt("m_recv_read");
				m_sent_del=rs.getInt("m_sent_del");
				m_recv_del=rs.getInt("m_recv_del");
				
				list.add(new MessageDto(m_no, m_sent_id, m_recv_id, m_note, m_date_sent, m_date_read, m_recv_read, m_sent_del, m_recv_del));
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

	//보낸 편지함 불러오기
	public ArrayList<MessageDto> selectSendOne(String id) {
		try {
			conn=getConnection();
			query="select * from messages where m_sent_id=? and m_sent_del=0 order by m_no desc";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				m_no=rs.getInt("m_no");
				m_sent_id=rs.getString("m_sent_id");
				m_recv_id=rs.getString("m_recv_id");
				m_note=rs.getString("m_note");
				m_date_sent=rs.getTimestamp("m_date_sent");
				m_date_read=rs.getTimestamp("m_date_read");
				m_recv_read=rs.getInt("m_recv_read");
				m_sent_del=rs.getInt("m_sent_del");
				m_recv_del=rs.getInt("m_recv_del");
				
				list.add(new MessageDto(m_no, m_sent_id, m_recv_id, m_note, m_date_sent, m_date_read, m_recv_read, m_sent_del, m_recv_del));
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

	//popup msg 불러오기
	public MessageDto selectPop(int m_no2) {
		try {
			conn=getConnection();
			query="select * from messages where m_no=? order by m_no desc";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, m_no2);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				m_no=rs.getInt("m_no");
				m_sent_id=rs.getString("m_sent_id");
				m_recv_id=rs.getString("m_recv_id");
				m_note=rs.getString("m_note");
				m_date_sent=rs.getTimestamp("m_date_sent");
				m_date_read=rs.getTimestamp("m_date_read");
				m_recv_read=rs.getInt("m_recv_read");
				m_sent_del=rs.getInt("m_sent_del");
				m_recv_del=rs.getInt("m_recv_del");
				
				mdto= new MessageDto(m_no, m_sent_id, m_recv_id, m_note, m_date_sent, m_date_read, m_recv_read, m_sent_del, m_recv_del);
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
		return mdto;
	}//selectPop

	//읽은 시간 체크
	public void receiveDateCheck(int m_no2) {
		try {
			conn=getConnection();
			query="update messages set m_recv_read=1, m_date_read=sysdate where m_no=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, m_no2);
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
	}//receiveDateCheck

	//받은 쪽지함 삭제
	public void delRecvMsg(String m_no2) {
		try {
			conn=getConnection();
			query="update messages set m_recv_del=1 where m_no=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, m_no2);
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
	}//delRecvMsg

	//보낸 쪽지함 삭제
	public void delSentMsg(String m_no2) {
		try {
			conn=getConnection();
			query="update messages set m_sent_del=1 where m_no=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, m_no2);
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
	}//delSentMsg

	
	
	
	
}
