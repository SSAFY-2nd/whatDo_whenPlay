package com.ssafy.play.model;

public class UserInfo {
	private int user_id;
	private String username;
	private String nickname;
	private String email;
	private String password;
	private int like1;
	private int like2;
	private int like3;
	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLike1() {
		return like1;
	}

	public void setLike1(int like1) {
		this.like1 = like1;
	}

	public int getLike2() {
		return like2;
	}

	public void setLike2(int like2) {
		this.like2 = like2;
	}

	public int getLike3() {
		return like3;
	}

	public void setLike3(int like3) {
		this.like3 = like3;
	}

	public UserInfo() {
		super();
	}

	public UserInfo(int user_id, String username, String nickname, String email, String password, int like1, int like2,
			int like3) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.like1 = like1;
		this.like2 = like2;
		this.like3 = like3;
	}

	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", username=" + username + ", nickname=" + nickname + ", email=" + email
				+ ", password=" + password + ", like1=" + like1 + ", like2=" + like2 + ", like3=" + like3 + "]";
	}
	
}
