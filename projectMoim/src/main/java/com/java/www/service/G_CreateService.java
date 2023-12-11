package com.java.www.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dao.UserDao;
import com.java.www.dto.GroupDto;
import com.java.www.dto.UserDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class G_CreateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String upload = "c:/upload";
		int size = 10*1024*1024;
		String u_gId;
		GroupDao gdao = null;
		int uResult;
	
		try {
		MultipartRequest multi = new MultipartRequest(request,upload,size,"utf-8",new DefaultFileRenamePolicy());	
		//String g_id = (String)session.getAttribute("session_g_id");
		//String g_id = multi.getParameter("g_id");
		//session.setAttribute("session_g_id", g_id);
		//System.out.println("g_id: "+g_id);
		String g_name = multi.getParameter("g_name");
		String g_intro = multi.getParameter("g_intro");
		String g_content = multi.getParameter("g_content");
		String g_local = multi.getParameter("g_local");
		String g_category ="";
		String[] g_categorys = multi.getParameterValues("category");
		for(int i=0;i<g_categorys.length;i++) {
			if(i==0) g_category = g_categorys[i];
			else g_category += "," + g_categorys[i];
		}	
		String g_file = multi.getParameter("g_file");
		String g_user_id = (String) session.getAttribute("session_id");
		String g_member_id = (String) session.getAttribute("session_id");
		Enumeration files = multi.getFileNames();
		while(files.hasMoreElements()) {
			String f = (String) files.nextElement(); 
			String tempfile = multi.getFilesystemName(f); 
			if(tempfile !=null) g_file = tempfile;
		}
		
		GroupDto gdto = new GroupDto(g_name, g_intro, g_content, g_local, g_category, g_file, g_user_id, g_member_id);
		gdao = new GroupDao();
		int result = gdao.g_create(gdto);
		request.setAttribute("result", result);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//u_id 가입신청자id / g_id 가입하려는 모임id
		String u_id = (String) session.getAttribute("session_id");
		String g_id = gdao.selectG_id();
		
		//가입신청자id로 유저정보 불러오기
		UserDao udao = new UserDao();
		UserDto udto = udao.selectOne(u_id);
		
		//신청유저의 이전가입모임유무 구분 후 가입모임입력 정리
		if(udto.getG_id()==null) {
			u_gId = g_id;
		} else {
			u_gId = udto.getG_id()+","+g_id;
		}	
		//유저정보 가입모임에 갱신된 정보 입력
		uResult = udao.join(u_gId,u_id);
	}

}
