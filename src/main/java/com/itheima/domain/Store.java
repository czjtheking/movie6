package com.itheima.domain;

public class Store {
    private Integer storeId;
    private Integer userId;
    private Integer movieId;

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

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", userId=" + userId +
                ", movieId=" + movieId +
                '}';
    }
}
