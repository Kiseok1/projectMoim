package com.java.www.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class P_InsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//dao 접근
		BoardDao bdao = new BoardDao();
		//변수선언
		String b_title="", b_content="", b_file="";
		//form데이터 처리 Multipart
		String upload = "c:/upload";
		int size = 10*1024*1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, upload,size,"utf-8",new DefaultFileRenamePolicy());
			b_title = multi.getParameter("b_title");
			b_content = multi.getParameter("b_content");
			//input type=file인것 이름 모두를 가져옴.
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String f = (String) files.nextElement();
				b_file = multi.getParameter(f);
			}
			BoardDto bdto = new BoardDto(b_title, b_content,b_file);
			//dao 접근 - 게시글 저장 메소드 호출
			int result = bdao.insert(bdto);
			//request 추가
			request.setAttribute("result", result);
			
		} catch (Exception e) {e.printStackTrace();}
		
	}

}