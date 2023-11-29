package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dao.UserDao;
import com.java.www.dto.GroupDto;
import com.java.www.dto.UserDto;

public class G_viewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String g_id = request.getParameter("g_id");
		
		
		GroupDao gdao = new GroupDao();
		GroupDto gdto = gdao.selectOne(g_id);
		
		if(session.getAttribute("session_id")!=null) {
			String id = (String) session.getAttribute("session_id"); 
			UserDao udao = new UserDao();
			UserDto udto = udao.selectOne(id);
			
			request.setAttribute("udto", udto);
		}
		
		request.setAttribute("gdto", gdto);
		

	}

}
