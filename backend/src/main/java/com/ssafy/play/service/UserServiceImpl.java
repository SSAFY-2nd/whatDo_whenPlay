package com.ssafy.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.UserDAO;
import com.ssafy.play.model.User;
import com.ssafy.play.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	public List<User> selectUserInfo() {
		return userInfoDao.selectUserInfo();
	}

	@Override
	public User selectUserInfoByUserid(int user_id) {
		return userInfoDao.selectUserInfoByUserid(user_id);
	}

	@Override
	public int insertUserInfo(User userinfo) {
		return userDao.insertUserInfo(userinfo);
	}

	@Override
	public int updateUserInfo(User userinfo) {
		return userDao.updateUserInfo(userinfo);
	}

	@Override
	public int deleteUserInfo(int user_id) {
		return userDao.deleteUserInfo(user_id);
	}

	@Override
	public User findUserInfoByNickname(String nickname) {
		return userDao.findUserInfoByNickname(nickname);
	}

	@Override
	public String findNicknameById(int user_id) {
		return userDao.findNicknameById(user_id);
	}

	@Override
	public int updatePassword(User userinfo) {
		return userDao.updatePassword(userinfo);
	}

	@Override
	public int updateLike(int user_id) {
		return userDao.updateLike(user_id);
	}

	@Override
	public int getUserId(String nickname) {
		return userDao.getUserId(nickname);
	}
}
