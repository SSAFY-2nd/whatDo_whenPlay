package com.ssafy.play.model;

public class FoodCategoryposting {
	private int id;
	private int subway_id;
	private int category_id;
	private int post;

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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public FoodCategoryposting(int id, int subway_id, int category_id, int post) {
		super();
		this.id = id;
		this.subway_id = subway_id;
		this.category_id = category_id;
		this.post = post;
	}

	public FoodCategoryposting() {
		super();
	}

}
