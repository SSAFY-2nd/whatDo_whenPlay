package com.ssafy.play.service;

import java.util.List;


public interface PlayTasteService {


	int deleteTaste(int user_id);

	List<Integer> selectTaste(int user_id);

	int possibleTaste(int user_id, int category_id);

	int insertTaste(int user_id, int category_id);

}
