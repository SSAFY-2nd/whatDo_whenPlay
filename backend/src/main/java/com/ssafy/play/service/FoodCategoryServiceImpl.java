package com.ssafy.play.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.FoodCategoryDAO;


@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {

	@Autowired
	private FoodCategoryDAO FoodDAO;

	

}
