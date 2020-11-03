package com.ssafy.play.service;

import com.ssafy.play.model.Subway;

public interface SubwayService {

	Subway searchById(int subway_id);
	Subway searchByName(String subway_name);
	
}
