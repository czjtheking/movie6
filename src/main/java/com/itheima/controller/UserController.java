package com.itheima.controller;

import com.itheima.domain.Code;
import com.itheima.domain.Result;
import com.itheima.domain.User;
import com.itheima.service.CommentService;
import com.itheima.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserService userService;
    private CommentService commentService;

    public UserController(UserService userService, CommentService commentService) {
        this.userService = userService;
        this.commentService = commentService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User newUser = userService.loginInService(user.getUserAccount(),user.getUserPsw(),user.isUserAd());
        if(newUser!=null){
            return new Result(Code.LOGIN_OK,newUser,"登陆成功");
        }
        else return new Result(Code.LOGIN_ERR,"账号或密码错误");
    }

    @PostMapping("/info")
    public Result getInfo(@RequestBody User user){

        User newUser = userService.findUser(user.getUserId());
        if(newUser!=null){
            return new Result(Code.GET_OK,newUser,"查找成功");
        }
        else return new Result(Code.GET_ERR,null,"查找失败");
    }



    @PostMapping("/register")
    public Result register(@RequestBody User user){
        User newUser = userService.registerService(user);
        if(newUser!=null){
            return new Result(Code.REGISTER_OK,newUser,"注册成功");
        }
        else {
            return new Result(Code.REGISTER_ERR,"用户已存在");
        }
    }

    @PutMapping  ("/setname")
    public Result setName(@RequestBody User user) {
        System.out.println(user);
        boolean temp = userService.upName(user.getUserId(),user.getUserName());
        commentService.keepName(user.getUserId(),user.getUserName());
        Integer code = temp ?Code.UPDATE_OK:Code.UPDATE_ERR;
        String msg = temp ?"修改用户名成功":"修改用户名失败";
        return new Result(code,msg);
    }

    @PutMapping("/setpsw")
    public Result setPsw(@RequestBody User user){
        boolean temp = userService.upPsw(user.getUserId(),user.getUserPsw());
        Integer code = temp ?Code.UPDATE_OK:Code.UPDATE_ERR;
        String msg = temp ?"修改密码成功":"修改密码失败";
        return new Result(code,msg);
    }



}
