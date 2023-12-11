package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.java.www.service.G_MainService;
import com.java.www.service.G_NoticeService;
import com.java.www.service.G_applyService;
import com.java.www.service.G_approveConfirmService;
import com.java.www.service.G_approveSelectService;

import com.java.www.service.G_CreateService;
import com.java.www.service.G_UpdateService;

import com.java.www.service.G_doSearchService;



import com.java.www.service.G_joinService;
import com.java.www.service.G_quitService;
import com.java.www.service.G_viewService;
import com.java.www.service.M_deleteService;
import com.java.www.service.M_insertService;
import com.java.www.service.M_selectPopService;
import com.java.www.service.M_selectRecieveService;
import com.java.www.service.M_selectSendService;

import com.java.www.service.P_DeleteService;
import com.java.www.service.P_InsertService;
import com.java.www.service.P_ReplyService;
import com.java.www.service.P_SelectOneService;
import com.java.www.service.P_UpdateService;
import com.java.www.service.P_freelistSelectService;
import com.java.www.service.P_listSelectService;



import com.java.www.service.GselectOneService;
import com.java.www.service.GselectService;

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
		
		//호출된 파일이름
		System.out.println("FController 파일 이름 :"+fileName);
		
		
		switch (fileName) {
		case "/main.do":
			response.sendRedirect("main.jsp");
			break;
		case "/b_insert.do":
			response.sendRedirect("b_insert.jsp");
			break;
		case "/b_freeinsert.do":
			response.sendRedirect("b_freeinsert.jsp");
			break;
		case "/b_notice.do":
			response.sendRedirect("b_notice.jsp");
			break;
		case "/dologin.do":
			service = new U_LoginService();
			service.execute(request, response);
			url="dologin.jsp";
			break;		
		case "/do_notice.do":
			service = new P_InsertService();
			service.execute(request, response);
			url="do_notice.jsp";
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
		case "/g_apply.do":
			service = new G_applyService();
			service.execute(request, response);
			url="g_apply.jsp";
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
		case "/g_approveConfirm.do":
			service = new G_approveConfirmService();
			service.execute(request, response);
			url="g_approveConfirm.jsp";
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
			//게시글 리스트 가져오기
		case "/b_list.do":
			service = new P_listSelectService();
			service.execute(request, response);
			url="b_list.jsp";
			break;		
		case "/b_freelist.do":
			service = new P_freelistSelectService();
			service.execute(request, response);
			url="b_freelist.jsp";
			break;		
		case "/b_view.do":
			service = new P_SelectOneService();
			service.execute(request, response);
			url="b_view.jsp";
			break;		
		case "/b_freeview.do":
			service = new P_SelectOneService();
			service.execute(request, response);
			url="b_freeview.jsp";
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
			System.out.println("Fcontroller g_id :"+request.getParameter("g_id"));
			service = new P_InsertService();
			service.execute(request, response);
			url="do_insert.jsp";
			break;
		case "/do_freeinsert.do":
			service = new P_InsertService();
			service.execute(request, response);
			url="do_freeinsert.jsp";
			break;
		case "/do_update.do":
			service = new P_UpdateService(); //아이디 사용 
			service.execute(request, response);
			url="do_update.jsp";
			break;		
		case "/do_freeupdate.do":
			service = new P_UpdateService(); //아이디 사용 
			service.execute(request, response);
			url="do_freeupdate.jsp";
			break;		
		case "/g_create.do":
			url = "g_create.jsp";
			break;
		case "/doG_create.do": 
			service = new G_CreateService();
			service.execute(request, response);
			url = "doG_create.jsp";
			break;
		case "/g_update.do":
			service = new GselectOneService();
			service.execute(request, response);
			url = "g_update.jsp";
			break;
		case "/doG_update.do":
			service = new G_UpdateService();
			service.execute(request, response);
			url = "doG_update.jsp";
			break;
		case "/g_notice.do":
			service = new G_NoticeService();
			service.execute(request, response);
			url = "g_notice.jsp";
			break;

		case "/u_login.do":
			response.sendRedirect("u_login.jsp");
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
		case "/b_freeupdate.do":
			service = new P_SelectOneService();
			service.execute(request, response);
			url="b_freeupdate.jsp";
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
