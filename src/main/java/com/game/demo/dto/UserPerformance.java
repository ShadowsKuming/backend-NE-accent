package com.game.demo.dto;

public class UserPerformance {
    private int ranking;
    private String userName;
    private int scores;
    private int boroughCorrect;
    private int CountyCorrect;

    public UserPerformance(int ranking, String userName, int scores, int boroughCorrect, int countyCorrect) {
        this.ranking = ranking;
        this.userName = userName;
        this.scores = scores;
        this.boroughCorrect = boroughCorrect;
        CountyCorrect = countyCorrect;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getBoroughCorrect() {
        return boroughCorrect;
    }

    public void setBoroughCorrect(int boroughCorrect) {
        this.boroughCorrect = boroughCorrect;
    }

    public int getCountyCorrect() {
        return CountyCorrect;
    }

    public void setCountyCorrect(int countyCorrect) {
        CountyCorrect = countyCorrect;
    }
}
