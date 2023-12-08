export default {
  namespaced: true,
  state() {
    return {
      infoMark: localStorage.getItem('infoMark')
    }
  },
  mutations: {
    setInfoMark(state, id) {
      state.infoMark = id
      localStorage.setItem("infoMark", id);
    }
  },
  actions: {},
  getters: {}
}