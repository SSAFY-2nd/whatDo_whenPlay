package com.ssafy.play.service;

import java.util.List;

import com.ssafy.play.model.PlayCategoryposting;

public interface PlayCategorypostingService {

	List<Integer> searchBySubwayId(int subway_id);

}
