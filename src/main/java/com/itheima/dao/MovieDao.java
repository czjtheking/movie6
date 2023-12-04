package com.itheima.dao;


import com.itheima.domain.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieDao {
    @Select("select * from movie where movieName like concat('%',#{movieName},'%')")
    public List<Movie> searchByname(String movieName);

    //@Select("select")
}
