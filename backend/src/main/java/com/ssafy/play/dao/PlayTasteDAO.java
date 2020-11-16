package com.ssafy.play.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PlayTasteDAO {

	int deleteTaste(int user_id);

	List<Integer> selectTaste(int user_id);

	int possibleTaste(int user_id, int category_id);

	int insertTaste(int user_id, int category_id);

}
