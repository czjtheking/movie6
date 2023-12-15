package com.itheima.dao;


import com.itheima.domain.Rate;
import com.sun.corba.se.impl.orbutil.LogKeywords;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RateDao {
    @Insert("insert into rate (userId,movieId,rateNum) values (#{userId},#{movieId},#{rateNum})")
    public void saveRate(Rate rate);

    @Select("select * from rate where userId = #{userId} and movieId = #{movieId}")
    public List<Rate> isRepeat(Integer userId,Integer movieId);

    @Select("select * from rate where userId = #{userId} and movieId = #{movieId}")
    public Rate findRateNum(Integer userId,Integer movieId);

    @Update("update rate set rateNum = #{rateNum} where userId = #{userId} and movieId = #{movieId}")
    public int updateRate(double rateNum,Integer userId,Integer movieId);

}
