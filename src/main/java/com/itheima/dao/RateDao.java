package com.itheima.dao;


import com.itheima.domain.Rate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RateDao {
    @Insert("insert into rate (userId,movieId,rateNum) values (#{userId},#{movieId},#{rateNum})")
    public void saveRate(Rate rate);
}
