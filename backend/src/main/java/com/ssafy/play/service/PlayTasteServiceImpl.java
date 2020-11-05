package com.ssafy.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.PlayTasteDAO;
import com.ssafy.play.model.PlayTaste;

@Service
public class PlayTasteServiceImpl implements PlayTasteService{
	
	@Autowired
	PlayTasteDAO playtastedao;
	
	@Override
	public int insertTaste(PlayTaste playtaste) {
		return playtastedao.insertTaste(playtaste);
	}

	@Override
	public int deleteTaste(int user_id, int category_id) {
		return playtastedao.deleteTaste(user_id, category_id);
	}

	@Override
	public List<Integer> selectTaste(int user_id) {
		return playtastedao.selectTaste(user_id);
	}

}
