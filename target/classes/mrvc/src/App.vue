<template>
  <div id="app">
    <div class="bg"></div>
    <MainTitle> </MainTitle>
    <router-view />
  </div>
</template>


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
