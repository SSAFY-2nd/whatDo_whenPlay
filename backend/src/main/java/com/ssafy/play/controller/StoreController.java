package com.ssafy.play.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.model.Store;
import com.ssafy.play.service.StoreService;


import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService storeservice;
	
	@GetMapping("{subway_id}/{category}")
	@ApiOperation(value = "음식점 or 먹거리 가게 목록")
	public ResponseEntity<Store> searchBySubway(@PathVariable int subway_id, @PathVariable String category) {
		List<Store> store=storeservice.searchBySubway(subway_id, category);
		ResponseEntity response = new ResponseEntity<List<Store>>(store, HttpStatus.OK);
		return response;
	}

	@GetMapping("{store_id}")
	@ApiOperation(value = "상점 검색")
	public ResponseEntity<Store> searchById(@PathVariable String store_id) {
		Store store = storeservice.searchById(store_id);
		ResponseEntity response = new ResponseEntity<>(store, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/sub/{subway_id}")
	@ApiOperation(value = "역 주변 상점리스트 검색")
	public ResponseEntity<List<Store>> searchBySubwayId(@PathVariable String subway_id) {
		List<Store> store = storeservice.searchBySubwayId(subway_id);
		ResponseEntity response = new ResponseEntity<List<Store>>(store, HttpStatus.OK);
		return response;
	}

}