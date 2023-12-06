package com.itheima.service;

import com.itheima.domain.Movie;
import com.itheima.domain.User;

import java.util.List;

public interface RecommendationService {
    List<Movie> getRecommendedMovies(User user);

    List<Movie> getRecommendedMovies(int userId);
}
