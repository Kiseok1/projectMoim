package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dao.UserDao;
import com.java.www.dto.ApproveDto;
import com.java.www.dto.GroupDto;
import com.java.www.dto.UserDto;

public class G_viewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id;
		int status=1;
		String g_id = request.getParameter("g_id");
		UserDao udao = new UserDao();
		ArrayList<UserDto> list = new ArrayList<UserDto>();
		
		GroupDao gdao = new GroupDao();
		GroupDto gdto = gdao.selectOne(g_id);
		
		if(session.getAttribute("session_id")!=null) {
			id = (String) session.getAttribute("session_id"); 
			UserDto udto = udao.selectOne(id);
			
			request.setAttribute("udto", udto);
			
			status = gdao.selectApproveStatus(id, g_id);
			request.setAttribute("status", status);
		}
		
		String joinUser = gdto.getG_member_id();
		String[] joinUsers = joinUser.split(",");
		list = udao.selectJoinUser(joinUsers);
		
		String admin = gdto.getG_user_id();
		
		
		
		request.setAttribute("gdto", gdto);
		request.setAttribute("list", list);
		request.setAttribute("admin", admin);

	}

}
