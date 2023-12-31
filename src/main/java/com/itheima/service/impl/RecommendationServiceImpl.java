package com.itheima.service.impl;

import com.itheima.dao.MovieDao;
import com.itheima.dao.StoreDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Movie;
import com.itheima.domain.MovieSimilarity;
import com.itheima.domain.Store;
import com.itheima.domain.User;
import com.itheima.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service

public class RecommendationServiceImpl implements RecommendationService {
    private UserDao userDao;
    private MovieDao movieDao;
    private StoreDao storeDao;

    public RecommendationServiceImpl(UserDao userDao, MovieDao movieDao, StoreDao storeDao) {
        this.userDao = userDao;
        this.movieDao = movieDao;
        this.storeDao = storeDao;
    }

    @Override
    public List<Movie> getRecommendedMovies(User user) {
        // 获取用户的喜好数据
        int userId = user.getUserId();
        List<Store> storeList  = storeDao.selectStore(userId);
        if (storeList.size()==0)
        {
            return null;
        }
        List<Integer> userPreferences = new ArrayList<>();
        for (int i = 0;i<storeList.size();i++)
        {
            Store temp = storeList.get(i);
            userPreferences.add(temp.getMovieId());
        }
        Random random = new Random();
        int selectMovieId = userPreferences.get(random.nextInt(userPreferences.size()));

        // 获取所有电影数据
        List<Movie> allMovies = movieDao.getAllmovies();

        // 计算用户与每个电影的相似度
        List<MovieSimilarity> movieSimilarityArrayList = new ArrayList<>();
        System.out.println(allMovies.size());
        for (int i=0;i<allMovies.size();i++) {
            double similarity = calculateSimilarity(movieDao.searchMovieGenre(selectMovieId), movieDao.searchMovieGenre(allMovies.get(i).getMovieId()));
            if(similarity<1&&similarity>0)
            {
                MovieSimilarity temp = new MovieSimilarity(allMovies.get(i),similarity);
                movieSimilarityArrayList.add(temp);

            }
        }


        // 对电影相似度进行排序
        Collections.sort(movieSimilarityArrayList, Comparator.comparingDouble(MovieSimilarity::getSimilarity).reversed());

        // 获取推荐电影
        List<Movie> recommendedMovies = new ArrayList<>();
        int maxRecommendations = 4; // 设置最大推荐电影数量
        for (int i = 0; i < Math.min(maxRecommendations, movieSimilarityArrayList.size()); i++) {
            recommendedMovies.add(movieSimilarityArrayList.get(i).getMovie());
        }
            return recommendedMovies;
    }

    @Override
    public double calculateSimilarity(String userGenre, String movieFeatures) {
        // 根据KNN算法计算用户和电影之间的相似度
        // 这里可以使用不同的相似度计算方法，比较用户的喜好数据和电影的特征，计算相似度分数
        // 返回相似度分数，可以是一个介于0到1之间的值

        // 这里只是一个示例，假设相似度为共同喜好特征的数量
        int commonPreferences = 0;

        for (int i=0;i<Math.min(userGenre.length(),movieFeatures.length());i++)
        {
            Character user = userGenre.charAt(i);
            Character movie = movieFeatures.charAt(i);
            if (user.equals(movie)) {
                commonPreferences++;
            }
        }

        return (double) commonPreferences / Math.max(userGenre.length(), movieFeatures.length());
    }


}