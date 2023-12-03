import request from '@/utils/request'

// 获取个人数据

export const getUserData = (userid) => {
  return request.get('page/detail', {
    params: {
      userid,
    }
  })
}

// 修改昵称

export const updateUserName = (userid, username) => {
  console.log(userid, username);
  return request.post('page/datail', {
    form: {
      userid,
      username,
    }
  })
}

// 修改密码

export const updateUserPassword = (userid, userpassword) => {
  console.log(userid, userpassword);
  return request.post('page/datail', {
    form: {
      userid,
      userpassword,
    }
  })
}
