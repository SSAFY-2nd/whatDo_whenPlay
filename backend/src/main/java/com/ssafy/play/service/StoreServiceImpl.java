package com.ssafy.play.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.StoreDAO;


@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDAO StoreDAO;

	

}
