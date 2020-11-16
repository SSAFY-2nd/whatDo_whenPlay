package com.ssafy.play.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.model.TasteMap;
import com.ssafy.play.service.PlayTasteService;

import io.swagger.annotations.ApiOperation;



@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/playtaste",method= {RequestMethod.GET, RequestMethod.POST})
public class PlayTasteController {
	
	@Autowired
	private PlayTasteService playtasteservice;
	
	@ApiOperation(value = "취향을 등록한다", response = String.class)
	@PostMapping("insert/{user_id}")
	public ResponseEntity<String> insertTaste(@PathVariable int user_id, @RequestBody TasteMap category) {
		playtasteservice.deleteTaste(user_id);
		for (int i = 0; i < category.getCategory_id().length; i++) {
			playtasteservice.insertTaste(user_id, Integer.parseInt(category.getCategory_id()[i]));
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원정보에 관한 취향를 반환한다.", response = List.class)
	@GetMapping("{user_id}")
	public ResponseEntity<List<Integer>> selectTaste(@PathVariable int user_id) throws Exception {
		return new ResponseEntity<List<Integer>>(playtasteservice.selectTaste(user_id), HttpStatus.OK);
	}
}
