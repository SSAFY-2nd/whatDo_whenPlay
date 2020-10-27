package com.ssafy.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.UserInfoDAO;
import com.ssafy.play.model.UserInfo;
import com.ssafy.play.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO userInfoDao;

	@Override
	public List<UserInfo> selectUserInfo() {
		return null;
	}

	@Override
	public UserInfo selectUserInfoByUserid(int user_id) {
		return null;
	}

	@Override
	public int insertUserInfo(UserInfo userinfo) {
		return 0;
	}

	@Override
	public int updateUserInfo(UserInfo userinfo) {
		return 0;
	}

	@Override
	public int deleteUserInfo(int user_id) {
		return 0;
	}

	@Override
	public UserInfo findUserInfoByNickname(String nickname) {
		return null;
	}

	@Override
	public String findNicknameById(int user_id) {
		return null;
	}

	@Override
	public int updatePassword(UserInfo userinfo) {
		return 0;
	}

	@Override
	public int updateLike(int user_id) {
		return 0;
	}
}
