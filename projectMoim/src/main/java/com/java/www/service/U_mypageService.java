package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dao.UserDao;
import com.java.www.dto.GroupDto;
import com.java.www.dto.UserDto;

public class U_mypageService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("session_id");
		String g_id="";
		String[] g_ids=null;
		ArrayList<GroupDto> list = new ArrayList<GroupDto>();
		
		UserDao udao = new UserDao();
		UserDto udto = udao.selectOne(id);
		
		if(udto.getG_id()!=null) {
			g_id=udto.getG_id();
			g_ids=g_id.split(",");
			
			GroupDao gdao = new GroupDao();
			list = gdao.selectJoinGroup(g_ids);
		}
		
		
		request.setAttribute("list", list);
		request.setAttribute("udto", udto);

	}

}
