package com.ssafy.play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.service.UserInfoService;


@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/account")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	
}
