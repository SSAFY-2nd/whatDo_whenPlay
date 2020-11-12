package com.example.loginregisterexample.VO;

import java.io.Serializable;
import java.util.ArrayList;

public class Play implements Serializable {
    private ArrayList<Integer> subplay;
    private ArrayList<Integer> subfood;

    public Play(ArrayList<Integer> subplay, ArrayList<Integer> subfood) {
        this.subplay = subplay;
        this.subfood = subfood;
    }

    public ArrayList<Integer> getSubplay() {
        return subplay;
    }

    public void setSubplay(ArrayList<Integer> subplay) {
        this.subplay = subplay;
    }

    public ArrayList<Integer> getSubfood() {
        return subfood;
    }

    public void setSubfood(ArrayList<Integer> subfood) {
        this.subfood = subfood;
    }

    @Override
    public String toString() {
        return "Play{" +
                "subplay=" + subplay +
                ", subfood=" + subfood +
                '}';
    }
}
