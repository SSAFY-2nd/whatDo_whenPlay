package com.ssafy.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.play.dao.UserDAO;
import com.ssafy.play.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired

	private UserDAO UserDao;

	@Override
	public List<User> selectUser() {
		return UserDao.selectUser();
	}

	@Override
	public User selectUserByUserid(int user_id) {
		return UserDao.selectUserByUserid(user_id);
	}

	@Override
	public int insertUser(User User) {
		return UserDao.insertUser(User);
	}

	@Override
	public int updateUser(User User) {
		return UserDao.updateUser(User);
	}

	@Override
	public int deleteUser(int user_id) {
		return UserDao.deleteUser(user_id);
	}

	@Override
	public User findUserByNickname(String nickname) {
		return UserDao.findUserByNickname(nickname);
	
	}

	@Override
	public String findNicknameById(int user_id) {
		return UserDao.findNicknameById(user_id);
	}

	@Override
	public int updatePassword(User User) {
		return UserDao.updatePassword(User);
	}

	@Override
	public int updateLike(int user_id) {
		return UserDao.updateLike(user_id);
	}

	@Override
	public int getUserId(String nickname) {
		return UserDao.getUserId(nickname);
	}

	@Override
	public User search(String email) {
		return UserDao.search(email);
	}

	@Override

	public User searchByNickname(String nickname) {
		return UserDao.searchByNickname(nickname);
	}

	public User searchById(int id) {
		return UserDao.searchById(id);

	}

	@Override
	public User findUserByEmail(String email) {
		return UserDao.findUserByEmail(email);
	}
}
