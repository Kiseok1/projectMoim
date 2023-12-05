package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class P_listSelectService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//dao접근
		BoardDao bdao = new BoardDao();
		//검색부분
		String category = request.getParameter("category");
		String sword = request.getParameter("sword"); 
		//하단넘버링 필요 변수
		int rowPage = 10; // 1페이지당 게시글 
		int bottomPage = 10; //하단 넘버링 갯수
		int page = 1;
			if(request.getParameter("page")!=null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
		
		//검색된 게시글 개수
		int listCount = bdao.pListCount(category,sword);
		int maxPage = (int)Math.ceil((double)listCount/rowPage);
		int startPage = (int)((page-1)/bottomPage)*bottomPage +1;
		int endPage = startPage+bottomPage -1;
		if(endPage>maxPage) endPage=maxPage;
		int startRow = (page-1)*rowPage+1; //가져오는 게시글의 시작 b_no
		int endRow = startRow+rowPage-1; //가져오는 게시글의 마지막 b_no
		
		//전체 게시글 가져오기
		ArrayList<BoardDto> list =  bdao.p_listSelect(category,sword,startRow,endRow); 
		
		//request 추가 
		request.setAttribute("list", list);
		request.setAttribute("listCount", listCount);
		request.setAttribute("category", category);
		request.setAttribute("sword", sword);
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("maxPage", maxPage);
		
		
		
	}

}
