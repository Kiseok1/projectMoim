package com.java.www.service;

import com.java.www.dao.UserDao;
import com.java.www.dto.UserDto;

public class UIdCheckService {

	public int idCheck(String id) {
		int result=0;
		//dao접근
		UserDao udao = new UserDao();
		UserDto udto = udao.idCheck(id);
		
		//id 존재하지 않으면 1, 존재하면 0
		if(udto == null) result=1;
		
		return result;
	}
}
