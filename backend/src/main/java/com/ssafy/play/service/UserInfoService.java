package com.ssafy.play.service;

import java.util.List;

import com.ssafy.play.model.UserInfo;

public interface UserInfoService {
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
