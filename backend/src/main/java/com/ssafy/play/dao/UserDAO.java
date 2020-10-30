package com.ssafy.play.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.User;

@Mapper
public interface UserDAO {
	public List<User> selectUser();
	public User selectUserByUserid(int user_id);
	public int insertUser(User User);
	public int updateUser(User User);
	public int deleteUser(int user_id);
	public User findUserByNickname(String nickname);
	public String findNicknameById(int user_id);
	public int updatePassword(User User);
	public int updateLike(int user_id);
	public int getUserId(String nickname);
	public User search(String email);

	public User searchByNickname(String nickname);
	public User searchById(int id);
	public User findUserByEmail(String email);
}
