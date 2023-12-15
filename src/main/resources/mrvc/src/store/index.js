import Vue from 'vue'
import Vuex from 'vuex'
import movie from './modules/movie'
import user from './modules/user'
import info from './modules/info'
import title from './modules/title'

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
    getUserAvatar(state) {
      return state.user.userInfo.userAvatar
    },
    getInfoMark(state) {
      return state.info.infoMark
    },
    getTitleMark(state) {
      return state.title.titleMark
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
    title,
  }
})
