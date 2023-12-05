package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.UserDao;
import com.java.www.dto.UserDto;

public class U_selectOneService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id= (String) session.getAttribute("session_id");
		
		UserDao udao = new UserDao();
		UserDto udto = udao.selectOne(id);
		
		request.setAttribute("udto", udto);

	}

}
