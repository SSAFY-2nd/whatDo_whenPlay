package com.example.loginregisterexample.viewpager;

public class SampleData {
    private String poster;
    private String movieName;
    private String grade;

    public SampleData(String poster, String movieName, String grade){
        this.poster = poster;
        this.movieName = movieName;
        this.grade = grade;
    }

    public String getPoster()
    {
        return this.poster;
    }

    public String getMovieName()
    {
        return this.movieName;
    }

    public String getGrade()
    {
        return this.grade;
    }
}
