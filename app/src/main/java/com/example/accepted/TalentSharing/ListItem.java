package com.example.accepted.TalentSharing;

/**
 * Created by Accepted on 2017-10-24.
 */

public class ListItem {

    private int picture;
    private String name;
    private String keyword;
    private String distance;

    public ListItem(int picture, String name, String keyword, String distance) {
        this.picture = picture;
        this.name = name;
        this.keyword = keyword;
        this.distance = distance;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

}
