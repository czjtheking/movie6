package com.itheima.dao;

import com.itheima.domain.Comment;

import com.itheima.domain.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CommentDao {
    /**
     * 提交评论
     * @param comment
     */
    @Insert("insert into comment (user_id, movie_id, user_name, context, date) values (#{userId},#{movieId},#{userName},#{context},#{data})")
    void saveComment(Comment comment);

    /**
     * 删除评论
     * @param comment
     */
    @Delete("delete from comment where comment_id = #{commentId}")
    void deletecomment(Comment comment);
}
