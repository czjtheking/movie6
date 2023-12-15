package com.itheima.service;

import com.itheima.domain.Movie;
import com.itheima.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RecommendationService {
    public List<Movie> getRecommendedMovies(User user);
    public double calculateSimilarity(String userGenre, String movieFeatures);
}
