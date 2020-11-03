package com.ssafy.play.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.Subway;

@Mapper
public interface SubwayDAO {

	Subway searchById(int subway_id);

	Subway searchByName(String subway_name);

}
