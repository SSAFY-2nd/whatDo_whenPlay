package com.ssafy.play.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.SubwayDAO;
import com.ssafy.play.model.Subway;


@Service
public class SubwayServiceImpl implements SubwayService {

	@Autowired
	private SubwayDAO subwayDAO;

	@Override
	public Subway searchById(int subway_id) {
		return subwayDAO.searchById(subway_id);
	}

	@Override
	public Subway searchByName(String subway_name) {
		return subwayDAO.searchByName(subway_name);
	}

	

}
