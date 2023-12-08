package com.itheima.service.impl;


import com.itheima.dao.MovieDao;
import com.itheima.domain.Movie;
import com.itheima.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> movieSearchService(String movieName) {
        return movieDao.searchByname(movieName);
    }

    @Override
    public List<Movie> moviePopService() {
        return movieDao.searchRandom();
    }

    @Override
    public List<Movie> movieMainService() {
        List<Movie> movieList1 = movieDao.searchBanner();
        List<Movie> movieList2 = movieDao.searchMainPop();
        boolean fin = movieList1.addAll(movieList2);
        return movieList1;
    }

    @Override
    public boolean addMovieService(Movie movie) {
        movieDao.addMovie(movie);
        return true;
    }
}
