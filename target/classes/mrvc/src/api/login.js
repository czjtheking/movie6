// 所有登陆相关的接口请求
import request from '@/utils/request'

// 登录接口
export const codeLogin = (userAccount, userPsw, userAd) => {
  return request.post("/users/login", { //这个路径后面要修改
    userAccount,
    userPsw,
    userAd,
  });
}

// 注册接口
export const codeRegister = (userAccount, userPsw) => {
  return request.post("/users/register", {
    userAccount,
    userPsw,
  });
}