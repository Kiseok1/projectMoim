package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.UserDao;
import com.java.www.dto.UserDto;

public class U_LoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id:"+id);
		//dao접근
		UserDao udao = new UserDao();
		UserDto udto = udao.uLogin(id,pw);
		
		if(udto!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("session_id", udto.getU_id());
			System.out.println("session_id : "+udto.getU_id());
			session.setAttribute("session_nicname", udto.getU_nicname());
			System.out.println("session_nicname : "+udto.getU_nicname());
			result = 1;
			
		}
		System.out.println("result :" +result);
		
		//request 추가
		request.setAttribute("result", result);
		

	}

}