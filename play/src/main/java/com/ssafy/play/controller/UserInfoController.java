package com.ssafy.play.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.model.TokenSet;
import com.ssafy.play.model.UserInfo;
import com.ssafy.play.service.AuthService;
import com.ssafy.play.service.JwtService;
import com.ssafy.play.service.UserInfoService;
import com.ssafy.play.model.BasicResponse;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/account")
public class UserInfoController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private AuthService authService;
	
	@ApiOperation(value = "모든 회원 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<UserInfo>> selectUser() throws Exception {
		return new ResponseEntity<List<UserInfo>>(userInfoService.selectUserInfo(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "유저 회원가입 시 회원 정보를 등록한다.", response = String.class)
	@PostMapping("signup")
	public ResponseEntity<BasicResponse> insertUserInfo(@RequestBody UserInfo userinfo) {
	
		String password = userinfo.getPassword();
		userinfo.setPassword(password);
		
		if (userInfoService.insertUserInfo(userinfo) == 1) {
			BasicResponse result = new BasicResponse();
			result.status = true;
			result.data = "success";
			result.object = String.valueOf(userInfoService.getUserId(userinfo.getNickname()));
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		BasicResponse result = new BasicResponse();
		result.status = false;
		result.data = "fail";
		result.object = null;
		return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
	}

}
