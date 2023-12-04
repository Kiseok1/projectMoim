package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.G_MainService;
import com.java.www.service.G_approveSelectService;
import com.java.www.service.G_doSearchService;
import com.java.www.service.G_joinService;
import com.java.www.service.G_quitService;
import com.java.www.service.G_viewService;
import com.java.www.service.M_deleteService;
import com.java.www.service.M_insertService;
import com.java.www.service.M_selectPopService;
import com.java.www.service.M_selectRecieveService;
import com.java.www.service.M_selectSendService;
import com.java.www.service.Service;
import com.java.www.service.U_LoginService;
import com.java.www.service.U_insertService;
import com.java.www.service.U_mypageService;
import com.java.www.service.U_selectOneService;



@WebServlet("*.do")
public class FController extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		System.out.println(fileName);
		
		String url = null;
		Service service = null;
		
		switch (fileName) {
		case "/main.do":
			response.sendRedirect("main.jsp");
			break;
		case "/u_login.do":
			response.sendRedirect("u_login.jsp");
			break;
		case "/dologin.do":
			service = new U_LoginService();
			service.execute(request, response);
			url="dologin.jsp";
			break;		
		case "/u_logout.do":
			response.sendRedirect("u_logout.jsp");
			break;
		case "/u_insert.do":
			response.sendRedirect("u_insert.jsp");
			break;
		case "/g_main.do":
			service = new G_MainService();
			service.execute(request, response);
			url="g_main.jsp";
			break;		
		case "/g_view.do":
			service = new G_viewService();
			service.execute(request, response);
			url="g_view.jsp";
			break;		
		case "/g_join.do":
			service = new G_joinService();
			service.execute(request, response);
			url="g_join.jsp";
			break;		
		case "/g_quit.do":
			service = new G_quitService();
			service.execute(request, response);
			url="g_quit.jsp";
			break;		
		case "/g_admin.do":
			service = new G_viewService();
			service.execute(request, response);
			url="g_admin.jsp";
			break;		
		case "/g_approve.do":
			service = new G_approveSelectService();
			service.execute(request, response);
			url="g_approve.jsp";
			break;		
		case "/u_mypage.do":
			service = new U_mypageService();
			service.execute(request, response);
			url="u_mypage.jsp";
			break;		
		case "/u_DoInsert.do":
			service = new U_insertService();
			service.execute(request, response);
			url="u_DoInsert.jsp";
			break;		
		case "/u_update.do":
			service = new U_selectOneService();
			service.execute(request, response);
			url="u_update.jsp";
			break;		
		case "/u_message.do":
			service = new U_selectOneService();
			service.execute(request, response);
			url="u_message.jsp";
			break;		
		case "/m_Insert.do":
			service = new M_insertService();
			service.execute(request, response);
			url="m_Insert.jsp";
			break;		
		case "/m_recvMsg.do":
			service = new M_selectRecieveService();
			service.execute(request, response);
			url="m_recvMsg.jsp";
			break;		
		case "/m_recvMsgPop.do":
			service = new M_selectPopService();
			service.execute(request, response);
			url="m_recvMsgPop.jsp";
			break;		
		case "/m_sentMsg.do":
			service = new M_selectSendService();
			service.execute(request, response);
			url="m_sentMsg.jsp";
			break;		
		case "/m_sentMsgPop.do":
			service = new M_selectPopService();
			service.execute(request, response);
			url="m_sentMsgPop.jsp";
			break;		
		case "/m_write.do":
			url="m_write.jsp";
			break;		
		case "/m_delRecv.do":
			service = new M_deleteService();
			service.execute(request, response);
			url="m_recvMsg.do";
			break;		
		case "/m_delSent.do":
			service = new M_deleteService();
			service.execute(request, response);
			url="m_sentMsg.do";
			break;		
		
		}
		
		if(url != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}

}
