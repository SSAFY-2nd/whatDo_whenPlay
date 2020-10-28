package com.ssafy.play.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ssafy.play.dao.PlayCategoryDAO;


@Service
public class PlayCategoryServiceImpl implements PlayCategoryService {

	@Autowired
	private PlayCategoryDAO PlayDAO;

	

}
