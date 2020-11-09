package com.ssafy.play.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.PlayTaste;

@Mapper
public interface PlayTasteDAO {

	int insertTaste(PlayTaste playtaste);

	int deleteTaste(int user_id, int category_id);

	List<Integer> selectTaste(int user_id);

}
