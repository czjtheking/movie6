package com.itheima.dao;


import com.itheima.domain.Movie;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieDao {
    @Select("select * from movie where movieName like concat('%',#{movieName},'%')")
    public List<Movie> searchByname(String movieName);

    @Select("select * from movie order by rand() limit 10")
    public List<Movie> searchRandom();

    @Select("select * from movie limit 5")
    public List<Movie> searchBanner();

    @Select("select * from movie order by rand() limit 4")
    public List<Movie> searchMainPop();

    @Insert("insert into movie (movieName,movieGenre,movieDirector,movieActor,movieIntro,moviePicURL,movieRate) values (#{movieName},#{movieGenre},#{movieDirector},#{movieActor},#{movieIntro},#{moviePicURL},#{movieRate})")
    public void addMovie(Movie movie);

    @Select("select * from movie where movieId = #{movieId}")
    public Movie returnMovie(Integer movieId);

    @Select("select * from movie")
    public List<Movie> getAllmovies();

    @Select("select movieGenre from movie where movieId = #{movieId}")
    public String searchMovieGenre(Integer movieId);

}
