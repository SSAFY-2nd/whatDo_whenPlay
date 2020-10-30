package com.ssafy.play.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.LikeToDAO;
import com.ssafy.play.model.LikeTo;


@Service
public class LikeToServiceImpl implements LikeToService {

	@Autowired
	private LikeToDAO LikeDAO;

	@Override
	public int createLiketo(LikeTo liketo) {
		return LikeDAO.createLiketo(liketo);
	}

	@Override
	public int deleteLiketo(int user_id, int store_id) {
		return LikeDAO.deleteLiketo(user_id, store_id);
	}

	

}
