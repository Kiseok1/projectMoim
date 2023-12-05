package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.MessageDao;
import com.java.www.dto.MessageDto;

public class M_insertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("session_id");
		String recv_id = request.getParameter("recvId");
		String mcontent = request.getParameter("mcontent");
		int result = 0;
		
		MessageDao mdao = new MessageDao();
		MessageDto mdto = new MessageDto(id, recv_id, mcontent);
		result = mdao.sendMessage(mdto);
		
		request.setAttribute("result", result);

	}

}
