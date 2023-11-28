package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.UserDao;
import com.java.www.dto.UserDto;

public class U_LoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDao udao = new UserDao();
		UserDto udto = udao.uLogin(id,pw);
		
		session.setAttribute("session_id", udto.getU_id());
		session.setAttribute("session_nickname", udto.getU_nickname());

	}

}
