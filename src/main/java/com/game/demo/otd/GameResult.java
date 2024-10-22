package com.game.demo.otd;

public class GameResult {
    private int score;
    private double accuracy;
    private long rank;
    private long userCount;


    public GameResult(int score, double accuracy, long rank, long userCount) {
        this.score = score;
        this.accuracy = accuracy;
        this.rank = rank;
        this.userCount = userCount;

    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public long getUserCount() {
        return userCount;
    }

    public void setUserCount(long userCount) {
        this.userCount = userCount;
    }
}
