package com.ssafy.play.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.Store;

@Mapper
public interface StoreDAO {
	List<Store> searchBySubway(int subway_id, String category);
	Store searchById(String store_id);
	List<Store> searchBySubwayId(String subway_id);
}
