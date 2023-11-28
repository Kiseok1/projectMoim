package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dao.UserDao;
import com.java.www.dto.GroupDto;
import com.java.www.dto.UserDto;

public class G_quitService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String g_id=request.getParameter("g_id");
		String u_id = (String) session.getAttribute("session_id");
		UserDao udao = new UserDao();
		GroupDao gdao = new GroupDao();
		String g_member_id;
		String u_gId;
		String[] member_id = null;
		String[] u_gIds = null;
		int gResult=0,uResult=0;
		
		
		//모임에서 가입자id 가져오기
		GroupDto gdto = gdao.selectOne(g_id);
		g_member_id=gdto.getG_member_id();
		
		//가입자id 스플릿으로 분리
		member_id=g_member_id.split(",");
		
		//탈퇴자 분리
		g_member_id="";
		for(int i=0;i<member_id.length;i++) {
			if(member_id[i]!=u_id && g_member_id=="" ) 
				g_member_id=member_id[i];
			else if (member_id[i]!=u_id && g_member_id!="") {
				g_member_id += ","+member_id[i];
			}
			
			System.out.println(g_member_id);
		}//for
		
		//db에 수정된 member_id 저장
		gResult=gdao.quitGroup(g_member_id,g_id);
		
		
		//user 정보에서 g_id 가져오기
		UserDto udto = udao.selectOne(u_id);
		u_gId=udto.getG_id();
		
		//u_gid 스플릿으로 분리
		u_gIds=u_gId.split(",");
		
		//탈퇴모임 분리
		u_gId="";
		for(int i=0;i<u_gIds.length;i++) {
			if(u_gIds[i]!=g_id) {
				if(u_gId=="") u_gId=u_gIds[i];
				else u_gId += ","+u_gIds[i];
			}
		}//for

		//db에 수정된 g_id 저장
		uResult=udao.quitGroup(u_gId,u_id);
	}

}
