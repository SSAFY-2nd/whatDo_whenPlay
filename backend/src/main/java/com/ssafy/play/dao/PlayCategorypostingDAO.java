package com.ssafy.play.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.PlayCategoryposting;

@Mapper
public interface PlayCategorypostingDAO {

	List<Integer> searchBySubwayId(int subway_id);

}
