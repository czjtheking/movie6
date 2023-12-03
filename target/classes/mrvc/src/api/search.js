import request from '@/utils/request'

// 获取搜索数据

export const getSearchData = (obj) => {
  const { movie_name } = obj
  console.log(obj);
  return request.get('page/detail', {
    params: {
      movie_name,
    }
  })
}

// 获取热门

export const getPopData = () => {
  return request.get('page/detail', {

  })
}

// 获取推荐

export const getRecomData = (userid) => {
  return request.get('page/detail', {
    params: {
      userid,
    }
  })
}