package com.java.www.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dto.GroupDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class G_UpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		//변수선언
		HttpSession session = request.getSession();
		String upload = "c:/upload";
		int size = 10*1024*1024;
	
		try {
		MultipartRequest multi = new MultipartRequest(request,upload,size,"utf-8",new DefaultFileRenamePolicy());	
		String g_id = (String)session.getAttribute("session_g_id");
		String g_name = multi.getParameter("g_name");
		String g_local = multi.getParameter("g_local");
		String g_intro = multi.getParameter("g_intro");
		String g_content = multi.getParameter("g_content");
		String g_file = multi.getParameter("g_file");
		String g_category ="";
		String[] g_categorys = request.getParameterValues("g_categorys");
		for(int i=0;i<g_categorys.length;i++) {
			if(i==0) g_category = g_categorys[i];
			else g_category += "," + g_categorys[i];
		}	
		int g_member_cnt = Integer.parseInt(multi.getParameter("g_member_cnt"));
		Enumeration files = multi.getFileNames();
		while(files.hasMoreElements()) {
			String f = (String) files.nextElement(); 
			String tempfile = multi.getFilesystemName(f); 
			if(tempfile !=null) g_file = tempfile;
		}
		
		
		
		GroupDto gdto = new GroupDto(g_id, g_name, g_intro, g_content,g_local, g_file, g_member_cnt,g_category);
		
		GroupDao gdao = new GroupDao();
		int result = gdao.g_Update(gdto);
		request.setAttribute("result", result);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
	

		
		
		
