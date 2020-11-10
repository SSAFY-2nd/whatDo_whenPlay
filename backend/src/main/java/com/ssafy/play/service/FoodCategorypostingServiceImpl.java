package com.ssafy.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.FoodCategorypostingDAO;
import com.ssafy.play.dao.PlayCategorypostingDAO;
import com.ssafy.play.model.FoodCategoryposting;
import com.ssafy.play.model.PlayCategoryposting;


@Service
public class FoodCategorypostingServiceImpl implements FoodCategorypostingService{

	@Autowired
	private FoodCategorypostingDAO FoodDAO;

	@Override
	public List<Integer> searchBySubwayId(int subway_id) {
		return FoodDAO.searchBySubwayId(subway_id);
	}
	
	
}
