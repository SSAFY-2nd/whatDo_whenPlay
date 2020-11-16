package com.example.loginregisterexample.VO;

public class Store {
    private String id;
    private String subway_id;
    private String category;
    private String name;
    private String totReview;
    private String rating;
    private String address;
    private String distance;
    private String phoneNumber;
    private String workingTime;
    private String introduce;
    private String menu;
    private String picture;

    public Store(String id, String subway_id, String category, String name, String totReview, String rating, String address, String distance, String phoneNumber, String workingTime, String introduce, String menu, String picture) {
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
        this.picture = picture;
    }

    public Store() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubway_id() {
        return subway_id;
    }

    public void setSubway_id(String subway_id) {
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

    public void setTotReview(String toReview) {
        this.totReview = toReview;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id='" + id + '\'' +
                ", subway_id='" + subway_id + '\'' +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", totReview='" + totReview + '\'' +
                ", rating='" + rating + '\'' +
                ", address='" + address + '\'' +
                ", distance='" + distance + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", workingTime='" + workingTime + '\'' +
                ", introduce='" + introduce + '\'' +
                ", menu='" + menu + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
