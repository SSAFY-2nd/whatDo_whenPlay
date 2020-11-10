package com.ssafy.play.service;

import java.util.List;

import com.ssafy.play.model.FoodTaste;

public interface FoodTasteService {

	int insertTaste(FoodTaste foodtaste);

	int deleteTaste(int user_id, int category_id);

	List<Integer> selectTaste(int user_id);

}
