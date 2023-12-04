package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.MessageDao;
import com.java.www.dto.MessageDto;

public class M_selectPopService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		MessageDto mdto = null;
		
		MessageDao mdao = new MessageDao();
		//m_recv_read=1로 변경
		mdao.receiveDateCheck(m_no);
		//쪽지 내용 가져오기
		mdto = mdao.selectPop(m_no);
		
		request.setAttribute("mdto", mdto);

	}

}
