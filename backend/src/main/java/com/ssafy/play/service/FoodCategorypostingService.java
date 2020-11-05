package com.ssafy.play.service;

import java.util.List;

import com.ssafy.play.model.FoodCategoryposting;

public interface FoodCategorypostingService {
	List<FoodCategoryposting> searchBySubwayId(int subway_id);

}
