import request from '@/utils/request'

// 获取搜索数据

export const getSearchData = (movieName) => {
  console.log(movieName);
  return request.post('/movies/search', {
    movieName,
  })
}

// 获取热门

export const getPopData = () => {
  return request.post('/movies/pop', {

  })
}

// 获取推荐

export const getRecomData = (userId) => {
  return request.post('/movies/recommend', {
    userId,

  })
}