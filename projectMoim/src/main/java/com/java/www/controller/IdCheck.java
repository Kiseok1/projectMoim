package com.java.www.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.java.www.service.UIdCheckService;


@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//전달받은 데이터
		String id = request.getParameter("id");
		
		
		System.out.println("id : "+id);
		
		
		//service idCheck호출 - id를 보내서 중복체크 확인을 함.
		UIdCheckService ucs = new UIdCheckService();
		int result = ucs.idCheck(id);
		
		//json으로 타입 변경
		JSONArray jArray = new JSONArray(); //json배열
		JSONObject jObj = new JSONObject(); //json배열안에 객체추가
		jObj.put("result", result);
		jArray.add(jObj);
		
		
		//------------
		//response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(jArray);
		
		
		
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
