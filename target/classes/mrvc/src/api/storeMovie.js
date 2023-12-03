import request from '@/utils/request'

//申请收藏数据
export const getStoreData = (userid) => {
  return request.get('page/detail', {
    params: {
      userid,
    }
  })
}

//删除收藏数据
export const postDeleteStore = (userid, movieid) => {
  return request.post('page/detail', {
    params: {
      userid,
      movieid,
    }
  })
}
