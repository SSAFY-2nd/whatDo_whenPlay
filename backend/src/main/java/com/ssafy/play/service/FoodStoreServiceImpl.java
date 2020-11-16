package com.ssafy.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.FoodStoreDAO;
import com.ssafy.play.model.FoodStore;


@Service
public class FoodStoreServiceImpl implements FoodStoreService {

	@Autowired
	private FoodStoreDAO storeDAO;

	@Override
	public List<FoodStore> searchBySubway(int subway_id, int category) {
		return storeDAO.searchBySubway(subway_id, category);
	}

	@Override
	public FoodStore searchById(String store_id) {
		return storeDAO.searchById(store_id);
	}

	@Override
	public List<FoodStore> searchBySubwayId(String subway_id) {
		return storeDAO.searchBySubwayId(subway_id);
	}

	

}
