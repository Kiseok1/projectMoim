package com.java.www.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.UserDao;
import com.java.www.dto.UserDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class U_insertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String u_id,u_pw,u_nickname,u_profileImg="",u_email,u_local,u_category="";
		String[] u_categorys = null;
		int result=0;
		UserDto udto = null;
		String uPath = "c:/upload";
		int size = 2*1024*1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uPath, size, "utf-8", new DefaultFileRenamePolicy());
			u_id=multi.getParameter("id");
			u_pw=multi.getParameter("pw");
			u_nickname=multi.getParameter("nickname");
			u_email=multi.getParameter("email");
			u_local=multi.getParameter("local");
			u_categorys=multi.getParameterValues("category");
			for(int i=0;i<u_categorys.length;i++) {
				if(i==0) u_category=u_categorys[i];
				else u_category+= ","+u_categorys[i];
			}
			
			Enumeration files = multi.getFileNames();
			if(files.hasMoreElements()) {
				String f = (String) files.nextElement();
				u_profileImg = multi.getFilesystemName(f);
			}
			
			udto = new UserDto(u_id, u_pw, u_nickname, u_email, u_category, u_local, u_profileImg);
			UserDao udao = new UserDao();
			result = udao.insert(udto);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
