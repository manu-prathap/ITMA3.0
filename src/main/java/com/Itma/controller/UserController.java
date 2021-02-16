package com.Itma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Itma.model.UserDao;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserDao userDao;
	
	
	
	@RequestMapping("/")
	public String submit() {
		
		
		userDao.createUser();
		
		return "user/userRegister";
	}
	
	
}
