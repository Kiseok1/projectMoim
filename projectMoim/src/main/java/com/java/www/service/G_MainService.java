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
		String[] categorys = null;
		String category = null;
		UserDao udao = new UserDao();
		UserDto udto = null;
		
		if(session.getAttribute("session_id")!=null) {
			id = (String) session.getAttribute("session_id");
		}
		//로그인시
		if(id!=null) {
			udto = udao.selectOne(id);
			
			if(request.getParameter("g_srch")!="" && request.getParameter("g_srch")!=null) {
				search = request.getParameter("g_srch"); //검색어 있을 경우 : 검색어 / 없을 경우 : null
				System.out.println("service : "+search);
			} 
			
			//필터 나중에 구현
//			if(request.getParameter("local")!=null) {
//				local = request.getParameter("local"); //필터local이 있을 경우 : 검색한 지역
//			} else {
//				local = udto.getU_local();             //필터local이 null일 경우 : 회원정보 지역
//			}
//			
//			if(request.getParameter("category")!=null) {
//				
//				category = request.getParameter("category"); //필터category 있을 경우 : 검색한 카테고리
//			} else {
//				
//				category = udto.getU_category();             //필터category null일 경우 : 회원정보 카테고리
//			}
		} else {  //로그아웃된 상황
			search = request.getParameter("g_srch");   
			
			
				
//			local = request.getParameter("local");
//			category = request.getParameter("category");
		}
		
		
//		System.out.println("service : "+search);
//		System.out.println("service : "+local);
//		System.out.println("service : "+category);
		
		
		GroupDao gdao = new GroupDao();
		ArrayList<GroupDto> list = gdao.selectSearch(search,local,category);
		
		request.setAttribute("list", list);
		

	}

}
