package com.itheima.service.impl;

import com.itheima.dao.MovieDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Movie;
import com.itheima.domain.User;
import com.itheima.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service

public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> getRecommendedMovies(User user) {
        // 获取用户的喜好数据
        int userId = user.getUserId();
        List<Integer> userPreferences = user.getPreferences();

        // 获取所有电影数据
        List<Movie> allMovies = movieDao.getAllMovies();

        // 计算用户与每个电影的相似度
        List<MovieSimilarity> movieSimilarities = new ArrayList<>();
        for (Movie movie : allMovies) {
            double similarity = calculateSimilarity(userPreferences, movie.getFeatures());
            movieSimilarities.add(new MovieSimilarity(movie, similarity));
        }

        // 对电影相似度进行排序
        Collections.sort(movieSimilarities, Comparator.comparingDouble(MovieSimilarity::getSimilarity).reversed());

        // 获取推荐电影
        List<Movie> recommendedMovies = new ArrayList<>();
        int maxRecommendations = 5; // 设置最大推荐电影数量
        for (int i = 0; i < Math.min(maxRecommendations, movieSimilarities.size()); i++) {
            recommendedMovies.add(movieSimilarities.get(i).getMovie());
        }

        return recommendedMovies;
    }

    private double calculateSimilarity(List<Integer> userPreferences, List<Integer> movieFeatures) {
        // 根据KNN算法计算用户和电影之间的相似度
        // 这里可以使用不同的相似度计算方法，比较用户的喜好数据和电影的特征，计算相似度分数
        // 返回相似度分数，可以是一个介于0到1之间的值

        // 这里只是一个示例，假设相似度为共同喜好特征的数量
        int commonPreferences = 0;
        for (int preference : userPreferences) {
            if (movieFeatures.contains(preference)) {
                commonPreferences++;
            }
        }
        return (double) commonPreferences / Math.max(userPreferences.size(), movieFeatures.size());
    }

    @Override
    public List<Movie> getRecommendedMovies(int userId) {
        return null;
    }
}