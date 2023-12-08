package com.itheima.controller;
import com.itheima.domain.Comment;
import com.itheima.domain.CommetDtails;
import com.itheima.domain.Movie;
import com.itheima.domain.Result;
import com.itheima.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movies")
@CrossOrigin
public class CommentController {


    @Autowired
    private CommentService commentService;


    /**
     * 提交评论
     * @return
     */
    @PostMapping("/comment")
    public Result commit(@RequestBody Comment comment){
        log.info("提交评论: {}", comment);
        boolean temp = commentService.commit(comment);
        Integer code = temp ?Code.GET_OK:Code.GET_ERR;
        String msg = temp ?"提交评论成功":"提交评论失败";
        return new Result(code,msg);
    }

    /**
     * 删除评论
     */
    @PostMapping("/delcomment")
    public Result deletecomment(@RequestBody Comment comment){
        log.info("删除评论: {}",comment);
        boolean temp = commentService.deletecomment(comment);
        Integer code = temp ?Code.GET_OK:Code.GET_ERR;
        String msg = temp ?"删除评论成功":"删除评论失败";
        return new Result(code,msg);
    }

    /**
     * 电影请求
     */
    @PostMapping("/details")
    public Result query(@RequestBody Movie movie){
        log.info("电影请求: {}",movie);
        Movie movie1 = commentService.query1(movie.getMovieId());
        List<Comment> commentList = commentService.query2(movie.getMovieId());
        CommetDtails commetDtails = new CommetDtails(movie1,commentList);
        Integer code = commetDtails !=null?Code.GET_OK:Code.GET_ERR;
        String msg = commetDtails !=null?"删除成功":"删除失败";
        return new Result(code, commetDtails,msg);
    }
}
