export default {
  namespaced: true,
  state() {
    return {
      titleMark: JSON.parse(localStorage.getItem('titleMark'))
    }
  },
  mutations: {
    setTitleMark(state, id) {
      state.titleMark = id
      localStorage.setItem("titleMark", id);
    }
  },
  actions: {},
  getters: {}
}