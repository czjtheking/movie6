import request from '@/utils/request'

//申请收藏数据
export const getStoreData = (userId) => {
  return request.post('/store/getstore', {
    userId,
  })
}

//删除收藏数据
export const postDeleteStore = (storeId) => {
  return request.post('/store/delstore', {
    storeId,
  })
}
