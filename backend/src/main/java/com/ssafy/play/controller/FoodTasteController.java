package com.ssafy.play.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.service.FoodTasteService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/foodtaste", method = { RequestMethod.GET, RequestMethod.POST })
public class FoodTasteController {

	@Autowired
	private FoodTasteService foodtasteservice;

	@ApiOperation(value = "취향을 등록한다", response = String.class)
	@PostMapping("{user_id}/{category_id}")
	public ResponseEntity<String> insertTaste(@PathVariable int user_id, @PathVariable int category_id) {
		System.out.println(foodtasteservice.possibleTaste(user_id, category_id));
		if (foodtasteservice.possibleTaste(user_id, category_id) == 1) {
			foodtasteservice.deleteTaste(user_id, category_id);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else if (foodtasteservice.possibleTaste(user_id, category_id) == 0) {
			foodtasteservice.insertTaste(user_id, category_id);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원정보에 관한 취향를 반환한다.", response = List.class)
	@GetMapping("{user_id}")
	public ResponseEntity<List<Integer>> selectTaste(@PathVariable int user_id) throws Exception {
		return new ResponseEntity<List<Integer>>(foodtasteservice.selectTaste(user_id), HttpStatus.OK);
	}
}
