package com.itheima.domain;

public class Rate {
    private Integer rateId;
    private Integer userId;
    private Integer movieId;
    private double rateNum;

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public double getRateNum() {
        return rateNum;
    }

    public void setRateNum(double rateNum) {
        this.rateNum = rateNum;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rateId=" + rateId +
                ", userId=" + userId +
                ", movieId=" + movieId +
                ", rateNum=" + rateNum +
                '}';
    }
}

