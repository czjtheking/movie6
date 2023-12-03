package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User newUser = userService.loginInService(user.getUserAccount(),user.getUserPsw(),user.isUserAd());
        if(newUser!=null){
            return new Result(Code.LOGIN_OK,newUser,"登陆成功");
        }
        else return new Result(Code.LOGIN_ERR,"账号或密码错误");
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        User newUser = userService.registerService(user);
        if(newUser!=null){
            return new Result(Code.REGISTER_OK,newUser,"注册成功");
        }
        else {
            return new Result(Code.REGISTER_ERR,"用户名已存在");
        }
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        boolean flag = userService.update(user);
        System.out.println(user);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }



}
