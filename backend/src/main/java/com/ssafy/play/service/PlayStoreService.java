package com.ssafy.play.service;

import java.util.List;

import com.ssafy.play.model.PlayStore;

public interface PlayStoreService {

	List<PlayStore> searchBySubway(int subway_id, int category);
	PlayStore searchById(String store_id);
	List<PlayStore> searchBySubwayId(String subway_id);
	
}
