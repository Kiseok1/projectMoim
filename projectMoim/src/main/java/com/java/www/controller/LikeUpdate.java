package com.java.www.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.service.LikeUpdateService;
import com.java.www.service.Service;


@WebServlet("/LikeUpdate")
public class LikeUpdate extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("session_id");
		int g_id = Integer.parseInt(request.getParameter("g_id"));
		int like_status= Integer.parseInt(request.getParameter("like_status"));
		System.out.println("u_id : "+u_id);
		LikeUpdateService service = new LikeUpdateService();
		int likeCount = service.likeUpdate(u_id,g_id,like_status);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(likeCount);
		writer.close();
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
