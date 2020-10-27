package com.ssafy.play.model;

public class UserInfo {
	private int user_id;
	private String username;
	private String nickname;
	private String password;
	private int eatlike1;
	private int eatlike2;
	private int eatlike3;
	private int playlike1;
	private int playlike2;
	private int playlike3;
	private int liketo;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEatlike1() {
		return eatlike1;
	}

	public void setEatlike1(int eatlike1) {
		this.eatlike1 = eatlike1;
	}

	public int getEatlike2() {
		return eatlike2;
	}

	public void setEatlike2(int eatlike2) {
		this.eatlike2 = eatlike2;
	}

	public int getEatlike3() {
		return eatlike3;
	}

	public void setEatlike3(int eatlike3) {
		this.eatlike3 = eatlike3;
	}

	public int getPlaylike1() {
		return playlike1;
	}

	public void setPlaylike1(int playlike1) {
		this.playlike1 = playlike1;
	}

	public int getPlaylike2() {
		return playlike2;
	}

	public void setPlaylike2(int playlike2) {
		this.playlike2 = playlike2;
	}

	public int getPlaylike3() {
		return playlike3;
	}

	public void setPlaylike3(int playlike3) {
		this.playlike3 = playlike3;
	}

	public int getLiketo() {
		return liketo;
	}

	public void setLiketo(int liketo) {
		this.liketo = liketo;
	}

	public UserInfo(int user_id, String username, String nickname, String password, int eatlike1, int eatlike2,
			int eatlike3, int playlike1, int playlike2, int playlike3, int liketo) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.eatlike1 = eatlike1;
		this.eatlike2 = eatlike2;
		this.eatlike3 = eatlike3;
		this.playlike1 = playlike1;
		this.playlike2 = playlike2;
		this.playlike3 = playlike3;
		this.liketo = liketo;
	}

	public UserInfo() {
		super();
	}

}
