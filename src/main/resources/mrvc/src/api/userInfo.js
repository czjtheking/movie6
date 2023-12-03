import request from '@/utils/request'

// 获取个人数据

export const getUserData = (userId) => {
  return request.post('users/info', {

    userId,

  })
}

// 修改昵称

export const updateUserName = (userId, userName) => {
  console.log(userId, userName);
  return request.put('users/setname', {
    userId,
    userName,
  })
}

// 修改密码

export const updateUserPassword = (userId, userPsw) => {
  console.log(userId, userPsw);
  return request.put('users/setpsw', {
    userId,
    userPsw,
  })
}
