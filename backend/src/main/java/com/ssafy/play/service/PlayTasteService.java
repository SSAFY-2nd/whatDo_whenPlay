package com.ssafy.play.service;

import java.util.List;

import com.ssafy.play.model.FoodTaste;
import com.ssafy.play.model.PlayTaste;

public interface PlayTasteService {

	int insertTaste(PlayTaste playtaste);

	int deleteTaste(int user_id, int category_id);

	List<Integer> selectTaste(int user_id);
}
