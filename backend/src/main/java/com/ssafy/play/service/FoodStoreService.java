package com.ssafy.play.service;

import java.util.List;

import com.ssafy.play.model.Store;

public interface StoreService {

	List<Store> searchBySubway(int subway_id, String category);
	Store searchById(String store_id);
	List<Store> searchBySubwayId(String subway_id);
	
}
