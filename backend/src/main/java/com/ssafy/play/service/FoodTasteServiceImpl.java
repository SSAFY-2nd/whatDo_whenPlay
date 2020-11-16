package com.ssafy.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.FoodTasteDAO;
import com.ssafy.play.model.FoodTaste;

@Service
public class FoodTasteServiceImpl implements FoodTasteService{
	@Autowired
	FoodTasteDAO foodtastedao;



	@Override
	public List<Integer> selectTaste(int user_id) {
		return foodtastedao.selectTaste(user_id);
	}

	@Override
	public int insertTaste(int user_id, int category_id) {
		return foodtastedao.insertTaste(user_id, category_id);
	}

	@Override
	public int possibleTaste(int user_id, int category_id) {
		return foodtastedao.possibleTaste(user_id, category_id);
	}

	@Override
	public int deleteTaste(int user_id) {
		return foodtastedao.deleteTaste(user_id);
	}

}
