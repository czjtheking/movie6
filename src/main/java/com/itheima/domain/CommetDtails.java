package com.itheima.domain;

import java.util.List;

public class CommetDtails {
    private Movie movie;
    private List<Comment> commentList;
    private double rateNum = 0;
    boolean storeMark = false;

    public boolean isStoreMark() {
        return storeMark;
    }

    public CommetDtails(Movie movie, double rateNum, boolean storeMark,List<Comment> commentList) {
        this.movie = movie;
        this.commentList = commentList;
        this.rateNum = rateNum;
        this.storeMark = storeMark;
    }

    @Override
    public String toString() {
        return "CommetDtails{" +
                "movie=" + movie +
                ", commentList=" + commentList +
                ", rateNum=" + rateNum +
                ", storeMark=" + storeMark +
                '}';
    }

    public void setStoreMark(boolean storeMark) {
        this.storeMark = storeMark;
    }

    public double getRateNum() {
        return rateNum;
    }

    public void setRateNum(double rateNum) {
        this.rateNum = rateNum;
    }


    public CommetDtails() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
