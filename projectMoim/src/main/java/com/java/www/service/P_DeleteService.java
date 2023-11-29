package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;

public class P_DeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//dao 접근
		BoardDao bdao = new BoardDao();
		//변수선언
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		//메소드 호출
		int result = bdao.delete(b_no);
		//request추가
		request.setAttribute("result", result);
	}   
	

}
