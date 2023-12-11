package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.GroupDao;
import com.java.www.dto.GroupDto;

public class GselectService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		GroupDao gdao = new GroupDao();
		ArrayList<GroupDto> list = gdao.selectAll();
		
		request.setAttribute("list", list);

	}

}