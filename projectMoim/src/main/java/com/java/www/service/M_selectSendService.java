package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.MessageDao;
import com.java.www.dto.MessageDto;

public class M_selectSendService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id=(String) session.getAttribute("session_id");
		System.out.println("id : "+id);
		
		MessageDao mdao = new MessageDao();
		ArrayList<MessageDto> list = mdao.selectSendOne(id);
		
		request.setAttribute("list", list);

	}

}
