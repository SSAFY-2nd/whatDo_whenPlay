package com.ssafy.play.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ssafy.play.dao.AuthDAO;
import com.ssafy.play.model.Auth;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthDAO authDao;

	@Override
	public Auth selectAuthByUserid(int user_id) {
		return authDao.selectAuthByUserid(user_id);
	}

	@Override
	public int insertAuth(Auth auth) {
		return authDao.insertAuth(auth);
	}

	@Override
	public int updateAuth(Auth auth) {
		return authDao.updateAuth(auth);
	}

	@Override
	public int deleteAuth(String user_id) {
		return authDao.deleteAuth(user_id);
	}

	@Override
	public Auth findAuthByRefreshToken(String refresh_token) {
		return authDao.findAuthByRefreshToken(refresh_token);
	}

	@Override
	public Auth findAuthByAccessToken(String access_token) {
		return authDao.findAuthByAccessToken(access_token);
	}

}
