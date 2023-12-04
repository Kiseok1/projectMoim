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
		String[] categorys = request.getParameterValues("category");
		String category = null;
		UserDao udao = new UserDao();
		UserDto udto = null;
		
		//로그인 확인
		if(session.getAttribute("session_id")!=null) {
			id = (String) session.getAttribute("session_id");
		}
		
		//검색/필터 정보 입력
		if(categorys!=null) {
			for(int i=0;i<categorys.length;i++) {
				if(i==0) category=categorys[i];
				else category += ","+categorys[i];
			}
		}
		local = request.getParameter("local");
		search=request.getParameter("g_srch");
		
		//로그인시
		if(id!=null) {
			//받아온 아이디로 유저정보 불러오기
			udto = udao.selectOne(id);
			//검색 혹은 필터를 사용하지 않았으면 유저지역과 유저관심 카테고리 입력
			//검색 혹은 필터를 사용했다면 건너뛰기(검색/필터 정보 유지)
			if(search==null&&local==null&&category==null) {
				local=udto.getU_local();
				category=udto.getU_category();
			}
		} 
		
//		System.out.println("service search : "+search);
//		System.out.println("service local : "+local);
//		System.out.println("service category : "+category);
		
		//검색 모임 혹은 유저정보관련 모임 불러오기
		GroupDao gdao = new GroupDao();
		ArrayList<GroupDto> list = gdao.selectSearch(search,local,category);
		
		request.setAttribute("list", list);
		

	}

}
