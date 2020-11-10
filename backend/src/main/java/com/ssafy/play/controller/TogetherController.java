package com.ssafy.play.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.model.FoodCategoryposting;
import com.ssafy.play.model.PlayCategoryposting;
import com.ssafy.play.model.Taste;
import com.ssafy.play.model.User;
import com.ssafy.play.service.FoodCategorypostingService;
import com.ssafy.play.service.FoodTasteService;
import com.ssafy.play.service.PlayCategorypostingService;
import com.ssafy.play.service.PlayTasteService;
import com.ssafy.play.service.SubwayService;
import com.ssafy.play.service.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/together")
public class TogetherController {

	@Autowired
	private UserService userservice;

	@Autowired
	private SubwayService subwayservice;

	@Autowired
	private FoodCategorypostingService foodpostservice;

	@Autowired
	private PlayCategorypostingService playpostservice;

	@Autowired
	private PlayTasteService playtasteservice;

	@Autowired
	private FoodTasteService foodtasteservice;

	@GetMapping("/{user_id}/{friend_name}")
	@ApiOperation(value = "같은 취향 리스트 검색")
	public ResponseEntity<Taste> searchBytaste(@PathVariable int user_id, @PathVariable String friend_name) {
		List<Integer> Myplay = playtasteservice.selectTaste(user_id);
		List<Integer> Myfood = foodtasteservice.selectTaste(user_id);

		User friend = userservice.searchByNickname(friend_name);

		List<Integer> Youplay = playtasteservice.selectTaste(friend.getId());
		List<Integer> Youfood = foodtasteservice.selectTaste(friend.getId());

		Taste taste = new Taste();

		ArrayList<Integer> playin = new ArrayList<Integer>();
		ArrayList<Integer> playout = new ArrayList<Integer>();

		playout.addAll(Myplay);

		for (int i = 0; i < Youplay.size(); i++) {
			if (playout.contains(Youplay.get(i))) {
				playin.add(Youplay.get(i));
				playout.remove((Integer)Youplay.get(i));
			}
			else
				playout.add(Youplay.get(i));
		}

		taste.playin = playin;
		taste.playout = playout;

		ArrayList<Integer> foodin = new ArrayList<Integer>();
		ArrayList<Integer> foodout = new ArrayList<Integer>();
		foodout.addAll(Myfood);

		for (int i = 0; i < Youfood.size(); i++) {
			if (foodout.contains(Youfood.get(i))) {
				foodin.add(Youfood.get(i));
				foodout.remove((Integer)Youfood.get(i));
			}
			else
				foodout.add(Youplay.get(i));
		}

		taste.foodin = foodin;
		taste.foodout = foodout;

		ResponseEntity response = new ResponseEntity<>(taste, HttpStatus.OK);
		return response;
	}

	@GetMapping("/{user_id}/{friend_name}/{subway_id}")
	@ApiOperation(value = "같은 취향 리스트 검색")
	public ResponseEntity<Taste> searchBysubwaytaste(@PathVariable int user_id, @PathVariable String friend_name, @PathVariable int subway_id) {
		Taste taste = new Taste();
		User me = userservice.searchById(user_id);
		User friend = userservice.searchByNickname(friend_name);
		
		List<Integer> Myplay = playtasteservice.selectTaste(user_id);
		List<Integer> Myfood = foodtasteservice.selectTaste(user_id);

		List<Integer> Youplay = playtasteservice.selectTaste(friend.getId());
		List<Integer> Youfood = foodtasteservice.selectTaste(friend.getId());
		
		List<FoodCategoryposting> foodpost = foodpostservice.searchBySubwayId(subway_id);
		List<PlayCategoryposting> playpost = playpostservice.searchBySubwayId(subway_id);
		
		// 내 정보 넣기
		
		ResponseEntity response = new ResponseEntity<>(taste, HttpStatus.OK);
		return response;
	}

}