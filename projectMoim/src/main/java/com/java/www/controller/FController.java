package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.G_doSearchService;
import com.java.www.service.P_DeleteService;
import com.java.www.service.P_InsertService;
import com.java.www.service.P_ReplyService;
import com.java.www.service.P_SelectOneService;
import com.java.www.service.P_UpdateService;
import com.java.www.service.P_listSelectService;
import com.java.www.service.Service;
import com.java.www.service.U_LoginService;



@WebServlet("*.do")
public class FController extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		
		String url = null;
		Service service = null;
		
		//호출된 파일이름
		System.out.println("FController 파일 이름 :"+fileName);
		
		
		switch (fileName) {
		case "/main.do":
			response.sendRedirect("main.jsp");
			break;
		case "/b_insert.do":
			response.sendRedirect("b_insert.jsp");
			break;
		case "/g_search.do":
			service = new G_doSearchService();
			service.execute(request, response);
			url="g_search.jsp";
			break;
			//게시글 리스트 가져오기
		case "/b_list.do":
			service = new P_listSelectService();
			service.execute(request, response);
			url="b_list.jsp";
			break;		
		case "/b_view.do":
			service = new P_SelectOneService();
			service.execute(request, response);
			url="b_view.jsp";
			break;		
		case "/b_reply.do":
			service = new P_SelectOneService();
			service.execute(request, response);
			url="b_reply.jsp";
			break;		
		case "/do_Reply.do":
			service = new P_ReplyService();
			service.execute(request, response);
			url="do_Reply.jsp";
			break;
		case "/do_insert.do":
			service = new P_InsertService();
			service.execute(request, response);
			url="do_insert.jsp";
			break;
		case "/do_update.do":
			service = new P_UpdateService(); //아이디 사용 
			service.execute(request, response);
			url="do_update.jsp";
			break;		
		case "/u_login.do":
			response.sendRedirect("u_login.jsp");
			break;
		case "/dologin.do":
			service = new U_LoginService();
			service.execute(request, response);
			url="dologin.jsp";
			break;
		case "/do_Delete.do":
			service = new P_DeleteService();
			service.execute(request, response);
			url="do_Delete.jsp";
			break;
		case "/b_update.do":
			service = new P_SelectOneService();
			service.execute(request, response);
			url="b_update.jsp";
			break;		
		case "/u_logout.do":
			response.sendRedirect("u_logout.jsp");
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
