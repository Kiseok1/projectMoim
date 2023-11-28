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
		String u_id = (String) session.getAttribute("session_id");
		String g_member_id;
		String u_gId;
		String g_id = request.getParameter("g_id");
		int gResult=0,uResult=0;
		
		UserDao udao = new UserDao();
		UserDto udto = udao.selectOne(u_id);
		u_gId = udto.getG_id()+","+g_id;
		System.out.println(u_gId);
		uResult = udao.join(u_gId,u_id);

		GroupDao gdao = new GroupDao();
		GroupDto gdto = gdao.selectOne(g_id);
		g_member_id = gdto.getG_member_id()+","+u_id;
		System.out.println(g_member_id);
		gResult = gdao.join(g_member_id,g_id);
		
	}

}
