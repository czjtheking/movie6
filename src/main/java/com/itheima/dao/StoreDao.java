package com.itheima.dao;

import com.itheima.domain.Store;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreDao {
    @Insert("insert into stores (userId,movieId) values (#{userId},#{movieId})")
    public void saveStore(Store store);

    @Delete("delete from stores where storeId = #{storeId}")
    public void deleteStore(Integer storeId);

    @Select("select * from stores where userId = #{userId}")
    public List<Store> selectStore(Integer userId);

    @Select("select * from stores where userId = #{userId}")
    public List<Store> selectStoreId(Integer userId);

    @Select("select * from stores where userId = #{userId} and movieId = #{movieId}")
    public List<Store> isRepeat(Store store);

    @Select("select * from stores where userId = #{userId} and movieId = #{movieId}")
    public List<Store> haveStore(Integer userId,Integer movieId);

    @Delete("delete from stores where userId = #{userId} and movieId = #{movieId}")
    public void delStoreByuserAndmovie(Integer userId,Integer movieId);


}
