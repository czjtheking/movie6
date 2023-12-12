<template>
  <div id="app">
    <div class="bg"></div>
    <MainTitle v-if="show"> </MainTitle>
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {
      show: true,
    };
  },
  watch: {
    $route: async function (to, from) {
      console.log(to, from);
      if (to.fullPath === "/login" || to.fullPath === "/register") {
        this.show = false;
      } else {
        this.show = true;
      }
    },
  },
};
</script>

<style lang="less">
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
li {
  list-style: none;
}
#app {
  .bg {
    background: url("~@/assets/bg.png");
    width: 100%;
    height: 100%;
    position: fixed;
    background-size: 100% 100%;
    z-index: -2;
  }
}
</style>
