package com.ssafy.play.controller;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.model.BasicResponse;
import com.ssafy.play.model.User;
import com.ssafy.play.service.JwtService;
import com.ssafy.play.service.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/account",method= {RequestMethod.GET, RequestMethod.POST})
public class UserController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService UserService;

	@ApiOperation(value = "모든 회원 정보를 반환한다.", response = List.class)
	@GetMapping("all")
	public ResponseEntity<List<User>> selectUser() throws Exception {
		return new ResponseEntity<List<User>>(UserService.selectUser(), HttpStatus.OK);

	}

	@ApiOperation(value = "유저 회원가입 시 회원 정보를 등록한다.", response = String.class)
	@PostMapping("signup")
	public ResponseEntity<BasicResponse> insertUser(@RequestBody User user) {
		String password = user.getPassword();
		user.setPassword(password);

		if (UserService.insertUser(user) == 1) {
			BasicResponse result = new BasicResponse();
			result.status = true;
			result.data = "success";
			result.object = String.valueOf(UserService.getUserId(user.getNickname()));
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		BasicResponse result = new BasicResponse();
		result.status = false;
		result.data = "fail";
		result.object = null;
		return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/login")
	@ApiOperation(value = "로그인 성공/실패 여부를 반환한다")
	public ResponseEntity<Map<String, Object>> login(@RequestParam("nickname") String nickname,
			@RequestParam("password") String password, HttpServletResponse res) {
		Map<String, Object> resultMap = new HashMap<>();
		// 해당 이메일 회원 확인
		User user = UserService.searchByNickname(nickname);
		ResponseEntity response = null;

		if (user == null) { // 이메일이 없다면... 아이디 없음

			response = new ResponseEntity<>("ID not exist", HttpStatus.NOT_FOUND);
		} else {
			if (!user.getPassword().equals(password)) { // 비밀번호가 틀리다면 ..
				response = new ResponseEntity<>("Wrong Password", HttpStatus.NOT_FOUND);
			} else { // 이상 없음
				// 로그인에 성공햇다면 토큰 생성
				String token = jwtService.create(user);
				// 토큰 정보는 request의 헤더로 보내고 나머지는 Map에 담아주자
				res.setHeader("jwt-auth-token", token);
				resultMap.put("status", true);
				resultMap.put("data", user);
				response = new ResponseEntity<>(resultMap, HttpStatus.OK);
			}
		}

		return response;
	}

	@DeleteMapping("rm/{user_id}")
	@ApiOperation(value = "회원 삭제 후 성공/실패 여부를 반환다")

	public ResponseEntity<String> deleteUser(@PathVariable int user_id) {

		User user = UserService.searchById(user_id);
		ResponseEntity response = null;

		UserService.deleteUser(user.getId());
		response = new ResponseEntity<>("User delete success", HttpStatus.OK);
		return response;
	}

	@GetMapping("{user_id}")
	@ApiOperation(value = "해당 아이디의 회원정보를 반환한다")
	public ResponseEntity<User> searchById(@PathVariable int user_id) {
		User user = UserService.searchById(user_id);
		ResponseEntity response = new ResponseEntity<>(user, HttpStatus.OK);
		return response;
	}

	@ApiOperation(value = "유저 id에 해당하는 회원 정보를 수정한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> updateUser(@RequestBody User user, HttpServletRequest request) {
		User user2 = UserService.searchById(user.getId());

		if (user.getNickname() != null) {
			user2.setNickname(user.getNickname());
		}

		if (user.getEmail() != null) {
			user2.setEmail(user.getEmail());
		}

		if (user.getPassword() != null) {
			String password = user.getPassword(); // 입력받은 비밀번호
			user2.setPassword(password);
		}

		if (UserService.updateUser(user2) == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}	
		@GetMapping("/info")
		public ResponseEntity<Map<String,Object>> getInfo(HttpServletRequest req, @RequestParam("nickname") String nickname,HttpServletResponse res){
			
			Map<String,Object> resultMap = new HashMap<>();
			HttpStatus status = null;
			try {
				User user = UserService.searchByNickname(nickname);
				resultMap.put("status", true);
				resultMap.put("data", user);
				status = HttpStatus.OK;
			}catch(RuntimeException e) {
				resultMap.put("message", "실패");
				status = HttpStatus.NOT_FOUND;
			}
			return new ResponseEntity<Map<String,Object>>(resultMap, status);
		}

}
