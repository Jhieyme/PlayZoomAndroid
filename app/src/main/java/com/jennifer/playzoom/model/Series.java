package com.jennifer.playzoom.model;

public class Series extends Shows{

    private int season;

    public Series(String name, String imgUrl, int season) {
        super(name, imgUrl);
        this.season=season;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
