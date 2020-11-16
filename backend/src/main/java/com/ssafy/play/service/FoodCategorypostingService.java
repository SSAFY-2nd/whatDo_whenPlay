package com.ssafy.play.service;

import java.util.List;

import com.ssafy.play.model.FoodCategoryposting;

public interface FoodCategorypostingService {
	List<Integer> searchBySubwayId(int subway_id);

}
