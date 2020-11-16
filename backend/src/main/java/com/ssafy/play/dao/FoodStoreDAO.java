package com.ssafy.play.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.FoodStore;

@Mapper
public interface FoodStoreDAO {
	List<FoodStore> searchBySubway(int subway_id, int category);
	FoodStore searchById(String store_id);
	List<FoodStore> searchBySubwayId(String subway_id);
}
