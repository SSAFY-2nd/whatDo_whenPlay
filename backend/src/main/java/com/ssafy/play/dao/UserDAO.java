package com.ssafy.play.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.User;

@Mapper
public interface UserDAO {
	public List<User> selectUserInfo();
	public User selectUserInfoByUserid(int user_id);
	public int insertUserInfo(User userinfo);
	public int updateUserInfo(User userinfo);
	public int deleteUserInfo(int user_id);
	public User findUserInfoByNickname(String nickname);
	public String findNicknameById(int user_id);
	public int updatePassword(User userinfo);
	public int updateLike(int user_id);
	public int getUserId(String nickname);
	
}
