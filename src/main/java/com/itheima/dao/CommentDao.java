package com.itheima.dao;

import com.itheima.domain.Comment;

import com.itheima.domain.Comment;
import com.itheima.domain.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CommentDao {
    /**
     * 提交评论
     * @param comment
     */
    @Insert("insert into comments (userId, movieId, userName, context, date) values (#{userId},#{movieId},#{userName},#{context},#{date})")
    void saveComment(Comment comment);

    /**
     * 删除评论
     * @param comment
     */
    @Delete("delete from comments where commentId = #{commentId}")
    void deletecomment(Comment comment);


    /**
     * 电影请求1
     * @param
     * @return
     */
    @Select("select * from movie where movieId = #{movieId}")
    Movie query1(Integer movieId);

    /**
     * 电影请求2
     * @param
     * @return
     */
    @Select("select * from comments where movieId = #{movieId}")
    List<Comment> query2(Integer movieId);
}
