package com.ssafy.play.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.model.PlayStore;
import com.ssafy.play.service.PlayStoreService;


import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/playStore", method= {RequestMethod.GET})
public class PlayStoreController {
	
	@Autowired
	private PlayStoreService storeservice;
	
	@GetMapping("{subway_id}/{category}")
	@ApiOperation(value = "놀거리 가게 목록")
	public ResponseEntity<PlayStore> searchBySubway(@PathVariable int subway_id, @PathVariable int category) {
		List<PlayStore> store=storeservice.searchBySubway(subway_id, category);
		ResponseEntity response = new ResponseEntity<List<PlayStore>>(store, HttpStatus.OK);
		return response;
	}

	@GetMapping("{store_id}")
	@ApiOperation(value = "놀거리 검색")
	public ResponseEntity<PlayStore> searchById(@PathVariable String store_id) {
		PlayStore store = storeservice.searchById(store_id);
		ResponseEntity response = new ResponseEntity<>(store, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/sub/{subway_id}")
	@ApiOperation(value = "역 주변 놀거리리스트 검색")
	public ResponseEntity<List<PlayStore>> searchBySubwayId(@PathVariable String subway_id) {
		List<PlayStore> store = storeservice.searchBySubwayId(subway_id);
		ResponseEntity response = new ResponseEntity<List<PlayStore>>(store, HttpStatus.OK);
		return response;
	}

}