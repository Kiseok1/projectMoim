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
		HttpSession session = request.getSession();
		String b_title="", b_content="", b_file="";
		String id = (String)session.getAttribute("session_id");
		String nicname = (String)session.getAttribute("session_nicname");
		//form데이터 처리 Multipart
		String upload = "c:/upload";
		int size = 10*1024*1024;
		int result = 0;
		//그룹별 분류 변수
		String g_id = (String)session.getAttribute("session_gid");
		System.out.println("insert service : "+g_id);
		//파일이름 추출
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		
		try {
			MultipartRequest multi = new MultipartRequest(request, upload,size,"utf-8",new DefaultFileRenamePolicy());
			b_title = multi.getParameter("b_title");
			b_content = multi.getParameter("b_content");
			//input type=file인것 이름 모두를 가져옴.
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String f = (String) files.nextElement();
				b_file = multi.getFilesystemName(f);
				System.out.println("service bfile : "+b_file);
			}
			BoardDto bdto = new BoardDto(b_title,b_content,nicname,id,b_file,g_id);
			//dao 접근 - 게시글 저장 메소드 호출
	if(fileName.equals("/do_freeinsert.do")) {
				result = bdao.freeinsert(bdto);
			}else {
				result = bdao.insert(bdto);
			}

			//request 추가
			request.setAttribute("result", result);
			System.out.println("리턴받은 result의 값 :"+result);
		} catch (Exception e) {e.printStackTrace();}
		
	}

}
