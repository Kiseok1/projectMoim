package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dao.UserDao;
import com.java.www.dto.GroupDto;
import com.java.www.dto.UserDto;

public class G_approveConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		String[] a_nos = request.getParameterValues("a_no");
		String[] u_ids = request.getParameterValues("u_id");
		String g_member_id;
		String u_gId;
		String[] g_ids = request.getParameterValues("g_id");
		int gResult=0,uResult=0;
		
		GroupDao gdao = new GroupDao();
		UserDao udao = new UserDao();
		
		for(int i=0;i<a_nos.length;i++) {
			//db approves status 1로 변경
			gdao.approveConfirm(a_nos[i]);
			
			//가입신청자id로 유저정보 불러오기
			udao = new UserDao();
			UserDto udto = udao.selectOne(u_ids[i]);
			
			//신청유저의 이전가입모임유무 구분 후 가입모임입력 정리
			if(udto.getG_id()==null) {
				u_gId = g_ids[i];
			} else {
				u_gId = udto.getG_id()+","+g_ids[i];
			}
			
			//유저정보 가입모임에 갱신된 정보 입력
			uResult = udao.join(u_gId,u_ids[i]);

			//g_id로 모임정보 불러오기
			gdao = new GroupDao();
			GroupDto gdto = gdao.selectOne(g_ids[i]);
			
			//불러온 모임정보의 가입멤버 추가
			g_member_id = gdto.getG_member_id()+","+u_ids[i];
//			System.out.println(g_member_id);
			
			//모임정보 가입멤버에 갱신된 정보 입력
			gResult = gdao.join(g_member_id,g_ids[i]);
			
		}//for

	}

}
