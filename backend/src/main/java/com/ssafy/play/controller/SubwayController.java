package com.ssafy.play.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.model.Subway;
import com.ssafy.play.service.SubwayService;
import com.ssafy.play.service.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/subway",method= {RequestMethod.GET})
public class SubwayController {
	
	@Autowired
	private SubwayService subwayservice;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("{subway_id}")
	@ApiOperation(value = "지하철 검색")
	public ResponseEntity<Subway> searchById(@PathVariable int subway_id) {
		Subway subway = subwayservice.searchById(subway_id);
		ResponseEntity response = new ResponseEntity<>(subway, HttpStatus.OK);
		return response;
	}

	@GetMapping("/name/{subway_name}")
	@ApiOperation(value = "지하철 이름 검색")
	public ResponseEntity<Subway> searchByName(@PathVariable String subway_name) {
		Subway subway = subwayservice.searchByName(subway_name);
		ResponseEntity response = new ResponseEntity<>(subway, HttpStatus.OK);
		return response;
	}
	
}