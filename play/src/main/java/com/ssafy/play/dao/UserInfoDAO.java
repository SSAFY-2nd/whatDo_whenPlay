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
	public List<UserInfo> selectUserInfoSearch(String keyword);
	public String findNicknameById(int user_id);
	public int getUserId(String email);
	public int updateImage(UserInfo userinfo);
	public int updatePassword(UserInfo userinfo);
	public int updateDisable(int user_id);
	public int updateLike(int user_id);
	public String selectSaltByUserId(int user_id);
}
