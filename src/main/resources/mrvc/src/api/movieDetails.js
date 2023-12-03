import request from '@/utils/request'


//提交评论
export const newComment = (userid, username, movieid, context, date) => {
  return request.post("/passport/login", { //这个路径后面要修改
    form: {
      userid,
      username,
      movieid,
      context,
      date
    }
  });
}

//提交收藏
export const storeMovie = (userid, movieid) => {
  return request.post("/passport/login", {
    form: {
      userid,
      movieid,
    }
  })
}

//提交评分
export const rateMovie = (userid, movieid, ratenum) => {
  return request.post("/passport/login", {
    form: {
      userid,
      movieid,
      ratenum,
    }
  })
}

// 请求电影信息
export const getMovieDetails = (movieid) => {
  return request.get("/goods/details", {
    params: {
      movieid,
    }
  })
}

//删除评论
export const deleteComments = (commentid) => {
  return request.post("/passport/login", {
    form: {
      commentid
    }
  })
}