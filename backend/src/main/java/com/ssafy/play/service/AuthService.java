package com.ssafy.play.service;

import com.ssafy.play.model.Auth;

public interface AuthService {
	public Auth selectAuthByUserid(int user_id);
	public int insertAuth(Auth auth);
	public int updateAuth(Auth auth);
	public int deleteAuth(String user_id);
	public Auth findAuthByRefreshToken(String refresh_token);
	public Auth findAuthByAccessToken(String access_token);
}
