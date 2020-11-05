package com.ssafy.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.StoreDAO;
import com.ssafy.play.model.Store;


@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDAO storeDAO;

	@Override
	public List<Store> searchBySubway(int subway_id, String category) {
		return storeDAO.searchBySubway(subway_id, category);
	}

	@Override
	public Store searchById(String store_id) {
		return storeDAO.searchById(store_id);
	}

	@Override
	public List<Store> searchBySubwayId(String subway_id) {
		return storeDAO.searchBySubwayId(subway_id);
	}

	

}
