package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// TODO 添加@Mapper
@Mapper
public interface UserDao {
    @Insert("insert into user (userAccount,userPsw,userAd) values(#{userAccount},#{userPsw},#{userAd})")
    public int save(User user);

    @Update("update user set userName = #{userName}, userPsw = #{userPsw} where userAccount = #{userAccount}")
    public int update(User user);

    @Delete("delete from user where userId = #{userId}")
    public int delete(Integer User_id);

    @Select("select userAccount from user where userAccount = #{userAccount}")
    public User findByaccount(String userAccount);

    @Select("select * from user where userAccount = #{userAccount} and userPsw = #{userPsw} and userAd = #{userAd}")
    public User getByAccountancyUsurps(String userAccount, String userPsw,boolean userAd);

}
