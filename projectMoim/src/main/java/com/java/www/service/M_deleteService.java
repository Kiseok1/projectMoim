package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.MessageDao;

public class M_deleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		
		String[] m_nos=request.getParameterValues("m_no");
		String m_no = "";
		MessageDao mdao = new MessageDao();
		
		switch (fileName) {
		case "/m_delRecv.do":
			for(int i=0;i<m_nos.length;i++) {
				m_no=m_nos[i];
				mdao.delRecvMsg(m_no);
			}
			
			break;
		case "/m_delSent.do":
			for(int i=0;i<m_nos.length;i++) {
				m_no=m_nos[i];
				mdao.delSentMsg(m_no);
			}
			
			break;
		}//switch

	}//execute

}
