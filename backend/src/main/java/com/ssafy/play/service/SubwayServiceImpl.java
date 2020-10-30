package com.ssafy.play.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.SubwayDAO;


@Service
public class SubwayServiceImpl implements SubwayService {

	@Autowired
	private SubwayDAO subwayDAO;

	

}
