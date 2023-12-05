package com.itheima.controller;
import com.itheima.domain.Comment;
import com.itheima.domain.Result;
import com.itheima.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movies")
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

        commentService.commit(comment);
        return new Result(Code.GET_OK,"提交成功");
    }

    /**
     * 删除评论
     */
    @PostMapping("/delcomment")
    public Result deletecomment(@RequestBody Comment comment){
        log.info("删除评论: {}",comment);
        commentService.deletecomment(comment);
        return new Result(Code.GET_OK,"删除成功");
    }

}
