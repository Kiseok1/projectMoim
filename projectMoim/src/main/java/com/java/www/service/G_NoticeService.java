package com.java.www.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dto.GroupDto;
import com.java.www.dto.NoticeDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class G_NoticeService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int l_bno = 0;
		String l_title="",l_content="",l_file=""; 
		
		String upload = "c:/upload";
		int size = 10*1024*1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(request,upload,size,"utf-8",new DefaultFileRenamePolicy());
			l_title = multi.getParameter("l_title");
			System.out.println("l_title: "+l_title);
			l_content = multi.getParameter("l_content");
			System.out.println("l_content: "+l_content);
			Enumeration files = multi.getFileNames(); 
			while(files.hasMoreElements()) {
				String f = (String) files.nextElement();
				l_file = multi.getFilesystemName(f); 
			}
			l_bno = Integer.parseInt(request.getParameter("l_bno"));
			System.out.println("l_bno: "+l_bno);
			
			
			NoticeDto ndto = new NoticeDto(l_title,l_content,l_file,l_bno);
			GroupDao gdao = new GroupDao();
			int result = gdao.NselectOne(l_bno);
		
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			

	}

}
