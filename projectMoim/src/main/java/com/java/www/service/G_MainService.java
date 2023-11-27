package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dao.UserDao;
import com.java.www.dto.GroupDto;
import com.java.www.dto.UserDto;

public class G_MainService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id=null;
		String search = null;
		String local = null;
		String category = null;
		UserDao udao = new UserDao();
		UserDto udto = null;
		
		if(session.getAttribute("session_id")!=null) {
			id = (String) session.getAttribute("session_id");
		}
		//로그인시
		if(id!=null) {
			udto = udao.selectOne(id);
			
			if(request.getParameter("g_srch")!=null) {
				search = request.getParameter("g_srch");
			}
			
			if(request.getParameter("local")!=null) {
				local = request.getParameter("local");
			} else {
				local = udto.getU_local();
			}
			
			if(request.getParameter("category")!=null) {
				category = request.getParameter("category");
			} else {
				category = udto.getU_category();
			}
		} else {
			search = request.getParameter("g_srch");
			if(request.getParameter("g_srch").equals("검색어를 입력하세요")) {
				search=null;
			}
			local = request.getParameter("local");
			category = request.getParameter("category");
		}
		System.out.println("service : "+local);
		System.out.println("service : "+category);
		
		
		GroupDao gdao = new GroupDao();
		ArrayList<GroupDto> list = gdao.selectSearch(search,local,category);
		
		request.setAttribute("list", list);
		

	}

}
