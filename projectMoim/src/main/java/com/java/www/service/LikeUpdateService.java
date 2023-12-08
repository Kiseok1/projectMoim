package com.java.www.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.java.www.dao.GroupDao;
import com.java.www.dto.GroupDto;

public class LikeUpdateService {

	public int likeUpdate(String u_id, int g_id, int like_status) {
		GroupDao gdao= new GroupDao();
		
		int likeCount = gdao.likeStatusUpdate(u_id, g_id, like_status);
		return likeCount;
	}

	

}
