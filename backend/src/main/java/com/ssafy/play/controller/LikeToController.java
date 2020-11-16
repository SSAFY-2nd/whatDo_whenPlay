package com.ssafy.play.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.model.LikeTo;
import com.ssafy.play.service.LikeToService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/liketo", method= {RequestMethod.POST})
public class LikeToController {

	@Autowired
	private LikeToService likeService;

	@ApiOperation(value = "즐겨찾기 추가", response = String.class)
	@PostMapping("create")
	public ResponseEntity<String> createLiketo(@RequestBody LikeTo liketo) {
		if (likeService.createLiketo(liketo) == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "즐겨찾기를 삭제한다.", response = String.class)
	@DeleteMapping
	public ResponseEntity<String> deleteLiketo(@RequestParam int user_id, @RequestParam int store_id) {
		if (likeService.deleteLiketo(user_id, store_id) == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}

}