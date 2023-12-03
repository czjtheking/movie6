import request from '@/utils/request'

// 获取搜索数据

export const getSearchData = (obj) => {
  const { keyWords } = obj
  console.log(obj);
  return request.post('/search', {
    keyWords,
  })
}

// 获取热门

export const getPopData = () => {
  return request.post('/pop', {

  })
}

// 获取推荐

export const getRecomData = (userId) => {
  return request.post('/recommend', {
    userId,

  })
}