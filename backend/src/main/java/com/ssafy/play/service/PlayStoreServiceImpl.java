package com.ssafy.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.PlayStoreDAO;
import com.ssafy.play.model.PlayStore;


@Service
public class PlayStoreServiceImpl implements PlayStoreService {

	@Autowired
	private PlayStoreDAO playDAO;

	@Override
	public List<PlayStore> searchBySubway(int subway_id, int category) {
		return playDAO.searchBySubway(subway_id, category);
	}

	@Override
	public PlayStore searchById(String store_id) {
		return playDAO.searchById(store_id);
	}

	@Override
	public List<PlayStore> searchBySubwayId(String subway_id) {
		return playDAO.searchBySubwayId(subway_id);
	}

	

}
