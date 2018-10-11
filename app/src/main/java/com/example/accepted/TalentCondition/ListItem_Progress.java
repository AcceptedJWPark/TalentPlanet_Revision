package com.example.accepted.TalentCondition;

/**
 * Created by Accepted on 2017-10-24.
 */

public class ListItem_Progress {

    boolean ismentor;
    boolean isrequest;
    String name;
    String point;
    String date;
    String talent1;
    String talent2;

    public ListItem_Progress(boolean ismentor, boolean isrequest, String name, String point, String date, String talent1, String talent2) {
        this.ismentor = ismentor;
        this.isrequest = isrequest;
        this.name = name;
        this.point = point;
        this.date = date;
        this.talent1 = talent1;
        this.talent2 = talent2;
    }

    public boolean isIsmentor() {
        return ismentor;
    }

    public void setIsmentor(boolean ismentor) {
        this.ismentor = ismentor;
    }

    public boolean isIsrequest() {
        return isrequest;
    }

    public void setIsrequest(boolean isrequest) {
        this.isrequest = isrequest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTalent1() {
        return talent1;
    }

    public void setTalent1(String talent1) {
        this.talent1 = talent1;
    }

    public String getTalent2() {
        return talent2;
    }

    public void setTalent2(String talent2) {
        this.talent2 = talent2;
    }
}
