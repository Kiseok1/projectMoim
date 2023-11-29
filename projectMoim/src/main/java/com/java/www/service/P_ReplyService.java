package com.java.www.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class P_ReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//dao접근
		BoardDao bdao = new BoardDao();
		//변수선언
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("session_id");
		String nicname = (String)session.getAttribute("session_nicname");
		String b_title ="",b_content="",b_file="";
		int b_group=0,b_step=0,b_indent=0;
		//form 데이터 처리 MultiPart
		String upload = "c:/upload";
		int size = 10*1024*1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, upload, size,"utf-8",new DefaultFileRenamePolicy());
			b_title = multi.getParameter("b_title");
			b_content = multi.getParameter("b_content");
			b_group = Integer.parseInt(multi.getParameter("b_group"));
			b_step = Integer.parseInt(multi.getParameter("b_step"));
			b_indent = Integer.parseInt(multi.getParameter("b_indent"));
			//input type = file인것 이름 모두를 가져옴.
			Enumeration files = multi.getFileNames();
			while (files.hasMoreElements()) {
				String f = (String) files.nextElement();
				b_file = multi.getFilesystemName(f);
				
			}
			BoardDto bdto = new BoardDto(b_title,b_content,nicname,id,b_group,b_step,b_indent,b_file);
			//dao 접근 - 게시글 저장 메소드 호출
			//1. bstep 큰수들을 1씩 증가
			bdao.stepUp(b_group,b_step);
			//답글 달기 저장
			int result = bdao.replyInsert(bdto);
			//request 추가
			request.setAttribute("result", result);
			
			
		}catch (Exception e) {e.printStackTrace();}

	}

}
