package com.ssafy.play.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.FoodCategoryposting;

@Mapper
public interface FoodCategorypostingDAO {

	List<Integer> searchBySubwayId(int subway_id);

}
