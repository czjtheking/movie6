import { getInfo, setInfo } from "@/utils/storage"

export default {
  namespaced: true,
  state() {
    return {
      // 个人信息相关
      userInfo: getInfo()
    }
  },
  mutations: {
    // 所有mutations第一个参数都是state
    setUserInfo(state, obj) {
      state.userInfo = obj
      setInfo(obj)
    }
  },
  actions: {

  },
  getters: {

  }
}