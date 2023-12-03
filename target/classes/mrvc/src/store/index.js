import Vue from 'vue'
import Vuex from 'vuex'
import movie from './modules/movie'
import user from './modules/user'

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
    }
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    movie,
    user,
  }
})
