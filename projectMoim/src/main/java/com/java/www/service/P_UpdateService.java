package com.java.www.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class P_UpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//dao접근
		BoardDao bdao = new BoardDao();
		//변수선언 
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("session_id");
		String b_title="",b_content="",b_file="";
		int b_no=0;
		System.out.println("bfile:"+b_file);
		
		//form데이터 처리 MultiPart
		String upload = "c:/upload";
		int size = 10*1024*1024;
		try {
			MultipartRequest multi = new MultipartRequest(request, upload, size, "utf-8", new DefaultFileRenamePolicy());
			b_no = Integer.parseInt(multi.getParameter("b_no"));
			b_title = multi.getParameter("b_title");
			b_content = multi.getParameter("b_content");
			//파일 미첨부시 이전파일을 가져옴.
			b_file = multi.getParameter("oldfile");
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String f = (String) files.nextElement();
				String tempfile = multi.getFilesystemName(f);//똑같은 파일이 있을경우 이름을 변경해서 변경
				if(tempfile != null) b_file = tempfile;
			}
			BoardDto bdto = new BoardDto(b_no,b_title,b_content,id,b_file);
			int result = bdao.update(bdto);
			//request 추가
			request.setAttribute("result", result);
			
			
		}catch (IOException e) {e.printStackTrace();}

	}

}
