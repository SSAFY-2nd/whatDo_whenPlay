package com.ssafy.play.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.PlayStore;

@Mapper
public interface PlayStoreDAO {
	List<PlayStore> searchBySubway(int subway_id, int category);
	PlayStore searchById(String store_id);
	List<PlayStore> searchBySubwayId(String subway_id);
}
