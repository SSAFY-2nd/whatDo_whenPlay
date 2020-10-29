package com.ssafy.play.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.LikeTo;

@Mapper
public interface LikeToDAO {
	public int createLiketo(LikeTo liketo);
	public int deleteLiketo(int user_id, int store_id);
}
