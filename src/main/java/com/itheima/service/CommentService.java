package com.itheima.service;

import com.itheima.domain.Comment;

public interface CommentService {
    /**
     * 提交评论
     * @param comment
     */
    void commit(Comment comment);

    /**
     * 删除评论
     * @param comment
     */
    void deletecomment(Comment comment);
}
