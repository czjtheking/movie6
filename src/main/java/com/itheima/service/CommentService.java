package com.itheima.service;

import com.itheima.domain.Comment;
import com.itheima.domain.Movie;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CommentService {
    /**
     * 提交评论
     * @param comment
     */
    boolean commit(Comment comment);

    /**
     * 删除评论
     * @param comment
     */
    boolean deletecomment(Comment comment);

    /**
     * 电影请求1
     */
    Movie query1(Integer movieId);

    /**
     * 电影请求2
     * @return
     */
    List<Comment> query2(Integer movieId);

    boolean keepName(Integer userId,String userName);
}
