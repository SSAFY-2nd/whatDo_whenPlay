package com.ssafy.play.model;

public class LikeTo {
	private int user_id;
	private int store_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public LikeTo(int user_id, int store_id) {
		super();
		this.user_id = user_id;
		this.store_id = store_id;
	}

	public LikeTo() {
		super();
	}

}
