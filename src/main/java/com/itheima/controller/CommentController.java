package com.itheima.controller;
import com.itheima.domain.*;
import com.itheima.service.CommentService;
import com.itheima.service.RateService;
import com.itheima.service.StoreService;
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
    private RateService rateService;
    private StoreService storeService;

    public CommentController(RateService rateService, StoreService storeService) {
        this.rateService = rateService;
        this.storeService = storeService;
    }


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
    public Result query(@RequestBody Rate rate){
        log.info("电影请求: {}",rate);
        Movie movie1 = commentService.query1(rate.getMovieId());
        List<Comment> commentList = commentService.query2(rate.getMovieId());
        double rateNum = rateService.getRate(rate);
        boolean storeMark = storeService.isStore(rate.getUserId(),rate.getMovieId());
        CommetDtails commetDtails = new CommetDtails(movie1,rateNum,storeMark,commentList);
        Integer code = Code.GET_OK;
        String msg = "提交电影详情页成功";
        return new Result(code, commetDtails,msg);
    }
}
