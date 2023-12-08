package com.itheima.service;

import com.itheima.domain.Movie;
import com.itheima.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RecommendationService {
    List<Movie> getRecommendedMovies(User user);

    List<Movie> getRecommendedMovies(int userId);
}
