package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.GroupDao;
import com.java.www.dto.ApproveDto;

public class G_approveSelectService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String g_id = request.getParameter("g_id");
		
		//승인 대기중인 유저 불러오기
		GroupDao gdao= new GroupDao();
		ArrayList<ApproveDto> listA = gdao.approveSelect(g_id);
		
		//request에 추가
		request.setAttribute("listA", listA);

	}

}
