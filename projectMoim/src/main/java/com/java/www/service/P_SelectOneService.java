package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class P_SelectOneService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		int page = Integer.parseInt(request.getParameter("page"));
		String category = request.getParameter("category");
		String sword = request.getParameter("sword");
		//dao 접근
		BoardDao bdao = new BoardDao();
		BoardDto bdto = bdao.selectOne(b_no);
		//파일이름 추출
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		BoardDto preDto = null;
		BoardDto nextDto = null;
		BoardDto hitDto = null;
		
		if(fileName.equals("/b_view.do")||fileName.equals("/b_freeview.do")) {
			preDto = bdao.preSelectOne(b_no);
			
			nextDto = bdao.nextSelectOne(b_no);
			//조회수 1증가
			bdao.hitPlus(b_no);
		}
		
		
		
		//request추가
		request.setAttribute("bdto", bdto);
		request.setAttribute("preDto", preDto);
		request.setAttribute("nextDto", nextDto);
		request.setAttribute("page", page);
		request.setAttribute("category", category);
		request.setAttribute("sword", sword);
	}

}
