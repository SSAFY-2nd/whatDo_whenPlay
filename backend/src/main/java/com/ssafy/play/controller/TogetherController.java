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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.play.model.Taste;
import com.ssafy.play.model.Together;
import com.ssafy.play.model.User;
import com.ssafy.play.service.FoodCategorypostingService;
import com.ssafy.play.service.FoodTasteService;
import com.ssafy.play.service.PlayCategorypostingService;
import com.ssafy.play.service.PlayTasteService;
import com.ssafy.play.service.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/together",method= {RequestMethod.GET})
public class TogetherController {

	@Autowired
	private UserService userservice;

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
	@ApiOperation(value = "지하철 취향 리스트 검색")
	public ResponseEntity<Together> searchBysubwaytaste(@PathVariable int user_id, @PathVariable String friend_name, @PathVariable int subway_id) {
		Together together = new Together();
		List<Integer> Myplay = playtasteservice.selectTaste(user_id);
		List<Integer> Myfood = foodtasteservice.selectTaste(user_id);

		User friend = userservice.searchByNickname(friend_name);

		List<Integer> Youplay = playtasteservice.selectTaste(friend.getId());
		List<Integer> Youfood = foodtasteservice.selectTaste(friend.getId());

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

		//짝과의 취향 선택 (겹치는거 & 안겹치는거)
		
		List<Integer> SubwayPlay = playpostservice.searchBySubwayId(subway_id);
		List<Integer> SubwayFood = foodpostservice.searchBySubwayId(subway_id);
		
		//각 지하철 리스트 (포스팅 갯수 순서대로)
		
		ArrayList<Integer> playlist = new ArrayList<Integer>();
		ArrayList<Integer> foodlist = new ArrayList<Integer>();
		
		playlist.addAll(SubwayPlay);
		foodlist.addAll(SubwayFood);
		
		ArrayList<Integer> subplay = new ArrayList<Integer>();
		ArrayList<Integer> subfood = new ArrayList<Integer>();
		
		for (int i = 0; i < playin.size(); i++) {
			for (int j = 0; j < playlist.size(); j++) {
				if(playin.get(i).equals(playlist.get(j))) {
					subplay.add(playin.get(i));
					playlist.remove(j);
				}
			}
		}
		
		for (int i = 0; i < playlist.size(); i++) {
			subplay.add(playlist.get(i));
		}
		
		for (int i = 0; i < foodin.size(); i++) {
			for (int j = 0; j < foodlist.size(); j++) {
				if(foodin.get(i).equals(foodlist.get(j))) {
					subfood.add(foodin.get(i));
					foodlist.remove(j);
				}
			}
		}
		
		for (int i = 0; i < foodlist.size(); i++) {
			subfood.add(foodlist.get(i));
		}
		
		together.subplay=subplay;
		together.subfood=subfood;
		
		ResponseEntity response = new ResponseEntity<>(together, HttpStatus.OK);
		return response;
	}

}