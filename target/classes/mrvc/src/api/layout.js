import request from '@/utils/request'

// 获取首页数据

export const getHomeData = (userId) => {
  return request.post('/movies/home', {
    userId,
  })
}