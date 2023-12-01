package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.G_CreateService;
import com.java.www.service.G_UpdateService;
import com.java.www.service.G_doSearchService;
import com.java.www.service.GselectOneService;
import com.java.www.service.Service;



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
		case "/g_create.do":
			service = new G_CreateService();
			service.execute(request, response);
			url = "g_create.jsp";
			break;
		case "/doG_create.do": 
			service = new G_CreateService();
			service.execute(request, response);
			url = "doG_create.jsp";
			break;
		case "/g_update.do":
			service = new G_UpdateService();
			service.execute(request, response);
			url = "g_update.jsp";
			break;
		case "/doG_update.do": 
			service = new G_UpdateService();
			service.execute(request, response);
			url = "doG_update.jsp";
			break;
		/*
		 * case "/doG_info.input.do"://회원정보1개가져오기 service = new GselectOneService();
		 * service.execute(request, response); url = "doG_info.input.do"; break;
		 */
		case "/u_login.do":
			response.sendRedirect("u_login.jsp");
			break;
		case "/g_search.do":
			service = new G_doSearchService();
			service.execute(request, response);
			url="g_search.jsp";
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
