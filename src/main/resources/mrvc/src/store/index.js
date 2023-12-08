import Vue from 'vue'
import Vuex from 'vuex'
import movie from './modules/movie'
import user from './modules/user'
import info from './modules/info'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {

  },
  getters: {
    getUserId(state) {
      return state.user.userInfo.userId
    },
    getAuth(state) {
      return state.user.userInfo.isAdmin
    },
    getUserName(state) {
      return state.user.userInfo.userName
    },
    getInfoMark(state) {
      return state.info.infoMark
    }
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    movie,
    user,
    info,
  }
})
