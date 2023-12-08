package com.itheima.domain;

import java.util.List;

public class StoreDetails {
    private Integer storeId;
    private Integer userId;
    private Movie movie;

    public StoreDetails(Integer storeId, Integer userId, Movie movie) {
        this.storeId = storeId;
        this.userId = userId;
        this.movie = movie;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "storeDetails{" +
                "storeId=" + storeId +
                ", userId=" + userId +
                ", movie=" + movie +
                '}';
    }
}
