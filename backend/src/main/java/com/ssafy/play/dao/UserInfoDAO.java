package com.ssafy.play.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.play.model.UserInfo;

@Mapper
public interface UserInfoDAO {
	public List<UserInfo> selectUserInfo();
	public UserInfo selectUserInfoByUserid(int user_id);
	public int insertUserInfo(UserInfo userinfo);
	public int updateUserInfo(UserInfo userinfo);
	public int deleteUserInfo(int user_id);
	public UserInfo findUserInfoByNickname(String nickname);
	public String findNicknameById(int user_id);
	public int updatePassword(UserInfo userinfo);
	public int updateLike(int user_id);
	public int getUserId(String nickname);
	
}
