package com.game.demo.otd;

public class UserPerformance {
    private int ranking;
    private String userName;
    private int scores;
    private double accuracy;

    public UserPerformance(int ranking, String userName, int scores, double accuracy) {
        this.ranking = ranking;
        this.userName = userName;
        this.scores = scores;
        this.accuracy = accuracy;
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

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
