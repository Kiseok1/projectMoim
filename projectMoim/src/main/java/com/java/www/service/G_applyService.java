package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.GroupDao;
import com.java.www.dao.MessageDao;

public class G_applyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("session_id");
		String g_id = request.getParameter("g_id");
		
		GroupDao gdao = new GroupDao();
		gdao.apply(g_id,u_id);
		
	}

}
