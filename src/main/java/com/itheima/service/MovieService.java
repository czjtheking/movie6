package com.itheima.service;


import com.itheima.domain.Movie;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MovieService {
    public List<Movie> movieSearchService(String movieName);
    public List<Movie> moviePopService();
    public List<Movie> movieMainService();
    public boolean addMovieService(Movie movie);
    public List<Movie> movieNewService();
}
