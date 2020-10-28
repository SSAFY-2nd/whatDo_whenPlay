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
		return userInfoDao.selectUserInfo();
	}

	@Override
	public UserInfo selectUserInfoByUserid(int user_id) {
		return userInfoDao.selectUserInfoByUserid(user_id);
	}

	@Override
	public int insertUserInfo(UserInfo userinfo) {
		return userInfoDao.insertUserInfo(userinfo);
	}

	@Override
	public int updateUserInfo(UserInfo userinfo) {
		return userInfoDao.updateUserInfo(userinfo);
	}

	@Override
	public int deleteUserInfo(int user_id) {
		return userInfoDao.deleteUserInfo(user_id);
	}

	@Override
	public UserInfo findUserInfoByNickname(String nickname) {
		return userInfoDao.findUserInfoByNickname(nickname);
	}

	@Override
	public String findNicknameById(int user_id) {
		return userInfoDao.findNicknameById(user_id);
	}

	@Override
	public int updatePassword(UserInfo userinfo) {
		return userInfoDao.updatePassword(userinfo);
	}

	@Override
	public int updateLike(int user_id) {
		return userInfoDao.updateLike(user_id);
	}

	@Override
	public int getUserId(String nickname) {
		return userInfoDao.getUserId(nickname);
	}
}
