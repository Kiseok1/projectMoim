package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.GroupDao;
import com.java.www.dto.GroupDto;

public class G_viewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String g_id = request.getParameter("g_id");
		
		GroupDao gdao = new GroupDao();
		GroupDto gdto = gdao.selectOne(g_id);
		
		request.setAttribute("gdto", gdto);

	}

}
