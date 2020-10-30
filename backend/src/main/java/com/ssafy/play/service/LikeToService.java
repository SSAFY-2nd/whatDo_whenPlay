package com.ssafy.play.service;

import com.ssafy.play.model.LikeTo;

public interface LikeToService {
	public int createLiketo(LikeTo liketo);
	public int deleteLiketo(int user_id, int store_id);
}
