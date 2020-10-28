package com.ssafy.play.model;

public class User {
	private int id;
	private String name;
	private String nickname;
	private String password;
	private int eatlike1;
	private int eatlike2;
	private int eatlike3;
	private int playlike1;
	private int playlike2;
	private int playlike3;
	private int liketo;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
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

	public User(int id, String name, String nickname, String password, int eatlike1, int eatlike2,
			int eatlike3, int playlike1, int playlike2, int playlike3, int liketo, String email) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.password = password;
		this.eatlike1 = eatlike1;
		this.eatlike2 = eatlike2;
		this.eatlike3 = eatlike3;
		this.playlike1 = playlike1;
		this.playlike2 = playlike2;
		this.playlike3 = playlike3;
		this.liketo = liketo;
		this.email = email;
	}

	public User() {
		super();
	}

}
