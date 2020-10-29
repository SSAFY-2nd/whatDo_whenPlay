package com.ssafy.play.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.Auth;

@Mapper
public interface AuthDAO {
	public Auth selectAuthByUserid(int user_id);
	public int insertAuth(Auth auth);
	public int updateAuth(Auth auth);
	public int deleteAuth(String user_id);
	public Auth findAuthByRefreshToken(String refresh_token);
	public Auth findAuthByAccessToken(String access_token);
}
