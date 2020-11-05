package com.ssafy.play.model;

public class Recommend {
	private int foodlike;
	private int playlike;

	public int getFoodlike() {
		return foodlike;
	}

	public void setFoodlike(int foodlike) {
		this.foodlike = foodlike;
	}

	public int getPlaylike() {
		return playlike;
	}

	public void setPlaylike(int playlike) {
		this.playlike = playlike;
	}

	public Recommend(int foodlike, int playlike) {
		super();
		this.foodlike = foodlike;
		this.playlike = playlike;
	}

	public Recommend() {
		super();
	}

}
