package com.ssafy.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.PlayCategorypostingDAO;
import com.ssafy.play.model.PlayCategoryposting;


@Service
public class PlayCategorypostingServiceImpl implements PlayCategorypostingService{

	@Autowired
	private PlayCategorypostingDAO PlayDAO;

	@Override
	public List<Integer> searchBySubwayId(int subway_id) {
		return PlayDAO.searchBySubwayId(subway_id);
	}
	
	
}
