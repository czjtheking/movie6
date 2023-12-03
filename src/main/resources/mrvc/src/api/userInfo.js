import request from '@/utils/request'

// 获取个人数据

export const getUserData = (userid) => {
  return request.get('users/info', {

    userid,

  })
}

// 修改昵称

export const updateUserName = (userid, username) => {
  console.log(userid, username);
  return request.post('users/setName', {
    userid,
    username,
  })
}

// 修改密码

export const updateUserPassword = (userid, userpassword) => {
  console.log(userid, userpassword);
  return request.post('users/setPsw', {
    userid,
    userpassword,
  })
}
