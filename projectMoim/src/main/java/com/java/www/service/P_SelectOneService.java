package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class P_SelectOneService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		
		//dao 접근
		BoardDao bdao = new BoardDao();
		BoardDto bdto = bdao.selectOne(b_no);
		System.out.println("P_SelectOneService : "+b_no);
		
		//request추가
		request.setAttribute("bdto", bdto);
	}

}
