package com.ssafy.play.model;

public class Store {
	private int id;
	private int subway_id;
	private String category;
	private String name;
	private String totReview;
	private double rating;
	private String address;
	private int distance;
	private String phoneNumber;
	private String workingTime;
	private String introduce;
	private String menu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubway_id() {
		return subway_id;
	}

	public void setSubway_id(int subway_id) {
		this.subway_id = subway_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTotReview() {
		return totReview;
	}

	public void setTotReview(String totReview) {
		this.totReview = totReview;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public Store(int id, int subway_id, String category, String name, String totReview, double rating, String address,
			int distance, String phoneNumber, String workingTime, String introduce, String menu) {
		super();
		this.id = id;
		this.subway_id = subway_id;
		this.category = category;
		this.name = name;
		this.totReview = totReview;
		this.rating = rating;
		this.address = address;
		this.distance = distance;
		this.phoneNumber = phoneNumber;
		this.workingTime = workingTime;
		this.introduce = introduce;
		this.menu = menu;
	}

	public Store() {
		super();
	}

}
