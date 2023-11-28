package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.G_MainService;
import com.java.www.service.G_doSearchService;
import com.java.www.service.G_joinService;
import com.java.www.service.G_quitService;
import com.java.www.service.G_viewService;
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
