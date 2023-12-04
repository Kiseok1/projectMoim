package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dao.UserDao;
import com.java.www.dto.GroupDto;
import com.java.www.dto.UserDto;

public class G_joinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String g_member_id;
		String u_gId;
		int gResult=0,uResult=0;
		
		//u_id 가입신청자id / g_id 가입하려는 모임id
		String u_id = (String) session.getAttribute("session_id");
		String g_id = request.getParameter("g_id");
		
		//가입신청자id로 유저정보 불러오기
		UserDao udao = new UserDao();
		UserDto udto = udao.selectOne(u_id);
		
		//신청유저의 이전가입모임유무 구분 후 가입모임입력 정리
		if(udto.getG_id()==null) {
			u_gId = g_id;
		} else {
			u_gId = udto.getG_id()+","+g_id;
		}	

//		System.out.println(u_gId);
		
		//유저정보 가입모임에 갱신된 정보 입력
		uResult = udao.join(u_gId,u_id);

		//g_id로 모임정보 불러오기
		GroupDao gdao = new GroupDao();
		GroupDto gdto = gdao.selectOne(g_id);
		
		//불러온 모임정보의 가입멤버 추가
		g_member_id = gdto.getG_member_id()+","+u_id;
//		System.out.println(g_member_id);
		
		//모임정보 가입멤버에 갱신된 정보 입력
		gResult = gdao.join(g_member_id,g_id);
		
	}

}
