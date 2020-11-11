package com.ssafy.play.service;

import java.util.List;

import com.ssafy.play.model.FoodStore;
import com.ssafy.play.model.PlayStore;

public interface FoodStoreService {

	List<FoodStore> searchBySubway(int subway_id, int category);
	FoodStore searchById(String store_id);
	List<FoodStore> searchBySubwayId(String subway_id);
	
}
