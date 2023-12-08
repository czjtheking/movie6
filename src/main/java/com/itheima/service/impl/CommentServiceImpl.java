package com.itheima.service.impl;
import com.itheima.dao.CommentDao;
import com.itheima.domain.Comment;
import com.itheima.domain.Movie;
import com.itheima.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao CommentMapper;


    @Override
    public boolean commit(Comment comment) {
        CommentMapper.saveComment(comment);
        return true;
    }

    @Override
    public boolean deletecomment(Comment comment) {
        CommentMapper.deletecomment(comment);
        return true;
    }

    public Movie query1(Integer movieId) {
        return CommentMapper.query1(movieId);
    }

    public List<Comment> query2(Integer movieId) {
        return CommentMapper.query2(movieId);
    }

    @Override
    public boolean keepName(Integer userId, String userName) {
        return CommentMapper.keepName(userId,userName)>0;
    }
}
