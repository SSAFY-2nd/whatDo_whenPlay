package com.ssafy.play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.model.BasicResponse;
import com.ssafy.play.model.FoodTaste;
import com.ssafy.play.model.User;
import com.ssafy.play.service.FoodTasteService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/foodtaste", method= {RequestMethod.GET, RequestMethod.POST})
public class FoodTasteController {
	
	@Autowired
	private FoodTasteService foodtasteservice;
	
	@ApiOperation(value = "취향을 등록한다", response = String.class)
	@PostMapping("add")
	public ResponseEntity<BasicResponse> insertTaste(@RequestBody FoodTaste foodtaste) {
		if (foodtasteservice.insertTaste(foodtaste) == 1) {
			BasicResponse result = new BasicResponse();
			result.status = true;
			result.data = "success";
			result.object = String.valueOf(foodtaste.getId());
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		BasicResponse result = new BasicResponse();
		result.status = false;
		result.data = "fail";
		result.object = null;
		return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{user_id}/{category_id}")
	@ApiOperation(value = "취향 삭제 후 성공/실패 여부를 반환다")

	public ResponseEntity<String> deleteTaste(@PathVariable int user_id, @PathVariable int category_id) {
		if (foodtasteservice.deleteTaste(user_id, category_id)== 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}
}
