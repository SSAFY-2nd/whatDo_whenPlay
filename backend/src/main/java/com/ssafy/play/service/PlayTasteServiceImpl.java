package com.ssafy.play.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.PlayTasteDAO;

@Service
public class PlayTasteServiceImpl implements PlayTasteService{
	
	@Autowired
	PlayTasteDAO playtastedao;
	

	@Override
	public List<Integer> selectTaste(int user_id) {
		return playtastedao.selectTaste(user_id);
	}

	@Override
	public int possibleTaste(int user_id, int category_id) {
		return playtastedao.possibleTaste(user_id, category_id);
	}

	@Override
	public int insertTaste(int user_id, int category_id) {
		return playtastedao.insertTaste(user_id, category_id);
	}

	@Override
	public int deleteTaste(int user_id) {
		return playtastedao.deleteTaste(user_id);
	}

}
