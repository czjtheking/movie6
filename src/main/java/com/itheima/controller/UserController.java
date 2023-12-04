package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.web.bind.annotation.*;

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
            return new Result(Code.REGISTER_ERR,"用户名已存在");
        }
    }

    @PutMapping  ("/setname")
    public Result setName(@RequestBody User user) {
        userService.upName(user.getUserId(),user.getUserName());
        return new Result(Code.UPDATE_OK,"修改用户名成功");
    }

    @PutMapping("/setpsw")
    public Result setPsw(@RequestBody User user){
        userService.upPsw(user.getUserId(),user.getUserPsw());
        return new Result(Code.UPDATE_OK,"修改密码成功");
    }



}
