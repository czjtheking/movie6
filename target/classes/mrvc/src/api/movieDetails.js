import request from '@/utils/request'


//提交评论
export const newComment = (userId, movieId, userName, context, date) => {
  return request.post("/movies/comment", { //这个路径后面要修改
    userId,
    movieId,
    userName,
    context,
    date
  });
}

//提交收藏
export const storeMovie = (userId, movieId) => {
  return request.post("/store/commit", {
    userId,
    movieId,
  })
}

//提交评分
export const rateMovie = (userId, movieId, rateNum) => {
  return request.post("/movies/rate", {
    userId,
    movieId,
    rateNum,
  })
}

// 请求电影信息
export const getMovieDetails = (userId, movieId) => {
  return request.post("/movies/details", {
    userId,
    movieId,
  })
}

//删除评论
export const deleteComments = (commentId) => {
  return request.post("/movies/delcomment", {
    commentId
  })
}

//取消收藏
export const cancelStore = (userId, movieId) => {
  return request.post('/store/delstore2', {
    userId,
    movieId
  })
}

