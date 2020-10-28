package com.ssafy.play.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ssafy.play.dao.LikeToDAO;


@Service
public class LikeToServiceImpl implements LikeToService {

	@Autowired
	private LikeToDAO LikeDAO;

	

}
