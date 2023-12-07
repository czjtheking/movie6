package com.itheima.domain;

import java.util.List;

public class commetDtails {
    private Movie movie;
    private List<Comment> commentList;

    public commetDtails(Movie movie, List<Comment> commentList) {
        this.movie = movie;
        this.commentList = commentList;
    }

    public commetDtails() {
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "Details{" +
                "movie=" + movie +
                ", commentList=" + commentList +
                '}';
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
