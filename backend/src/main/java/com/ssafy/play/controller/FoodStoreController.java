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

import com.ssafy.play.model.FoodStore;
import com.ssafy.play.service.FoodStoreService;


import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/foodstore", method= {RequestMethod.GET})
public class FoodStoreController {
	
	@Autowired
	private FoodStoreService storeservice;
	
	@GetMapping("{subway_id}/{category}")
	@ApiOperation(value = "음식점  가게 목록")
	public ResponseEntity<FoodStore> searchBySubway(@PathVariable int subway_id, @PathVariable int category) {
		List<FoodStore> store=storeservice.searchBySubway(subway_id, category);
		ResponseEntity response = new ResponseEntity<List<FoodStore>>(store, HttpStatus.OK);
		return response;
	}

	@GetMapping("{store_id}")
	@ApiOperation(value = "음식점 검색")
	public ResponseEntity<FoodStore> searchById(@PathVariable String store_id) {
		FoodStore store = storeservice.searchById(store_id);
		ResponseEntity response = new ResponseEntity<>(store, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/sub/{subway_id}")
	@ApiOperation(value = "역 주변 음식점리스트 검색")
	public ResponseEntity<List<FoodStore>> searchBySubwayId(@PathVariable String subway_id) {
		List<FoodStore> store = storeservice.searchBySubwayId(subway_id);
		ResponseEntity response = new ResponseEntity<List<FoodStore>>(store, HttpStatus.OK);
		return response;
	}

}